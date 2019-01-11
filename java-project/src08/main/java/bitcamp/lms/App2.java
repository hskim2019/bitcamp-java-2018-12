package bitcamp.lms;

import java.sql.Date;

public class App2 {

  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    final int length = 10;
    Board[] app2 = new Board[length];
    
    int i = 0;
    while(i < length) {

      Board main = new Board();
      
    System.out.print("번호? ");
    
    main.no = Integer.parseInt(keyboard.nextLine());
    
    System.out.print("이름? ");
    main.name = keyboard.nextLine();
    
    System.out.print("이메일? ");
    main.email = keyboard.nextLine();
    
    System.out.print("암호? ");
    main.pw = Integer.parseInt(keyboard.nextLine());
        
    System.out.print("사진이름? ");
    main.picName = keyboard.nextLine();
    
    System.out.print("전화? ");
    main.phoneNumber = keyboard.nextLine();
    
    System.out.print("가입일? ");
    main.date = Date.valueOf(keyboard.nextLine());
    
    app2[i] = main;
    i++;
    
    System.out.print("\n계속 입력하시겠습니까?(Y/n)");
    String str = keyboard.nextLine();
    System.out.println();
    if(!str.equalsIgnoreCase("y") && !str.equalsIgnoreCase(""))
      break;
        }
    
    keyboard.close();
    
    for(int a = 0; a < i; a++) {
      System.out.printf("%d, %s, %s\t, %s\t, %s\n", 
          app2[a].no, app2[a].name, app2[a].email, app2[a].phoneNumber, app2[a].date);
      }
  }
}

