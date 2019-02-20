// DBMS에 연결하기 - java.sql.Driver 구현체 자동 등록 I
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;


public class Test02 {

  public static void main(String[] args) {
    
    try {
      // java.sql.Driver 인터페이스를 구현한 클래스를 로딩하면
      // 해당 클래스에서 자신을 자동으로 DriverManager 에게 등록할 것이다.
      // org.mariadb.jdbc.Driver클래스의 소스를 확인해보라
      // static 블록에서 Driver 객체를 만들어 DriverManager에게 등록한다
     // 이 방식의 장점은 소스 코드에 특정 클래스를 지정하지 않는다는 것이다
      // 클래스 이름을 문자열로 전달할 수 있기 때문에
      // 특정 클래스에 종속되지 않게 작성할 수 있다
      Class.forName("org.mariadb.jdbc.Driver");
      // (~~) ~라는 이름의 클래스를 로딩하는 것
      
    } catch (Exception e) {
      System.out.println("MariaDB의 java.sql.Driver 구현체를 등력하는 중에 오류 발생!");
      e.printStackTrace();

    }

    // 2) 드라이버 구현체를 이요하여 DBMS에 연결한다
    // => DBMS에 연결되면 소켓 정보를 갖고 있는 java.sql.Connection 구현체를 리턴한다
    // => DriverManager에게 요청한다. 어느 서버에 접속할 것인지 정보를 제공해야 한다
    // => DriverManger는 이전에 등록된 Driver 구현체에게 위임한다
    // => Driver구현체(org.mariadb.jdbc.Driver 객체) 는 DBMS와 연결한 후 소켓 정보를
    //     java.sql.Connection 구현체에 담아 리턴한다
    // => DriverManager.getConnection(jdbcUrl, username, password
    //      jdbcUrl => jdbc:(mysql 또는 mariadb)://서버주소:포트번호/데이터베이스명
    //       포트번호를 지정하지 않으면 기본인 3306이다
    //       username => 데이터베이스를 사용할 수 있는 DBMS에 등록된 사용자
    //         password => 암호

    try {
      Connection con = DriverManager.getConnection(
          "jdbc:mariadb://localhost/bitcampdb", "bitcamp", "1111");
      System.out.println("DBMS에 연결 성공");
    } catch (Exception e) {
      System.out.println("DBMS에 연결 중 오류발생");
      e.printStackTrace();
    }
  }



}
