// 데이터 주고 받기 - 파일 받는 서버 만들기
package ch23.b;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server3 {
  public static void main(String[] args)  {


    try(ServerSocket serverSocket= new ServerSocket(8888);
        Scanner keyboard = new Scanner(System.in)) {
      System.out.println("서버 소켓 생성 완료!");
      System.out.println("클라이언트의 연결을 기다림");

      try(
          Socket socket = serverSocket.accept();  //대기열에서 클라이언트 연결 정보를 꺼내 소켓 객체를 준비 : 클라이언트와 통신 할 socket객체
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          DataInputStream in = new DataInputStream (
              new BufferedInputStream (socket.getInputStream()))) {


        System.out.println("클라이언트가 연결되었음");
        // 클라이언트가 보낼 데이터의 크기를 먼저 읽는다
        long fileLen = in.readLong();
        System.out.printf("보내는 파일의 크기: %d byte\n", fileLen);

        // 클라이언트가 보내는 파일의 이름
        String filename = in.readUTF();
        System.out.printf("파일명: %s\n", filename);

        // 클라이언트가 보내는 데이터를 서버쪽 폴더에 저장한다
        File file = new File("temp/download/" + filename);   // 해당 이름으로 저장할 것

        // 클라이언트가 보낸 데이터를 읽어서 출력한다
        try(BufferedOutputStream fileOut= new BufferedOutputStream(new FileOutputStream(file))) {

          System.out.println("파일을 받는 중...");
          for ( long i = 0; i < fileLen; i++) {
            fileOut.write(in.read());   //소켓에서 읽은 바이트를 버퍼에 저장한다
            // 버퍼가 모두 차면 자동으로 파일에 출력할 것이다
          }
          // 버퍼에 남은 데이터를 마저 출력한다
          fileOut.flush();
          System.out.println("다운로드 완료");
          
          out.println("success");
          out.flush();
          
        }  catch (Exception e) {
          out.println("fail");
          out.flush();
          e.printStackTrace();
        }
        System.out.println("클라이언트에게 응답했음");

      }
      System.out.println("클라이언트와의 연결을 끊었습니다");

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("서버 종료!");
  }

}
