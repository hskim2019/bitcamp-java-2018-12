// Mybatis 설정하기 III
// => 도메인 클래스의 별명을 부여하기
// => SQL 매퍼 파일에서 데이터를 리턴하거나 파라미터로 데이터를 받을 때
//    클래스의 전체 이름(패키지 이름을 포함)을 지정해야 한다.
// => 패키지 이름이 길 경우 사용하기가 번거롭다.
//    그래서 클래스 전체 이름에 대해 별명을 지정하고 그 별명을 사용한다.

package ch26.c;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ch26.c.Board;

public class Test01 {

	public static void main(String[] args) throws Exception {
		
		// 1) mybatis-config.xml 변경
		//    - 클래스 전체 이름에 대해 별명을 지정한다
		// 2) BoardManager.xml 변경
		//   - 결과를 담을 클래스를 지정할 때 클래스 전체 이름을 사용하는 대신에
		//     mybatis 설정 파일에 등록된 별명을 사용할 수 있다
		
		// 1) mybatis 설정 파일을 읽을 때 사용할 도구를 준비한다
		String resource = "ch26/c/mybatis-config.xml";
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
		
		// 5) 출력
		for (Board b : list) {
			System.out.printf("%d, %s, %s, %s, %d\n", 
					b.getBoard_id(),
					b.getTitle(),
					b.getContents(),
					b.getCreated_date(),
					b.getView_count());
		}
		

	}
}
