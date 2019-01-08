// 흐름제어문 : switch 문
package ch05;

public class Test04 {
  public static void main(String[] args) {
    byte b = 1;  //switch 조건으로 OK
    short s = 1; // OK
    char c = 1; // OK
    int i = 1; // OK
    long l = 1L; // X
    float f = 1.0f; // X
    double d = 1.0; // X
        
    switch (s) {
      case 1:
        System.out.println("11");
        System.out.println("1111");
        break;
      case 2:
        System.out.println("22");
        System.out.println("2222");
        break;
      case 'A': // 'A'의 리턴 값은 2바이트 정수(UTF-16코드)값
        System.out.println("AAAA");
        default:
          System.out.println("????");
    }
  }
}

/*switch (4바이트 정수 값 또는 문자열= long&double x) {
 * case 4바이트 정수값 또는 문자열:
 * 문장1;
 * 문장2;
 * break;
 * default:
 */
