// 스프링 인터셉터 다루기
package bitcamp.app2;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c04_1")
public class Controller04_1 {

	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app2/c04_1/h1
	@GetMapping("h1")
	public String handler1(HttpSession session) {
		System.out.println("c04_1.handler1() 호출");
		return "c04_1";

		/*
		Interceptor3.preHandle()             - 모든 컨트롤러에 적용되는 인터셉터
		Interceptor1.preHandle()             - c04_1/* 아래 컨트롤러에 적용되는 인터셉터
		Interceptor4.preHandle()             - /c04_1/** 모든 컨트롤러에 적용, /c04_1/a/** 만 제외
		c04_1.handler1() 호출                - 컨트롤러
		Interceptor4.postHandle()
		Interceptor1.postHandle()
		Interceptor3.postHandle()
		c04_1.jsp 실행
		Interceptor4.afterCompletion()
		Interceptor1.afterCompletion()
		Interceptor3.afterCompletion()
		 */
	}

	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app2/c04_1/a/h2
	@GetMapping("a/h2")
	public String handler2(HttpSession session) {
		System.out.println("c04_1.handler2() 호출");
		return "c04_1";
		/*
		Interceptor3.preHandle()
		Interceptor2.preHandle()
		c04_1.handler2() 호출
		Interceptor2.postHandle()
		Interceptor3.postHandle()
		c04_1.jsp 실행
		Interceptor2.afterCompletion()
		Interceptor3.afterCompletion()
		 */
		
	}

	// 테스트:
	//   http://localhost:8080/java-spring-webmvc/app2/c04_1/b/h3
	@GetMapping("b/h3")
	public String handler3(HttpSession session) {
		System.out.println("c04_1.handler3() 호출");
		return "c04_1";
		
		/*
		Interceptor3.preHandle()
		Interceptor4.preHandle()
		c04_1.handler3() 호출
		Interceptor4.postHandle()
		Interceptor3.postHandle()
		c04_1.jsp 실행
		Interceptor4.afterCompletion()
		Interceptor3.afterCompletion()
		 */
	}
}
