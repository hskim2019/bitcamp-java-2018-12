package com.eomcs.lms.dao;

import java.util.List;

import com.eomcs.lms.domain.PhotoFile;

public interface PhotoFileDao {

	void insert(PhotoFile photoFile);   //add
	List<PhotoFile> findByPhotoBoardNo(int photoBoardNo);   //list    photoboard/detail 명령 시 해당 게시물의 사진 list 나오게 하기 위해서
	//PhotoFile findByNo(int no);          // detail
	//int update(PhotoFile photoFile);    //update
	int deleteByPhotoBoardNo(int photoBoardNo);                   //delete
}
