// 2단계 : 클라이언트의 연결을 승인한다
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.lms.domain.Member;

public class ServerApp {

  public static void main(String[] args) {

    try(ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버시작");

      while(true) {
        try(Socket socket = serverSocket.accept();
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()))
        {
          System.out.println("클라이언트와 연결되었음.");

          // 클라이언트에서 serialize해서 보내온 Member 객체의 내용을 출력하라
          Member request =  (Member) in.readObject();
          
          // 그리고 즉시 클라이언트로 Member 객체를 serialize하여 보내라!
          System.out.println(request);
          out.writeUTF("객체를 받았습니다.");
          out.flush();

        } catch (Exception e) {
          e.printStackTrace();
        }
        System.out.println("클라이언트와 연결을 끊었음"); //socket out
      }


    }catch (Exception e) {

    }




  } //main

}
