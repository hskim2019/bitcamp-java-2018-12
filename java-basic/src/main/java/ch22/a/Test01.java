// java.io.File 클래스 - 폴더 다루기 
package ch22.a;

import java.io.File;
import java.io.IOException;

public class Test01 {

  public static void main(String[] args) throws IOException {
    // File 클래스
    // => 디렉토리나 파일을 다룰 때 사용하는 클래스
    // => 디렉토리나 파일을 생성, 삭제, 변경할 수 있다
    
    // 현재 디렉토리를 조회
    // => '.' 으로 표현
    // => 이클립스 : 프로젝트 디렉토리를 가리킨다
    // => 콘솔 : 현재 명령어를 실행하는 위치를 가리킨다
    
    
    File dir = new File("../../teacher/java-basic");   // .. 현재 폴더의 상위 폴더로 가라
    System.out.println(dir.getName()); // 폴더명
    System.out.println(dir.getPath()); // 파일 경로
    System.out.println(dir.getAbsolutePath()); // 절대 경로
    System.out.println(dir.getCanonicalPath()); // 계산된 경로
    
    
    // 디렉토리가 존재하지 않는 경우 크기가 0
    System.out.println(dir.getTotalSpace()); // HDD 용량
    System.out.println(dir.getFreeSpace()); // 빈 용량
    System.out.println(dir.getUsableSpace()); // 빈 용량 중에서 사용할 수 용량
    
    // 
    System.out.println(dir.isDirectory()); // 이것이 directory인지 확인
    System.out.println(dir.isFile());
    System.out.println(dir.isHidden()); // 숨김파일인지 확인
    System.out.println(dir.exists());
    System.out.println(dir.canExecute());

    System.out.println("==============================================");
    dir = new File(".");   // .. 현재 폴더의 상위 폴더로 가라
    System.out.println(dir.getName()); // 폴더명
    System.out.println(dir.getPath()); // 파일 경로
    System.out.println(dir.getAbsolutePath()); // 절대 경로
    System.out.println(dir.getCanonicalPath()); // 계산된 경로
    
    // 디렉토리가 존재하지 않는 경우 크기가 0
    System.out.println(dir.getTotalSpace()); // HDD 용량
    System.out.println(dir.getFreeSpace()); // 빈 용량
    System.out.println(dir.getUsableSpace()); // 빈 용량 중에서 사용할 수 용량
    
    // 
    System.out.println(dir.isDirectory()); // 이것이 directory인지 확인
    System.out.println(dir.isFile());
    System.out.println(dir.isHidden()); // 숨김파일인지 확인
    System.out.println(dir.exists());
    System.out.println(dir.canExecute());
  }

}
