package ch18.e;

public class Zebra {
  // derection을 숫자로 해두면 나중에 소스 코드를 보면 이해가 안 될 수 있다
  // 숫자 보다는 문자가 기억하기 쉽기 때문에 변수를 활용한다
  // static변수로 만들어 int on = 1; => static int on = 1;
  // 한 번만 생성하게 static으로 선언
  // final을 붙이면 나중에 1,2 외의 다른 숫자로 바꿀 수 없음
  public final static int ON = 1;
  public final static int OFF = 2; 
  
  boolean use;
 
 public void rotate(int direction) {
   if(direction == 1) { // 오른쪽 회전
     this.use = true;
   } else if (direction == 2) { // 왼쪽 회전
     this.use = false;
   }
 }
}
