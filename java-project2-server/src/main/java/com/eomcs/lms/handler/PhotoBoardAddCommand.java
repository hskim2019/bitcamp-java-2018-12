package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardAddCommand extends AbstractCommand {

  PhotoBoardDao photoBoardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.
  PhotoFileDao photoFileDao;
  
  public PhotoBoardAddCommand(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
    this.photoBoardDao = photoBoardDao;
    this.photoFileDao = photoFileDao;
  }

  @Override
  public void execute(Response response) throws Exception {
      PhotoBoard photoBoard = new PhotoBoard();
      
      photoBoard.setTitle(response.requestString("제목?"));
      photoBoard.setLessonNo(response.requestInt("수업번호?"));
      photoBoardDao.insert(photoBoard);

      response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
      response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");
      
      List<String> files = new ArrayList<>();
      while(true) {
    	  String filePath = response.requestString("사진 파일?");
    	  if(filePath.length() == 0) {
    		  if(files.size() == 0) {
    			   response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
    			   continue;
    		  } else {
    		  break;
    		  }
    	  }
    	  files.add(filePath);
      }

      // 첨부파일을 DB에 저장한다
      for(String filePath : files) {
    	  PhotoFile photoFile = new PhotoFile();
    	  photoFile.setFilePath(filePath);
    	  photoFileDao.insert(photoFile);
      }
      
      response.println("사진을 저장하였습니다.");

  }
}
