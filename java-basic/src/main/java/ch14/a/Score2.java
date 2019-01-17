package ch14.a;

public class Score2 extends Score {

  protected int music;
  protected int art;
  
  // 오버라이딩(overriding)
  // => 상속 받은 메서드를 서브 클래스의 역할에 맞게 재정의하는 문법
  // => 상속 받은 메서드와 똑같은 시그너처로 메서드를 정의한다
  
  @Override  // 이 에노테이션이 있으면 아래에 computo와 같이 오타가 있어 상속받은 클래스와 메서드 이름 다르면 오류 알려줌
             // 컴파일러에게 상속 받은 메서드를 재정의 한다는 것을 알려준다
  public void compute() {
    this.sum = this.kor + this.eng + this.math + this.music + this.art;
    this.aver = this.sum / 5f;
  }
}