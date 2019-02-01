// 버퍼 사용 후
package ch22.c;

import java.io.FileOutputStream;

public class Test02_2 {
  public static void main(String[] args) {
    FileOutputStream out = null;
    try {
      out = new FileOutputStream("data.bin");
      
      System.out.println("데이터 쓰는 중...");
      
      long start = System.currentTimeMillis();
      
      byte[] buf = new byte[1024];
      int size = 0; // local 변수는 자동 초기화 안되므로 0으로 초기화 해주기
      
      for(int i = 0; i < 1000000; i++) {
         
        // 일단 바이트 버퍼에 저장한다
        buf[size++] = 0x55;   // buf[0] ~ buf[1024] 까지 0x55로 값 채워짐
        
        if(size >= 1024) {
          out.write(buf);  // 버퍼가 꽉 차면 파일로 내보낸다
          size = 0;        // 다시 버퍼를 쓸 수 있도록 size를 0으로 초기화
        }
        
                             // 1024단위로 write하고(976) 1000000번 반복되는 동안 buf[0]-buf[575] 가 남았는데 출력 못 함
      }
      
      // 마지막으로 버퍼에 남아있는 바이트를 출력한다
      out.write(buf, 0, size);  //남은 버퍼를 출력(buf[0] ~ buf[575]의 값들, 0 부터 size만큼
      
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
