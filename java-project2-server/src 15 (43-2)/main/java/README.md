# 43-1 
 13단계: Mybatis 퍼시스턴스 프레임워크 적용하기
 => 자바 소스 코드에서 SQL을 분리하여 별도의 파일에서 관리한다
 => JDBC 코드를 캡슐화하여 DB 프로그래밍을 간결하게 한다
 작업: 
 1) Mybatis 설정 파일 준비
     - src/main/resources/com/eomcs/lms/conf/mybatis-config.xml생성
     - src/main/resources/com/eomcs/lms/conf/jdbc.properties 생성
 2) LessonDao 에 mybatis 적용
     - src/main/resources/com/eomcs/lms/mapper/LessonMapper.xml 생성
     - LessonDaoImpl 클래스 변경
     - ApplicationInitializer 클래스 변경