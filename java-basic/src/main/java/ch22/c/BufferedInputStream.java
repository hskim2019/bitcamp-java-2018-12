package ch22.c;

import java.io.IOException;
import java.io.InputStream;

//InputStream에 기능을 덧붙이는 플러그인 역할을 수행하는 클래스이다.
//=> 이런 클래스를 데코레이터(decorator)라 한다.
//=> 데코레이터는 기능을 덧붙이는 대상 클래스와 같은 조상을 가져야 한다.
// 그리고 생성자에게 대상 객체 주소를 받아야 한다.
// 작업을 수행할 때 대상 객체를 사용한다.
// 그리고 자신만의 기능을 덧붙인다.
public class BufferedInputStream  extends InputStream {
  InputStream in;
  byte[] buf = new byte[1024];
  int size=0; //배열사이즈?
  int cursor=0; // 버퍼를 가리키는 커서, 0번 인덱스부터 이동하면서 buf[cursor] 값 리턴할 때 사용
  
  public BufferedInputStream(InputStream in) {
    this.in = in;
  }
  
  //데이터 읽을 메서드
  public int read() throws IOException { //호출 한 쪽에서 오류를 알 수 있도록 예외처리 던져주기, 이 메서드는 데이터만 읽음
    if(cursor >= size) {
      size = in.read(buf); // 얼마만큼 읽었는지를 알아야
      if(size == -1)  // 더 이상 읽을 것 없으면
        return -1;
      cursor = 0;   // 새로 읽었으면 커서는 다시 0부터
    }
    
    // 바이트의 값을 온전히 4byte int값으로 변환하기 위해
    // 0x000000ff 값을 & 비트연산한다, 둘 다 1일 때만 1, 아니면 0, 앞에 3byte 자리를 0으로 채워 줌
    // => 0xff 상수 값은 0x000000ff 를 의미한다.
    return buf[cursor++] & 0xff; // buf에 데이터가 들어있다면, 커서가 가리키는 값을 리턴해줌, 데이터가 있는지를 알아야 하므로 유효성 검사 -> if문
    
  }


}
