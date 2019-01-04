// 레퍼런스 변수
package ch03;

public class Test05 {
  public static void main(String[] args) {
    java.util.Date d1 = new java.util.Date();
    java.util.Date d2 = d1;
    
    System.out.printf("%d, %d\n", d1.getDate(), d2.getDate());
       
    d1.setDate(10);
    
    System.out.printf("%d, %d\n", d1.getDate(), d2.getDate());
    
    // d1에 저장된 일자 값을 변경한 후
    // d2에 저장된 일자 값을 출력해 보면 d1과 똑같이 변경 되어 있다
    // d1과 d2에 저장되는 것은 값이 아니라 '날짜 정보가 저장되어 있는'메모리의 주소
    // 이렇게 값을 저장하지 않고 값이 저장된 위치(주소)를 저장하는 변수를
    // 레퍼런스(변수) 라 부름


  }
}

/*
 #
 */

