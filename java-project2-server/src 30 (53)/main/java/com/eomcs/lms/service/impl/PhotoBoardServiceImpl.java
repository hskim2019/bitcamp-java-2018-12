package com.eomcs.lms.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

// 스프링 IoC 컨테이너가 관리하는 객체 중에서 
// 비지니스 로직을 담당하는 객체는
// 특별히 그 역할을 표시하기 위해 @Component 대신에 @Service 애노테이션을 붙인다
// 이렇게 애노테이션으로 구분해두면 나중에 애노테이션으로 객체를 찾을 수 있다
@Service
public class PhotoBoardServiceImpl implements PhotoBoardService{

	PhotoBoardDao boardDao;
	PhotoFileDao fileDao;

	public PhotoBoardServiceImpl (PhotoBoardDao boardDao, PhotoFileDao fileDao) {
		this.boardDao = boardDao;
		this.fileDao = fileDao;
	}

	// 비지니스 객체에서 메서드 이름은 가능한 업무 용어를 사용한다
	@Override
	public int add(PhotoBoard board) {

		try {
			int count = boardDao.insert(board);
			
			// 파일을 저장하기 전에 사진 게시물의 번호를 각 사진 객체에 주입해야 한다
			List<PhotoFile> files = board.getFiles();
			for(PhotoFile f : files) {
				f.setPhotoBoardNo(board.getNo());
			}
			fileDao.insert(board.getFiles());
			return count;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public List<PhotoBoard> list(int lessonNo, String searchWord) {
		if(lessonNo <= 0 && searchWord == null) {
			return boardDao.findAll(null);
		} else {
			HashMap<String, Object> params = new HashMap<>();
			if(lessonNo > 0) {
				params.put("lessonNo", lessonNo);
			}
			if(searchWord != null) {
				params.put("keyword", searchWord);
			}
			return boardDao.findAll(params);
		}

	}

	@Override
	public PhotoBoard get(int no) {
		// Command 객체는 데이터를 조회한 후 조회수를 높이는 것에 대해 신경 쓸 필요가 없어졌다
		PhotoBoard board = boardDao.findWithFile(no);
		if(board != null) {
			boardDao.increaseCount(no);
		}
		return board;
	}

	@Override
	public int update(PhotoBoard board) {

		try {
			// PhotoBoard 객체에 제목이 들어 있다는 것은 사용자가 변경했다는 의미다
			if(board.getTitle() != null) {
				boardDao.update(board);
			}

			List<PhotoFile> photoFiles = board.getFiles();
			if(photoFiles != null) {
				// 먼저 기존 첨부 파일을 삭제한다.
				fileDao.deleteByPhotoBoardNo(board.getNo());
				fileDao.insert(photoFiles);
			}

			return 1;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	@Override
	public int delete(int no) {

		try {
			// 데이터를 지울 때는 자식 테이블의 데이터부터 지워야 한다
			fileDao.deleteByPhotoBoardNo(no);
			int count = boardDao.delete(no);

			return count;

		} catch (RuntimeException e){
			throw e;
		}
	}
}
