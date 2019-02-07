// Serialize -  serialVersion UID 스테틱 필드 사용하기
package ch22.f;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test3_2 {
  public static void main(String[] args) {

    // deserialize
    // => Score3 클래스를 변경하지 않고 읽어 본다
    //    정상적으로 읽을 수 있을 것이다
    // => Score3에 tel 필드와 getter/setter를 추가하고
    //    toString()을 다시 생성한 후 
    //    읽어보자
    //    단 serialVersionUID 값은 그대로 100이 되게 하라

    try(ObjectInputStream in = new ObjectInputStream(
        new FileInputStream("score3.data"))) {

      Score3 score = (Score3) in.readObject();
      System.out.println(score);
      System.out.printf("%s, %d", score.getName(), score.getSum());
      
      // Score3 클래스를 바꾼 후에도 기존에 serialize 된 데이터를
      // 그대로 읽을 수 있다
      // 왜? serialVersionUID가 같기 때문이다
      // 이런 이유로 개발자가 serialVersionUID 변수의 값을 설정하는 것이다
      // 물론 기존 클래스와 비교해 완전히 바뀌어서
      // 기존에 serialize 된 값을 정상적으로 읽을 수 없을 경우에는
      // serialVersionUID 값을 같게 하는 것은 좋지 않다
      
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
