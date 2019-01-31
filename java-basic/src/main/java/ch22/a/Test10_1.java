// java.io.File 클래스 - 필터 사용하기 (스테틱 중첩 클래스 사용
package ch22.a;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Test10_1 {
  
  // FilenameFilter는 interface 
  // static nested class 
  static class TextFileFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
            if(name.endsWith(".txt"))
        return true;
      else
        return false;
    }
  }
  
  
  public static void main(String[] args) throws Exception {

    File file = new File(".");

    String[] names = file.list(new TextFileFilter());

    for (String name : names) {
      System.out.println(name);
    }
  }

}
