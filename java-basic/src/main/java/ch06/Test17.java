// 메서드 - JVM 아규먼트 응용 I
package ch06;

public class Test17 {
  public static void main(String[] args) {
    // JVM 아규먼트로 학생의 이름, 국영수 점수를 입력 받아 총점과 평균을 출력하라
    // -$java -cp ./bin/main -Dname=홍길동 -Dkor-100 -Deng=100 -Dmath=90 ch06.Test17
    // 이름: 홍길동
    // 총점:290
    // 평균: 96.9

    String name = System.getProperty("name");
    int k = Integer.parseInt(System.getProperty("kor"));
    int e = Integer.parseInt(System.getProperty("eng"));
    int m = Integer.parseInt(System.getProperty("math"));
    int sum = k + e + m;

    System.out.printf("이름: %s\n", name);
    System.out.printf("총점: %d\n", sum);
    System.out.printf("평균: %.1f\n", sum / 3f);

  } // main end

}//class end
