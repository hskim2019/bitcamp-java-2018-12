// 27단계 : XML 설정으로 트랜잭션 다루기
// => 애노테이션을 사용할 경우 각 서비스 클래스의 메서드에 대해 애노테이션을 붙여야 한다
// README.md
package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;
import com.eomcs.lms.handler.Response;

public class ServerApp {

	// Command 객체와 그와 관련된 객체를 보관하고 있는 빈 컨테이너
	ApplicationContext iocContainer;

	// 클라이언트 요청을 처리할 메서드 정보가 들어 있는 객체 (Command 클래스, 메서드)
	RequestMappingHandlerMapping handlerMapping;

	public void service() throws Exception {

		try (ServerSocket ss = new ServerSocket(8888)) {


			//Spring IoC 컨테이너 준비
			iocContainer = new AnnotationConfigApplicationContext(AppConfig.class);
			printBeans();

			// 스프링 IoC 컨테이너에서 ReuqestMappingHandlerMapping 객체를 꺼낸다
			// 이 객체에 클라이언트 요청을 처리할 메서드 정보가 들어 있다
			handlerMapping = (RequestMappingHandlerMapping) iocContainer.getBean(RequestMappingHandlerMapping.class);


			System.out.println("서버 실행 중...");

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

				System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
				e.printStackTrace();

			}  finally {
				// 클라이언트 요청을 모두 처리했으면 DB 커넥션 객체를 커넥션풀에 반납한다\
				// 커넥션 객체를 close() 해서는 안된다
				// 왜? 다음에 다시 사용해야 하기 때문이다.
			}
		}

	}
	
	
	
	private void printBeans() {
		System.out.println("-----------------------------------");
		String[] names = iocContainer.getBeanDefinitionNames();
		for (String name : names) {
			System.out.printf("%s ====> %s\n", name,
					iocContainer.getBean(name).getClass().getName());
		}
		System.out.println("-----------------------------------");
	}
}









