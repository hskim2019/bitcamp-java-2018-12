// ???
package bitcamp.app1;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/c05_1")
public class Controller05_1 {

	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app1/c05_1/h1
	@GetMapping("h1")
	@ResponseBody
	public String handler1() {
		// 리턴 값이 클라이언트에게 보내는 콘텐트라면
		// 메서드 선언부에 @ResponseBody를 붙인다
		// => 붙이지 않으면 프론트 컨트롤러는 view URL로 인식한다
		// => 출력 콘텐트는 브라우저에서 기본으로 HTML로 간주한다. 기본이 text/plain;charset=ISO-8859-1 이다
		//    또한 한글을 ISO-8859-1 문자표에 정의된 코드가 아니기 때문에 
		//    클라이언트에게 보낼 때 '?' 문자로 변경된다.
		return "<html><body><h1>abc가각간</h1></body></html>";
	}

	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app1/c05_1/h2
	// => 리턴되는 콘텐트의 MIME 타입과 charset을 지정하고 싶다면
	//    애노테이션의 produces 프로퍼티에 설정하라
	@GetMapping(value="h2", produces="text/html;charset=UTF-8")
	@ResponseBody
	public String handler2() {
		// 리턴 값이 클라이언트에게 보내는 콘텐트라면
		// 메서드 선언부에 @ResponseBody를 붙인다
		// => 붙이지 않으면 프론트 컨트롤러는 view URL로 인식한다
		// => 출력 콘텐트는 기본이 text/plain;charset=ISO-8859-1 이다
		//    그래서 HTML 태그를 인식하지 못한다
		//    또한 한글을 ISO-8859-1 문자표에 정의된 코드가 아니기 때문에 '?' 문자로 변경된다
		return "<html><body><h1>abc가각간</h1></body></html>";
	}

	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app1/c05_1/h3
	// => 리턴되는 콘텐트의 MIME 타입과 charset을 지정하고 싶다면
	//    애노테이션의 produces 프로퍼티에 설정하라
	@GetMapping("h3")
	@ResponseBody
	public String handler3(HttpServletResponse reponse) {
		// HttpServletResponse에 대해 다음과 같이 콘텐트 타입을 설정해봐야 소용 없다.
		reponse.setContentType("text/html;charset=UTF-8");
		return "<html><body><h1>abc가각간handler3</h1></body></html>";
	}


	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app1/c05_1/h4
	@GetMapping("h4")
	public HttpEntity<String> handler4(HttpServletResponse reponse) {
		// HttpEntity 객체에 콘텐트를 담아 리턴할 수 있다
		// 이 경우에는 리턴 타입으로 콘텐트임을 알 수 있기 때문에
		// @ResponseBody 애노테이션을 붙이지 않아도 된다
		HttpEntity<String> entity = new HttpEntity<>
		("<html><body><h1>abc가각간handler4</h1></body></html>");
		// 이 경우에는 출력할 때 ISO-8859-1 문자표의 코드로 변환하여 출력한다
		// 그래서 한글은 ? 문자표로 변환된다
		return entity;
	}

	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app1/c05_1/h5
	@GetMapping(value="h5", produces="text/html;charset=UTF-8")
	public HttpEntity<String> handler5(HttpServletResponse reponse) {
		// 한글을 제대로 출력하고 싶으면 위의 애노테이션에 produces 속성에 콘텐트 타입을 지정한다
		HttpEntity<String> entity = new HttpEntity<>
		("<html><body><h1>abc가각간handler5</h1></body></html>");
		return entity;
	}

	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app1/c05_1/h6
	@GetMapping(value="h6", produces="text/html;charset=UTF-8")
	public HttpEntity<String> handler6(HttpServletResponse reponse) {
		// 한글을 제대로 출력하고 싶으면
		// 응답 헤더에 직접 Content-Type을 설정할 수 있다

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;charset=UTF-8");

		HttpEntity<String> entity = new HttpEntity<>
		("<html><body><h1>abc가각간handler6</h1></body></html>", headers);
		return entity;
	}

	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app1/c05_1/h6
	@GetMapping(value="h7", produces="text/html;charset=UTF-8")
	public ResponseEntity<String> handler7(HttpServletResponse reponse) {
		// HttpEntity 대신에 ResponseEntity 객체를 리턴 할 수 있다
		// 이 클래스의 경우 응답 상태 코드를 추가하기 편하다

		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html;charset=UTF-8");

		// 이렇게 응답 헤더를 따로 설정하는 방법이 존재하는 이유는
		// 임의의 응답 헤더를 추가하는 경우가 있기 때문이다
		headers.add("BIT-OK", "ohora");
		
		ResponseEntity<String> entity = new ResponseEntity<>
		("<html><body><h1>abc가각간handler7</h1></body></html>", 
				headers,
				HttpStatus.OK); // 응답 status 코드를 지정할 수 있다
		return entity;
	}
}
