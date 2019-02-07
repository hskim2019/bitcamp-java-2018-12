// 인스턴스 출력 - ObjectOutputStream 데코레이터 사용하기
package ch22.e;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Test04_2 {
  public static void main(String[] args) {

    // Score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라
    // => java.io.BufferedOutputStream 클래스를 사용하라
    // => java.io.DataOutputStream 클래스를 사용하라 

    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라
    // => 홍길동, 100, 100, 100, 300, 100

    ArrayList<Score> students = new ArrayList<>();

    // ObjectInputStream
    // => DataInputStream의 기능을 포함한다
    // => ObjectOutputStream.writeObject()로 출력한 바이트 배열을 읽어
    //    인스턴스를 생성하는 기능이 있다
    // => 단 클래스가 java.io.Serializable 인터페이스를 구현한 클래스여야 한다.
    //    출력할 때 클래스 버전과 읽을 때의 클래스의 버전이 같아야 한다
    // => 인스턴스 필드를 생성한 후 직접 필드에 값을 저장한다
    //    이 때는 생성자가 호출되지 않는다
    //    따라서 초기화시킬 것이 있다면 따로 메서드를 호출해야 한다
    try(ObjectInputStream in = new ObjectInputStream(
        new BufferedInputStream(
            new FileInputStream("score.data")))) {

      int len = in.readInt(); // 몇 개의 데이터 배열이 들어 있는지

      for(int i = 0; i < len; i++) {
//        Score s = new Score();
//        s.setName(in.readUTF());
//        s.setKor(in.readInt());
//        s.setEng(in.readInt());
//        s.setMath(in.readInt());
        
       // => 1단계 students.add((Score) in.readObject()); 생성자 호출 안되기 때문에 초기화 시킬 것 있으면 따로 메서드 호출해야 
        Score score = (Score) in.readObject();
        // 저장한 인스턴스 필드 값을 그대로 읽을 것이기 때문에
        // sum과 aver필드 값도 그대로 읽을 것이다
        // 따라서 compute를 여기서 따로 호출할 필요가 없다
        //score.compute();  생성자에 compute(); 메서드 호출해 뒀기 때문에 여기서 실행할 필요 없음
        students.add(score);
      }

      for(Score s : students) {
      System.out.printf("%s, %d, %d, %d, %d, %.1f\n", 
          s.getName(), s.getKor(), s.getEng(), s.getMath(), s.getSum(), s.getAver());
      }
      
    }  catch (Exception e) {
      e.printStackTrace();
    }

  }
}
