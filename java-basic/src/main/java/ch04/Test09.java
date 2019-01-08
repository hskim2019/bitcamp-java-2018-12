// 후위 연산자 - a++, a--
package ch04;

public class Test09 {
  public static void main(String[] args) {
    int a = 5;
    int r = a++;
    System.out.printf("%d, %d\n", a, r);
    // 후위 연산
    // => 변수의 값을 먼저 그 자리에 놓는다
    // => 그 후에 변수의 값을 증감시킨다
    
    a = 5;
    r = a++ + a++ * a++;
    System.out.printf("%d, %d\n", a, r);
    //  5(a=6) + 6(a=7) *7(a=8)  
    
    a = 5;
    a = a++;
    System.out.println(a);
   
  }
}
