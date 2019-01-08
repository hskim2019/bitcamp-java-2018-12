package bitcamp.lms;

import java.sql.Date;

public class App3 {

  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    final int LENGTH = 10;
    
    int[] no = new int[LENGTH];
    String[] info = new String[LENGTH];
        
    int i = 0;
    while(i < LENGTH) {
    System.out.print("번호: ");
    no[i] = Integer.parseInt(keyboard.nextLine());
            
    System.out.print("내용: ");
    info[i] = keyboard.nextLine();
    
    System.out.println();
    
    i++;
       
    System.out.println("계속 입력하시겠습니까? [Y/n]");
    String str = keyboard.nextLine();
    if(!str.equalsIgnoreCase("Y") && !str.equalsIgnoreCase(""))
    break;
    }
    
    Date creatDate = new Date(System.currentTimeMillis());
        
    int countView = 0;
    
//    keyboard.close();
    System.out.println();
    
//    System.out.printf("번호: %s\n", no);
//    System.out.printf("내용: %s\n", info);
//    System.out.println("작성일: " +creatDate);
//    System.out.println("조회수: " +countView);
    
    for(int a = 0; a < i; a++) {
    System.out.printf("%d,%s,\t", no[a], info[a] );
    System.out.print(creatDate + ",");
    System.out.print(countView);
    System.out.println();
    }
  
  }
}

/*번호: 1
내용: 게시글입니다.
작성일: 2019-01-01
조회수: 0
```
*/