package com.eomcs.lms.handler;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand extends AbstractCommand {

	SqlSessionFactory sqlSessionFactory;

	public BoardUpdateCommand(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void execute (Response response) throws Exception {

		try (SqlSession sqlSession = sqlSessionFactory.openSession()){

			//SqlSession으로부터 BoardDao 구현체를 얻는다
			BoardDao boardDao = sqlSession.getMapper(BoardDao.class);

			int no = response.requestInt("번호? ");
			Board board = boardDao.findByNo(no);
			if(board == null) {
				response.println("해당번호의 게시물이 없습니다.");
				return;
			}

			Board temp = new Board();
			temp.setNo(no);

			String input = response.requestString(String.format("내용(%s)?", board.getContents()));
			if(input.length() > 0)
				temp.setContents(input);

			if(temp.getContents() != null) {
				boardDao.update(temp);
				sqlSession.commit();
				response.println("변경했습니다.");
			} else {
				response.println("변경 취소했습니다.");
			}
		}
	}
}
