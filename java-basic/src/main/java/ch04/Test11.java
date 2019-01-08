// 논리 연산자: &, |
package ch04;

public class Test11 {
  public static void main(String[] args) {
    
    // 피 연산자가 boolean 타입일 때는 &&, ||와 동일하게 동작
        
    // & (AND연산자) 논리 연산자
    // => 피 연산자 모두 true일 때만 결과가 true
    System.out.println(true & true); //true 출력
    System.out.println(true & false); // false 출력
    
    // | (OR) 논리 연산자
    // => 둘 중 한 개라도 true이면 결과가 true
    System.out.println(true | false);  //true 출력
    System.out.println(false | false); // false 출력
    
    // 피연산자가 정수일 때는 비트연산을 수행
    // 비트연산? 비트와 비트끼리 and, or 연산 수행
    
    int a = 0xca; // 0000 0000 0000 0000 0000 0000 1100 1010
    int b = 0x66; // 0000 0000 0000 0000 0000 0000 0110 0110
    System.out.println(a & b);
    // 1(true), 0(false)로 간주
    //                  0000 0000   0000  0000 0000 0000   0100  0010
    //                                                      64    2
    // ; 66
    
    System.out.println(a | b);
    //                                                     1110 1110
    //                                                    2 4 8 32 64 128       
    //                                                                238   
  }
}
