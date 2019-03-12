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

		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {  //Thread에서 생성한 session을 열어서 insert함, commit과 close는 아직 안 됨
			sqlSession.insert("PhotoBoardMapper.insert", photoBoard);
		}
	}


	@Override
	public PhotoBoard findByNo(int no) {    //detail

		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			PhotoBoard photoBoard = sqlSession.selectOne("PhotoBoardMapper.findByNo", no);
			if (photoBoard != null) {
				sqlSession.update("PhotoBoardMapper.increaseCount", no);
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
			}
			return photoBoard;
		}

	}




	public int update(PhotoBoard photoBoard) {

		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.update("PhotoBoardMapper.update", photoBoard);
		}
	}

	public int delete(int no) {

		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.delete("PhotoBoardMapper.delete", no);
		}
	}
}
