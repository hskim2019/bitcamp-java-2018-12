package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.handler.BoardHandler;
import bitcamp.lms.handler.LessonHandler;
import bitcamp.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in); // 모든 메서드가 공통으로 사용할 것


  public static void main(String[] args) {
    //LessonHandler의 keyboard 와 App class 의 keyboard가 같은 객체를 가리키게
    LessonHandler.keyboard = keyboard;
    MemberHandler.keyboard = keyboard;
    BoardHandler.keyboard = keyboard;

    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        LessonHandler.addLesson();
      } else if (command.equals("/lesson/list")) {
        LessonHandler.listLesson();
      }

      else if (command.equals("/member/add")) {
        MemberHandler.addMember();

      } else if (command.equals("/member/list")) {
        MemberHandler.listMember();

      } else if (command.equals("/board/add")) {
        BoardHandler.addBoard();

      } else if (command.equals("/board/list")) {
        BoardHandler.listBoard();

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
    String command = keyboard.nextLine().toLowerCase();
    return command;
  }



}
