// 메서드 - 파라미터와 리턴값
package ch06;

public class Test04 {
  public static void main(String[] args) {
   //test 
    p(10, 20);
    
   String str = greet("홍길동"); // String형태의 return 값을 받기 위해 변수 선언해줌, String형태의 파라미터가 있으므로 값도 넣어줌 
   System.out.println(str);
   
   int result = plus(10, 20);
   System.out.println(result);
   
   
  }
  //test
  static void p(int a, int b) {
    System.out.println( a + b);
  }
  //test  
    
  static String greet(String name) {
    return name + "님 반값습니다!";
  }
  
  static int plus(int a, int b) {
    return a + b;
  }

 
  
}
/*
 
 */
