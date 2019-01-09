// 메서드 - 로컬 변수의 생성과 소멸
package ch06;

public class Test09 {
  public static void main(String[] args) {
    int value = 100;
    m1(value); // 이 안의 value는 100 -> m1 method에 가서 100을 대입
               // -> m1 method에 value = 200; 으로 초기화 되어 있음 
    System.out.println(value);
    
    m1(value + 15); //15를 더한 상태로 125가 되어 m1을 호출하지만 실행 후 소멸, int value = 100
    System.out.println(value);
    
    m1(value + 15);
    System.out.println(value);
  }

  static void m1(int value) {
    value = 200;
    System.out.printf("m1(): %d\n", value);
  }
}//class end

/* 로컬변수 - 총3개
 * main method 안의value, args  * m1()의 value 
 
 * 로컬변수의 생성과 소멸
 * - 메서드가 호출될 때 생성된다
 * - 메서드를 모두 실행한 후 리턴할 때 소멸된다
 */
