package ch01;  
 
public class Test03 {
 /**
  이 메서드는 Object 클래스의 메서드를 재정의한 것이다.
  */
 
  @Override // 에노테이션이라 부르는 주석
  public String toString(){
    return "ok";
  }

  public static void main(String[] args) {
    System.out.println("Hello!");
  }
}

