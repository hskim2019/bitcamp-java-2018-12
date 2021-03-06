// java 의 iterator는 역순으로 뽑을 수 없음
// iterator - 인터페이스
// hasNext() - 있는지 없는 지 검사, next() - 꺼내기
package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  // 사용자가 입력한 명령을 보관할 스택 준비
  static Stack<String> commandHistory = new Stack<>(); // 입력된 명령어 담을 보관소가 commandHistory, static main()에서도 사용할 수 있게 static변수로 만듦
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>();  //[1] 입력된 명령어 담을 보관소가 commandHistory2

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
        printCommandHistory(new Iterator<String>(){           //익명클래스 문법, new super class/interface
          // 익명클래스 내용
          int index = commandHistory.size() - 1;

          @Override
          public boolean hasNext() {
            return index >= 0;      // true/false
          }

          @Override
          public String next() {
            return commandHistory.get(index--); // 현재 index 값
          }

        });   

      }else if (command.equals("history2")) {
        printCommandHistory(commandHistory2.iterator());  

      }else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  private static void printCommandHistory(Iterator<String> iterator) { 
    //    Iterator<String> iterator = commandHistory.iterator();
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

  //  private static void printCommandHistory2() { 
  //    Iterator<String> iterator = commandHistory2.iterator();
  //    int count = 0;다형성 - 오버라이딩 하는 이유                               ch14. a
  //    while(iterator.hasNext()) { // 꺼낼 값이 있으면
  //      System.out.println(iterator.next());
  //      if(++count % 5 == 0) {
  //        System.out.print(":");
  //        String input = keyboard.nextLine();
  //        if(input.equalsIgnoreCase("q"))
  //          break;
  //      }
  //    }
  //    System.out.println();
  //  }



  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
