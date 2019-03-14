package com.eomcs.lms.handler;
import java.util.List;

import com.eomcs.lms.context.Component;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

@Component("/photoboard/detail")
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

		// lms_photo 테이블의 데이터와 lms_photo_file 테이블의 데이터를 조인하여
		// 결과를 PhotoBoard 객체에 저장한다
		// 특히 lms_photo_file 데이터는 PhotoFile 객체에 저장되고,
		// 그 목록은 ??
		PhotoBoard photoBoard = photoBoardDao.findWithFile(no);
		if(photoBoard == null) {
			response.println("해당 번호의 사진이 없습니다.");
			return;
		} 
		
		photoBoardDao.increaseCount(no);
		
		response.println(String.format("제목: %s", photoBoard.getTitle()));
		response.println(String.format("작성일: %s", photoBoard.getCreatedDate()));
		response.println(String.format("조회수: %d", photoBoard.getViewCount()));
		response.println(String.format("수업: %s(%s ~ %s)", photoBoard.getLesson().getTitle(),
				photoBoard.getLesson().getStartDate(),
				photoBoard.getLesson().getEndDate()));
		
		response.println(String.format("사진 파일:"));
		List<PhotoFile> files = photoBoard.getFiles();
		for (PhotoFile file : files) {
			response.println(String.format("> %s",file.getFilePath()));
		}
	}
}
