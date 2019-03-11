# 43-2 (43-1 + join)
// 13단계: Mybatis 퍼시스턴스 프레임워크 적용하기
// => 자바 소스 코드에서 SQL을 분리하여 별도의 파일에서 관리한다.
// => JDBC 코드를 캡슐화하여 DB 프로그래밍을 간결하게 한다.
// 
// 작업:
// 1) Mybatis 설정 파일 준비
//    - src/main/resources/com/eomcs/lms/conf/mybatis-config.xml 생성
//    - src/main/resources/com/eomcs/lms/conf/jdbc.properties 생성
// 2) LessonDao에 Mybatis 적용
//    - src/main/resources/com/eomcs/lms/mapper/LessonMapper.xml 생성
//    - LessonDaoImpl 클래스 변경
//    - ApplicationInitializer 클래스 변경
// 3) MemberDao에 Mybatis 적용
//    - src/main/resources/com/eomcs/lms/mapper/MemberMapper.xml 생성
//    - MemberDaoImpl 클래스 변경
//    - ApplicationInitializer 클래스 변경
// 4) BoardDao에 Mybatis 적용
//    - src/main/resources/com/eomcs/lms/mapper/BoardMapper.xml 생성
//    - BoardDaoImpl 클래스 변경
//    - ApplicationInitializer 클래스 변경 
// 5) PhotoBoardDao에 Mybatis 적용
//    - src/main/resources/com/eomcs/lms/mapper/PhotoBoardMapper.xml 생성
//    - PhotoBoardDaoImpl 클래스 변경
//    - ApplicationInitializer 클래스 변경
// 6) PhotoFileDao에 Mybatis 적용
//    - src/main/resources/com/eomcs/lms/mapper/PhotoFileMapper.xml 생성
//    - PhotoFileDaoImpl 클래스 변경
//    - ApplicationInitializer 클래스 변경
     
     
        (1)insert()         (2)insert()                    (4)                 (5)
     --------------> [Dao] -------------->[SqlSession] ----------->[JDBC API] ----->[MySQL]
                      |                      return    |       
                      | (2) openSession()      |       |___use
                      |__________[openSessionFactory]        [SQL Mapper]
                      
  Thread가 그동안 임시 DB에 저장했던 것도 commit
  MYSQL은 SQLSessionClient가 1개의 객체이기 때문에 구분할 수 없음
  rollback필요한 경우 rollback 하기 이전에 다른 client가 commit 할 때 commit이 되어버려 취소가 안 됨
  => SQLSessoin 객체를공유하면 안 됨
  
  
  
 /                         insert()  
  [PhotoBoardAddCommand]---------------->[PhotoBoardDao]----------->[SqlSession]------------------>MySQL
/                     |      a.gif  
/                     |----------------> [PhotoFileDao]-------------[SqlSession]------------------>MySQL
ex)a.gif, b.gif, 255자 초과하는 파일명 insert하면 rollback되지 않고 a.gif, b.gif 는 commit되어 버림
=>SqlSession을 보관해서 새로 만들지 않고 Thread에 보관된 sqlSession객체를 리턴하여 PhotoBoardDao와 PhotoFileDao가 공유
   마지막에 commit
  
=> openSession요청 시 Thread에 있으면 기존에 Thread에 있는 것 return, 없으면 SqlSessionFactory에게 요청해서 Session을 open하는 SqlSessionFactoryProxy를 만들어야 함
=> 다음 단계
  
  
  
  