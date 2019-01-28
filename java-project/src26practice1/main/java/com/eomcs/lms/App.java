package com.eomcs.lms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  // 사용자가 입력한 명령을 보관할 스택 준비
  static Stack<String> commandHistory = new Stack<>(); 
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>(); 

  public static void main(String[] args) {
  
    //[6-1]
    ArrayList<Board> boardList = new ArrayList<>();
   
    //[6-2] 나중에 8번과 같이 변경 
    //BoardAddCommand boardAddCommand = new BoardAddCommand(keyboard, boardList); // 같은 keyboard를 사용하고 같은 boardList를 사용한다
    //BoardListCommand boardListCommand = new BoardListCommand(keyboard, boardList);
    
    //[8-1]  [6]번에 입력한 내용을 [8]번과 같이 합쳐 준다
    HashMap<String,Command> commandMap = new HashMap<>();
    
    //[8-2] 
    commandMap.put("/board/add", new BoardAddCommand(keyboard,boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard,boardList));
    
    
    LessonHandler lessonHandler = new LessonHandler(keyboard, new ArrayList<>());
    MemberHandler memberHandler = new MemberHandler(keyboard, new ArrayList<>());
//    BoardHandler boardHandler2 = new BoardHandler(keyboard, new LinkedList<>()); => 이제 각각의 클래스로 다룰 것이므로 필요 없음
//    BoardHandler boardHandler1 = new BoardHandler(keyboard, new LinkedList<>());


    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택과 큐에 보관한다
      commandHistory.push(command);
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

      } //else if (command.equals("/board/add")) {
//        boardHandler1.addBoard();
       // boardAddCommand.execute();  //[7] => 9번 실행하면서 없앰

     // } else if (command.equals("/board/list")) {
//        boardHandler1.listBoard();
        // boardListCommand.execute(); //[7]

     // } 
        else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.equals("history")) {
        printCommandHistory(new Iterator<String>(){          
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
        //[9]
        Command commandHandler = commandMap.get(command);
        
        if (commandHandler == null)
        System.out.println("실행할 수 없는 명령입니다.");
        else
          commandHandler.execute();
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




  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
