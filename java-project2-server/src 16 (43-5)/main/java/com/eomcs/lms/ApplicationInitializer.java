package com.eomcs.lms;

import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoBoardDaoImpl;
import com.eomcs.lms.dao.mariadb.PhotoFileDaoImpl;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberSearchCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.lms.handler.PhotoBoardAddCommand;
import com.eomcs.lms.handler.PhotoBoardDeleteCommand;
import com.eomcs.lms.handler.PhotoBoardDetailCommand;
import com.eomcs.lms.handler.PhotoBoardListCommand;
import com.eomcs.lms.handler.PhotoBoardUpdateCommand;
import com.eomcs.mybatis.SqlSessionFactoryProxy;
import com.eomcs.mybatis.TransactionManager;

// App 객체의 상태가 변경될 때 마다 보고 받는 옵저버가 되려면
// ApplicationContextListener 규격에 따라 작성해야 한다
public class ApplicationInitializer implements ApplicationContextListener {


	@Override
	public void contextInitialized(Map<String, Object> context) {
		try {
            //Mybatis의 SqlSessionFactory 준비
			SqlSessionFactory sqlSessionFactory =
			  new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(
					  "com/eomcs/lms/conf/mybatis-config.xml"));
			
			  // SqlSessionFactory 구현체의 프록시를 만든다.
		      SqlSessionFactoryProxy sqlSessionFactoryProxy = 
		          new SqlSessionFactoryProxy(sqlSessionFactory);

		      //트랜잭션 메니저 준비
		    TransactionManager txManager = new TransactionManager(sqlSessionFactoryProxy);
		      
			// DAO 객체 준비
			LessonDaoImpl lessonDao = new LessonDaoImpl(sqlSessionFactoryProxy);
			MemberDaoImpl memberDao = new MemberDaoImpl(sqlSessionFactoryProxy);
			BoardDaoImpl boardDao = new BoardDaoImpl(sqlSessionFactoryProxy);
			PhotoBoardDaoImpl photoBoardDao = new PhotoBoardDaoImpl(sqlSessionFactoryProxy);
			PhotoFileDao photoFileDao = new PhotoFileDaoImpl(sqlSessionFactoryProxy);
			

			// Command 객체 준비
			//Scanner keyboard = (Scanner) context.get("keyboard");
			context.put("/lesson/add", new LessonAddCommand(lessonDao));
			context.put("/lesson/list", new LessonListCommand(lessonDao));
			context.put("/lesson/detail", new LessonDetailCommand(lessonDao));
			context.put("/lesson/update", new LessonUpdateCommand(lessonDao));
			context.put("/lesson/delete", new LessonDeleteCommand(lessonDao, photoBoardDao, photoFileDao, txManager));


			context.put("/member/add", new MemberAddCommand(memberDao));
			context.put("/member/list", new MemberListCommand(memberDao));
			context.put("/member/detail", new MemberDetailCommand(memberDao));
			context.put("/member/update", new MemberUpdateCommand(memberDao));
			context.put("/member/delete", new MemberDeleteCommand(memberDao));
			context.put("/member/search", new MemberSearchCommand(memberDao));


			context.put("/board/add", new BoardAddCommand(boardDao));
			context.put("/board/list", new BoardListCommand(boardDao));
			context.put("/board/detail", new BoardDetailCommand(boardDao));
			context.put("/board/update", new BoardUpdateCommand(boardDao));
			context.put("/board/delete", new BoardDeleteCommand(boardDao));

			context.put("/photoboard/add", new PhotoBoardAddCommand(photoBoardDao, photoFileDao, txManager));
			context.put("/photoboard/list", new PhotoBoardListCommand(photoBoardDao));
			context.put("/photoboard/detail", new PhotoBoardDetailCommand(photoBoardDao, photoFileDao));
			context.put("/photoboard/update", new PhotoBoardUpdateCommand(photoBoardDao, photoFileDao, txManager));
			context.put("/photoboard/delete", new PhotoBoardDeleteCommand(photoBoardDao, photoFileDao, txManager));


		} catch (Exception e) {
			throw new ApplicationContextException(e);
		}
	}

	@Override
	public void contextDestroyed(Map<String, Object> context) {
	}

}
