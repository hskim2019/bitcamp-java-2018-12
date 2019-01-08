// 흐름제어문 : switch 문자열
package ch05;

public class Test05 {
  public static void main(String[] args) {
    String str = "aaa";
        
    switch (str) {
      case "ok":
        System.out.println("okokok");
        break;
      case "no":
        System.out.println("nononono");
        break;
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
 * case xxxx:
 * 문장1;
 * ....
 * break;
 * default:
 * 위의 조건에 해당하는 것이 없으면 이 문장을 실행한다
 * }
 */
