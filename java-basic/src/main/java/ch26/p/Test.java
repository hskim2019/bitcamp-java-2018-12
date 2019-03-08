package ch26.p;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {


	public static void main(String[] args) throws Exception {

		String resource = "ch26/p/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory =
				new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();

//				Board board = sqlSession.selectOne("namespace.select1");
//				System.out.println(board);
//				
//				List<Board> boards = sqlSession.selectList("namespace.select2", "ok");
//				for (Board b : boards) {
//					System.out.println(b);
//				}
//				System.out.println("------------------");
				Board board = new Board();
				board.setContents("tt");
				sqlSession.insert("namespace.insert1", board);
				System.out.println(board);
		//sqlSession.commit();
		List<Board> list = sqlSession.selectList("namespace.select1");
		for(Board b : list) {
			System.out.println(b);
		}
//				List<Map<?,?>> list = sqlSession.selectList("namespace.select3", "ok");
//				for(Map<?,?> m : list) {
//					System.out.println(m);
//				}

		//		System.out.println("-------select4");
		//       Scanner keyboard = new Scanner(System.in);
		//        System.out.print("번호? ");
		//        String value = keyboard.nextLine();
		//        
		//        
		//		Board board = new Board();
		//		board.setNo(Integer.parseInt(value));
		//
		//		System.out.println("내용? ");
		//		board.setContents(keyboard.nextLine());
		//		keyboard.close();
		//		
		//        List<Board> list = sqlSession.selectList("namespace.select4", board);
		//        for (Board b : list) {
		//        	System.out.println(b);
		//        }

//		Scanner keyboard = new Scanner(System.in);
//
//		System.out.print("번호?");
//		int no = Integer.parseInt(keyboard.nextLine());
//
//		Board board = sqlSession.selectOne("namespace.selectJoin", no);
//		System.out.println(board);
//
//		System.out.println("첨부파일:");
//		for(Photo f : board.getFiles()) {
//			System.out.println(f);
//		}
		
//		HashMap<String,Object> params = new HashMap<>();
//		Scanner keyboard = new Scanner(System.in);
//		
//		System.out.println("번호? ");
//		int no = Integer.parseInt(keyboard.nextLine());
//		params.put("nooo", no);
//		
//		System.out.println("내용? ");
//		String contents = keyboard.nextLine();
//		params.put("contentssss", contents);
//		
//		sqlSession.update("namespace.update", params);
//		sqlSession.commit();
//		
//        Board board = sqlSession.selectOne("namespace.selectJoin", no);
//        System.out.println(board);
		


	}
}
