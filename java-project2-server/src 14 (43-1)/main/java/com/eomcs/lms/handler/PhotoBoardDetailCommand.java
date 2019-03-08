package com.eomcs.lms.handler;
import java.util.List;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardDetailCommand extends AbstractCommand {

	PhotoBoardDao photoBoardDao;
	PhotoFileDao photoFileDao;

	public PhotoBoardDetailCommand(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
		this.photoBoardDao = photoBoardDao;
		this.photoFileDao = photoFileDao;
	}

	@Override
	public void execute(Response response) throws Exception{

		int no = response.requestInt("번호? ");

		PhotoBoard photoBoard = photoBoardDao.findByNo(no);
		if(photoBoard == null) {
			response.println("해당 번호의 사진이 없습니다.");
			return;
		} 
		response.println(String.format("제목: %s", photoBoard.getTitle()));
		response.println(String.format("작성일: %s", photoBoard.getCreatedDate()));
		response.println(String.format("조회수: %d", photoBoard.getViewCount()));
		response.println(String.format("수업: %d", photoBoard.getLessonNo()));
		response.println(String.format("사진 파일:"));
		List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(no);
		for (PhotoFile file : files) {
			response.println(String.format("> %s",file.getFilePath()));
		}
	}
}
