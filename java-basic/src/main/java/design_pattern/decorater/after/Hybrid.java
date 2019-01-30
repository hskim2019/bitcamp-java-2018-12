package design_pattern.decorater.after;

public class Hybrid extends Decorator {


  public Hybrid(Car car) {
    super(car);       //super 클래스인 Car에 입력받은 car 를 넣는다
  }

  @Override
  public void run() {
    System.out.print("전기모터를 켜고, ");
    this.car.run();   

  }
}
