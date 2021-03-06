package com.eomcs.lms.dao.mariadb;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

//서버쪽에 있는 MemberDaoImpl 객체를 대행할 클라이언트측 대행자 클래스 정의 
//
public class MemberDaoImpl implements MemberDao {

	// Mybatis 의존 객체 선언
	SqlSessionFactory sqlSessionFactory;

	public MemberDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public List<Member> findAll() {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("MemberMapper.findAll");
		}
	}

	@Override
	public List<Member> findByKeyword(String keyword) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectList("MemberMapper.findByKeyword", keyword);
		}
	}

	public void insert(Member member) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			sqlSession.insert("MemberMapper.insert", member);
		}
	}

	public Member findByNo(int no) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.selectOne("MemberMapper.findByNo", no);
		}
	}

	public int update(Member member) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.update("MemberMapper.update", member);
		}
	}

	public int delete(int no) {
		try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
			return sqlSession.delete("MemberMapper.delete", no);
		}
	}
}