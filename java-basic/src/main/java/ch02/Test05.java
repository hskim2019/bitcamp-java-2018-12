// 부동소수점 리터럴(literal)의 메모리 크기
// 부동소수점을 메모리에 저장하는 방법
package ch02;

public class Test05 {
  public static void main(String[] args) {
    // 9876.54345678 출력하라 (=8바이트 부동소수점)
    System.out.println(12345678901234567.8);
    
    // 9876.54345678f 출력하라 (=4바이트 부동소수점)
    System.out.println(9876.54365678f);
  }
}


