package com.eomcs.lms.service;

import java.util.List;

import com.eomcs.lms.domain.Board;

public interface BoardService {
	
	List<Board> list();
	int add(Board board);
	Board get(int no);   // detail
	int update(Board board);
	int delete(int no);
	

}
