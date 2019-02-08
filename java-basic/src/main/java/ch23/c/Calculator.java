package ch23.c;

import java.io.Serializable;

// java.io.Serializable
// => 개발자가 serialVersionUID 값을 직접 설정할 수 있다
public class Calculator implements Serializable{
  private static final long serialVersionUID = 100L; // L = long값
 private int a;
 private String x;
 private int b;

  public Calculator() {

  }

  public Calculator(int a, String x, int b) {
    this.a = a;
    this.x = x;
    this.b = b;
  }

}
