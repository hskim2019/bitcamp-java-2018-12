package ch13.f;

public class Y extends X {
  private int v2 = 200;

  //기본생성자
  public Y() {
//    super(); //X 클래스 생성자에 value 값을 넣도록 만들었기 때문에 컴파일 오류
    super(500); 
    System.out.println("B.B()");
  }

  public void m2() {
    System.out.printf("B.v2 = %d\n", this.v2);
  }
}
