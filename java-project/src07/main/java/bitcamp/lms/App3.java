package bitcamp.lms;

import java.sql.Date;

public class App3 {

  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    final int length = 10;
    Member[] app3 = new Member[length];
        
    int i = 0;
    while(i < length) {
      
      Member main = new Member();
      
    System.out.print("번호: ");
    main.no = Integer.parseInt(keyboard.nextLine());
            
    System.out.print("내용: ");
    main.info = keyboard.nextLine();
    
    main.creatDate = new Date(System.currentTimeMillis());
    main.countView = 0;
    
    app3[i] = main;
    i++;
       
    System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
    String str = keyboard.nextLine();
    System.out.println();
    if(!str.equalsIgnoreCase("Y") && !str.equalsIgnoreCase(""))
    break;
    }
    
    keyboard.close();

    for(int a = 0; a < i; a++) {
    System.out.printf("%d,%-10s, %s, %4d\n", app3[a].no, app3[a].info, app3[a].creatDate, app3[a].countView);
    }
  
  }
}
