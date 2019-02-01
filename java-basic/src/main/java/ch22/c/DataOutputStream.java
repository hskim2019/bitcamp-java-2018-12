package ch22.c;

import java.io.IOException;
import java.io.OutputStream;


// primitive type의 데이터를 출력하는 플러그인 객체
// => OutputStream의 데코레이터이다
public class DataOutputStream extends OutputStream{

  OutputStream out;

  public DataOutputStream(OutputStream out) {
    this.out =  out; 
  }

  @Override
  public void write(int b) throws IOException {
    out.write(b);
  }

  public void wrtieShort(short value) throws IOException {
    out.write(value >> 8);
    out.write(value);
  }


  public void writeInt(int value) throws IOException {
    out.write(value >> 24);  
    out.write(value >> 16); 
    out.write(value >> 8);  
    out.write(value); 
  }

  public void writeUTF(String value) throws IOException {
    // 문자열을 바이트 배열로 출력하는 형식
    // => 바이트수를 2바이트로 출력 : 바이트수(2byte) + 문자열바이트
    byte[] bytes = value.getBytes("UTF-8");    //입력 받은 문자열(String value)을 UTF-8 형식 byte배열로 바꾼다
    out.write(bytes.length >> 8);
    out.write(bytes.length);
    out.write(bytes);

  }
  @Override
  public void flush() throws IOException {
    out.flush();
  }
}
