// 콘솔로 출력하기 III - 형식을 갖춰 날짜 값 출력하
package ch02;

public class Test13 {
  
  public static void main(String[] args) {
    // 현재 날짜 및 시각 정보를 생성한다
    // java.lang 패키지의 멤버를 사용할 때는 그냥 이름을 지정하면 됨
    // 그 외 다른 패키지의 멤버를 사용할 때는 반드시 패키지 이름을 지정해야 함
    
    java.util.Date today = new java.util.Date();
    
    // %t날짜 및 시간 옵션
    // Y : 날짜 및 시간 데이터에서 년도를 추출하여 4자리로 표현
    // y : 날짜 및 시간 데이터에서 년도를 추출하여 뒤의 2자리로 표현
    System.out.printf("%tY\n", today);
    System.out.printf("%1$tY, %1$ty\n", today);
    
    // B : 날짜 및 시간 데이터에서 월을 추출하여 전체 이름으로 표현 January
    // b : 날짜 및 시간 데이터에서 월을 추출하여 단축 이름으로 표현 Jan
    System.out.printf("%1$tB, %1$tb\n", today);
    
    // m : 날짜 및 시간 데이터에서 월을 추출하여 2자리 숫자로 표현 ex: 12, 01
    System.out.printf("%1$tm\n", today);
    
    // d : 날짜 및 시간 데이터에서 일을 추출하여 2 자리 숫자로 표현 ex) 01, 22
    // e : 날짜 및 시간 데이터에서 일을 추출하여 1 자리 숫자로 표현 ex) 1, 22
    System.out.printf("%1$td %1$te\n", today);
    
    // A : 날짜 및 시간 데이터에서 요일을 추출하여 긴 이름으로 표현 ex) Sunday
    // a : 날짜 및 시간 데이터에서 요일을 추출하여 짧은 이름으로 표현 ex)Sun
    System.out.printf("%1$tA %1$ta\n", today);
    
    // H : 날짜 및 시각 데이터에서 시각을 추출하여 24시로 표현
    // I : 날짜 및 시각 제이터에서 시각을 추출하여 12로 표현한다
    System.out.printf("%1$tH %1$tI\n", today);
    
    // M : 날짜 및 시각 데이터에서 시각을 추출하여 분을 표현한다
    System.out.printf("%1$tM\n", today);
    
    // S : 날짜 및 시각 데이터에서 시각을 추출하여 초단위를 표현
    // L : 날짜 및 시각 데이터에서 시각을 추출하여 밀리초로 표현 
    // N : 날짜 및 시각 데이터에서 시각을 추출하여 나노초를 표 
    System.out.printf("%1$tS %1$tL %1$tN\n", today);
    
    // p : 오전 오후 출력하기
    //       소문자 t를 사용하면 am 또는 pm으로 출력
    //       대문자 T를 사용하면 AM 또는 PM으로 출력
    //       한글은 대소문자가 없기 때문에 의미가 없음
    System.out.printf("%1$tp\n", today);
    
    // 년-월-일-시:분:초 출력
    System.out.printf("%1$tY-%1$tm-%1$td %1$tp %1$tH:%1$tM:%1$tS", today);
    
    
    
    
    
  }
}
