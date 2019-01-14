// 그 밖의 클래스 멤버들
package ch08;

 class My4 {
  // 클래스 필드 = 스테틱 필드(변수) - method area에 생성
  // => 클래스가 로딩 될 때 생성되는 변수
  // => 클래스 필드도 인스턴스 필드처럼 기본 값으로 자동 초기화 된다
        // 레퍼런스는 null, 나머지는 0으로
  static int a;
  
  // 스테틱 블록 = 클래스 블록 
  // => 클래스가 로딩될 때 클래스 변수를 생성한 후 실행되는 블럭
  // => 클래스와 같이 한 번만 실행된다
  static {
    System.out.println("스테틱블록1");
  }

  static {
    System.out.println("스테틱 블록2");
  }

  // 클래스 메서드 = 스테틱 메서드
  // => 클래스 이름으로 호출하는 함수
  static void m1() {
    System.out.println("클래스 메서드 = 스테틱 메서드 호출");
  }
}

public class Test04 {
  
  public static void main(String[] args) {

    System.out.println("*******************");
 
    // 레퍼런스를 선언할 때는 클래스가 로딩되지 않는다
    My4 obj1;
    
    System.out.println("----------------");
    // 아래와 같이 클래스 멤버(클래스 필드, 클래스 메서드)를 사용해야 로딩이 됨
    //    My4.a = 300;
    
    // 클래스 메서드를 사용할 때
    My4.m1();
    My4.m1();  // 한 번 클래스가 로딩되면 다시 로딩하지 않는다. 스테틱 블록은 1번만 실행

  }
}

/*
# 클래스 로딩
1) 클래스를 외부 저장소에서 내부 저장소인 RAM으로 로딩한다
2) 클래스의 바이트코드 유효성을 검사한다
3) 클래스 내부에서 사용하는 모든 이름(변수명, 메서드명, 클래스명 등) 목록을 준비한다
4) 클래스 필드를 찾아 생성한다
5) 스테틱 블록이 있으면 순서대로 실행한다
 */