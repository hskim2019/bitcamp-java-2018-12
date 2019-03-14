# 48

20 단계 : Command 인터페이스 대신 애노테이션을 이용하여 명령어를 처리할 메서드를 식별하기
=> 기존에는 클라이언트로부터 명령을 받았을 때 Command 규칙에 따라 메서드를 호출하였다
=> 이번 단계에서는 Command 인터페이스의 구현 여부와 상관없이
   @RequestMapping 이 붙은 메서드를 찾아 호출해보자
=> 이렇게 하면 특정 인터페이스의 제약에서 벗어날 수 있다
   좀 더 유연하게 커멘드를 처리하는 코드를 작성할 수 있다


작업:
1) RequestMapping 애노테이션 정의
   => value 프로퍼티는 명령을 저장한다
   
2) RequestMappingHandler 정의 
   => RequestMapping 애노테이션이 붙은 메서드의 정보를 저장하는 클래스
   => RequestMappingHandlerMapping의 스테틱 중첩 클래스로 정의한다

3) RequestMappingHandlerMapping 정의
  =>  클라이언트가 보낸 명령을 처리할 메서드에 대한 정보(RequestMappingHandler)를 관리한다
  
4) Command 변경 
  => CRUD 관련 커맨드를 한 클래스로 합쳐서 XxxCommand로 만든다
     예) BoardAddCommand + BoardListCommand,... => BoardCommand

5) ApplicationContext 변경 
  => 인스턴스를 모두 생성한 후 RequestMappingHandler를 찾아
     RequestMappingHandlerMapping에 보관한다
     
6) ServerApp 변경
  => 클라이언트 요청이 들어왔을 때 RequestMappingHandlerMapping에서 메서드를 찾아 실행한다
  
  
  
  
  