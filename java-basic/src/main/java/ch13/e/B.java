package ch13.e;

public class B extends A {
  private int v2 = 200;

  { //인스턴스 블록
    v2 = 210;
    System.out.println("B.{}");
  }
  
  //기본생성자
  public B() {
    v2 = 120;
    System.out.println("B.B()");
  }
  
  public void m2() {
    System.out.printf("B.v2 = %d\n", this.v2);
  }
}
