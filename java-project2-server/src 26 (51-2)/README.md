# 51 - 2

24단계 : Spring Java config 정리, 스프링의 BeanPostProcessor로 RequestMapping 애노테이션 처리
=> Spring Java config 클래스를 역할별로 분리한다 


작업
1) AppConfig에서 데이터베이스 관련 설정 분리
   => DatabaseConfig 클래스 생성
      
2) AppConfig에서 Mybatis 설정 분리
   => MybatisConfig 클래스 생성

3) RequestMapping 애노테이션 처리
   => RequestMappingAnnotationBeanPostProcessor 생성
   
4) RequestMappingHandlerMapping 을 스프링 IoC 컨테이너 관리 대상에 포함시킨다
  => @Component 애노테이션을 붙인다

5) ServerApp에서 Spring IoC 컨테이너를 준비한다
  => ApplicationInitializer 클래스 삭제
  
6) ServerApp의 시작/종료를 보고 받는 옵저버 제거
  => ApplicationContextListener 인터페이스 제거
  => ApplicationContextException 클래스 삭제
  => ServerApp 에서 관련 코드 제거
