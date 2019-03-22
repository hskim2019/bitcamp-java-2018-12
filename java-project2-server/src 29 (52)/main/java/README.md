# 52

27단계 : XML 설정으로 트랜잭션 다루기
=> 애노테이션을 사용할 경우 각 서비스 클래스의 메서드에 대해 애노테이션을 붙여야 한다
=> XML 설정을 사용하면 pointcut 규칙으로 트랜잭션을 적용할 메서드를 간단히 지정할 수 있다
   그래서 실무에서 많이 사용한다


작업
1) 트랜잭션을 설정하는 XML 파일을 준비한다
   => tx-context.xml
      
2) 기존에 서비스 클래스에 붙인 @Transactional 애노테이션을 모두 제거한다
   => LessonServiceImpl 의 delete(),
      PhotoBoardServiceImpl 의 add(), update(), delete() 에 붙인 애노테이션을 제거한다

3) AOP 라이브러리를 추가한다
  => PlatformTransactionManager를 사용하여 트랜잭션을 다룰 때는
     개발자가 해당 메서드에 직접 코드를 삽입하기 때문에 AOP 기술을 사용할 일이 없다
  => @Tranasactional 애노테이션을 사용하여 트랜잭션을 다룰 때도
     Spring IoC 컨테이너에서 Proxy 생성 기술을 사용하기 때문에 AOP 기술을 사용할 일이 없다
  => 그러나 XML에서 advice를 이용하여 트랜잭션을 다룰 때는 AOP 라이브러리를 사용하기 때문에 프로젝트에 추가 해야 한다
     - aspectjweaver 라이브러리를 추가하라




PlatformTransactionManager 인터페이스
  |
  PlatformTransactionManager의 구현클래스 종류
   => DataSourceTransactionManager
      :JDBC 및 마이바티스 등으로 데이터베이스 접근시 이용
      
 Spring에서 트랜잭션 관리
 1)선언적 관리 
 2)프로그램적 관리
 
 
  

  
  
  