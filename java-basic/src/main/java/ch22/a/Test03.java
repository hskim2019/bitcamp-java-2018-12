// java.io.File 클래스 - 디렉토리 생성하기
package ch22.a;

import java.io.File;
import java.io.IOException;

public class Test03 {

  public static void main(String[] args) throws IOException {

    // 생성할 디렉토리 정보를 준비한다
    File dir = new File("temp");
    if (dir.mkdir()) {                    //directory 만들면 true, 한 번 만들고 난 뒤 똑같은 이름으로 못 만들기 때문에 false로 나옴
      System.out.println("디렉토리 생성 됨");
    } else {
      System.out.println("디렉토리 생성 못함");
    }

    // 존재하지 않는 폴더 아래에 새 폴더를 만들 때
    // => 존재하지 않는 폴더가 자동 생성되지 않는다
    // => 따라서 그 하위 폴더를 생성할 수 없다
    dir = new File("temp2/ok");
    if (dir.mkdir()) {                    
      System.out.println("디렉토리 생성 됨");
    } else {
      System.out.println("디렉토리 생성 못함");
    }

    // 존재하지 않는 상위 폴더를 자동으로 생성하는 방법
    // =>  mkdirs()
    dir = new File("temp2/ok");
    if (dir.mkdirs()) {                    
      System.out.println("디렉토리 생성 됨");
    } else {
      System.out.println("디렉토리 생성 못함");
    }

  }
}
