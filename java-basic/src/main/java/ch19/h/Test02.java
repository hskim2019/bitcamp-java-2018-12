// Lambda 문법 : 람다 문법 I
 // => 문법
    //         (파라미터, 파라미터, ...) -> 문장 한개
    //         (파라미터, 파라미터, ...) -> {문장1; 문장2; 문장3;}
    //         () -> 문장 한개
    //         () -> {문장1; 문장2; 문장3}



package ch19.h;

public class Test02 {

  // 다음과 같이 추상 메서드가 한 개 있는 인터페이스를 "functional interface"라고 부른다 
  // => 이런 경우 람다 문법으로 사용할 수 있다
  static interface Player {
    void play();
  }
  public static void main(String[] args) {

    // 1) 한 문장일 때는 중괄호를 생략할 수 있다
    Player p1 = () -> System.out.println("테스트1");

    p1.play();

    // 2) 중괄호 넣어도 됨
    Player p2 = () -> {System.out.println("테스트1");};




  }
}
