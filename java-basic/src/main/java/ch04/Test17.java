// 조건연산자 => 조건 ?  값1  :  값2  but 자바에서는 바로 문자열을 넣을 수 없음, 표현식 필요
//           => 조건? 표현식1 : 표현식2
//         => cond(ition) ? expr(ession) : expr(ession);
// 조건이 참이면 표현식의 리턴값이 놓이고, 거짓이면 표현식 2의 리턴값이 놓인다

// 문장? statement
// => 여러 개의 연산자나 표현식으로 이루어진 한 명령
// => 보통 세미콜론(;)으로 끝낸다
// 표현식? expression
// => 문장 중에서 ===리턴 값====이 있는 문장
package ch04;

public class Test17 {
  public static void main(String[] args) {
    int age = 20;
    
//    (age >= 19) ? System.out.println("성인") : System.out.println("미성년"); (x)
    String result = (age >= 19) ? "성인" : "미성년";
    System.out.println(result);
    System.out.println((age >= 19) ? "성인" : "미성년");
    System.out.println((age >= 19) ? "성인" : false);
    System.out.println((age >= 65) ? "성인" : false);
      }
}
