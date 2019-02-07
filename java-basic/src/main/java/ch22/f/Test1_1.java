// Serialize - serializable 에 대한 설명
package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_1 {

 public static void main(String[] args) {
  
  try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("score1.data"))) {
    
    // 인스턴스 출력하기
    
    // writeObject(인스턴스(의 주소))
    // => ###모든 인스턴스 필드를(static 필드 x) 바이트 배열로 만들어 출력###한다
    //    인스턴스 필드의 값을 바이트 배열로 만드는 것을
    //    "직렬화(serialize = marshaling)"라 부른다
    //    반대로 바이트 배열을 가지고 인스턴스를 만드는 것을 
    //    "객체화(deserialize = unmarshaling)"라 부른다
    // => 단 serialize를 허락한 객체에 한해서만 작업 가능하다
    //    (java.io.Serializable 인터페이스의 구현체에 대해서만 작업 가능)
    // => 만약 허락되지 않은 객체에 대해 이 메서드를 호출하면
    //    NotSerializableException 예외가 발생
    out.writeObject(new Score1("홍길동", 100, 100, 100));
    
    // Score1 클래스는 serialize 인터페이스를 구현 안 해서 writeObject() 사용 못 함
    
  } catch (Exception e) {
    e.printStackTrace();
  }
 }
}
