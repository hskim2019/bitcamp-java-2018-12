// java.io.File 클래스 - 파일 삭제
package ch22.a;

import java.io.File;
import java.io.IOException;

public class Test06 {

  public static void main(String[] args) throws IOException {
    
    // 파일을 삭제함
    File file = new File("temp2/test.txt");
    if (file.delete()) {                    
      System.out.println("파일이 삭제함");
    } else {
      System.out.println("파일을 삭제하지 못함");
    }
   
  }

}
