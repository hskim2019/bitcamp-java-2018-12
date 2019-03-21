package com.eomcs.lms.handler;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.domain.PhotoBoard;
import com.eomcs.lms.domain.PhotoFile;
import com.eomcs.lms.service.PhotoBoardService;

@Component
public class PhotoBoardCommand {

	PhotoBoardService photoBoardService;

	public PhotoBoardCommand(PhotoBoardService photoBoardService) {
		this.photoBoardService = photoBoardService;
	}

	@RequestMapping("/photoboard/add")
	public void add(Response response)  {

		try {
			PhotoBoard board = new PhotoBoard();

			board.setTitle(response.requestString("사진 제목?")); // PhotoBoard에 입력받은 내용 set
			board.setLessonNo(response.requestInt("수업번호?"));

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

				files.add(file);
			}

			board.setFiles(files);

			photoBoardService.add(board);
			response.println("사진을 저장하였습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			response.println("저장 중 오류 발생.");
		}

	}

	@RequestMapping("/photoboard/list")
	public void list(Response response) throws Exception{
		List<PhotoBoard> boards = photoBoardService.list(0, null);

		for (PhotoBoard board : boards) {
			response.println(String.format("%3d, %-20s, %s, %d, %d", 
					board.getNo(), board.getTitle(), 
					board.getCreatedDate(), board.getViewCount(), board.getLessonNo()));

		} 
	}



	@RequestMapping("/photoboard/detail")
	public void detail(Response response) throws Exception{

		int no = response.requestInt("번호? ");

		PhotoBoard photoBoard = photoBoardService.get(no);
		if(photoBoard == null) {
			response.println("해당 번호의 사진이 없습니다.");
			return;
		} 

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


	@RequestMapping("/photoboard/search")
	public void search(Response response) throws Exception{
 int lessonNo = 0;
		try {
			lessonNo = response.requestInt("사진 파일 번호? ");
		} catch (Exception e) { // 수업 번호를 입력하지 않거나 정상 입력이 아닌 경우는 무시
		}

		String searchWord = null;
		try {
			String keyword = response.requestString("검색어?");
			if (keyword.length() > 0)
				searchWord =  keyword;
		} catch (Exception e) { // 사용자가 검색어를 입력하지 않았으면 무시한다
		} 

		List<PhotoBoard> boards = photoBoardService.list(lessonNo, searchWord);

		response.println("[검색 결과]");

		for (PhotoBoard board : boards) {
			response.println(String.format("%3d, %-20s, %s, %d, %d", 
					board.getNo(), board.getTitle(), 
					board.getCreatedDate(), board.getViewCount(), board.getLessonNo()));

		} 
	}


	@RequestMapping("/photoboard/update")
	public void update(Response response) throws Exception {



		try {
			PhotoBoard board = new PhotoBoard();
			board.setNo(response.requestInt("번호?"));

			PhotoBoard origin = photoBoardService.get(board.getNo());
			if (origin == null) {
				response.println("해당 번호의 사진이 없습니다.");
				return;
			}

			String input = response.requestString(
					String.format("제목(%s)?", origin.getTitle()));
			if(input.length() > 0) {
				board.setTitle(input);
			}

			// 변경하려면 사진 게시물의 첨부 파일을 출력한다.
			response.println("사진 파일:");
			List<PhotoFile> files = origin.getFiles();
			for (PhotoFile file : files) {
				response.println("> " + file.getFilePath());
			}
			response.println("");

			response.println("사진은 일부만 변경할 수 없습니다.");
			response.println("전체를 새로 등록해야 합니다.");
			input = response.requestString("사진을 변경하시겠습니까?(y/N)");
			if (input.equalsIgnoreCase("y")) {

				// 그리고 새 첨부 파일을 추가한다.
				response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
				response.println("파일명 입력 없이 그냥 엔터를 치면 파일 추가를 마칩니다.");

				ArrayList<PhotoFile> photoFiles = new ArrayList<>();
				while (true) {
					String filePath = response.requestString("사진 파일?");
					if (filePath.length() == 0) {
						if (photoFiles.size() == 0) {
							response.println("최소 한 개의 사진 파일을 등록해야 합니다.");
							continue;
						} else {
							break;
						}
					}
					PhotoFile file = new PhotoFile();
					file.setFilePath(filePath);
					file.setPhotoBoardNo(board.getNo());// 사진 게시물을 입력한 후 자동 생성된 PK 값을 꺼낸다.

					photoFiles.add(file);
				}

				board.setFiles(photoFiles);

			}

			photoBoardService.update(board);
			response.println("변경했습니다.");
		} catch (Exception e) {
			response.println("변경 중 오류 발생.");
		}
	}


	@RequestMapping("/photoboard/delete")
	public void delete(Response response) throws Exception{


		try { 
			int no = response.requestInt("번호? ");
		

			if( photoBoardService.delete(no)== 0) {
				response.println("해당 번호의 게시물이 없습니다.");
				return;
			}
			response.println("삭제했습니다.");

		} catch (Exception e) {
			response.println("삭제 중 오류 발생.");
		}

	}


}
