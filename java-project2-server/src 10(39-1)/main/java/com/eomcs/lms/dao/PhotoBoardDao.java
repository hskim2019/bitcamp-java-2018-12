package com.eomcs.lms.dao;

import java.util.List;

import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardDao {

	void insert(PhotoBoard photoBoard);   //add
	List<PhotoBoard> findAll();           //list
	PhotoBoard findByNo(int no);          // detail
	int update(PhotoBoard photoBoard);    //update
	int delete(int no);                   //delete
}
