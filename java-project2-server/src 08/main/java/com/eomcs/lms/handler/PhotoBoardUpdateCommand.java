package com.eomcs.lms.handler;
import java.util.List;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardUpdateCommand extends AbstractCommand {

	PhotoBoardDao photoBoardDao;
	PhotoFileDao photoFileDao;

	public PhotoBoardUpdateCommand(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao) {
		this.photoBoardDao = photoBoardDao;
		this.photoFileDao = photoFileDao;
	}

	@Override
	public void execute (Response response) throws Exception {

		PhotoBoard photoBoard = new PhotoBoard();
		photoBoard.setNo(response.requestInt("번호? "));
		photoBoard.setTitle(response.requestString("제목? "));

		if(photoBoardDao.update(photoBoard) == 0) {
			response.println("해당 게시물이 없습니다.");
			return;
		}

		// 변경하려면 사진 게시물의 첨부 파일을 출력한다
		response.println("사진 파일:");
		List<PhotoFile> files = photoFileDao.findByPhotoBoardNo(photoBoard.getNo());
		for(PhotoFile file : files) {
			response.println("> " + file.getFilePath());
		}
		response.println("");

		response.println("사진은 일부만 변경할 수 없습니다\n전체를 새로 등록해야 합니다.");
		String input = response.requestString("사진을 변경하시겠습니까?(y/N)");

		if(input.equalsIgnoreCase("y")) {

			//기존 파일을 변경하는 것이 아니라 삭제하고 새로 입력
			photoFileDao.deleteByPhotoBoardNo(photoBoard.getNo());
			
			// 새 파일을 추가
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
			response.println("사진 파일 변경합니다");
		} 



		response.println("변경했습니다.");

	}
}
