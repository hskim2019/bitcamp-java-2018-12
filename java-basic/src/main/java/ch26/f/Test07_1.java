// dynamic SQL 다루기 - #{} 과 ${} 사용법
package ch26.f;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test07_1 {

	public static void main(String[] args) throws Exception {

		String resource = "ch26/f/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();

		HashMap<String, Object> params = new HashMap<>();

		// SQL 문장 앞에 오는 키워드를 제거하기
		// 동적 SQL을 다루다 보면 조건에 따라 다음과 같은 문장이 생성될 수 있다
		// where
		//    or title = #{title}
		// 이 때 or 앞에 다른 조건이 없기 때문에 or 를 제거해야 한다
		// 이를 자동으로 처리하려면 <trim> 태그를 사용하라!
		Scanner keyboard = new Scanner(System.in);
		System.out.print("정렬할 컬럼? ");
		String column = keyboard.nextLine();
		if(column.length() > 0) {
			params.put("column",column);
		}
		
		System.out.print("정렬방식? ");
		String sort = keyboard.nextLine();
		if(sort.length() > 0) {
			params.put("sort", sort);
		}

		keyboard.close();

		// 정렬할 컬럼 이름과 정렬 방식(asc 또는 desc) 값을 전달할 수 없다
//		List<Board> boards = sqlSession.selectList("board.select7_error", params);
		
		// 컬럼 이름과 정렬 방식을 값으로 전달 하려면
		// SQL 매퍼 파일에서 #{프로퍼티} 대신 ${프로퍼티}문법을 사용해야 한다
		// 즉 SQL 코드를 직접 삽입하는 것이다
		// 문제는 사용자가 입력한 값을 직접 전달하게 되면 "SQL 삽입 공격"에 노출 되므로
		// 절대 직접 전달해서는 안된다
		// 다음과 같이 자바 코드에서 값을 만들어 전달하라
		// 다음 Test07_2 클래스와 같이 자바 코드에서 만든 값을 전달하라
		
		// 이 예제는 사용자가 입력한 값을 그대로 SQL 코드에 삽입하는 예이다
		// => SQL 삽입 공격이 가능한 상황이다
		List<Board> boards = sqlSession.selectList("board.select7_ok", params);

		for (Board b : boards) {
			System.out.println(b);
		}
		System.out.println("--------------------------------");


	}
}
