// 오버라이딩 메서드와 추상 메서드
package ch14.f;

public class Test04 {
  
  public static void main(String[] args) {
    // 레퍼런스 변수 선언
    // => 어떤 타입의 레퍼런스가 있다면 그 타입의 인스턴스 주소를 담을 수 있다는 것이다
    // => 또한 그 타입의 서브 클래스의 인스턴스 주소도 담을 수 있다
    A obj = new B();
    obj.m1(); // B.m1()
    // obj.m2(); // 컴파일 오류 !
    
    // 레퍼런스가 가리키는 실제 타입을 그대로 사용하고 싶다면
    // (obj에 저장된 B 클래스를 그대로 사용하고 싶다면)
    // 형변환하여 사용하라
    B obj2 = (B) obj; // 컴파일러야 obj에 들어 있는 주소가 원래 B의 인스턴스이다
                      // 그러니 obj2에 저장해라
    
    obj2.m2(); // obj에 들어있는 주소와 obj2에 들어 있는 주소 같음
    
    if(obj == obj2) {
      System.out.println("obj == obj2");
    }
    
    // 컴파일러는 속일지라도 JVM은 속일 수 없다
    A obj3 = new A();
    
    // A 타입의 인스턴스를 B타입의 인스턴스라고 주장하면
    // 컴파일러는 통과시킨다
    // 그러나 JVM은 오류를 발생시킨다
    B obj4 = (B) obj3; // Rumtime 예외 발생
    
    obj3.m1();
    obj4.m1();
  }

}
