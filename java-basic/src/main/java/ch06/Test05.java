// 메서드 - 메서드 중첩 호출
package ch06;

public class Test05 {
  public static void main(String[] args) {
   // 2 + 3 + 4 + 5
    int result = plus(2, 3);
    result = plus(result, 4);
    result = plus(result, 5);
    System.out.println(result);
    
    result = plus(plus(plus(2, 3), 4), 5);
    System.out.println(result);
    
    System.out.printf("200 + 300 = %d\n", plus(200, 300));
  }
  
  static int plus(int a, int b) {
    return a + b;
  }

}
/*
 
 */
