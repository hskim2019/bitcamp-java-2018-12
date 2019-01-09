// 메서드 - 로컬 변수와 스택 메모리
// 출력결과
// 4 m3 출력  
// 3  ---
// 2  ---
// 1 main method의 출력값
package ch06;

public class Test10 {
  public static void main(String[] args) {
    int value = 0;
    m1(++value);                        
    System.out.println(value); 
  }

  static void m1(int value) {   
    m2(++value);  //m1을 실행하면 m2를 호출하는데 value값을 증가시키면서
    System.out.println(value + 10);   
  }

  static void m2(int value) {
    m3(++value);
    System.out.println(value + 100);
  }
  
    static void m3(int value) {
      System.out.println(++value);
    }
 
}//class end

/* first in first out
 * 맨 마지막에 넣은 것을 맨 처음 꺼내게 됨
 * 
 * 스택 메모리
 * - 'JVM 스택 메모리' 라고 부른다
 * - 각 스레드 별로 'JVM 스택 메모리'가 있다
 * - 메서드를 호출할 때 '프레임(frame)'이 생성된다
 *    -프레임 안에 로컬 변수, 리턴 값, 예외가 발생했다면 예외 정보가 들어 있다
 * - 메서드 호출이 끝나면 '프레임'은 삭제된다
 * - main() 맨 마지막에 삭제된다
 * - 이렇게 메서드가 호출될 때 로컬 변수가 준비되고 맨 마지막에 호출한 메서드가 먼저 삭제된다고 해서
 *   "스택(stack)" 메모리라 부른다
 *   접시 쌓는 것을 생각하라
 * - 스택방식은 "Last in First out(LIFO)(후입선출)"라고 부른다
 * - ex) 홈페이지 뒤로가기
 */
