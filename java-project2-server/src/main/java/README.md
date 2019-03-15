# 51

23단계 : Spring IoC 컨테이너와 Mybatis 연동하기
=> Mybatis 관련 객체를 Spring IoC 컨테이너가 자동으로 관리하도록 연동한다


작업
1) Spring IoC 컨테이너와 연동할 때 사용할 Mybatis 라이브러리 가져오기
   => mvnrepository.com 에서 mybatis spring로 검색한다
   => 프로젝트의 build.gradle 파일에 spring 의존 라이브러리 정보를 추가한다
   => '$ gradle eclipse' 를 실행하여 의존 라이브러리를 다운로드 받고
       이클립스 설정 파일을 갱신한다
   => 이클립스 IDE에서 프로젝트를 refresh 한다
      
2) 의존 라이브러리 준비
   => DataSource 구현체인 apache의 commons-dbcp2 라이브러리 추가
   => Spring의 jdbc 관련 spring-jdbc 라이브러리 추가
      트랜잭션 관련 라이브러리도 자동으로 추가된다

3) AppConfig 변경
   => mybatis 관련 객체를 생성한다
   => mybatis-config.xml을 삭제한다
   => SqlSessionFactoryProxy, SqlSessionProxy, TransactionManager 삭제
   => DaoFactory 삭제한다
   
4) LessonCommand, PhotoBoardCommand 변경
  => Spring 프레임워크에서 제공해주는 트랜잭션 관리자로 교체한다

5) 
  => 
  
  
  
  
  