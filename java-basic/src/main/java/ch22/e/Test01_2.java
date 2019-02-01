// 인스턴스 읽기
package ch22.e;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test01_2 {
  public static void main(String[] args) {

    // Score.data 파일에서 세 학생의 데이터를 읽어 Score 인스턴스로 생성하라
    // => java.io.BufferedOutputStream 클래스를 사용하라
    // => java.io.DataOutputStream 클래스를 사용하라 
    Score s1 = null;
    Score s2 = null;
    Score s3 = null;

    // 그리고 세 학생의 정보를 다음과 같은 형식으로 출력하라
    // => 홍길동, 100, 100, 100, 300, 100

    try(FileInputStream in = new FileInputStream("score.data");
        BufferedInputStream in1 = new BufferedInputStream(in);
        DataInputStream in2 = new DataInputStream(in1)) {

      String name = in2.readUTF(); 
      int kor = in2.readInt();
      int eng = in2.readInt();
      int math = in2.readInt();
      int sum = in2.readInt();
      float aver = in2.readFloat();
      
      System.out.printf("%s, %d, %d, %d, %d, %.2f", name, kor, eng, math, sum, aver);

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (Exception e1) {
      e1.printStackTrace();
    }

  }
}
