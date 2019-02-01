// 버퍼 사용 전
package ch22.c;

import java.io.FileOutputStream;

public class Test02_1 {
  public static void main(String[] args) {
    FileOutputStream out = null;
    try {
      out = new FileOutputStream("data.bin");
      
      System.out.println("데이터 쓰는 중...");
      
      long start = System.currentTimeMillis();
      
      for(int i = 0; i < 1000000; i++) {
        out.write(0x55);
      }
      
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      
     out.close();
      
    } catch (Exception e) {   //write하다 예외가 발생하면 catch로 오는데 out.close가 try안에 있으면 닫히지 않음 , finally에도 out.close()넣어줌
      e.printStackTrace();
    } finally {
      try {   out.close(); } catch (Exception e) { }
      }
    
    
    
    System.out.println("출력 완료!");
  }
}
