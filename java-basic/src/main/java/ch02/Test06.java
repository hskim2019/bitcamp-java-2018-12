// 부동소수점을 메모리에 저장하는 원리
package ch02;

public class Test06 {
  static final float f = 12.375f;
  
  public static void main(String[] args) {
  System.out.println(0.1f == 0.1);
  //부동소수점을 이진수로 바꿀 때 오차가 있을 수 있다
  // 예상한 값과의 오차가 부동소수점에서 인정하는 오차 이하의 값이면 같은 것으로 취급한다
  System.out.println((0.1f * 0.1f - 0.01f) <= Float.POSITIVE_INFINITY);
  }
}
