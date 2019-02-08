// 계산기 클라이언트 만들기 : +, -, *, /, % 지원
package ch23.c;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
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
public class CalculatorClient {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);
    
    try (Socket socket = new Socket("localhost", 8888);
    DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
    Scanner in = new Scanner(socket.getInputStream());) {
      
      
      System.out.println(in.nextLine());
      System.out.println(in.nextLine());
      System.out.println(in.nextLine());
      
      out.writeUTF(keyboard.nextLine());
      out.flush();
      
      
      
    } catch(Exception e) {
      System.out.println("?");
    }
  }
}
