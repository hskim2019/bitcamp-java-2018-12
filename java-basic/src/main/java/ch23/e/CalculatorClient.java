// Stateless 클라이언트 만들기

// Stateless 통신방법
// =>서버에 연결한 후 한 번 요청하고 응답 받은 후 연결을 끊는다
// => 단점 : 서버에 요청 할 때 마다 연결해야 한다
//         : 지속적으로 서버에 연결하는데 실행 시간이 소요된다
// => 장점 : 서버에 계속 연결된 상태가 아니기 때문에 서버쪽에서 메모리를 많이 사용하지 않는다
//         : stateful 보다 더 많은 클라이언트 요청을 처리할 수 있다
// => 예 : HTTP 프로토콜, 메신저 등

package ch23.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/*
구현 조건:
- 최소 +, -, *, /, % 연산자는 지원한다.

실행 예:
- 클라이언트가 계산기 서버에 접속한 후 

계산기 서버에 오신 걸 환영합니다! <== 서버의 응답
계산식을 입력하세요! <== 서버의 응답
예) 23 + 7 <== 서버의 응답
> 23 + 7 <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
결과는 30 입니다. <== 서버의 응답
> 23 ^ 7 <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
^ 연산자를 지원하지 않습니다. <== 서버의 응답
> ok + yes <== 사용자의 입력
식의 형식이 잘못되었습니다. <== 서버의 응답
> quit <== 사용자의 입력. '>'문자는 클라이언트에서 출력한다.
안녕히 가세요! <== 서버의 응답

 */

public class CalculatorClient {
  
  public static void main(String[] args) {
    
    long sessionId = 0;
    Scanner keyboard = new Scanner(System.in);

    while(true) {
      System.out.print("> ");
      String input = keyboard.nextLine();
      if(input.equalsIgnoreCase("quit"))
        break;

      try (Socket socket = new Socket("localhost", 8888);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()))) {


        System.out.println("서버와 연결됨! 서버에게 요청함");
        out.println(sessionId);
        out.println(input);
        out.flush();

        if(sessionId == 0) {
          sessionId = Long.parseLong(in.readLine());
          System.out.printf("발급받은 sessionID는 %d 입니다.\n", sessionId);
        }
        String response = in.readLine();
        System.out.println(response);

      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.println("서버와 연결 끊음!");
    } //while
    keyboard.close();
  }
}












