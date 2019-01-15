// 생성자 - 기본생성자 I
package ch10;

class Monitor7 {
  int bright;    // 밝기 (0% ~ 100%)
  int contrast = 50;  // 명암 (0% ~ 100%)
  int widthRes;  // 해상도 너비
  int heightRes = 1080; // 해상도 높이

  // 클래스에 기본 생성자가 없으면 컴파일러가 자동으로 '공개 된' 기본 생성자를 추가한다
  // => 그래서 모든 클래스는 기본 생성자가 반드시 한 개 이상 있다
  // public Monitor7() {}

  public void on() {
    // 모니터를 켜면 bright, contrast, widthRes, heightRes 값에 맞춰서
    // LCD의 불을 밝힌다
    System.out.println("화면을 출력한다.");
  }
}
public class Test09 {
  public static void main(String[] args) {
    // 인스턴스 생성

    // 1) 클래스에 기본 생성자가 없다고 해서 다음과 같이 인스턴스를 생성할 수 없다
    //    new Monitor7; 컴파일 오류!

    // 2) 기본생성자 표시해야 한다
    new Monitor7();

    // 3) 파라미터 값을 받지 않는 생성자를 호출할 때 값을 주면 컴파일 오류가 발생한다
    //    new Monitor6(100); 컴파일 오류
  }
}


