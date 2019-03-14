# 46
ver 5.5.0 - 지정된 패키지에서 `Command` 구현체를 찾아 객체를 자동 생성하라.
(src 18 -> 20)


18 단계: Command 구현체를 자동 생성하는 Ioc 컨테이너 도입하기
=> ApplicationInitializer의 Command 객체 생성 작업을 ApplicationContext에 위임한다

작업:
1) ApplicationContext 정의
   => 생성자에 패키지를 지정하면 해당 패키지와 그 하위 패키지를 모두 뒤져서
      Command 인터페이스를 구현한 클래스를 찾는다
   => 그리고 Command 구현체의 인스턴스를 생성한다
 
2) Command 구현체 변경
  => 각 커멘드 객체에 이름을 부여한다
  => Applicationcontext는 그 이름을 사용하여 객체를 보관 할 것이다
  
  
3) ServerApp 변경
  => Command 객체를 꺼낼 때 ApplicationContext에서 꺼낸다
  
  객체를 자동을 생성했을 때의 이점
  => /hello 라는 요청을 했을 때 "안녕하세요!" 라고 인사하는 기능을 추가하라
  => 1) AbstractCommand 를 상속 받아서 HelloCommand를 만든다
  