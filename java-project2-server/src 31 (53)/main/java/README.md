# 53

// 29단계: Log4J 2.x 적용하기
// 
// 작업
// 1) log4j 2.x 라이브러리를 추가한다.
//    => mvnrepository.com 에서 log4j2 검색한다.
//    => build.gradle에 라이브러리 추가한다.
//    => '$ gradle eclipse' 실행한다.
//    => 이클립스 프로젝트 갱신한다.
// 2) Log4J 2 설정 파일 준비한다.
//    => CLASSPATH 루트 패키지에 log4j2.xml 파일을 생성한다.
//       예) src/main/resources/log4j2.xml
// 3) Mybatis에서 사용할 로깅 라이브러리 지정하기
//    => SqlSessionFactory 객체를 생성할 때 어떤 로깅 라이브러리를 사용할 지 지정한다.
//    => MybatisConfig.java 에서 SqlSessionFactory 생성하는 메서드 안에 다음 코드 추가한다. 
//         LogFactory.useLog4J2Logging();  
   

 
 
  

  
  
  