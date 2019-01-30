package design_pattern.decorater.after;

public class Dump extends Decorator {


  public Dump(Car car) {
    super(car);       //super 클래스인 Car에 입력받은 car 를 넣는다
  }

  @Override
  public void run() {
    // 생성자에서 받은 자동차에 덧붙인 짐내리기 기능을 실행한다
    this.car.stop();
    
    this.dump();
    
    // 생성자에서 받은 원래의 자동차를 실행한다
    this.car.run();   

  }
  public void dump() {
    System.out.println("짐을 내린다");
  }
}
