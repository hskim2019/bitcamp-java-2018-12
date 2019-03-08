package com.eomcs.lms.dao;

import java.util.List;
import java.util.Map;

import com.eomcs.lms.domain.PhotoBoard;

public interface PhotoBoardDao {

	void insert(PhotoBoard photoBoard);   //add
	List<PhotoBoard> findAll(Map<String,Object> params); //list
	PhotoBoard findByNo(int no);          // detail
	PhotoBoard findWithFile(int no);    // 첨부파일과 같이 조회
	int update(PhotoBoard photoBoard);    //update
	int delete(int no);                   //delete
}
