// 흐름제어문: Do ~ while 반복문
package ch05;

public class Test11 {
  
  public static void main(String[] args) {
    int i = 1;
    do
      System.out.print(i + "");
    while(i++ < 10); // i값이 10 이하일 때 까지 반복
    System.out.println();
    
    i = 0;
    do {
      System.out.print(++i);
      System.out.print(",");
    } while (i < 10 );
    System.out.println();
        
  }
}

/* while문과의 차이점 : do - while은 한 번은 반드시 실행한다
 * 
 * 형
 * do ~ while
 * do
 *   문장1;
 * while (조건);
 * 
 * do {
 * 문장1;
 * 문장2;
 * 문장3;
 * } while (조건);
 *
 */
