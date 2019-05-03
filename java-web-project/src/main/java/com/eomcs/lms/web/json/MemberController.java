package com.eomcs.lms.web.json;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;

@RestController("json/MemberController") // AJAX 기반 JSON 데이터 다루는 컨트롤러
@RequestMapping("json/member") // 이름 겹치지 않게 json/member로 바꿔주기
public class MemberController {
  
  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;
  
//  @GetMapping("form")
//  public void form() {
//  }
  
  @PostMapping("add")
  public String add(Member member, Part photoFile) throws Exception {
    
    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath(
          "/upload/member");
      photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }

    memberService.add(member);
    
    return "redirect:.";
  }
  
  @GetMapping("delete/{no}")
  public String delete(@PathVariable int no) {

    if (memberService.delete(no) == 0) 
      throw new RuntimeException("해당 번호의 회원이 없습니다.");
    return "redirect:../";
  }
  
  @GetMapping("{no}")
  public String detail(@PathVariable int no, Model model) {
    Member member = memberService.get(no);
    model.addAttribute("member", member);
    return "member/detail";
  }
  
  @GetMapping("list")
  public Object list(
		  @RequestParam(defaultValue="1") int pageNo,
		  @RequestParam(defaultValue="3") int pageSize) {
	  
	  if (pageSize < 3 || pageSize > 8) 
	        pageSize = 3;
	      
	      int rowCount = memberService.size();
	      int totalPage = rowCount / pageSize;
	      if (rowCount % pageSize > 0)
	        totalPage++;
	      
	      if (pageNo < 1) 
	        pageNo = 1;
	      else if (pageNo > totalPage)
	        pageNo = totalPage;
	      
    List<Member> members = memberService.list(null, pageNo, pageSize);
    
    HashMap<String,Object> content = new HashMap<>();
    content.put("list", members);
    content.put("pageNo", pageNo);
    content.put("pageSize", pageSize);
    content.put("totalPage", totalPage);
    
    return content;
  }
  
  @GetMapping("search")
  public Object search(String keyword) {
    List<Member> members = memberService.list(keyword, 0, 5);
    HashMap<String,Object> content = new HashMap<>();
    content.put("list", members);
    
    return content;
  }

  @PostMapping("update")
  public String update(Member member, Part photoFile) throws Exception {

    if (photoFile.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      String uploadDir = servletContext.getRealPath("/upload/member");
      photoFile.write(uploadDir + "/" + filename);
      member.setPhoto(filename);
    }

    if (memberService.update(member) == 0)
      throw new RuntimeException("해당 번호의 회원이 없습니다.");
      
    return "redirect:.";
  }
}
