// 인스턴스와 가비지 컬렉터, 레퍼런스 카운트
package ch07;

public class Test06 {

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
    Score s2 = new Score();
    
    s2 = s1; // s2에 저장되었던 주소는 s1에 저장된 주소로 변경되어 
             // 원래 s2가 가리키던 인스턴스는 주소를 잃어버려 사용할 수 없게 됨
             // 이렇게 주소를 잃어버린 인스턴스는 가비지
             // 가비지 컬렉터에 의해 제거 될 수 있다

    s1 = new Score();
    
  }//main end

}//class end

// 가비지 컬렉터는 힙 메모리에 존재하는 가비지를 찾아 제거하는 일을 한다
// 레퍼런스 카운트(reference count)
//    - JVM은 인스턴스 주소를 몇 개의 레퍼런스가 가지고 있는지 따로 관리한다
//    - 레퍼런스가 인스턴스 주소를 가지거나, 가지지 않을 때 마다 카운트 증감
//    - 레퍼런스 카운터가 '0' = 가비지
