package com.eomcs.lms.handler;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDetailCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao;

  public PhotoBoardDetailCommand(PhotoBoardDao photoBoardDao) {
    this.photoBoardDao = photoBoardDao;
  }

  @Override
  public void execute(Response response) throws Exception{

    int no = response.requestInt("번호? ");

      PhotoBoard photoBoard = photoBoardDao.findByNo(no);
      if(photoBoard == null) {
        response.println("해당 번호의 게시물이 없습니다.");
        return;
      } 
      response.println(String.format("제목: %s", photoBoard.getTitle()));
      response.println(String.format("작성일: %s", photoBoard.getCreatedDate()));
      response.println(String.format("조회수: %d", photoBoard.getViewCount()));
      response.println(String.format("수업: %d", photoBoard.getLessonNo()));
      
  }
}
