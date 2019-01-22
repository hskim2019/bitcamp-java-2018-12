package ch18.e;

public class MultiPen extends Zebra implements Pen{
  @Override
  public void write(String text) {
    if (!this.use)  // 사용할 수 있는 상태가 아니면 아무것도 리턴하지 말고
      return;
    System.out.println("제브라>> " + text);
  }
}
