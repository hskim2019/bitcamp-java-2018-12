// 연습 - 게시물 변경
package ch25.b;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BoardUpdateApp {

  // 다음과 같이 게시물을 변경하는 프로그램을 작성하라!
  // ----------------------------
  // 번호? 1
  // 제목? xxx
  // 내용? xxxxx
  // 변경하였습니다.
  // (또는)
  // 해당 번호의 게시물이 존재하지 않습니다.
  //----------------------------
  public static void main(String[] args) {
  String no;
  String title;
  String contents;
  
  try(Scanner keyboard = new Scanner(System.in)) {
    System.out.print("번호? ");
    no = keyboard.nextLine();
    
    System.out.print("제목? ");
    title = keyboard.nextLine();
    
    System.out.print("내용? ");
    contents = keyboard.nextLine();
  }
  
  try(Connection con = DriverManager.getConnection("jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
    
    try(PreparedStatement stmt = con.prepareStatement(
        "update x_board set title =?, contents =? where board_id =?")) {
      
      stmt.setString(3, no);
      stmt.setString(1, title);
      stmt.setString(2, contents);
      
      int count = stmt.executeUpdate();
      
      if(count == 0) {
        System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
      } else {
        System.out.println("변경하였습니다.");
      }
    }
  } catch(Exception e) {
    e.printStackTrace();
  }
    
    
  }

}
