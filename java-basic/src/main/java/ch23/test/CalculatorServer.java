package ch23.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

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
public class CalculatorServer {

  public static void main(String[] args) {

    try( ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("연결 기다림");

      while(true) {
        try {  new CalculatorProcessor(serverSocket.accept()).execute();

        } catch (Exception e) {
          System.out.println("클라이언트와 통신 중 오류 발생");
          e.printStackTrace();
        }


      } 
    }catch (Exception e) {
      e.printStackTrace();
    }

  }



}
