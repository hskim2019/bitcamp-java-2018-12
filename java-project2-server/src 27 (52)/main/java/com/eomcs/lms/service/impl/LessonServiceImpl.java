package com.eomcs.lms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.service.LessonService;

// 스프링 IoC 컨테이너가 관리하는 객체 중에서 
// 비지니스 로직을 담당하는 객체는
// 특별히 그 역할을 표시하기 위해 @Component 대신에 @Service 애노테이션을 붙인다
// 이렇게 애노테이션으로 구분해두면 나중에 애노테이션으로 객체를 찾을 수 있다
@Service
public class LessonServiceImpl implements LessonService{
	
	LessonDao lessonDao;
	//PhotoBoardDao photoBoardDao;
	//PhotoFileDao photoFileDao;
	PlatformTransactionManager txManager;
	
	public LessonServiceImpl (
			LessonDao lessonDao, PlatformTransactionManager txManager,
			PhotoBoardDao photoBoardDao,
			PhotoFileDao photoFileDao) {
		this.lessonDao = lessonDao;
		this.txManager = txManager;
		//this.photoBoardDao = photoBoardDao;
		//this.photoFileDao = photoFileDao;
	}
	
	@Override
	public int add(Lesson lesson) {
		return lessonDao.insert(lesson);
	}
	
	@Override
	public List<Lesson> list() {
		// 게시물 목록을 가져오는 경우 서비스 객체에서 특별하게 할 일이 없다
		// 그럼에도 불구하고 Command 객체와 DAO 사이에 Service 객체를 두기로 헀으면
		// 일관성을 위해 Command 객체는 항상 Service객체를 통해 데이터를 다뤄야 한다
		return lessonDao.findAll();
	}

	@Override
	public Lesson get(int no) {
		Lesson lesson  = lessonDao.findByNo(no);
		return lesson;
	}
	
	@Override
	public int update(Lesson lesson) {
		return lessonDao.update(lesson);
	}
	
	@Override
	public int delete(int no) {
		
		// 트랜잭션 동작 방식을 설정한다
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("tx1");
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		// 트랜잭션을 준비한다
		TransactionStatus status = txManager.getTransaction(def);	
		
		try {
           lessonDao.delete(no);
			txManager.commit(status);
			return 1;
		} catch (RuntimeException e) {
			txManager.rollback(status);
		}
		
		return 0;
	}
}
