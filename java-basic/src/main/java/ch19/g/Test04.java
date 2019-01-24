// 파일 필터 클래스를 로컬 클래스로 만든다
package ch19.g;

import java.io.File;
import java.io.FilenameFilter;

public class Test04 {
  

  public static void main(String[] args) {
    // 이 메서드 안에서만 사용할 클래스라면 이렇게 로컬 클래스로 만든다
    class MyFilenameFilter implements FilenameFilter {  //static이 되어야 static main에서 쓸 수 있다
      @Override
      public boolean accept(File dir, String name) {
        
        if(name.endsWith(".txt"))
          return true;
        else
          return false;
      }
    }
    // File 클래스 : 파일이나 디렉토리 정보를 다루는 도구
    File dir = new File("./"); // 이클립스에서 실행하면 ./는 프로젝트 디렉토리를 가리킨다

    // 이전 경우보다 훨씬 중첩 클래스가 가까이 있어 소스 보기가 편하
    String[] names = dir.list(new MyFilenameFilter());
    
    // 문제는 list() 호출하는 코드와 필터 클래스 정의하는 코드 사이에 
    // 많은 다른 코드가 있다면 이전과 마찬가지로 소스 보기가 불편 할 것이다
    
    for (String name : names) {
      System.out.println(name);
    }
  }
}
