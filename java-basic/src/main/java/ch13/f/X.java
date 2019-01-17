package ch13.f;

public class X {
  private int v1 = 100; //인스턴스 필드

  //생성자 - 파라미터 값 있는 생성자
  public X(int value) {
    //    super();
    // 수퍼 클래스의 생성자를 호출할 때는 반드시 첫 번째 문장으로 와야 한다
    this.v1 = value;
    System.out.println("A.A()");
  }

  //메서드
  public void m1() {
    System.out.printf("A.v1 = %d\n", this.v1);
  }
}
