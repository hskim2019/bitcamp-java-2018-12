// primitive data type의 값을 출력하기

package ch22.c;

import java.io.FileOutputStream;

public class Test03_1 {
  public static void main(String[] args) {
    

    try( FileOutputStream out= new FileOutputStream("data.bin")) {
      
      int value = 0x22334455;        
      
      // 위의 4바이트 value값을 출력하시오
      out.write(value >> 24);  //22출력
      out.write(value >> 16); // 33출력 
      out.write(value >> 8);  // 44출력
      out.write(value);   // 55출력
      }
      
      
     catch (Exception e) {  
      e.printStackTrace();
    } 
    
    
    
    System.out.println("출력 완료!");
  }
}
