package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.ArrayList;
import com.eomcs.util.Iterator;
import com.eomcs.util.LinkedList;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  // 사용자가 입력한 명령을 보관할 스택 준비
  static Stack<String> commandHistory = new Stack<>(); // 입력된 명령어 담을 보관소가 commandHistory, static main()에서도 사용할 수 있게 static변수로 만듦
  static Queue<String> commandHistory2 = new Queue<>();  //[1] 입력된 명령어 담을 보관소가 commandHistory2

  public static void main(String[] args) {
   // ArrayList<Lesson> lessonList = new ArrayList<>(); <= 이렇게 객체 생성 할 필요 없이 바로 아래와 같이
    
    // 핸들러가 필요로 하는 의존 객체를 이 클래스에서 만들어 주입해준다
    // => "의존 객체 주입(Dependency Injection; DI)" 이라 한다
    LessonHandler lessonHandler = new LessonHandler(keyboard, new ArrayList<>());
    MemberHandler memberHandler = new MemberHandler(keyboard, new ArrayList<>());
    BoardHandler boardHandler1 = new BoardHandler(keyboard, new LinkedList<>());
    BoardHandler boardHandler2 = new BoardHandler(keyboard, new LinkedList<>());


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

  private static void printCommandHistory() { 
    Iterator<String> iterator = commandHistory.iterator();
    int count = 0;
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
      if(++count % 5 == 0) {
        System.out.print(":");
        String input = keyboard.nextLine();
        if(input.equalsIgnoreCase("q"))
          break;
      }
    }
    System.out.println();
  }
  
  private static void printCommandHistory2() { 
    Iterator<String> iterator = commandHistory2.iterator();
    int count = 0;
    while(iterator.hasNext()) { // 꺼낼 값이 있으면
      System.out.println(iterator.next());
      if(++count % 5 == 0) {
        System.out.print(":");
        String input = keyboard.nextLine();
        if(input.equalsIgnoreCase("q"))
          break;
      }
    }
    System.out.println();
  }
  


  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
