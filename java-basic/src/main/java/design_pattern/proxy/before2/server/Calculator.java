// 2단계 - C(lient)/S(server) 계산기 애플리케이션 만들기
// => 개발자는 원격 서버와 통신을 하여 Calculator 클래스를 간접적으로 사용한다
package design_pattern.proxy.before2.server;

public class Calculator {
  
  public int plus(int a, int b) {
    return a + b;
  }
  
  public int minus(int a, int b) {
    return a - b;
  }

}
