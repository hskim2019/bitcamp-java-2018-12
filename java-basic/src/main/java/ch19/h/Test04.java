// Lambda 문법 : 람다 파라미터 II
 // => 문법
    //         (파라미터, 파라미터, ...) -> 문장 한개
    //         (파라미터, 파라미터, ...) -> {문장1; 문장2; 문장3;}
    //         () -> 문장 한개
    //         () -> {문장1; 문장2; 문장3}

package ch19.h;

public class Test04 {

  static interface Player {
    void play(String name, int age);
  }

  public static void main(String[] args) {

    // 1) 파라미터는 괄호() 안에 선언한다
    Player p1 = (String name, int age) -> 
    System.out.printf("%s(%d) 님 환영합니다\n", name, age);
    p1.play("홍길동", 20);

    // 2) 파라미터 타입을 생략할 수 있다
    Player p2 = (name, age) -> 
    System.out.printf("%s(%d) 님 환영합니다\n", name, age);
    p2.play("홍길동", 20);

    // 3) 파라미터가 여러개일 때는 괄호도 생략할 수 없다
//    Player p3 = name, age -> 
//    System.out.printf("%s(%d) 님 환영합니다\n");
//    p3.play("홍길동", 20);




  }
}

