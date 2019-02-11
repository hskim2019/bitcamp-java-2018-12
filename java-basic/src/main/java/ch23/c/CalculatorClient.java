// 계산기 클라이언트 만들기 : +, -, *, /, % 지원
package ch23.c;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
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


    try ( Scanner keyboard = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        DataOutputStream out = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()))) {


      System.out.println(in.readUTF());    //계산기 서버에 오신걸
      
      while(true) {
        System.out.print("> ");
        out.writeUTF(keyboard.nextLine());    //계산식 보내기
        out.flush();
        
        //System.out.println(in.readUTF());
        String response = in.readUTF();
        if(response.equals("안녕히 가세요"))
          break;
        else {
          System.out.println(response);
        }
        
      }
    } catch(Exception e) {
      e.printStackTrace();
    }

  }
}