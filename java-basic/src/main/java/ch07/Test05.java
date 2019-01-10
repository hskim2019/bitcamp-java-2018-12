// 레퍼런스와 인스턴스의 관계 .
package ch07;

public class Test05 {

  static class Score { 
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  } // Score end

  public static void main(String[] args) {

    Score s1 = new Score(); //new가 붙으면 인스턴스는 stack 이 아닌 heap 메모리에 만들어짐
                            // s1 메모리 주소 담긴 것은 stack에, s1에 담긴 메모리는 heap에 저장 됨

    s1.name = "홍길동";
    s1.kor = 100; 
    s1.eng = 100;
    s1.math = 100;

    Score s2 = s1; // s1에 저장 된 인스턴스 주소를 s2에 복사
    System.out.println(s2.name);
    s1.name = "임꺽정";
    System.out.println(s2.name);
    
    Score s3 = creatScore("유관순", 90, 90, 90);
    System.out.println(s3.name);
    System.out.println(s3.kor);
  }//main end

  // Score 인스턴스를 생성한 후 그 주소를 리턴
  static Score creatScore(String n, int kor, int eng, int math) {
    Score s = new Score();
    s.name = n; // Score 클래스와 같이 메모리를 만들고 name에 가서 파라미터에 입력 된 n값을 name에 넣는다는 의미
    s.kor = kor;
    s.eng = eng;
    s.math = math;
    s.sum = kor + eng + math;
    s.aver = s.sum / 3f;
    
    return s; //s에 저장된 instance의 주소를 리턴
    
  }

}//class end
