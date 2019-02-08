// 계산기 서버 만들기 : +, -, *, /, % 지원
package ch23.c;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/*실행 예 :
- 클라이언트가 계산기 서버에 접속한 후
 
 계산기 서버에 오신 걸 환영합니다!<== 서버의 응답
 계산식을 입력하세요!            <== 서버의 응답
 예) 23 + 7                     <== 사용자의 입력. '>' 문자는 클라이언트에서 출력한다
 > 23 + 7   (입력 받을 수 있게)  <== 서버의 응답
 결과는  ** 입니다 (입력값에 따라 결과값 출력) 
 > 23 ^ 7
 ^ 연산식을 지원하지 않습니다
 > ok + yes
 식의 형식이 잘못되었습니다
 > quit
 안녕히 가세요
 
 */
public class CalculatorServer {
  
  public static void main(String[] args) throws Exception {
    
    ServerSocket serverSocket = new ServerSocket(8888);
    Scanner keyboard = new Scanner(System.in);
    System.out.println("연결기다림");
    
    Socket socket = serverSocket.accept();  // 클라이언트와 통신할 객체
    PrintWriter out = new PrintWriter(socket.getOutputStream());
    DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
   
    
    out.write("계산기 서버에 오신 걸 환영합니다!\n계산식을 입력하세요\n예) 23 + 7\n");
    out.flush();
    
    String server =  in.readUTF();
    char[] arr = new char[server.length()];
    System.out.println(arr[0]);
    System.out.println(arr[1]);
    System.out.println(arr[2]);
    System.out.println(arr[3]);
    System.out.println(arr[4]);
    
    
    
    
  }


}
