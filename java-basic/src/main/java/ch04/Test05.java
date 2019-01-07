// 연산자 우선순위
package ch04;

public class Test05 {
  public static void main(String[] args) {
    float r1 = 3.2f + 5 / 2;
    System.out.println(r1);
    
    float r2 = (3.2f + 5) / 2;
    System.out.println(r2);
    
    int a = 2;
    int r3 = a++ + a++ * a++;
    System.out.println(r3);
    // r3 = 2 + 3 *4 (a는 5인 상태, 후위연산자는 a값을 더하되 나중에)
    
    //연산자 우선순위
    // 괄호
    // 후위 연산자(a++, a--)
    // 전위 연산자(++a, --a), 단항 연산자(+,-)
    // * / %
    // + -
    //비트이동 연산자: <<, >>, >>>
    //관계연산자:  <,>,<=, >=, instanceof
    //등위 연산자: ==, !=
    //&
    //^
    //|
    //논리 연산자 AND :  &&
    //논리 연산자 OR : ||
    //삼항 연산자: (조건) ? 값:값
    //할당 연산자: = += -= *= /= %= &= ^= |= <<= >>= >>>=
  }
}
