// 43 -1
// 13단계: Mybatis 퍼시스턴스 프레임워크 적용하기
// README.md

package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;

public class ServerApp {

	// ApplicationContextListener(옵저버) 목록을 보관할 객체
	ArrayList<ApplicationContextListener> listeners = new ArrayList<>();

	// App에서 사용할 객체를 보관하는 저장소
	// service()메서드 안에 있으면 로컬 변수로, thread클래스에서 접근 못 하므로, 인스턴스 필드로 옮겨 줌
	HashMap<String,Object> context = new HashMap<>();

	public void addApplicationContextListener(ApplicationContextListener listener) {
		listeners.add(listener);
	}

	public void service() throws Exception {

		try (ServerSocket ss = new ServerSocket(8888)) {


			// 애플리케이션을 시작할 때, 등록된 리스너에게 알려준다.
			for (ApplicationContextListener listener : listeners) {
				listener.contextInitialized(context);
			}

			System.out.println("서버 실행 중...");

			while (true) {
				// 클라이언트가 있으면 대기열에서 소켓 하나를 꺼내어 RequestHandlerThread객체 생성
				new RequestHandlerThread(ss.accept()).start();

			} // while

			// 애플리케이션을 종료할 때, 등록된 리스너에게 알려준다.
			// => 현재 while문은 종료 조건이 없기 때문에 다음 문장을 실행할 수 없다
			/*
			for (ApplicationContextListener listener : listeners) {
				listener.contextDestroyed(context);
			}
			 */

		} catch (Exception e) {
			e.printStackTrace();
		} // try(ServerSocket)

	}



	public static void main(String[] args) throws Exception {
		ServerApp app = new ServerApp();

		// App이 실행되거나 종료될 때 보고를 받을 옵저버를 등록한다.
		app.addApplicationContextListener(new ApplicationInitializer());

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
				Command commandHandler = (Command) context.get(request);

				if (commandHandler == null) {
					out.println("실행할 수 없는 명령입니다.");
					out.println("!end!");
					out.flush();
					return;
				}

				try {
					commandHandler.execute(in, out);
					// 클라이언트 요청을 처리한 후 커넥션을 통해 작업한 것을 최종 완료한다

				} catch (Exception e) {
					// 만약 클라이언트 요청을 처리하는 동안에 예외가 발생했다면
					// 커넥션을 통해 수행했던 모든 데이터 변경 작업을 취소한다
					out.printf("실행 오류! : %s\n", e.getMessage());
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
				System.out.println("DB 커넥션을 커넥션 풀에 반납");
			}
		}

	}
}









