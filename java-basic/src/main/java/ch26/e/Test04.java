// delete 실행
package ch26.e;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test04 {

	public static void main(String[] args) throws Exception {

		String resource = "ch26/e/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		
		int count = sqlSession.insert("board.delete", 40);
		System.out.println("--------------------------------");
		
        sqlSession.commit();
        
		List<Board> boards = sqlSession.selectList("board.select1");
		for (Board b : boards) {
			System.out.println(b);
		}
		System.out.println("--------------------------------");


	}
}
