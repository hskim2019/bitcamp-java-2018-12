package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    LessonHandler lessonHandler = new LessonHandler(keyboard);
    MemberHandler memberHandler = new MemberHandler(keyboard);
    BoardHandler boardHandler1 = new BoardHandler(keyboard);
    BoardHandler boardHandler2 = new BoardHandler(keyboard);
    
    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        lessonHandler.addLesson();
        
      } else if (command.equals("/lesson/list")) {
        lessonHandler.listLesson();
      
      } else if (command.equals("/lesson/detail")) { //[1] LessonHandler에 detailLesson()메서드 만들기
        lessonHandler.detailLesson();
      
      } else if (command.equals("/lesson/delete")) { //[2] LessonHandler에 deleteLesson()메서드 만들기
        lessonHandler.deleteLesson();
      
      } else if (command.equals("/lesson/update")) { //[3] LessonHandler에 updateLesson()메서드 만들기
        lessonHandler.updateLesson();
        
      } else if (command.equals("/member/add")) {
        memberHandler.addMember();
        
      } else if (command.equals("/member/list")) {
        memberHandler.listMember();
        
      } else if (command.equals("/member/detail")) {
        memberHandler.detailMember();
        
      } else if (command.equals("/member/delete")) {
        memberHandler.deleteMember();
        
      }else if (command.equals("/member/update")) {
        memberHandler.updateMember();
        
      }else if (command.equals("/board/add")) {
        boardHandler1.addBoard();
        
      } else if (command.equals("/board/list")) {
        boardHandler1.listBoard();
        
      } else if (command.equals("/board2/add")) {
        boardHandler2.addBoard();
        
      } else if (command.equals("/board2/list")) {
        boardHandler2.listBoard();
        
      } else if (command.equals("/board/detail")) {
        boardHandler1.detailBoard();
        
      }else if (command.equals("/board/delete")) {
        boardHandler1.deleteBoard();
        
      } else if (command.equals("/board/update")) {
        boardHandler1.updateBoard();
        
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
