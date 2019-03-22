# 52

26단계 : 애노테이션으로 트랜잭션 다루
=> @Transactional 애노테이션을 이용하여 트랜잭션을 이용할 수 있


작업
1) @Transactional 애노테이션을 처리할 객체를 스프링 IoC 컨테이너 설정에 등록한다
   => Java config 클래스에 @EnableTrasnactionManagement 애노테이션을 붙인다
      
2) 트랜잭션을 적용할 서비스 클래스의 메서드에 @Transactional을 붙인다 
   => DAO 메서드에 붙이지 않고 Service 클래스의 메서드에 붙이는 이유?
       - DAO 메서드들은 업무에 따라 단독으로 실행될 때가 있고
         다른 DB 작업과 묶여서 실행 될 때가 있기 때문이다
       - 예를 들어 PhotoBoardDao의 delete() 메서드를 보라
         이 메서드는 단독으로 실행할 수도 있지만
         PhotoFileDao의 delete() 와 묶여서 실행될 때가 있다
       - 즉 DAO의 메서드는 업무에 따라 다른 DAO의 데이터 변경 메서드와 묶일 수 있기 때문이다
   =>  LessonServiceImpl 의 delete()
       PhotoBoardServiceImpl의 add(), update(), delete() 에 @Transactional을 붙인다

3) 




PlatformTransactionManager 인터페이스
  |
  PlatformTransactionManager의 구현클래스 종류
   => DataSourceTransactionManager
      :JDBC 및 마이바티스 등으로 데이터베이스 접근시 이용
  

  
  
  