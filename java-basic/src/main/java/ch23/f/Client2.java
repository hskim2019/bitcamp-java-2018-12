// Connection-Oriented vs Connectionless
package ch23.f;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {

  @SuppressWarnings("static-access")
  public static void main(String[] args) {


    // Connectionless
    // => 서버와 연결 없이 데이터를 보내고 받을 수 있다
    // => DatagramSocket, DatagramPcket을 사용하여 처리한다
    // 예) 편지, ping 등
    // => 응용) 모니터링 프로그램에서 많이 사용한다

    // => 받는쪽에서는 소켓을 생성할 때 포트번호를 설정한다
    try(DatagramSocket socket = new DatagramSocket()){

      for(int i = 0; i < 100; i ++ ) {
        // 보낼 데이터와 상대편(받는 이) 주소를 패킷에 담는다
        byte[] bytes = String.format("Hello! - %d", i).getBytes("UTF-8");
        DatagramPacket packet = new DatagramPacket(
            bytes, // 보내는 데이터 (바이트 배열)
            bytes.length, //바이트 배열의 크기
            InetAddress.getByName("localhost"), // 받는이의 주소
            8888 //받는이의 포트 번호
            );

        // 소켓을 이용하여 패킷을 네트워크로 내보낸다
        socket.send(packet);
        System.out.println(i + " - 데이터 전송 완료(단 상대편이 해당 패킷을 받았는지는 보장 못함)");

        Thread.currentThread().sleep(500); // 0.5초마다 쉼
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }

}
