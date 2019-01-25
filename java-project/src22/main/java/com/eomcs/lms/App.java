package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  // 사용자가 입력한 명령을 보관할 스택 준비
  static Stack<String> commandHistory = new Stack<>(); // 입력된 명령어 담을 보관소가 commandHistory, static main()에서도 사용할 수 있게 static변수로 만듦
  static Queue<String> commandHistory2 = new Queue<>();  //[1] 입력된 명령어 담을 보관소가 commandHistory2

  public static void main(String[] args) {

    LessonHandler lessonHandler = new LessonHandler(keyboard);
    MemberHandler memberHandler = new MemberHandler(keyboard);
    BoardHandler boardHandler1 = new BoardHandler(keyboard);
    BoardHandler boardHandler2 = new BoardHandler(keyboard);


    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다
      commandHistory.push(command);
      //[2] 사용자가 입력한 명령을 큐에 보관한다
      commandHistory2.offer(command);
      

      if (command.equals("/lesson/add")) {
        lessonHandler.addLesson();

      } else if (command.equals("/lesson/list")) {
        lessonHandler.listLesson();

      } else if (command.equals("/lesson/detail")) {
        lessonHandler.detailLesson();

      } else if (command.equals("/lesson/update")) {
        lessonHandler.updateLesson();

      } else if (command.equals("/lesson/delete")) {
        lessonHandler.deleteLesson();

      } else if (command.equals("/member/add")) {
        memberHandler.addMember();

      } else if (command.equals("/member/list")) {
        memberHandler.listMember();

      } else if (command.equals("/member/detail")) {
        memberHandler.detailMember();

      } else if (command.equals("/member/update")) {
        memberHandler.updateMember();

      } else if (command.equals("/member/delete")) {
        memberHandler.deleteMember();

      } else if (command.equals("/board/add")) {
        boardHandler1.addBoard();

      } else if (command.equals("/board/list")) {
        boardHandler1.listBoard();

      } else if (command.equals("/board/detail")) {
        boardHandler1.detailBoard();

      } else if (command.equals("/board/update")) {
        boardHandler1.updateBoard();

      } else if (command.equals("/board/delete")) {
        boardHandler1.deleteBoard();

      } else if (command.equals("/board2/add")) {
        boardHandler2.addBoard();

      } else if (command.equals("/board2/list")) {
        boardHandler2.listBoard();

      } else if (command.equals("/board2/detail")) {
        boardHandler2.detailBoard();

      } else if (command.equals("/board2/update")) {
        boardHandler2.updateBoard();

      } else if (command.equals("/board2/delete")) {
        boardHandler2.deleteBoard();

      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.equals("history")) {
        printCommandHistory();   // 메서드 만들어야 함

      }else if (command.equals("history2")) {
        printCommandHistory2();   // [3] 메서드 만들어야 함

      }else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  private static void printCommandHistory() { //temp = String을 보관하고 있는 임시 스택
    try {
      // 명령어가 보관 된 스택에서 명령어를 꺼내기 전에 복제한다 . 그렇지 않으면 pop 하고 나면 사라지므로 원본을 놔두고 복제를 해두기
      Stack<String> temp = commandHistory.clone();
      int count = 0;  //
      while(!temp.empty()) {                  // stack이 비지 않았을 동안
        System.out.println(temp.pop());          // stack에서 꺼내 출력
        if(++count % 5 == 0) {//      5번에 한 번씩 다음 페이지 출력할 지 물어보게 설정
          System.out.println(":"); //
          String input = keyboard.nextLine(); //
          if(input.equalsIgnoreCase("q")) //
            break; //
        }
      } 
    }catch (CloneNotSupportedException e) {
      e.printStackTrace();
    } 
  }
  
  //[4]
  private static void printCommandHistory2() { //temp = String을 보관하고 있는 임시 스택
    try {
      // 명령어가 보관 된 스택에서 명령어를 꺼내기 전에 복제한다 . 그렇지 않으면 pop 하고 나면 사라지므로 원본을 놔두고 복제를 해두기
      Queue/* 리터타입변경*/ <String> temp = commandHistory2.clone(); //[5]queue도  클론하러 가기 [8] queue클론 다시하러가기 //[7] commandHistory2 선언을 왜 main밖에서 해야 하는지?
      int count = 0;  //
      while(!temp.empty()) {                  // stack이 비지 않았을 동안
        System.out.println(temp.poll());          // Queue에서 꺼내 출력
        if(++count % 5 == 0) {//      5번에 한 번씩 다음 페이지 출력할 지 물어보게 설정
          System.out.println(":"); //
          String input = keyboard.nextLine(); //
          if(input.equalsIgnoreCase("q")) //
            break; //
        }
      } 
    }catch (CloneNotSupportedException e) {
      e.printStackTrace();
    } 
  }
  


  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
