// 클래스 로딩과 클래스 필드의 생성, Method Area의 관계
package ch08;

class My2 {
  // 클래스 필드 - method area에 생성
  static String manager = "관리자";
  static String member = "회원";
  static String guest = "손님";

  //인스턴스 필드 - new 명령을 실행하면 heap에 생성
  String name;
  int age;
  String userType;
}

public class Test02 {
  public static void main(String[] args) {
    // 클래스 로딩 과정
    //         $ java Test02 실행했을 때
    // 1) Test02.class를 "Method Area 영역"에 로딩
    // 2) Test02의 main() 메서드를 호출
    // 3) main() 메서드에 선언된 로컬 변수를 "JVM Stack 영역"에 생성한다
    // 4) main() 메서드의 코드를 실행한다
    //      -My2.class를 "Method area"에 로딩한다
    //      -My2의 클래스 필드를 "Method Area"에 생성한다
    //      -System.out.println(My2.manager);를 실행한다
    //      -My2 클래스가 이미 로딩 되었기 때문에 다시 로딩하지 않는다
    //      -System.out.println(My2.member)를 실행한다
    // 5) new 명령에 따라 "Heap 영역"에 인스턴스 필드를 생성한다

    System.out.println(My2.manager);
    System.out.println(My2.member);

  }
}

/*
# 클래스 로딩
  - 외부 저장장치(예: HDD, USB메모리, DVD - ROM 등)에 있는 .class파일을 JVM이 관리하는 메모리로 로딩하는 것
  - 클래스 코드를 사용하는 시점에 메모리(Method Area)에 로딩된다
  - 한 번 로딩되면 JVM을 종료할 때까지 유지한다
  - 강제로 unloading할 수 있다. 그리고 다시 로딩할 수 있다

# JVM이 관리하는 메모리 영역
1) Heap
 - new 명령으로 생성한 인스턴스가 놓임
 - 가비지 컬렉터는 이 메모리의 가비지들을 관리
 2) JVM stack
 - 각 스레드가 개인적으로 관리하는 메모리 영역
 - 스레드에서 메서드를 호출할 때 메서드의 로컬 변수를 이 영역에 만든다
 - 메서드가 호출될 때 그 메서드가 사용하는 로컬 변수를 프레임에 담아 만든다
 - 메서드 호출이 끝나면 그 메서드가 소유한 프레임이 삭제 된다
 3) Method Area
 - JVM이 실행하는 바이트코드(.class 파일)를 두는 메모리 영역
 - 즉 클래스 코드가 이 영역에 놓이는 것이다
 - JVM은 코드를 실행할 때 이 영역에 놓은 명령어를 실행하는 것이다
 - 주의! Heap에는 개발자가 작성한 명령어가 없다
 - 개발자가 작성한 클래스, 메서드 등 이런 코드들이 이 영역에 놓이는 것이다
 - 스테틱 필드를 이 영역에 생성한다
 
 # 클래스의 코드를 사용하는 시점?
  - 스테틱 멤버(필드와 메서드)를 사용할 때
  - 예) My2.member = 200;
  -    System.out.println(My2.member);
  - new 명령을 사용하여 인스턴트를 생성할 때
  - 주의! 레퍼런스 변수를 선언할 때는 클래스를 로딩하지 않는다
  -   예) My2 obj1;
 
 */


