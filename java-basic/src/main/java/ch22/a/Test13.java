// java.io.File 클래스 - 연습 과제 - bin 폴더를 삭제하라
package ch22.a;

import java.io.File;
import java.io.IOException;

public class Test13 {

  public static void main(String[] args) throws Exception {

   
    File dir = new File("bin");
    
    // 하위 파일 지우기
    // => bin의  하위폴더 : test, main, ch01  
    delete(dir);
    
    System.out.println("삭제 완료");
    
  }
  static void delete(File dir) {
    
    // 파일의 하위 디렉토리와 파일 목록 얻기
    // 파일 목록에서 파일을 하나 꺼낸다
    // 만약 파일이면 삭제
    // 디렉토리면 delete() 호출하여 삭제
    File[] files = dir.listFiles();
    for(File file : files) {
      if(file.isFile()) {
        file.delete();
      } else {
        delete(file);
      }
    }
    dir.delete();
    
  }

}
