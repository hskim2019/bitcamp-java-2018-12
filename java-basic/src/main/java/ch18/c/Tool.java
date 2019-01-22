// 다중 인터페이스 구현 - 한 클래스는 여러 규칙을 준수할 수 있다
package ch18.c;

// 한 클래스가 여러 규칙에 따라 동작하도록 정의할 수 있다
public class Tool implements ProtocolA, ProtocolB{

  // 여러 규칙을 모두 만족시키려면 
  // 여러 규칙의 모든 메서드를 구현해야 한다

  // ProtocolA 규칙에 따라 메서드 구현
  @Override
  public void m1() {
    System.out.println("Tool.m1()");    
  }

  // m2()는 ProtocolA와 ProtocolB 모두 만족시킨다
  @Override
  public void m2() {
    System.out.println("Tool.m2()");    

  }

  // ProtocolB 규칙에  따라 동작하도록 메서드 구현
  // => m2() 는 이미 위에서 ProtocolA를 구현할 때 만들었기 때문에 또 만들 필요 없고 만들 수 없다
  // => 같은 시그너처(signature; 메서드명, 파라미터, 리턴타입)를 갖는 메서드가
  //    여러 규칙에 존재할 때, 각 규칙 별로 해당 메서드를 구분해서 구현 할 방법이 없다
  // => 왜? 호출할 때 구분해서 호출 할 수 없기 때문
  // => m2()는 ProtocolA와 ProtocolB에서 공유하는 메서드

  //  @Override
  //  public void m2() {
  //    System.out.println("Tool.m2()");  
  //  }

  @Override
  public void m3() {
    System.out.println("Tool.m3()");  
  }




}
