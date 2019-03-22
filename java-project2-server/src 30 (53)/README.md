# 53

28단계 : Log4J 1.x 적용하기
=> 애플리케이션을 실행하는 중에 내부 상태를 확인할 목적으로 기록을 남기는 것을 로깅(loggin)이라고 한다
=> 로깅은 애플리케이션을 실행하는 콘솔창으로 출력할 수도 있고
   파일이나 네트워크로도 출력할 수 있다
=> 보통 실무에서는 파일로 기록을 남긴다
=> 로깅 작업을 도와주는 대표적인 라이브러리가 log4j이다
   출력 레벨에 따라 로깅을 조절할 수 있어 편리하다

작업
1) log4j 1.x 라이브러리를 추가한다
   => mvnrepository.com 에서 log4j 검색
   => build.gradle / gradle eclipse
         
2) log4j 설정 파일 준비한다
   => CLASSPATH 루트 패키지에 log4j.properties 파일을 생성한다
      예) src/main/resources/log4j.properties
      
3) Mybatis에서 사용할 로깅 라이브러리 지정하기
  => SqlSessionFactory 객체를 생성할 때 어떤 로깅 라이브러리를 사용할 지 지정한다
  => MybatisConfig.java에서 SqlSessionFactory 생성하는 메서드 안에 다음 코드 추가한다
     LogFactory.useLog4Logging();
     
  **************<< Log4J 설정법 >> *******************
  => CLASSPATH 루트 패키지에 log4j.properties 이름으로 설정 파일을 둔다
  1) 출력 등급 설정 
   => log4j.rootLogger=DEBUG, A1
      : rootLogger에 설정하면 모든 클래스에 대해 적용된다
   => log4j.logger.com.eomcs.lms.service=ERROR
      : com.eomcs.lms.service 패키지에 대해서는 ERROR 레벨을 적용한다
      : 즉 rootLogger에 기본 출력 등급을 설정하고
        특정 패키지에 전체나 특정 클래스에 대해 등급을 바꾸고 싶을 때 사용한다
   => 다음과 같이 등급을 조정할 수 있다
      : rootLogger = DEBUG
            com.eomcs.lms.dao = ERROR
            com.eomcs.lms.service = FATAL
            com.eomcs.lms.handler = INFO
            따로 지정하지 않으면 rootLogger의 출력 등급을 적용한다
   => 등급
       FATAL : 애플리케이션을 중지 할 만큼 치명적인 오류일 경우. 예) DBMS 연결 안 됨
       ERROR : 계속 애플리케이션을 실행해도 되는 오류일 경우. 예) 날짜 형식 오류로 인한
       WARN  : 잠재적인 위험을 안고 있는 경우. 예) 서버와의 소켓 연결을 close()하지 못했을 때
       INFO  : 관리자가 확인해야 할 레벨의 정보
               애플리케이션의 주요 실행 정보. 예) 어떤 IP의 클라이언트가 접속 정보, 연결 종료
       DEBUG : 개발자가 알아야 할 정보 레벨
               애플리케이션의 내부 실행 상태를 추적해 볼 수 있는 정보. 
                예) Mybatis가 실행하는 SQL, SQL을 실행할 때 in-parameter에 설정되는 값
       TRACE : DEBUG보다 더 상세한 정보를 출력할 때. 예) IoC 컨테이너가 생성한 객체 목록 


   => 등급에 따른 출력 제어
       FATAL > ERROR > WARN > INFO > DEBUG > TRACE
       : 지정된 등급 이상의 로그는 모드 출력된다
       : 즉 INFO 등급의 로그만 출력하도록 하면 INFO보다 큰 레벨 (WARN, ERROR, FATAL)의 로그도 출력된다
    
   2) 출력 담당자 지정
   => 어디로 출력할 것인지 지정한다
   => log4j.rootLogger=출력등급, 담당자이름
      log4j.appender.담당자이름 = 담당자가 출력하기 위해 사용할 도구(패키지명을 포함한 클래스명)
      예)
      log4j.rootLogger=DEBUG, A
      log4j.appender.A=org.apache.log4j.ConsoleAppender
    => 출력 도구
       org.apache.log4j.ConsoleAppender : 콘솔 창으로 출력. 즉 System.out/System.err 객체를 사용하여 출력
       org.apache.log4j.FileAppender    : 지정한 파일로 출력
       org.apache.log4j.net.SocketAppender : 네트워크의 다른 컴퓨터로 출력
     
   3) 출력 형식 지정
    => 출력할 문자열의 형식을 지정할 수 있다
    => log4j.appender.담당자명.layout=출력형식을 다룰 클래스(패키지명을 포함)
       예) log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
    => 출력 형식을 다룰 클래스
       org.apache.log4j.SimpleLayout : 단순 문자열 출력
       org.apache.log4j.HTMLLayout   : HTML 태그로 출력
       org.apache.log4j.PatternLayout: 설정파일에 지정된 형식에 맞춰 출력
       org.apache.log4j.xml.XMLLayout: XML 태그로 출력
     
   4) 출력 형식의 패턴 설정하기
    => PatternLayout을 사용하여 출력할 때 설정하는 방법
    => %p : 출력 등급. 예) FATAL, DEBUG, WARN, INFO, TRACE
       %자릿수p : 출력 문자열의 자릿수를 지정할 수 있다
       %t : 스레드 이름. 서버인 경우 동시에 여러 클라이언트가 요청을 한다
            따라서 클라이언트 요청을 처리하는 스레드가 다를 수 있다
       %m : 로그 메세지
       %n : 줄 바꿈 명령
       %d{yyyy-MM-dd HH:mm:ss} : 년-월-일 시간:분:초
       %c : 분류명 출력, 분류명을 따로 지정하지 않으면 클래스명이 사용된다
       %C : 클래스명 출력
       %C{개수} : 개수를 지정할 수 있다
       %M : 로그를 출력하는 메서드명
       
   **************<<log4j를 코드에서 사용하기 >> ********************
   1) 특정 클래스로 로그 남기기
      Logger logger = LogManager.getLogger(클래스 타입);
   2) 특정 분류명으로 로그 남기기
     => 여러 클래스의 로그를 하나로 묶어 표현하고 싶을 때
      Logger logger = LogManager.getLogger("분류명");
   

 
 
  

  
  
  