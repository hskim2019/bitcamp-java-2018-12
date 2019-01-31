// java.io.File 클래스 - 파일 생성
package ch22.a;

import java.io.File;
import java.io.IOException;

public class Test05 {

  public static void main(String[] args) throws IOException {
    
    // 이미 파일이 존재하면 생성 못 함
    File file = new File("temp2/test.txt");
    if (file.createNewFile()) {                    
      System.out.println("파일이 생성됨");
    } else {
      System.out.println("파일을 생성하지 못함");
    }
   
    // 디렉토리가 존재하지 않아도 파일을 생성하지 못함
    // => 디렉토리가 자동으로 생성되지 않는다. ex) temp3라는 디렉토리(폴더) 없으면 파일 생성 못 함
    // => 예외 발생
    file = new File("temp3/test.txt");
    if (file.createNewFile()) {                    
      System.out.println("파일이 생성됨");
    } else {
      System.out.println("파일을 생성하지 못함");
    }
  }

}
