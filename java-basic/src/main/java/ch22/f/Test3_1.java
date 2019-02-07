// Serialize -  serialVersion UID 스테틱 필드 사용하기
// 어떤 버전을 읽어들일 것인가 version의 개념
package ch22.f;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test3_1 {

 public static void main(String[] args) {
  
  try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("score3.data"))) {
    
    // 인스턴스 출력하기
    
    // Score3 클래스는 java.io.Serializable을 구현하였다
    // serialVersionUID의 값을 100으로 설정하였다
    
    out.writeObject(new Score3("홍길동", 100, 100, 100));
    out.flush();
    System.out.println("출력 완료");
    
  } catch (Exception e) {
    e.printStackTrace();
  }
 }
}
