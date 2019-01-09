package bitcamp.lms;

import java.sql.Date;

public class App3 {

  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    final int LENGTH = 10;
    
    int[] no = new int[LENGTH];
    String[] info = new String[LENGTH];
    Date[] creatDate = new Date[LENGTH];
    int[] countView = new int[LENGTH];
        
    int i = 0;
    while(i < LENGTH) {
    System.out.print("번호: ");
    no[i] = Integer.parseInt(keyboard.nextLine());
            
    System.out.print("내용: ");
    info[i] = keyboard.nextLine();
    
    creatDate[i] = new Date(System.currentTimeMillis());
    countView[i] = 0;
    
    i++;
       
    System.out.print("\n계속 입력하시겠습니까?(Y/n) ");
    String str = keyboard.nextLine();
    System.out.println();
    if(!str.equalsIgnoreCase("Y") && !str.equalsIgnoreCase(""))
    break;
    }
    
    keyboard.close();

    for(int a = 0; a < i; a++) {
    System.out.printf("%d,%s,\t, %s, %d", no[a], info[a], creatDate[a], countView[a] );
    System.out.println();
    }
  
  }
}
