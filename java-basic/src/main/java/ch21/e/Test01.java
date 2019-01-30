// 사용자 정의 예외 사용하기
package ch21.e;

public class Test01 {
  // 사용자(개발자) 정의 예외 클래스
  // => Exception 또는 RuntimeException을 상속 받아 만든다
  // => 예외 클래스는 수퍼 클래스에 기능을 덧붙이는 것이 아니다
  // => 단지 클래스 이름으로 예외를 직관적으로 알리기 위해 사용한다

  // Exception : 예외에 대한 간단한 정보들을 주는 클래스
  static class MyException extends Exception {
    // 보통 수퍼 클래스를 상속 받은 후 수퍼 클래스와 같은 생성자를 만든다
    // 서브 클래스 생성자는 단지 수퍼 클래스의 생성자를 호출한다
    // 만드는 법: source - generate Constructions from Superclass
    public MyException() {
      super();
      // TODO Auto-generated constructor stub
    }

    public MyException(String message, Throwable cause, boolean enableSuppression,
        boolean writableStackTrace) {
      super(message, cause, enableSuppression, writableStackTrace);
      // TODO Auto-generated constructor stub
    }

    public MyException(String message, Throwable cause) {
      super(message, cause);
      // TODO Auto-generated constructor stub
    }

    public MyException(String message) {
      super(message);
      // TODO Auto-generated constructor stub
    }

    public MyException(Throwable cause) {
      super(cause);
      // TODO Auto-generated constructor stub
    }

  }

  public static void main(String[] args) throws Exception { // 예외 던지기
    // m1()에서 발생한 예외 정보를 보면 예외 클래스 이름이 출력된다
    // 예외 클래스 이름으로 어디에서 왜 예외가 발생했는지 짐작할 수 있다
    // 이런 이유로 사용자 정의 예외를 만들어 사용하는 것이다
    
    // 대부분의 라이브러리나 프레임워크는 자신들만의 예외 클래스를 만들어 던진다
    m1();
  }
  static void m1() throws MyException {
    throw new MyException();
  }

}

