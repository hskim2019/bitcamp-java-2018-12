// 2단계 : 서버 실행 테스트
package com.eomcs.lms;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import com.eomcs.lms.domain.Member;

public class ServerTest {

  static ObjectOutputStream out;
  static ObjectInputStream in;

  public static void main(String[] args) {

    try(Socket socket = new Socket("localhost", 8888);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream())) {

      ServerTest.out = out;
      ServerTest.in = in;

      System.out.println("서버와 연결되었음.");

      add(new Member(1, "홍길동"));
      add(new Member(2, "임꺽정"));

      list();

      out.writeUTF("okok"); out.flush();
      System.out.println(in.readUTF());

      quit();

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버와의 연결을 끊었음.");


  } //main

  static void add(Object object) throws Exception {
    out.writeUTF("add"); 
    out.writeObject(object);
    out.flush();
    System.out.println(in.readUTF());
  }

  static void list() throws Exception {
    out.writeUTF("list"); out.flush();
    @SuppressWarnings("unchecked")
    List<Member> members = (List<Member>) in.readObject();
    for (Member m : members) {
      System.out.println(m);
    }
  }

  static void quit() throws Exception {
    out.writeUTF("quit"); out.flush();
    System.out.println(in.readUTF());
  }

}
