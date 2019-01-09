// 논리 리터
package ch02;

public class Test08 {
  
  public static void main(String[] args) {
    System.out.println(true);
    System.out.println(false);
    
   // System.out.println((boolean)1); // 자바는 정수 값을 true/false로 형변환할 수 없다
   
    // 작은 따옴표(single quote) 의 리턴 값은 2바이트 정수 값(UTF-16 코드)이다
    if('가' == 0xac00) {
      System.out.println("맞다!");
     } else {
       System.out.println("아니다!");
     }
    
    //if (10 - 10){ // c언어에서는 0은 false, 그 외의 수는 true. 자바는 아니다
      
   
  }
}

// 논리 리터럴
// - 자바 참, 거짓을 표현하는 키워드를 제공한다
// - 참:  true, 거짓: false

// 논리 값을 메모리에 저장할 때 크기 
// -4바이트 int 메모리에 저장
// 배열 값인 경우 1바이트 메모리에 저장한다
// -true 1, false 0 으로 저장