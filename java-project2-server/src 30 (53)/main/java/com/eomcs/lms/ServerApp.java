// 28단계 : Log4J 1.x 적용하기
// => 애플리케이션을 실행하는 중에 내부 상태를 확인할 목적으로 기록을 남기는 것을 로깅(loggin)이라고 한다
// README.md
package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import com.eomcs.lms.handler.Response;


public class ServerApp {
    // 보통 클래스에서 사용할 로그 출력 객체는 클래스의 스테틱 멤버로 선언한다
	final static Logger logger = LogManager.getLogger(ServerApp.class);
	
	
	
	// Command 객체와 그와 관련된 객체를 보관하고 있는 빈 컨테이너
	ApplicationContext iocContainer;

	// 클라이언트 요청을 처리할 메서드 정보가 들어 있는 객체 (Command 클래스, 메서드)
	RequestMappingHandlerMapping handlerMapping;

	public void service() throws Exception {

		try (ServerSocket ss = new ServerSocket(8888)) {
			logger.info("서버 실행 중...");


			//Spring IoC 컨테이너 준비
			iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
			printBeans();

			// 스프링 IoC 컨테이너에서 ReuqestMappingHandlerMapping 객체를 꺼낸다
			// 이 객체에 클라이언트 요청을 처리할 메서드 정보가 들어 있다
			handlerMapping = (RequestMappingHandlerMapping) iocContainer.getBean(RequestMappingHandlerMapping.class);



			while (true) {
				// 클라이언트가 있으면 대기열에서 소켓 하나를 꺼내어 RequestHandlerThread객체 생성
				new RequestHandlerThread(ss.accept()).start();

			} // while


		} catch (Exception e) {
			e.printStackTrace();
		} // try(ServerSocket)

	}



	public static void main(String[] args) throws Exception {
		ServerApp app = new ServerApp();

		// App 을 실행한다.
		app.service();
	}


	// 바깥 클래스의 인스턴스 필드를 사용한다면 Inner 클래스로 정의하라
	// Inner 클래스(non-static nested class)로 정의하라
	class RequestHandlerThread extends Thread {

		Socket socket;

		public RequestHandlerThread(Socket socket) {
			this.socket = socket;
		}

		@Override
		public void run() {

          logger.info("클라이언트 연결되었음.");
          
			try (Socket socket = this.socket;
					BufferedReader in = new BufferedReader(
							new InputStreamReader(socket.getInputStream()));
					PrintWriter out = new PrintWriter(socket.getOutputStream())) {

				// 클라이언트의 요청 읽기
				String request = in.readLine();

				// 클라이언트에게 응답하기
				// => 클라이언트 요청을 처리할 메서드를 꺼낸다
				RequestMappingHandler requestHandler = handlerMapping.get(request);

				if (requestHandler == null) {
					out.println("실행할 수 없는 명령입니다.");
					out.println("!end!");
					out.flush();
					return;
				}

				try {
					// 클라이언트 요청을 처리할 메서드를 찾았다면 호출한다
					requestHandler.method.invoke(            //invoke(객체, 메서드, 파라미터)
							requestHandler.bean,  // 메서드를 호출할 때 사용할 인스턴스
							new Response(in, out));   // 메서드 파라미터 값

					// 클라이언트 요청을 처리한 후 커넥션을 통해 작업한 것을 최종 완료한다

				} catch (Exception e) {
					// 만약 클라이언트 요청을 처리하는 동안에 예외가 발생했다면
					// 커넥션을 통해 수행했던 모든 데이터 변경 작업을 취소한다
					out.printf("실행 오류! : %s\n", e.getMessage());
					e.printStackTrace();
				}

				out.println("!end!");
				out.flush();


			} catch (Exception e) {

				logger.error("명령어 실행 중 오류 발생 : " + e.toString());
				StringWriter strWriter = new StringWriter();
                PrintWriter out = new PrintWriter(strWriter);
				e.printStackTrace(out);
				logger.error(strWriter.toString());
				

			} 
			logger.info("클라이언트와 연결 종료");
		}

	}
	
	
	
	private void printBeans() {
		// 개발하는 동안 참고할 로그는 보통 debug 등급으로 출력한다
		logger.debug("-----------------------------------");
		String[] names = iocContainer.getBeanDefinitionNames();
		for (String name : names) {
			logger.debug(String.format("빈 생성 됨 (객체명=%s, 클래스명=%s)", name,
					iocContainer.getBean(name).getClass().getName()));
		}
		logger.debug("-----------------------------------");
	}
}









