// 흐름제어문 : if ~else 조건문
package ch05;

public class Test02 {
  public static void main(String[] args) {
    int age = 22;

    // 기본문장
    if(age >= 20) 
      System.out.println("성인입니다");
    else
      System.out.println("미성년입니다");

    // 여러 문장을 실행할 때 블럭을 묶어야 함
    if(age >= 20) {
      System.out.println("----------------");
      System.out.println("성인입니다");
    }
    else {
      System.out.println("----------------");
      System.out.println("미성년입니다");
    }

    // if ~else의 모양
    if(age >= 20) {
      System.out.println("----------------");
      System.out.println("성인입니다");
    } else {
      System.out.println("----------------");
      System.out.println("미성년입니다");
    }



  }
}
/*#if 조건문
 * 문법1 : if (조건) 문장1: 조건이 참일 때 문장1 수행
 * 문법2 : if (조건) 문장1; else 문장2; : 조건이 참일 때 문장1 수행, 거짓이면 문장2
 * if 문만 작성할 수 있지만, else 문은 홀로 존재할 수 없다
 */
