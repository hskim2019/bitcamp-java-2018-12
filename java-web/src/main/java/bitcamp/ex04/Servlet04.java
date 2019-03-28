// multipart 파일 업로드 처리하기 - apache 라이브러리 사용
package bitcamp.ex04;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ex04/s4")
public class Servlet04 extends GenericServlet {
  
  private static final long serialVersionUID = 1L;

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {
    
    // 멀티파트 형식으로 보낸 첨부파일 데이터를 읽는 방법
    
    // 테스트
    // - http://localhost:8080/java-web/ex04/test04.html 실행
    //
  
    req.setCharacterEncoding("UTF-8");

    // getParameter() 가 null을 리턴한다는 것을 확인하기 위해
    // 파라미터 모두 String으로 받는다
    String age = req.getParameter("age");
    String name = req.getParameter("name");
    String photo = req.getParameter("photo");
    
    res.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = res.getWriter();
    out.printf("이름=%s\n", name);
    out.printf("나이=%s\n", age);
    out.printf("사진=%s\n", photo);
  }
}

// <form> 태그의 enctype을 "multipart/form-data"로 설정하면
// 웹 브라우저가 데이터를 전송할 때 다음과 같은 형식으로 보낸다
// 요청 프로토콜에서 Content-Type을 확인하라

//https://mangkyu.tistory.com/17?category=761303








