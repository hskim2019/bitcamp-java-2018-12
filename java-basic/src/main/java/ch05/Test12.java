// 흐름제어문:  for 반복문 I
package ch05;

public class Test12 {
  
  public static void main(String[] args) {
   for (int i = 1; i <=10; i++)
     System.out.print(i + " ");
   System.out.println();
   //실행순서
   //1) 변수초기화 => int i = 1;
   //2) 조건 => i <= 10;
   //3) 문장 => System.out.print(i + "");
   
   //변수초기화를 꼭 for문 안에 넣지 않아도 됨
   // for문 안에 선언된 변수는 for 문을 나가면 제거 됨
   int i = 1;
   for(; i <= 10; i++)
     System.out.print(i + " ");
   System.out.println();
   
   
   i = 1;
   for(; i <= 10;) {
     System.out.print(i + " ");
     i++;
   }
   System.out.println();
   
   i = 1;
   for (;;) {
     if (i > 10)
       break;
     System.out.print(i + " ");
     i++;
   }
   System.out.println();
  }
}

/* for 반복문
 * 배열과 함께 사용할 떄 유용
 * 
 * for (변수초기화, 조건; 변수증가문)
 * 문장1;
 * 
 * for (변수 초기화; 조건; 변수증가문) {
 *  문장1;
 *  문장2;
 * }
 * 
 */
