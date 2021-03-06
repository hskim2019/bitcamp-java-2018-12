package com.eomcs.lms.dao.mariadb;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao{

	SqlSessionFactory sqlSessionFactory;

	public PhotoBoardDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<PhotoBoard> findAll(Map<String,Object> params) {   // list
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
		      return sqlSession.selectList("PhotoBoardMapper.findAll", params);
		    }
	}


	@Override
	public void insert(PhotoBoard photoBoard) {   //add
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
		      sqlSession.insert("PhotoBoardMapper.insert", photoBoard);
		      sqlSession.commit();
		    }
	}


	@Override
	public PhotoBoard findByNo(int no) {    //detail
		
	    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
		      PhotoBoard photoBoard = sqlSession.selectOne("PhotoBoardMapper.findByNo", no);
		      if (photoBoard != null) {
		        sqlSession.update("PhotoBoardMapper.increaseCount", no);
		        sqlSession.commit();
		      }
		      return photoBoard;
		    }

	}
	
	
	
	@Override
	public PhotoBoard findWithFile(int no) {    //detail
		
	    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
		      PhotoBoard photoBoard = sqlSession.selectOne(
		    		  "PhotoBoardMapper.findWithFile", no);
		      if (photoBoard != null) {
		        sqlSession.update("PhotoBoardMapper.increaseCount", no);
		        sqlSession.commit();
		      }
		      return photoBoard;
		    }

	}
	
	
	

	public int update(PhotoBoard photoBoard) {
		
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
		      int count = sqlSession.update("PhotoBoardMapper.update", photoBoard);
		      sqlSession.commit();
		      return count;
		    }
	}

	public int delete(int no) {
		
		  try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
		      int count = sqlSession.delete("PhotoBoardMapper.delete", no);
		      sqlSession.commit();
		      return count;
		    }
	}
}
