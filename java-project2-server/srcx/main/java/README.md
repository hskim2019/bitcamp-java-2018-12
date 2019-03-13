# 46
ver 5.5.0 - 지정된 패키지에서 `Command` 구현체를 찾아 객체를 자동 생성하라.

18 단계: Command 구현체를 자동 생성하는 Ioc 컨테이너 도입하기
=> ApplicationInitializer의 Command 객체 생성 작업을 ApplicationContext에 위임한다

작업:
1) ApplicationContext 정의
   => 생성자에 패키지를 지정하면 해당 패키지와 그 하위 패키지를 모두 뒤져서
      Command 인터페이스를 구현한 클래스를 찾는다
   => 그리고 Command 구현체의 인스턴스를 생성한다
 
2) 
  => 
 
