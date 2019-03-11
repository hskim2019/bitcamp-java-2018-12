# 43 -5 
ver 5.2.4 - `MyBatis`의 트랜잭션을 관리하라.

14단계: Mybatis 퍼시스턴스 프레임워크에 트랜잭션 관리자 도입하기
=> 트랜잭션 관리자를 도입하여 여러개의 데이터 변경 작업을 한 단위의 작업으로 묶어 다룬다

작업:
1) SqlSessionFactoryProxy 생성
   => Mybatis가 제공하는 SqlSessionFactory 객체를 대행한다
   => 트랜잭션을 위한 SqlSession 객체를 준비하고 해제하는 일을 한다
   => 트랜잭션을 시작하면 스레드 보관소에 SqlSession 객체를 보관한다
      그래서 스레드가 수행하는 모든 데이터 변경 작업을 한 SqlSession 객체가 다루게 한다
 
 2) SqlSessionProxy 생성
   => Mybatis가 제공하는 SqlSession을 대행한다
   => 트랜잭션 중에는 close()를 하지 않는다
 
 3) TransactionManager 생성
   => 트랜잭션을 시작시키고 완료시키는 일을 한다
   => SqlSession 객체를 통해 데이터 변경 작업들을 commit()하고 rollback()하는 일을 한다
   
 4) DAO 변경
   => DAO 에서 데이터 변경 (insert/update/delete) 후에 commit() 하지 말라
   => 트랜잭션을 사용할 때는 DAO에서 commit()하는 것이 아니다
      왜? 여러 DAO의 작업을 한 단위로 묶어서 commit() 해야 하기 때문이다
   => 그러면 트랜잭션을 사용하지 않을 때는 auto commit이 trune인 SqlSession을 사용하기 때문에
      아무런 문제가 없다
      
 5) Command 변경
   => 트랜잭션을 사용해야 하는 Command에 대해서는 TrnasactionManager를 주입하라
      예) PhotoBoardAddCommand, PhotoBoardDeleteCommand, PhotoBoardDeleteCommand
          LessonDeleteCommand
          
 =>  insert하다가 에러가 발생하면 전체 rollback 되고, 오류가 없을 때 그동안 명령한 변경 내용이 commit됨
   