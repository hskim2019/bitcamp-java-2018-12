// l-value 와 r-value 용어
package ch03;

public class Test04 {
  public static void main(String[] args) {
    int a = 100;
    int b = a;
    
    System.out.printf("%d, %d\n", a, b);
    
    a = 200;
    System.out.printf("%d, %d\n", a, b);
    
    a = 1;
    b = a;
    a = 2;
    System.out.println(b);
    
  }
}

/*
 # l-value 와 r-value
 int a = 100;
 a 는 l-value / 100 은 r-value
 l-value 는 반드시 메모리여야 한다
 100 = a; (x)
 r-value 는 리터럴 가능
 a = b; (o)
 */

