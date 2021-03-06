// 문자 데이터 출력하기
package ch22.d;

import java.io.FileWriter;

public class Test01_1 {

  public static void main(String[] args) {

    // FileWriter
    // => 문자 단위로 데이터를 출력하는 일을 한다

    try (FileWriter out = new FileWriter("data.txt")) {
      out.write('A'); // => 0x41 1바이트 출력
      out.write('B'); // => 0x42 1바이트 출력
      out.write('C'); // => 0x43 1바이트 출력
      out.write('가'); // => 0xEAB080 3바이트 출력
      out.write('각'); // => 0xEAB081 3바이트 출력 
      out.write('간'); // => 0xEAB084 3바이트 출력 

      // character stream 클래스 FileWriter는 문자 데이터를 출력하라 때
      // 자바 내부에서 문자열을 다룰 때 사용하는 UTF-16 코드를
      // OS의 기본 character set 코드로 값을 변환하여 출력한다
      //
      // Linux, macOS 의 기본 character set => UTF-8
      // Windows의 기본 character set => MS949
      
      // 따라서 같은 프로그램을 어느 OS에서 실행하느냐에 따라
      // 출력되는 코드값이 달라진다
      
      // OS에 상관없이 동일한 character set으로 출력하고 싶다면
      // JVM을 실행할 때 file.encoding 프로퍼티의 값을 character set 이름을 지정하라
      //    예) java -Dfile.encoding=UTF-8 클래스명
      // 단, character set을 지정할 때는 해당 OS에서 사용가능한 문자표이어야 한다
      // MS Windows에서는 MS949 문자표를 사용할 수 있지만
      // 리눅스나 macOS에서는 ms949 문자표를 사용할 수 없다
      // 왜? 국제 표준이 아니기 때문이다
      // 결론!
      // => 무슨 OS를 사용하든지 출력할 때는 가능한 국제 표준인 UTF-8을 사용하라 

    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("출력 완료!");
  }

}
