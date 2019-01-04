// 문자열 리터럴
package ch02;

public class Test09 {
  
  public static void main(String[] args) {
    System.out.println("홍길동");
    System.out.println("Hello," + "world!");
    System.out.println("나이:" +20);
    System.out.println(false + "<== 재직자 여부");
    System.out.println("성별:" + '여');
    System.out.println("키:" + 170.5f);

  }
}

//# 문자열
// - 자바의 기본 타입이 아니라 객체이다
// - 객체란? 여러 데이터의 덩어리이다
// - char[] 배열에 유니코드가 저장된다
// - double quote 안에 문자들을 작성한다.
// - 문자열 연결 연산자(concatenation) +
// - +를 이용하여 문자열과 문자열을 연결하면 문자열이 새로 생성된다
// - ex) Hello=a, world=b, Hello world = c
// - 문자열과 다른 종류의 값을 연결하
