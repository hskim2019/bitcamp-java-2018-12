// java.sql.ResultSet 객체 - 서버에서 select의 결과를 가져오기 II
package ch25.a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test08 {

  public static void main(String[] args) {

    // DriverManager의 getConnection()을 호출하면
    // => org.mariadb.jdbc.Driver.connect() 가 호출 됨
    
    try(Connection con = DriverManager.getConnection(
        "jdbc:mariadb://localhost/bitcampdb?user=bitcamp&password=1111")) {
          System.out.println("DBMS 연결됨");

          // Connection 객체를 통해 SQL을 DBMS에 전달할 떄 사용할 도구를 얻는다.
          // => java.sql.Statement 구현체이다
          try(Statement stmt = con.createStatement()) {
            
            // Statement 구현체를 이용하여 SQL문을 서버에 전달한다
            // executeUpdate() : insert, update, delete 등 DDL, DMS문법을 전달한다
            // executeQuery() : select 문법을 전달한다
            // execute() : 모든 SQL문을 전달한다
            // executeBatch() : 여러 개의 SQL문을 전달한다

            // ResultSet 객체?
            // => 서버의 select 실행 결과를 가져온다
            // => 단 한 개씩 가져온다. 한 번에 모두 가져오는 것이 아니다
            // 
            
            ResultSet rs = stmt.executeQuery("select * from x_board order by board_id desc");

            // next() : 
            //       서버에서 한 개의 row(=record)를 가져온다
            //       만약 가져오지 못했으면 false를 리턴
            while(rs.next()) {
              // 레코드에서 컬럼 값을 꺼낼 때 컬럼 번호를 지정하는 것 보다
              // 컬럼의 이름을 지정하는 것이 유지보수에 더 좋음
              
              System.out.printf("%d, %s, %s, %s, %d\n",
                  rs.getInt("board_id"),  
                  rs.getString("title"), 
                  rs.getString("contents"), 
                  rs.getDate("created_date"), 
                  rs.getInt("view_count"));
            }
            
            System.out.println("입력 성공");
          }
          
          
    } catch (Exception e) {
      e.printStackTrace();
    }
  }



}
