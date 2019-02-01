// 버퍼 사용 후 - 버퍼 기능을 대신 수행해주는 BufferedOutputStream 사용하기
package ch22.c;

import java.io.FileOutputStream;

public class Test02_3 {
  public static void main(String[] args) {
    
    try(FileOutputStream out = new FileOutputStream("data.bin");  BufferedOutputStream out2 = new BufferedOutputStream(out)) {
      
      System.out.println("데이터 쓰는 중...");
      
      long start = System.currentTimeMillis();
      
      for(int i = 0; i < 1000000; i++) {
        out2.write(0x55);
      }
      out2.flush();
      
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      
    } catch (Exception e) {   //write하다 예외가 발생하면 catch로 오는데 out.close가 try안에 있으면 닫히지 않음 , finally에도 out.close()넣어줌
      e.printStackTrace();
    } 
    
    
    
    System.out.println("출력 완료!");
  }
}
