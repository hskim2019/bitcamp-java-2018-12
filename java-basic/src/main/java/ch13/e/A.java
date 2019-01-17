package ch13.e;

public class A {
  private int v1 = 100; //인스턴스 필드

  { //인스턴스 블록
    v1 = 110;
    System.out.println("A.{}");
  }
  
  //기본생성자
  public A() {
    v1 = 120;
    System.out.println("A.A()");
  }
  
  //메서드
  public void m1() {
    System.out.printf("A.v1 = %d\n", this.v1);
  }
}
