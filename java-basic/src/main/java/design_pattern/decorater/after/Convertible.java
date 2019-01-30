package design_pattern.decorater.after;

public class Convertible extends Decorator {

  boolean openRoof;

  public Convertible(Car car) {
    super(car);       //super 클래스인 Car에 입력받은 car 를 넣는다
  }

  @Override
  public void run() {
    
    // 생성자에서 받은 자동차에 덧붙인 자동차 지붕 열기 기능을 실행한다
    this.car.run();   

    // 생성자에서 받은 자동차에 덧붙인 자동차 지붕 열기 기능을 실행한다
    if(this.openRoof) {
      System.out.println("지붕을 연다");
    } else {
      System.out.println("지붕을 닫는다");
    }
  }

  public void openRoof(boolean openRoof) {
    this.openRoof = openRoof;
  }
}
