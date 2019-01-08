// 논리 연산자: &&, ||, ^, !
package ch04;

public class Test10 {
  public static void main(String[] args) {
    // && (AND연산자) 논리 연산자
    // => 피 연산자 모두 true일 때만 결과가 true
    System.out.println(true && true); //true 출력
    System.out.println(true && false); // false 출력
    
    // || (OR) 논리 연산자
    // => 둘 중 한 개라도 true이면 결과가 true
    System.out.println(true || false);  //true 출력
    System.out.println(false || false); // false 출력
    
    // ^ (exclusive OR) 논리 연산자
    // => 피연산자가 서로 다를 때만 true
    System.out.println(true ^ true);   // false 출력
    System.out.println(false ^ false); // false 출력
    System.out.println(true ^ false);  // true 출력
    
//    System.out.println(1 && 1);
//     논리 연산자의 피연산자 값은 반드시 true 또는 false 이어야 한다

    // &&, || 연산는 피연산자가 반드시 boolean 타입 이어야 한다. 즉 true 또는 false 이어야 한다.
    //System.out.println(1 && 1); // 컴파일 오류!
    
    // !(not) 논리 연산자
    System.out.println(!true);
    System.out.println(!false);
  }
}
