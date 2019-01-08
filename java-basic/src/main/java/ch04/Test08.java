// 전위 연산자 - ++a, --a
package ch04;

public class Test08 {
  public static void main(String[] args) {
    int a = 5;
    int r = ++a;
    System.out.printf("%d, %d\n", a, r);
    
    // r = ++a 연산 순서
    // 1) ++a 연산 수행 - a 변수의 값을 1 증가시킨다
    // 2) a값을 리턴한다 => r = 6;
    //  3) 연산자 수형 => r변수에 6값을 넣는다
    
    a = 5;
    r = --a;
    System.out.printf("%d, %d\n", a, r);
    
    a = 5;
    r = --a + --a / --a;
    //    4   +  3   /   2
    //     4  + 1
    System.out.printf("%d, %d\n", a, r);

    
  }
}
