// 바이너리 데이터 입출력 - FileInputStream - 배열 단위로 읽기
package ch22.b;

import java.io.FileInputStream;

public class Test02_2 {

  public static void main(String[] args) {

    // 파일의 바이너리 데이터 읽어 배열에 저장한다
    try {
      FileInputStream in = new FileInputStream("data.bin");

      // 데이터를 저장할 바이트 배열을 준비한다
      byte[] buf = new byte[1024];

      // 바이너리 데이터를 읽어 배열에 저장하기
      // read(byte[]) : 
      //          읽은 데이터를 바이트 배열에 채운다. 리턴 값은 읽은 바이트 수 이다
      // read(byte[], 저장할 위치, 저장하기를 희망하는 개수) : 
      //           읽은 데이터를 저장할 위치부터 개수만큼 저장한다. 리턴 값은 실제 읽은 바이트 개수
      int count = in.read(buf); // count는 읽은 개수
       System.out.println(count);      
      
      for(int i = 0; i < count; i++) {
         System.out.print(Integer.toHexString(buf[i]) +".");
      }
      System.out.println();

      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("출력 완료");

  }

}
