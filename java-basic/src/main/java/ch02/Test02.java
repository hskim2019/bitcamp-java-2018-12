package ch02;

public class Test02 {
  public static void main(String[] args) {
    // 20억을 4바이트로 출력하라
   System.out.println(2000000000);
    // 20억을 8바이트 리터럴로 출력하라
   System.out.println(2000000000L);
    // 30억을 8바이트 리터럴로 출력하라
   System.out.println(3000000000L);
    // 30억을 4바이트 리터럴로 출력하라
   System.out.println(300000000);//4바이트는 약21억개 숫자만 표현 가능하므로 30억은 출력오류
   
    //4바이트 정수 리터럴
    //100
    //8바이트 정수 리터럴
   //100L
  }
}
