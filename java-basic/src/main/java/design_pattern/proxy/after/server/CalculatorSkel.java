package design_pattern.proxy.after.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 계산을 수행할 객체

public class CalculatorSkel {
  public static void main(String[] args) {

    // 실제 계산 작업을 수행 할 객체
    Calculator calc = new CalculatorImpl();

    try(ServerSocket ss = new ServerSocket(8888)){
      System.out.println("서버 실행 중...");

      while(true) {
        try(Socket s = ss.accept();
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream())) {

          int a = in.readInt();
          int b = in.readInt();
          String op = in.readUTF();

          switch(op) {
            case "+":
              // 클라이언트 요청을 처리하기 위해 실제 작업을 수행하는 객체를 사용한다
              out.writeUTF("OK");
              out.writeInt(calc.plus(a, b));
              break;
            case "-":
              out.writeUTF("OK");
              out.writeInt(calc.minus(a, b));
              break;
            default : 
              out.writeUTF("FAIL");
          }
          out.flush();
        }catch (Exception e) {
          System.out.println("클라이언트 요청 처리 중에 오류 발생!");
        }


      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }  

}
