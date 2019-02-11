// Stateful 클라이언트 만들기

// Stateful 통신방법
// =>서버에 연결한 후 클라이언트에서 연결을 끊을 때까지 계속해서 연결을 유지하며 클라이언트 요청을 처리한다
// => 단점 : 클라이언트와 서버의 연결을 계속 유지하기 때문에 클라이언트에서 요청을 하지 않아도
//           서버쪽에는 클라이언트 정보를 계속 가지고 있어야 하므로 메모리 낭비가 있다 
//         : 클라이언트와 연결되는 개수의 한계가 있기 때문에
//           보다 많은 클라이언트 요청을 처리할 수 없다
// => 장점 : 클라이언트와 서버는 계속 연결된 상태이기 때문에
//           요청할 때마다 연결하지 않기 때문에 시간 소요가 stateless 방식보다 덜하다
//         : 클라이언트 정보를 계속 유지할 수 있다
// => 예 : telnet/ssh, ftp/sftp 등

package ch23.d;
//계산기 클라이언트 만들기 - 2단계: 키보드에서 입력 받은 값을 서버에 보낸다.
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

public class CalculatorClient2 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);


    // 서버에 요청할 때 연결을 하고
    // 연결을 끊을 때 까지 요청/응답을 반복할 수 있다
    // => 매번 요청할 때 마다 서버와 연결할 필요가 없기 때문에 stateless 방식에 비해
    //    요청처리 시간이 적게 걸린다
    // => 대신 서버쪽에는 클라이언트 연결 정보를 계속 유지해야 하기 때문에 메모리를 일정부분 소요한다
    try (Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()))) {

      System.out.println("서버와 연결됨!");

      while(true) {
        System.out.print("> ");
        String input = keyboard.nextLine();


        out.println(input);
        out.flush();
        
        System.out.println("서버에게 계산 작업을 요청함");

        
        String response = in.readLine();
        System.out.println(response);
        
        if(input.equalsIgnoreCase("quit"))
          break;

      } //while

      System.out.println("서버와 연결 끊음!");

    } catch (Exception e) {
      e.printStackTrace();
    }
    keyboard.close();
  }
}












