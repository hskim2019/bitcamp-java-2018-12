// 클래스 로딩과 클래스 필드의 생성, Method Area의 관계 (제목 확인하기)
package ch08;

class My3 {
  // 클래스 필드 - method area에 생성
  static int sa;

  //인스턴스 필드 -heap
  int ia;
}

public class Test03 {
  public static void main(String[] args) {
    // 클래스 필드는 인스턴스를 생성할 필요 없이 클래스 이름으로 바로 사용한다
    My3.sa = 100;
    
    // 인스턴스 필드는 new 명령을 수행해야 생성된다
    My3 obj1 = new My3();  // stack 영역에 주소담을 변수엔 obj1변수 준비 
    My3 obj2 = new My3();
    
    // 인스턴스 필드는 인스턴스의 주소가 있어야만 접근할 수 있다
    obj1.ia = 200;
    obj1.ia = 300;
    
    // 클래스 이름으로는 인스턴스 필드에 접근할 수 없다
//    My3.ia = 500; 
    
    // 클래스 필드에 접근할 때는 레퍼런스를 통해 접근할 수 있다
    obj1.sa = 500;
    // 인스턴스 필드에 sa가 있는지 찾아보고 없으면 obj1의 클래스에서 자동으로 찾는다
    // 컴파일 오류는 발생하지 않지만 
    System.out.println(My3.sa);
  }
}
