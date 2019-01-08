package bitcamp.lms;

import java.sql.Date;

public class App2 {

  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    System.out.print("번호: ");
    int no = keyboard.nextInt();
    
    keyboard.nextLine();
    
    System.out.print("이름: ");
    String name = keyboard.nextLine();
    
    System.out.print("이메일: ");
    String email = keyboard.nextLine();
    
    System.out.print("암호: ");
    int pw = keyboard.nextInt();
    
    keyboard.nextLine();
    
    System.out.print("사진이름: ");
    String picName = keyboard.nextLine();
    
    System.out.print("전화: ");
    String phoneNumber = keyboard.nextLine();
    
    System.out.print("가입일: year-month-date");
    Date date = Date.valueOf(keyboard.nextLine());
    
    keyboard.close();
    System.out.println();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %d\n", pw);
    System.out.printf("사진이름: %s.png\n", picName);
    System.out.printf("전화: %s\n", phoneNumber);
    System.out.printf("가입일: %s\n", date);
    
    
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