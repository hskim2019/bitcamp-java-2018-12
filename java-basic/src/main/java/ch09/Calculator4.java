package ch09;

public class Calculator4 {

  int result = 0; 

  //인스턴스 주소를 파라미터로  받지 않고 호출될 때 앞에서 받는 방법
  void plus(int a) {
    // 메서드를 호출할 때 인스턴스 주소를 앞으로 넘겼다
    // 예) c1.plus(2);
    //      => c1에 들어있던 인스턴스 주소가 plus에 전달 되었다는 것인데 주소가 어디에 있을까?
    //      =>static이 붙지 않은 메서드를 인스턴스 메서드라 부른다
    //      => 모든 인스턴스 메서드는 호출될 때 넘겨받은 인스턴스 주소를 저장하기 위한
    //         변수를 내장(built-in)하고 있다
    //      => 내장 된 변수의 이름은 "this"이다
    // 파라미터 that에 들어 있는 주소로 찾아가서 그 인스턴스의 result필드를 사용한다
    this.result += a;   // 이렇게 result변수가 있는 인스턴스 주소를 사용하여 계산을 수행한다
  }

  void minus(int a) {
    result -= a;   //  this를 생략해도 컴파일 할 때 this가 자동으로 붙는다
  }

  void multiple(int a) {
    this.result *= a;
  }

  void divide(int a) {
    result /= a;
  }

}
