// this와 super 키워드를 사용하여 메서드를 호출할 때:
package ch14.b;

public class D3 extends D2 {

  void m1() {
    System.out.printf("D3.m1()");
  }


  public void m3() {
    System.out.println("D3.m3()");
  }

  void test() {
    this.m4(); //D1.m4() // this 는 현재 클래스부터
    super.m4(); //D1.m4() // super는 super 클래스부터
    
    this.m3(); //D3.m3()
    super.m3(); //D1.m3()
    
    this.m1(); //D3.m1()
    super.m1(); //D2.m1()
    
    this.m2(); //D2.m2()
    super.m2(); //D2.m2()
  }
  
  public static void main(String[] args) {
    D3 obj = new D3();
    obj.test();
  }
}
