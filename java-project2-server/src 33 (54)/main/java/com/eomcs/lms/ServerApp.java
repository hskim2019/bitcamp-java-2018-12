// 31 단계: Tomcat 서버 적용하기
// => 웹 브라우저와의 통신을 전문적으로 담당할 서버를 도입한다

package com.eomcs.lms;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

@WebServlet("/*") // 들어오는 모든 요청을 이 servlet이 실행한다는 의미
public class ServerApp implements Servlet{
  // 보통 클래스에서 사용할 로그 출력 객체는 클래스의 스태틱 멤버로 선언한다.
  final static Logger logger = LogManager.getLogger(ServerApp.class);

  // Command 객체와 그와 관련된 객체를 보관하고 있는 빈 컨테이너
  ApplicationContext iocContainer;

  // 클라이언트 요청을 처리할 메서드 정보가 들어 있는 객체
  RequestMappingHandlerMapping handlerMapping;

  ServletConfig config;

  @Override
  public void init(ServletConfig config) throws ServletException {
    // 이 클래스의 인스턴스가 생성된 후 톰캣이 제일 처음으로 호출하는 메서드
    // => 보통 이 클래스가 작업하는데 필요한 객체를 준비한다
    this.config = config;

    logger.info("Spring IoC 컨테이너 준비");
    iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
    printBeans();

    // 이 객체에 클라이언트 요청을 처리할 메서드 정보가 들어 있다.
    logger.info("스프링 IoC 컨테이너에서 RequestMappingHandlerMapping 객체 준비");
    handlerMapping = 
        (RequestMappingHandlerMapping) iocContainer.getBean(
            RequestMappingHandlerMapping.class); 
  }

  @Override
  public void service(javax.servlet.ServletRequest req, javax.servlet.ServletResponse res)
      throws ServletException, IOException {

    // 톰캣 서버가 파라미터로 넘겨준 값을 원래의 타입으로 변환해서 사용하자
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    
    // 웹 브라우저로 출력할 때 사용할 출력 스트림 준비
    response.setContentType("text/html;charset=UTF-8"); // 출력 스트림 얻기 전에 설정해야 함
    PrintWriter out = response.getWriter();

    String commandPath = request.getPathInfo();
    logger.info("클라이언트 요청" + commandPath);

    RequestMappingHandler requestHandler = handlerMapping.get(commandPath);

    if (requestHandler == null) {
      out.println("실행할 수 없는 명령입니다.");
      return;
    }

    try {
      requestHandler.method.invoke( 
          requestHandler.bean, // 메서드를 호출할 때 사용할 인스턴스 
          request, response); // 메서드 파라미터 값

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public void destroy() {
    // 서버를 종료하거나 웹 애플리케이션을 종료할 때
    // 생성된 모든 서블릿 객체는 소멸될 것이다
    // 그래서 소멸되기 전에 사용한 자원을 해제시키기 위해 톰캣이 메서드를 호출한다
    // => 즉 init()에서 준비한 자원은 이 메서드에서 해제시켜라
  }

  @Override
  public ServletConfig getServletConfig() {
    // init()가 호출될 때 파라미터로 받은 ServletConfig 객체를 그대로 리턴하면 된다
    return this.config;
  }

  @Override
  public String getServletInfo() {
    // 톰캣 서버가 관리자 화면을 띄울 때 서블릿 정보를 출력하기 위해 
    // 이 메서드를 호출하는 경우가 있다
    // => 간단히 이 서블릿이 어떤 일을 하는 서블릿인지 알려주는 문장을 리턴하라
    return "Command 요청을 받아 처리하는 서블릿";
  }


  private void printBeans() {
    // 개발하는 동안 참고할 로그는 보통 debug 등급으로 출력한다.
    logger.debug("---------------------------------------------------"); 
    String[] names = iocContainer.getBeanDefinitionNames();
    for (String name : names) {
      logger.debug(String.format("빈 생성 됨 (객체명=%s, 클래스명=%s)", name, 
          iocContainer.getBean(name).getClass().getName()));
    }
    logger.debug("---------------------------------------------------"); 
  }

}









