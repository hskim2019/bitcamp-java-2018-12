package ch16;

import java.util.Date;

// 제네릭을 적용한 클래스 만들기

class Box<T> {
  T value;    //T라는 타입으로 클래스 만들고, T 타입 인스턴스 주소 저장할 필드

  //메서드
  public Box(T value) {
    this.value = value;
  }

  public T getValue() {
    return this.value;
  }

}

// 제네릭 클래스 이용
public class practice {
  public static void main(String[] args) {
    Box<String> x1 = new Box<>("홍길동");
      Box<String> x2 = new Box<>("임꺽정");
      Box<String> x3 = new Box<>("유관순");
      Box<Date> x4 = new Box<>(new Date());
      
      String a = x1.getValue();
      Date b = x4.getValue();
      System.out.println(a);
      System.out.println(x4);
      System.out.println(b);

  }
}
