// request handler 구분하는 방법 - 파라미터 이름으로 구분하는 방법
package bitcamp.app1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c03_1")
public class Controller03_1 {

	// 테스트 방법:
	// => http://localhost:8080/java-spring-webmvc/app1/c03_1?name=kim

	@GetMapping(params = "name")
	@ResponseBody
	public String handler1() {
		return "파라미터에 name이라는 것이 있어서 handler1 호출 됨";
	}

	// 테스트 방법:
	// => http://localhost:8080/java-spring-webmvc/app1/c03_1?age=20
	@GetMapping(params = "age")
	@ResponseBody
	public String handler2() {
		return "age";
	}
	
	// 테스트 방법:
	// => http://localhost:8080/java-spring-webmvc/app1/c03_1?name=kim&age=20
	@GetMapping(params = {"age","name"})
	@ResponseBody
	public String handler3() {
		return "age,name";
	}

}
