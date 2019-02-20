// java.sql.Connection 객체
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;

public class Test05 {

  public static void main(String[] args) {

    // DriverManager의 getConnection()을 호출하면
    // => org.mariadb.jdbc.Driver.connect() 가 호출 됨
    
    try(Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
          System.out.println("DBMS 연결됨");
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류발생");
      e.printStackTrace();
    }
  }



}
