package com.eomcs.lms.handler;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardListCommand extends AbstractCommand  {

	//BoardDao boardDao;
	SqlSessionFactory sqlSessionFactory;

	public BoardListCommand(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void execute(Response response) throws Exception{
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()){
		
		//SqlSession으로부터 BoardDao 구현체를 얻는다
		BoardDao boardDao = sqlSession.getMapper(BoardDao.class);
		
		List<Board> boards = boardDao.findAll();

		for (Board board : boards) {
			response.println(String.format("%3d, %-20s, %s, %d", 
					board.getNo(), board.getContents(), 
					board.getCreatedDate(), board.getViewCount()));
			
		}
		}
	}

}
