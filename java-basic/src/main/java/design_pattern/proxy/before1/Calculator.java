//1 단계 - 데스크탑 용 계산기 애플리케이션 만들기
//개발자는 Calculator 클래스를 직접 호출하여 사용한다

package design_pattern.proxy.before1;

public class Calculator {
  
  public int plus(int a, int b) {
    return a + b;
  }
  
  public int minus(int a, int b) {
    return a - b;
  }

}
