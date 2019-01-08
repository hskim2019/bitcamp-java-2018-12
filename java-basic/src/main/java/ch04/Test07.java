// 부동소수점의 오류
package ch04;

public class Test07 {
  public static void main(String[] args) {
    
    float f1 = 0.1f;
    float f2 = 0.1f;
    
    System.out.println(f1 * f2 == 0.01f);
    
    //이유?
    System.out.println(f1 * f2); // 0.010000001 결과 값  뒤에 오차발생
    
    //해결책?
    //  => 오차를 제거한 후 비교 (양수일 때는 문제없음)
    System.out.println((f1 * f2) - 0.01f <= Float.POSITIVE_INFINITY);
    
    //음수의 오차가 있을 때도 있음 - 오차를 제거 한 후 & 절대값으로 비교할 수 있게 바꿔줌
    float r = f1 * f2 - 0.01f;
    System.out.println(Math.abs(r) <= Float.POSITIVE_INFINITY);
 
    int [] arr = {3,5,7,9,0};
    for (int i = 0; i < arr.length; i++) {
       System.out.println("arr ["+i+"]: " + arr[i]);
    }
  }
}
