// Stateless 서버 만들기 
package ch23.d;
//계산기 서버 만들기 - 3단계: 연산자 처리
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      // Stateless 통신 방법
      // => 클라이언트 요청이 들어오면 작업을 수행하고 응답을 한다
      //    응답한 후에 즉시 연결을 끊는다
      //    
      while (true) {
        try (Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream());) {
          System.out.println("클라이언트와 연결됨! 요청 처리중...");
          String[] input = in.readLine().split(" ");
          int a = 0, b = 0, result = 0;
          String op = null;

          try {
            a = Integer.parseInt(input[0]);
            op = input[1];
            b = Integer.parseInt(input[2]);
            result = 0;
          } catch (Exception e) {
            out.println("식의 형식이 바르지 않습니다.");
            out.flush();
            continue; // while문 바로 위로 올라가기, 다음 클라이언트 요청을 받으러
          }
          switch (op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
            case "%": result = a % b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n", op);
              out.flush();
              continue;
          }

          out.printf("결과는 %d 입니다.\n", result);
          out.flush();
        } catch (Exception e) {
          //클라이언트 요청을 처리하다가 예외가 발생하면 무시하고 연결을 끊는다
          System.out.println("클라이언트와 통신 중 오류 발생!");
        }
        System.out.println("클라이언트와 연결 끊음");
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}