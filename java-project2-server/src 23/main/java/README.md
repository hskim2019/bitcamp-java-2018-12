# 50
*github에 없음

21 단계 : 자바 설정 방식을 이용하여 IoC 컨테이너를 설정하기
=> IoC 컨테이너에게 필요한 것들을 자바 코드로 설정한다


작업1 - 팩토리 메서드를 통해 객체 생성하기
1) AppConfig 정의
   => IoC 컨테이너가 보관할 객체를 생성하는 메서드 정의
   => IoC 컨테이너가 자동으로 생성하지 않는 객체를 메서드에서 리턴한다
      
2) Bean 애노테이션 정의
   => IoC 컨테이너가 bean을 생성하기 위해 호출해야 할 메서드를 표시할 때 사용한다
   => IoC 컨테이너는 이 애노테이션이 붙은 메서드를 호출하여 그 리턴 값을 보관할 것이다

3) AppConfig 변경
  => 객체를 생성하여 리턴하는 메서드에 Bean 애노테이션을 붙인다
  
4) ApplicationContext 변경
  => 생성자의 파라미터로 받은 클래스에 대해 설정 작업을 수행한다

5) ComponentScan 애노테이션 정의
  => IoC 컨테이너가 객체를 자동 생성할 때 뒤질 패키지 이름을 설정한다
     
6) AppConfig 변경
  => ComponentScan 애노테이션을 추가한다
  
7) ApplicationContext변경
  => 생성자에서 CompoenentScan 애노테이션을 처리한다
  
  
  
  
  