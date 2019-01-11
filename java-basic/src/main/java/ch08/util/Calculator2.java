package ch08.util;

// 계산 기능과 관련된 메서드를 별도의 블록으로 분리하는 문법이 클래스이다
public class Calculator2 {
  // public을 붙이지 않으면 같은 패키지에 소속된 클래스만이 사용할 수 있다
  // 다른 패키지의 클래스도 이들 메서드에 접근할 수 있게 하려면 public 으로 공개해야 한다
  public static int plus(int a, int b) {
    return a + b;
  }
  
  public static int minus(int a, int b) {
    return a - b;
  }
  
  public static int multiple(int a, int b) {
    return a* b;
  }
  
  public static int divide(int a, int b) {
    return a / b;
  }
  
  public static int abs(int a) {
//    if(a >= 0)
//      return a;
//    else
//      return a + -1;
    return (a >= 0) ? a : a * -1;
  }
  
  // 클래스를 정의하면서 만든 기능을 간단하게 테스트할 때 다음과 같이 해당 클래스에 main() 메서드를 만들어 테스트 해 볼 수 있다
//  public static void main(String[] args) {
//    System.out.println(abs(100));
//    System.out.println(abs(-100));
//  }
}
