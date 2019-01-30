// 예외 던지기 - Exception 예외 던지기 I
package ch21.d;

public class Test04 {

  public static void main(String[] args) throws Exception {
    // main()에서조차 예외를 처리하지 않는다면 JVM에게 보고해야 한다
    // JVM은 예외를 보고 받자마자 즉시 예외 정보를
    m3();
    System.out.println("종료!");
  }

  static void m3() throws Exception {
    m2();
  }

  static void m2() throws Exception {
    // Exception 예외를 발생시키는 메서드를 호출할 때는
    // 1) try~ catch로 예외를 처리하거나
    // 2) throws절을 사용하여 어떤 예외가 발생하는지 선언(보고) 해아한다
    m1();  
  }


  static void m1() throws Exception {
    // Exception 예외를 발생시키는 메서드는
    // 반드시 메서드 선언부에 어떤 예외를 던지는지 선언해야 한다
    throw new Exception("m1()에서 발생한 예외");      
  }

}






