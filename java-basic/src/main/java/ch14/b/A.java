package ch14.b;

public class A {

  void m1(int a) {
    System.out.printf("A.m1(%d)\n", a);
  }
  
  protected void m2(String a, int b) {
    System.out.println("A.m2()");
  }
  
  public void m3() {
    System.out.println("A.m3()");
  }
}
