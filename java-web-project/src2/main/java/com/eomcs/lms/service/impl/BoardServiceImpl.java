package com.eomcs.lms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.service.BoardService;

// 스프링 IoC 컨테이너가 관리하는 객체 중에서 
// 비지니스 로직을 담당하는 객체는
// 특별히 그 역할을 표시하기 위해 @Component 대신에 @Service 애노테이션을 붙인다
// 이렇게 애노테이션으로 구분해두면 나중에 애노테이션으로 객체를 찾을 수 있다
@Service
public class BoardServiceImpl implements BoardService{
	
	BoardDao boardDao;
	
	public BoardServiceImpl (BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	
	// 비지니스 객체에서 메서드 이름은 가능한 업무 용어를 사용한다
	@Override
	public int add(Board board) {
		// 이 메서드도 하는 일이 없다
		// 그래도 일관된 프로그래밍을 위해 COmmand 객체는 항상 Service 객체를 경유하여 DAO를 사용해야 한다
		return boardDao.insert(board);
	}
	
	@Override
	public List<Board> list() {
		// 게시물 목록을 가져오는 경우 서비스 객체에서 특별하게 할 일이 없다
		// 그럼에도 불구하고 Command 객체와 DAO 사이에 Service 객체를 두기로 헀으면
		// 일관성을 위해 Command 객체는 항상 Service객체를 통해 데이터를 다뤄야 한다
		return boardDao.findAll();
	}

	@Override
	public Board get(int no) {
		Board board = boardDao.findByNo(no);
		// Command 객체는 데이터를 조회한 후 조회수를 높이는 것에 대해 신경 쓸 필요가 없어졌다
		if(board != null) {
			boardDao.increaseCount(no);
		}
		return board;
	}
	
	@Override
	public int update(Board board) {
		return boardDao.update(board);
	}
	
	@Override
	public int delete(int no) {
		return boardDao.delete(no);
	}
}
