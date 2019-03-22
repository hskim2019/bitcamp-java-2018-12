# 52

25단계 : business layer 추가
=> 커멘드 객체에서 비즈니스 로직을 분리하여 별도의 클래스로 정의한다
=> 비지니스 로직의 재사용성을 높일 수 있다


작업
1) BoardCommand에서 비지니스 로직 분리
   => BoardService 인터페이스 생성
   => BoardServiceImpl 구현체 생성
      
2) PhotoBoardCommand 에서 비즈니스 로직 분리
   => PhotoBoardService 인터페이스 생성
   => PhotoBoardServiceImpl 구현체 생성

3) LessonCommand, MemberCommand에도 적용




PlatformTransactionManager 인터페이스
  |
  PlatformTransactionManager의 구현클래스 종류
   => DataSourceTransactionManager
      :JDBC 및 마이바티스 등으로 데이터베이스 접근시 이용
  
  