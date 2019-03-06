// selectOne()과 selectList()
package ch26.d;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ch26.d.Board;

public class Test01 {

	public static void main(String[] args) throws Exception {
		
		// 1) mybatis 설정 파일을 읽을 때 사용할 도구를 준비한다
		String resource = "ch26/d/mybatis-config.xml";
		// 3) BoardManger.xml 파일 변경
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		// 2) mybatis 설정 파일에 따라 동작할 SQL 실행 도구를 준비한다
		// => SqlSessionFactoryBuilder : 
		//       - SqlSessionFactory를 만들어 주는 일
		// => SqlSessionFactory : 
		//        -SqlSession 객체를 만들어 주는 일
		//        - Factory Method 디자인 패턴이 적용되어 있다
		//          (객체 생성 과정이 복잡할 경우 메서드를 통해 객체를 생성하는 것이 유지보수에 좋다)
		
		// => SqlSession : SQL 매퍼 파일에 보관된 SQL을 찾아 실행해주는 일
		SqlSessionFactory sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		
		// 3) 팩토리 메서드를 통해 객체를 생성한다
		// SqlSession안에 JDBC들어 있음
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// 4) SQL 매퍼 파일에 보관된 SQL문을 찾아 실행한다
		// => 파라미터 값은 SQL문의 id이다
		// => SQL 매퍼 파일의 namespace 값과 SQL ID 값을 결합해서 지정한다
		// => selectList()의 리턴 값은 SQL 매퍼 파일의 resultType에 지정된 객체를 담고 있는 List객체이다

		List<Board> list = sqlSession.selectList("board.select1");
		// selectList()
		// => 여러 개의 결과 값을 리턴하는 select를 실행할 때 사용한다.
		// => select 실행으로 생성된 각 row의 값은 resultType에 지정한 클래스의 인스턴스에 저장된다
		// => 그리고 그 인스턴스는 List 구현체에 담겨 리턴된다
		
		// 5) 출력
		for (Board b : list) {
			System.out.printf("%d, %s, %s, %s, %d\n", 
					b.getBoard_id(),
					b.getTitle(),
					b.getContents(),
					b.getCreated_date(),
					b.getView_count());
		}
		
		System.out.println("-------------------------------------");

		// selectOne()
		// => 한 개의 결과 값을 리턴하는 select를 실행할 때 사용한다
		// => 만약 여러 개의 결과가 리턴되는 select를 실행한다면 예외가 발생한다
		
		// board.select1 SQL문은 여러 개의 결과값이 리턴되기 때문에 selectOne()으로 실행하면 
		// 실행 오류가 발생한다
		// selectList를 실행해야 한다
		//Board board = sqlSession.selectOne("board.select1");
		//System.out.println(board); // 실행 오류
		
		Board board = sqlSession.selectOne("board.select2");
		System.out.println(board);
		
	}
}
