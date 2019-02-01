// 버퍼 사용 - 버퍼를 적용하여 데이터 읽기를 대신 처리해주는 도우미 클래스 사용
// data seek time(버퍼를 사용하면 data seek time줄일 수 있음), data transfertime(전송시간은 얼마 안 걸림)
package ch22.c;

import java.io.FileInputStream;

public class Test01_3 {
  public static void main(String[] args) {
    
    try {
      FileInputStream in = new FileInputStream("jls11.pdf"); //실제 파일을 읽는 클래스
      BufferedInputStream in2 = new BufferedInputStream(in);  // 데코레이터 클래스, 추가기능
      
      System.out.println("데이터 읽는 중...");
      
      long start = System.currentTimeMillis();
      
      int b;
      int count = 0;
      while ((b = in2.read()) != -1) {
        count++;
      }
      
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      System.out.println(count);
      
      in.close();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
    
    System.out.println("출력 완료!");
  }
}
