package bitcamp.lms;

import java.sql.Date;

public class App3 {

  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    System.out.print("번호: ");
    int no = Integer.parseInt(keyboard.nextLine());
    // Integer (도구함:Class) parseInt(Integer 안의 기능:method)
        
    System.out.print("내용: ");
    String info = keyboard.nextLine();
    
    Date creatDate = new Date(System.currentTimeMillis());
        
    int countView = 0;
    
    keyboard.close();
    System.out.println();
    
    System.out.printf("번호: %s\n", no);
    System.out.printf("내용: %s\n", info);
    System.out.println("작성일: " +creatDate);
    System.out.println("조회수: " +countView);
    
  
  }
}

/*번호: 1
내용: 게시글입니다.
작성일: 2019-01-01
조회수: 0
```
*/