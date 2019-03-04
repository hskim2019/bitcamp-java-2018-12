package com.eomcs.lms.handler;
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

		photoBoard.setTitle(response.requestString("제목?")); // PhotoBoard에 입력받은 내용 set
		photoBoard.setLessonNo(response.requestInt("수업번호?"));
		photoBoardDao.insert(photoBoard);  //PhotoBoard set한 내용을 DB에 insert하기

		response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
		response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

		int count = 0;
		while(true) {
			String filePath = response.requestString("사진 파일?");
			if(filePath.length() == 0) {
				if(count == 0) {
					response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
					continue;
				} else {
					break;
				}
			}
			PhotoFile file = new PhotoFile();
			file.setFilePath(filePath);
			file.setPhotoBoardNo(photoBoard.getNo()); // 사진 게시물을 입력한 후 자동 생성된 PK값을 꺼낸다

			// 첨부파일을 DB에 저장한다
			photoFileDao.insert(file);
			count++;
		}


		response.println("사진을 저장하였습니다.");

	}
}
