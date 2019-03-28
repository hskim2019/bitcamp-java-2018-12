package design_pattern.chain_of_responsibility;

public abstract class AbstractHandler implements Handler{
  
  Handler next;  // 다음 핸들러 객체 주소 보관
  public AbstractHandler() {
    
  }
  public AbstractHandler(Handler next) {
    this.next = next;
  }

  public Handler getNext() {
    return next;
  }

  public void setNext(Handler next) {
    this.next = next;
  }

  
}
