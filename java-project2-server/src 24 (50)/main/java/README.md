# 50

22 단계 : Spring IoC 컨테이너 도입
=> 기존에 제작했던 IoC 컨테이너를 Spring IoC 컨테이너로 교체한다


작업
1) Spring IoC 컨테이너의 라이브러리 가져오기
   => mvnrepository.com 에서 spring-context로 검색한다
   => 프로젝트의 build.gradle 파일에 spring 의존 라이브러리 정보를 추가한다
   => '$ gradle eclipse' 를 실행하여 의존 라이브러리를 다운로드 받고
       이클립스 설정 파일을 갱신한다
   => 이클립스 IDE에서 프로젝트를 refresh 한다
      
2) 기존 애노테이션을 Spring에서 제공하는 애노테이션으로 교체한다
   => 기존의 애노테이션을 삭제한다
   => Bean, Component, ComponentScan 삭제

3) 기존 ApplicationContext를 삭제한다
  
4) ApplicationInitializer 변경
  => 기존의 ApplicationContext를 Spring의 ApplicationContext로 교체한다

5) ServerApp 변경
  => 
  
  
  
  
  