// select 결과 값을 자바 인스턴스에 온전히 담는 방법 II
package ch26.d;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {

	public static void main(String[] args) throws Exception {
		
		String resource = "ch26/d/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =
		  new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		// mybatis 의 SqlSession이 "board.select3" SQL 문을 실행한 후
		// 그 결과는 SQL매퍼 파일에 지정된대로 ch26.d.Board2 인스턴스에 담아 리턴한다
		// 그런데 다음과 같이 전혀 다른 타입의 레퍼런스로 받으려 하면 오류가 발생한다
		//Board board = sqlSession.selectOne("board.select3"); // 실행오류
		//System.out.println(board);
		
		// select 문에서 컬럼을 지정할 때 자바의 인스턴스의 프로퍼티에 맞추기 위해
		// 별명을 부여하는 방식은 번거롭다
		// 특히 컬럼 개수가 많은 경우 더더욱 번거롭다
		// 이를 해결하기 위해 컬럼의 이름과 프로퍼티 이름을 미리 설정해두는 문법을 제공한다
		// 
		Board2 board = sqlSession.selectOne("board.select5");
		System.out.println(board);
		
		
	}
}
