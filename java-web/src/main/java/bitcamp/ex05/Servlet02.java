// HTTP 프로토콜 다루기 - MyHttpServlet 클래스 활용하기
package bitcamp.ex05;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex05/s2")
public class Servlet02 extends MyHttpServlet {
  
  private static final long serialVersionUID = 1L;

  // 서블릿 컨테이너는 original service()를 호출할 것
  // 상속 받았기 때문에 HttpServlet에 있는 service를 호출할 것이고
  // original service는 아래 오버로딩한 service 호출할 것
  @Override
  protected void service(
      HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    super.service(request, response);
  
    // 테스트
    // - http://localhost:8080/java-web/ex05/test01.html 실행
    
    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    // HttpServletRequest에는 HTTP 프로토콜의 요청 방식을 리턴하는 메서드가 있다
    // HttpServletRequest.getMetnod()
    
    if (request.getMethod().equals("GET")) {
      out.println("GET 요청입니다");
    } else if (request.getMethod().equals("POST")) {
      out.println("POST 요청입니다.");
    } else {
      out.println("이 서블릿이 다루지 못하는 요청 방식입니다");
    }
  }
}








