package com.eomcs.lms.web.json;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.service.MemberService;
import com.eomcs.lms.service.NaverService;

@RestController("json/AuthController")
@RequestMapping("/json/auth")
public class AuthController {

  final static Logger logger = LogManager.getLogger(AuthController.class);
  
  static final String REFERER_URL = "refererUrl";

  @Autowired MemberService memberService;
  @Autowired ServletContext servletContext;
  @Autowired NaverService naverService;
  
  @GetMapping("form")
  public void form(
      @RequestHeader(value="Referer",required=false) String refererUrl,
      HttpSession session) {
    
    logger.debug("refererUrl: " + refererUrl);
    
    if (refererUrl != null && !refererUrl.endsWith("/auth/login")) {
      session.setAttribute(REFERER_URL, refererUrl);
    } else {
      session.removeAttribute(REFERER_URL);
    }
  }
  
  @PostMapping("login")
  public Object login(
      String email,
      String password,
      HttpSession session,
      HttpServletResponse response) {

    Member member = memberService.get(email, password);

    HashMap<String,Object> content = new HashMap<>();
    
    if (member == null) {
      content.put("status", "fail");
      content.put("message", "이메일이 없거나 암호가 맞지 않습니다.");
    } else {
      session.setAttribute("loginUser", member);
      content.put("status", "success");
    }

    return content;
  }
  
  @SuppressWarnings("rawtypes")
  @PostMapping("snsLogin")
  public Object snsLogin(String token, 
      HttpSession session,
      HttpServletResponse response) {
    
    HashMap<String, Object> content = new HashMap<>();
    
    Map loginUser = null;
    
    loginUser = naverService.getLoginUser(token);  //토큰 받을 ServiceImp 만들어야 함
    
    if (loginUser == null) {   // 만약 토큰을 받지 못했으면
      content.put("status", "no-data");
      content.put("message", "잘못된 토큰입니다.");
      return content;
    }
    
    String email = (String) loginUser.get("email");
    String name = (String) loginUser.get("name");
    
    Member member = memberService.get(email, "snspassword"); // 기존에 sns로 가입 되어있는지 조회하기
    if(member == null) {         // 가입된 내역 없으면 여기서 member 정보 add
      member = new Member();
      member.setEmail(email);
      member.setName(name);
      member.setPassword("snspassword");
      memberService.add(member);
      System.out.println("다음의 멤버 추가 됨" + member);
      session.setAttribute("loginUser", member);     // session에 정보 넣어주기
      content.put("status", "success");               // success 면 callback에서 index.html로 이동
      content.put("member", member);                  // 멤버 정보 필요한 경우 사용하라고
      return content;
    } else { // 기존에 sns 가입 되어 있으면
      session.setAttribute("loginUser", member);
      content.put("status", "success");               
      content.put("member", member); 
      return content;
    }
    
  }
  
  @GetMapping("logout")
  public Object logout(HttpSession session) throws Exception {
    
    logger.debug("세션 무효화시킴!");
    logger.debug("loginUser: " + session.getAttribute("loginUser"));
    session.invalidate();
    
    HashMap<String,Object> content = new HashMap<>();
    content.put("status", "success");
    
    return content;
  }
  
  @GetMapping("user")
  public Object user(HttpSession session) throws Exception {
    
    Member loginUser = (Member)session.getAttribute("loginUser");
    
    HashMap<String,Object> content = new HashMap<>();

    if (loginUser != null) {
      content.put("status", "success");
      content.put("user", loginUser);
    } else {
      content.put("status", "fail");
    }
    return content;
  }
}










