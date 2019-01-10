// 인스턴스 배열
package ch07;

public class Test08 {
  static class Score { 

    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  } // Score end 
  
  public static void main(String[] args) {
    
    // 낱개 변수 선언
    int v1, v2, v3;
    
    // int 배열 선언
    int[] values = new int[3];
    // values : 배열의 주소를 담는 변수
//    System.out.println(v1);
    System.out.println("1:" + values[0]);
    
    // s1은 레퍼런스 주소
    Score s1, s2, s3;
    
    // Score 변수를 3개 만드는 배열 선언
    // => Score 변수란 Score 인스턴스 주소를 담는 레퍼런스
    Score[] scores = new Score[3];
    // scores : 배열의 주소를 저장하는 레퍼런스
    // new Score[3] : Score 인스턴스를 3개 생성
    // 인스턴스 배열을 만들 수는 없음
//    System.out.println(scores[0].name); // 실행오류 runtime exception 발생
    System.out.println(scores[0]); // heap에 scores라는 메모리 공간만 생겼고, 그 안에 name, kor 등은 안 만들어짐
    
    // 배열 레퍼런스에 인스턴스 주소를 넣은 다음에 사용하라
    scores[0] = new Score();
    scores[1] = new Score();
    scores[2] = new Score();
    
    System.out.println(scores[0].name);
    System.out.println(scores[0].kor);
    
  }//main end

}//class end

// 인스턴스 배열을 만들 수 없다
// 레퍼런스 배열만 가능하다
// 자바기본타입은 해당 타입의 메모리를 배열로 만들 수 있다
// 그 외 모든 타입은 오직 레퍼런스 배열만 생성한다
