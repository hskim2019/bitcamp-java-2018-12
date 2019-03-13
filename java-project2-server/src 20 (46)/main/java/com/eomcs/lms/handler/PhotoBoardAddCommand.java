package com.eomcs.lms.handler;
import java.util.ArrayList;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.mybatis.TransactionManager;

public class PhotoBoardAddCommand extends AbstractCommand {

	TransactionManager txManager;
	PhotoBoardDao photoBoardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시 객체이다.
	PhotoFileDao photoFileDao;

	public PhotoBoardAddCommand(PhotoBoardDao photoBoardDao, PhotoFileDao photoFileDao, TransactionManager txManager) {
		this.photoBoardDao = photoBoardDao;
		this.photoFileDao = photoFileDao;
		this.txManager =  txManager;
		this.name = "/photoboard/add";
	}

	@Override
	public void execute(Response response) throws Exception {

		txManager.beginTransaction();
		// original SqlSession 대신 SqlSessionProxy로 포장 된 SqlSession을 사용하고
		// Thread에도 이 객체를 넣어준다 
		try {
			PhotoBoard photoBoard = new PhotoBoard();

			photoBoard.setTitle(response.requestString("사진 제목?")); // PhotoBoard에 입력받은 내용 set
			photoBoard.setLessonNo(response.requestInt("수업번호?"));
			photoBoardDao.insert(photoBoard);  //PhotoBoard set한 내용을 DB에 insert하기

			response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
			response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");
			
			ArrayList<PhotoFile> files = new ArrayList<>();
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
				PhotoFile file = new PhotoFile();
				file.setFilePath(filePath);
				file.setPhotoBoardNo(photoBoard.getNo()); // 사진 게시물을 입력한 후 자동 생성된 PK값을 꺼낸다
                
				files.add(file);
			}

			photoFileDao.insert(files);

			response.println("사진을 저장하였습니다.");
			txManager.commit();

		} catch (Exception e) {
			response.println("저장 중 오류 발생.");
			txManager.rollback();
			e.printStackTrace();
		}

		// 트랜잭션 종료 
		// => 여기서 commit을 수행하는 대신에 이 메서드를 호출한 execute(BufferedReader, PrintWriter)메서드에서 commit 수행하면 된다
		//ApplicationInitializer.con.commit();

		// commit() 호출하지 않아도 목록데이터를 조회할 때 입력된 내용이 출력은 된다
		// 커넥션 객체를 공유하기 때문에
		// commit을 하지 않아도 같은 커넥션에 대해 목록을 조회하면
		// 임시 DB에 보관된 내용까지 함께 조회하기 때문에
		// 겉으로 봐서는 데이터 변경(insert, update, delete)이 완료 된 것처럼 보여진다
		// => 하지만 커넥션을 끊고 다시 커넥션을 연결한 후 데이터를 조회해 보면
		//    commit() 하지 않아서 임시 DB에 보관되었던 데이터는 목록 조회 할 때 출력되지 않는다
		//     즉 commit() 하지 않은 데이터는 커넥션을 끊을 때 자동 제거된다
	}
}
