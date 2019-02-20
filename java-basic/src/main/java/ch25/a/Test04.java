// java.sql.Driver 구현체 조회
package ch25.a;

import java.sql.DriverManager;

public class Test04 {

  public static void main(String[] args) {

    try {
      //JDBC URL을 이용하여 등록된 java.sql.Driver 구현체를 알아낸다
      java.sql.Driver driver = DriverManager.getDriver("jdbc:mariadb:");
          System.out.println(driver);
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류발생");
      e.printStackTrace();
    }
  }



}
