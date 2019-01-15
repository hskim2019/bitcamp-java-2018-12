// 생성자 - 생성자가 여러개일 때
package ch10;

class Monitor9 {
  int bright;    // 밝기 (0% ~ 100%)
  int contrast = 50;  // 명암 (0% ~ 100%)
  int widthRes;  // 해상도 너비
  int heightRes = 1080; // 해상도 높이

  Monitor9() { // 생성자1
    this.bright = 50;
    this.contrast = 50;
    this.widthRes = 2560;
    this.heightRes = 1200;
    System.out.println("Monitor9()");
  }
  
  Monitor9 (int bright, int contrast) { //생성자2
    this.bright = bright;
    this.contrast = contrast;
    System.out.println("Monitor9(int, int)");
  }

  Monitor9(int bright, int contrast, int widthRes, int heightRes) { //생성자3
    this.bright = bright;
    this.contrast = contrast;
    this.widthRes = widthRes;
    this.heightRes = heightRes;
    System.out.println("Monitor9(int, int, int, int)");
  }
  
  public void on() {
    // 모니터를 켜면 bright, contrast, widthRes, heightRes 값에 맞춰서
    // LCD의 불을 밝힌다
    System.out.println("화면을 출력한다.");
  }
}
public class Test11 {
  public static void main(String[] args) {
    // 인스턴스 생성

// 생성자를 지정할 때 파라미터의 값에 따라 결정된다
    new Monitor9(); // 기본생성자 호출 생성자1
    new Monitor9(50 ,50); // 생성자2
    new Monitor9(50, 50, 1920, 1080); // 생성자 3
    
    // 파라미터 타입이나 개수가 일치하지 않는 생성자는 호출할 수 없다
//    new Monitor9(1);
  }
  
}


