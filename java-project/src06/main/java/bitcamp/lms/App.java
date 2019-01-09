/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {

    Scanner keyboard = new Scanner(System.in);
    
    final int length = 10;
    
    int[] no = new int[length] ;
    String[] title = new String[length];
    String[] info = new String[length]; 
    Date[] startDate = new Date[length];
    Date[] endDate = new Date[length];
    int[] totalHour = new int[length];
    int[] dayHour = new int[length];
    
    int index = 0;
    while(index < 10) {
    System.out.print("번호? ");
    no[index] = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("수업명? ");
    title[index] = keyboard.nextLine();
    
    System.out.print("설명? ");
    info[index] = keyboard.nextLine();
    
    System.out.print("시작일? ");
    startDate[index] = Date.valueOf(keyboard.nextLine());
    
    System.out.print("종료일? ");
    endDate[index] = Date.valueOf(keyboard.nextLine());
    
    System.out.print("총수업시간? ");
    totalHour[index] = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("일수업시간? ");
    dayHour[index] = Integer.parseInt(keyboard.nextLine());
  
    index++;
    
    System.out.print("\n계속 하시겠습니까?(Y/n)");
    String str = keyboard.nextLine();
    System.out.println();
    if (!str.equalsIgnoreCase("Y") && !str.equals("")) 
      break;
    }
    
    keyboard.close();
    
    int count = 0;
    while(count < index) {
    System.out.printf("%d, %-20s, %s ~ %s, %4d\n", no[count], title[count], startDate[count], endDate[count], totalHour[count]);
     count++;
    }
    
  }
}