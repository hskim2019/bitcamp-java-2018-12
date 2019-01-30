package design_pattern.decorater.after;

public class Test01 {

  public static void main(String[] args) {
    
    // Decorator 패턴이 적용 된 자동차를 만들어 써보자
    // Decorator 디자인 패턴의 목표: 
    // => 기능을 플러그인처럼 붙였다 뗐다를 자유롭게 하기 위함이다
    
    
    // 전기차 트럭을 만들어보자
    System.out.println("Truck + Hybrid============================================" );
    Truck c1 = new Truck();
    Hybrid c2 = new Hybrid(c1);
    c2.run();

    System.out.println("Hybrid(+Truck) + Convertible====================================" );
    
    // Hybrid 이면서 convertible 기능   System.out.println("============================================" );을 갖는 자동차
    Convertible c3 = new Convertible(c2);
     c3.openRoof(true);
     c3.run();
     
     System.out.println("Sedan + Convertible====================================" );
     // Hybrid 기능 빼고 Sedan에 Convertible 기능을 달자
     Sedan s1 = new Sedan();
     Convertible c4 = new Convertible(s1);
     c4.openRoof(true);
     c4.run();
     
     System.out.println("Convertible(Sedan) + Dump====================================" );
     Dump c5 = new Dump(c4);
     c5.run();
     
     System.out.println("Convertible(Hybrid(Truck) + Dump====================================" );
     // c3는 Truck이면서 Convertible
     Dump c6 = new Dump(c3);
     c6.run();
     
  }

}
