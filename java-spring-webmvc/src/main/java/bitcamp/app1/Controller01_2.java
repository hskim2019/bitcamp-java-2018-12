// 페이지 컨트롤러 만드는 방법 - 한 개의 페이지 컨트롤러에 여러 개의 요청 핸들러 두기
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller01_2 {
	
	@RequestMapping("/c01_2_h1") // 핸들러에서 URL을 지정한다
	@ResponseBody   // 메서드의 리턴 값이 클라이언트에게 출력할 내용임을 표시한다
	public String handler() {
		return "c01_2_h1";
	}
	
	@RequestMapping("/c01_2_h2") // 이 애노테이션을 붙여서 요청이 들어왔을 때 호출 될 메서드임을 표시한다
	@ResponseBody   // 메서드의 리턴 값이 클라이언트에게 출력할 내용임을 표시한다
	public String handler2() {
		return "c01_2_h2";
	}
	
	@RequestMapping("/c01_2/h3") // URL을 지정할 때 디렉토리 형식으로 지정할 수 있다
	@ResponseBody
	public String handler3() {
		return "c01_2/h3";
	}
	
	@RequestMapping("/c01_2/h4") // URL을 지정할 때 디렉토리 형식으로 지정할 수 있다
	@ResponseBody
	public String handler4() {
		return "c01_2/h4";
	}
	

}
