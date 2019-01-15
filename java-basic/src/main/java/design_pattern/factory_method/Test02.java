// 팩토리 메서드 적용 전
package design_pattern.factory_method;

class Car2 {
  String model;
  int cc;
  boolean sunroof;
}

// 인스턴스 생성과정이 복잡할 때 별도의 클래스에서 인스턴스를 생성하는 것이 유지보수에 좋다
// => 어떤 클래스의 인스턴스를 대신 생성해 주는 클래스는 보통 XxxFactory라는 이름으로 짓는다
class Car2Factory {
  
  // 인스턴스를 생성해주는 메서드를 정의한다
  // => 이렇게 설계하는 기법을 "팩토리 메서드"라고 한다
  public static Car2 creat(String product) {
    Car2 c = new Car2();

    switch (product) {
      case "tc":
        c.model = "티코";
        c.cc = 890;
        c.sunroof = false;
        break;
      case "tcg":
        c.model = "티코 골드";
        c.cc = 890;
        c.sunroof = true;
        break;
      case "sn":
        c.model = "소나타";
        c.cc = 1980;
        c.sunroof = false;
        break;
      case "sng":
        c.model = "소나타 골드";
        c.cc = 1980;
        c.sunroof = true;
        break;
      default:
        return null;
    }
    return c;
  }
}

public class Test02 {

  public static void main(String[] args) {
    // 인스턴스를 만들 때 사용에 적합하도록 직접 초기화 시켜야 한다
    Car2 c1 = Car2Factory.creat("tc");
    Car2 c2 = Car2Factory.creat("tcg");
    Car2 c3 = Car2Factory.creat("sn");
    Car2 c4 = Car2Factory.creat("sng");
    Car2 c5 = Car2Factory.creat("ok");
    
    System.out.println(c1.model);
    System.out.println(c2.model);
    System.out.println(c3.model);
    System.out.println(c4.model);
    System.out.println(c5.model);
    


  }

}
