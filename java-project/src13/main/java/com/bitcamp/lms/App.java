package com.bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;
import com.bitcamp.lms.handler.BoardHandler;
import com.bitcamp.lms.handler.LessonHandler;
import com.bitcamp.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    LessonHandler lesson = new LessonHandler();
    lesson.keyboard = keyboard; //해당부분 생략해도 경고가 뜨지 않음, 해당 부분을 반드시 넣게 하려면 생성자 필요
    MemberHandler member = new MemberHandler();
    member.keyboard = keyboard;
    BoardHandler board1 = new BoardHandler();
    board1.keyboard = keyboard;
    BoardHandler board2 = new BoardHandler();
    board2.keyboard = keyboard;

    
    
    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        lesson.addLesson();
      } 
      else if (command.equals("/lesson/list")) {
        lesson.listLesson();
      } 
      else if (command.equals("/member/add")) {
        member.addMember();
      } 
      else if (command.equals("/member/list")) {
        member.listMember();
      } 
      else if (command.equals("/board/add")) {
        board1.addBoard();
      } 
      else if (command.equals("/board/list")) {
        board1.listBoard();
      } 
      else if (command.equals("/board2/add")) {
        board2.addBoard();
      }
      else if (command.equals("/board2/list")) {
        board2.listBoard();
      }
      else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
      } 
      else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      System.out.println(); // 결과 출력 후 빈 줄 출력
    }
    keyboard.close();
  }

  public static String prompt() {
    System.out.print("명령> ");
    String command = keyboard.nextLine().toLowerCase();
    return command;
  }

  


}
