// 로컬 변수와 인스턴스 필드(변수)의 초기화
package ch07;

public class Test07 {
  static class Score { 

    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  } // Score end 
  
  public static void main(String[] args) {
    // 로컬 변수는 자동으로 초기화 되지 않는다
    // 초기화 - 값을 한 번이라도 저장하는 것;
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
    
//    System.out.println(name); 한 번도 초기화 하지 않아서 컴파일 오류
    
    // Heap 에 생성되는 인스턴스 필드(변수)는 자동으로 초기화된다
    //  reference = null
    // byte, short, int, long = 0
    // char = '\u0000' = 0;
    // float, double = 0.0 = 0
    // blooean = false = 0
    
    // 인스턴스 필드(변수)는 생성 즉시 0으로 초기화 된다
    Score s = new Score();
    System.out.println(s.name); // 출력 null
    System.out.println(s.kor);  // 출력 0
    
  }//main end

}//class end
