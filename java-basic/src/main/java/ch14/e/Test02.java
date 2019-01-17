// 다형적 변수의 사용 I
package ch14.e;

public class Test02 {

  public static void main(String[] args) {
    PickupTruck c1 = new PickupTruck();
    SUV c2 = new SUV();
    Convertable c3 = new Convertable();
    DumpTruck c4 = new DumpTruck();
    
    // 위에서 생성한 각 인스턴스를 테스트하려면
    // 다음과 같이 타입에 맞는 test() 메서드를 각각 정의해야 한다
    // test() 메서드의 코드는 같지만 타입이 다르기 때문에 복/붙 해서라도 개별적으로 정의해야 한다
    // 그게 가능하려면 test() 메서드의 파라미터가 모든 자동차의 인스턴스 주소를 받을 수 있어야 한다
    // => 타입이 다르기 때문에 같은 코드를 공유할 수 없는 문제를 해결하기 위해
    //    등장한 문법이 "다형적 변수(polymorphic variable)" 이다.
    // => 한 개의 변수가 다양한 타입의 값을 받을 수 있는 것을 말한다
    test(c1);
    test(c2);
    test(c3);
    test(c4);
    
  }

  // Car reference는 Car의 모든 종류(sub Class)의 인스턴스 주소를 담을 수 있다
  // => 이렇게 한 변수가 다양한 타입의 값을 담을 수 있는 것을 "다형적 변수"라고 부른다
  // => 다형적 변수를 사용하면 훨씬 더 유연하게 객체를 다룰 수 있다
    static void test(Car car) {
      System.out.println("---------------------");
      car.run(); // Car 변수가 실제 가리키는 인스턴스의 오버라이딩 메서드
      car.stop();      //Car의 stop
      car.run(); // Car 변수가 실제 가리키는 인스턴스의 오버라이딩 메서드
      car.stop();      // Car의 stop
      System.out.println("---------------------");
    }
   
}
