// 계산기 서버 만들기 : +, -, *, /, % 지원
package ch23.c;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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

    try (
        ServerSocket serverSocket = new ServerSocket(8888, 5);
        Scanner keyboard = new Scanner(System.in);) {
      System.out.println("연결기다림");

      try(Socket socket = serverSocket.accept(); 
          DataOutputStream out = new DataOutputStream (new BufferedOutputStream(socket.getOutputStream()));
          DataInputStream in = new DataInputStream(new BufferedInputStream(socket.getInputStream()))){


        out.writeUTF("계산기 서버에 오신 걸 환영합니다!\n계산식을 입력하세요\n예) 23 + 7");
        out.flush();


        while(true) {

          String input =  in.readUTF();
          String[] inputarr = input.split(" ");

          if(input.equalsIgnoreCase("quit")) {
            out.writeUTF("안녕히 가세요");
            out.flush();
            break;
          }


          if(!isNumber(inputarr[0]) || !isNumber(inputarr[2])) {
            out.writeUTF("식의 형식이 잘못되었습니다"); 
            out.flush();
          } 
          else {
            int a = Integer.parseInt(inputarr[0]);
            int b = Integer.parseInt(inputarr[2]);
            String c = inputarr[1];

            if(c.equals("+")) {
              out.writeUTF("결과는" +plus(a , b) + "입니다.");
              out.flush();
            } else if(c.equals("-")) {
              out.writeUTF("결과는" +minus(a , b) + "입니다.");
              out.flush();
            } else if(c.equals("*")) {
              out.writeUTF("결과는" + multi(a , b) + "입니다.");
              out.flush();
            } else if(c.equals("/")) {
              out.writeUTF("결과는" + divide(a , b) + "입니다.");
              out.flush();
            } else if(c.equals("%")) {
              out.writeUTF("결과는" + left(a , b) + "입니다.");
              out.flush();
            } else {
              out.writeUTF(inputarr[1] + " 연산식을 지원하지 않습니다.");
              out.flush();
            }
          }
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
    } catch (Exception e2) {
      e2.printStackTrace();
    }
  }

  public static boolean isNumber(String str){
    boolean result = false;

    try{
      Double.parseDouble(str) ;
      result = true ;
    }catch(Exception e){}
    return result ;
  }

  public static int plus(int a, int b) {
    int result = a + b;
    return result;
  }

  public static int minus(int a, int b) {
    int result = a - b;
    return result;
  }

  public static int multi(int a, int b) {
    int result = a * b;
    return result;
  }

  public static float divide(int a, int b) {
    float result = (float) a /(float) b;
    return result;
  }
  public static int left(int a, int b) {
    int result = a % b;
    return result;
  }

}