package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardSearchCommand extends AbstractCommand  {

  BoardDao boardDao;

  public BoardSearchCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(Response response) throws Exception{
    
    String keyword = response.requestString("검색어? ");
    
      List<Board> boards = boardDao.findByKeyword(keyword);

      for (Board board : boards) {
        response.println(String.format("%3d, %-20s, %s, %d", 
            board.getNo(), board.getContents(), 
            board.getCreatedDate(), board.getViewCount()));

    } 
  }

}
