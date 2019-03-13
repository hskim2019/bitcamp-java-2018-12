package com.eomcs.lms.handler;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoBoardDetailCommand extends AbstractCommand {

	SqlSessionFactory sqlSessionFactory;

	public PhotoBoardDetailCommand(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void execute(Response response) throws Exception{

		try (SqlSession sqlSession = sqlSessionFactory.openSession()){

			//SqlSession으로부터 BoardDao 구현체를 얻는다
			PhotoBoardDao photoBoardDao = sqlSession.getMapper(PhotoBoardDao.class);


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
			sqlSession.commit();

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

}
