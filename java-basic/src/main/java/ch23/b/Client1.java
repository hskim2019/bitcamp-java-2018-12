// 데이터 주고 받기 - 클라이언트 만들기 
package ch23.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {
  public static void main(String[] args)  {
    
    // 서버와 데이터를 주고 받을 수 있도록 입출력 스트림 객체를 준비한다
    // => 출력 스트림 객체를 준비하기 
    // 바이너리이기 때문에 텍스트 출력 못함 -> PrintStream 필요, 여기서는 char로 출력하기 위해 PrintWriter 사용
    // => 입력 스트림 객체를 준비하기
    
    try(Socket socket = new Socket("localhost", 8888);
        OutputStream out = socket.getOutputStream();  // 출력 된 것을 socket으로 보냄
        InputStream in = socket.getInputStream()) {   // 읽은 것을 socket으로 보냄
      
      
      System.out.println("서버와 연결되었음");

      // 서버에게 데이터 보내기
      // - 보통 클라이언트 쪽에서 먼저 서버로 데이터를 보낸다.
      // - 서버에서 데이터를 모두 받아야만 리ㄴ턴한다
      //   즉 blocking 모드로 작동한다
      // - 실제 write()는 소켓의 내부 버퍼(에) 출력한다. 아직 server에는 전달 안 되었어도 출력 했으므로 다음 코드로 넘어감
      //   따라서 write() 호출 후 즉시 리턴될 것이다
      out.write(100);
      System.out.println("서버에 데이터를 보냈음");
      
      // 서버의 응답을 받는다
      // - 서버가 응답을 할 때까지 리턴하지 않는다
      //   즉 blocking 모드로 작동한다
      int response = in.read();
      System.out.println(response);
      
    } catch (Exception e) {
    } 
    
    
  }

}
