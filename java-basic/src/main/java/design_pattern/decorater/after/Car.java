package design_pattern.decorater.after;

public abstract class Car {
  
  protected int speed;
  int capacity;
  

  public void start() {
    System.out.println("시동 건다");
  }

  public void stop() {
    System.out.println("시동 끈다");
  }

  public abstract void run();

}
