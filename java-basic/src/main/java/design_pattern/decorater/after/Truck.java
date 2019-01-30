package design_pattern.decorater.after;

public class Truck extends Car {
  int weight;

  @Override
  public void run() {
    System.out.println("트럭은 덜컹덜컹 달린다");    
  }

 
}
