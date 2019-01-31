// java.io.File 클래스 - 연습 과제 - bin/main 폴더를 뒤져서 모든 클래스 파일의 이름을 출력하라
package ch22.a;

import java.io.File;
import java.io.FileFilter;

public class Test14 {
  
  static class ClassFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
      if(pathname.isDirectory() || pathname.isFile() && pathname.getName().endsWith(".class"))
        return true;
      else
        return false;
    }
  }


  public static void main(String[] args) throws Exception {
    // 클래스 이름을 출력할 때 패키지 이름을 포함해야 한다
    // 예) ch01.Test01
    // 예) ch22.a.Test14

    File dir = new File("bin/main");
    findClass(dir, "");
    
    //test
//    dir = new File("bin/main/ch04");
//    File[] files = dir.listFiles();
//    for(File file : files) {
//      System.out.printf("%s\n", file.getName());
//    }
    

  }

  private static void findClass(File dir, String a) {
    File[] files = dir.listFiles(new ClassFileFilter());   // 디렉토리 & .class파일
    
    for(File file : files) {
      if (file.isFile()) {
        System.out.printf("%s %s\n", a, file.getName().replace(".class", ""));
      } else { 
        findClass(file, a + file.getName() + ".");
        // findClass(ch01, ""+ch01.)  String a = ch01.
        //    ch01.Test01 출력
        // 만약 ch01.a 폴더가 있으면
        // findClass(ch01-a, ch01. + a.) String a = ch01.a.
        // ch01.a.Test01 출력
      }
    }
  }


}
