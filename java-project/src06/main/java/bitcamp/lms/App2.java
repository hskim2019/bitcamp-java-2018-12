package bitcamp.lms;

import java.sql.Date;

public class App2 {

  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    final int LENGTH = 10;
    
    int[] no = new int[LENGTH];
    String[] name = new String[LENGTH];
    String[] email = new String[LENGTH];
    int[] pw = new int[LENGTH];
    String[] picName = new String[LENGTH];
    String[] phoneNumber = new String[LENGTH];
    Date[] date = new Date[LENGTH];
    
    int i = 0;
    while(i < LENGTH) {
      
    System.out.print("번호? ");
    no[i] = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("이름? ");
    name[i] = keyboard.nextLine();
    
    System.out.print("이메일? ");
    email[i] = keyboard.nextLine();
    
    System.out.print("암호? ");
    pw[i] = Integer.parseInt(keyboard.nextLine());
        
    System.out.print("사진이름? ");
    picName[i] = keyboard.nextLine();
    
    System.out.print("전화? ");
    phoneNumber[i] = keyboard.nextLine();
    
    System.out.print("가입일? ");
    date[i] = Date.valueOf(keyboard.nextLine());
    
    System.out.println();
    
    i++;
    
    System.out.print("\n계속 입력하시겠습니까?(Y/n)");
    String str = keyboard.nextLine();
    System.out.println();
    if(!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase(""))
      break;
        }
    
    keyboard.close();
    
    for(int a = 0; a < i; a++) {
      System.out.printf("%d, %s, %s\t, %s\t, %s\n", no[a], name[a], email[a], phoneNumber[a], date[a]);
      }
  }
}

/*
번호: 1
이름: 홍길동
이메일: hong@test.com
암호: 1111
사진: hong.png
전화: 1111-2222
가입일: 2019-01-01
*/