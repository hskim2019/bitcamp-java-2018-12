// 인터페이스 구현 - 인터페이스에 선언 된 모든 메서드를 정의해야 한다
package ch18.h;

public class MyPen implements Pen {

  boolean use;

  @Override
  public void on() {
    this.use = true;  
  }

  @Override
  public void off() {
    this.use = false;
  }

  @Override
  public void write(String text) {
    if(!this.use)
      return; // 사용할 수 없으면 더이상 메서드 실행 안 함
    System.out.println("=====>" + text);


  }

}
