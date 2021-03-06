package com.eomcs.lms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.context.ApplicationListener;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;
import com.eomcs.lms.listener.BoardDataLoaderListener;
import com.eomcs.lms.listener.LessonDataLoaderListener;
import com.eomcs.lms.listener.MemberDataLoaderListener;

public class App {

  //[2] 애플리케이션의 상태 변경을 보고 받을 옵저버 목록
  static ArrayList<ApplicationListener> observers = new ArrayList<>();

  // [7]애플리케이션에서 사용할 객체를 보관하는 보관소
  static HashMap<String,Object> context = new HashMap<>();

  // [8] 스테틱 블록 만들기 : 애플리케이션에서 사용할 객체를 준비하여 보관소에 저장한다
  static {
    context.put("keyboard", new Scanner(System.in));
    context.put("commandHistory", new Stack<>());
    context.put("commandHistory2", new LinkedList<>());
    context.put("lessonList", new ArrayList<Lesson>());
    context.put("memberList", new  ArrayList<Member>());
    context.put("boardList", new ArrayList<Board>());
  }

  //[9] 아래를 8번 스테틱 블록으로 올리기 : 변수로 두지 않고 보관소에 담는다 
  //  static Scanner keyboard = new Scanner(System.in);
  //  static Stack<String> commandHistory = new Stack<>();
  //  static Queue<String> commandHistory2 = new LinkedList<>();
  //  static ArrayList<Lesson> lessonList;  
  //  static ArrayList<Member> memberList;
  //  static ArrayList<Board> boardList;

  //[4] 
  static void addApplicationListener(ApplicationListener listener) {
    observers.add(listener);
  }

  @SuppressWarnings("unchecked")
  public static void main(String[] args) {
    //[5] 애플리케이션의 상태가 변경되었을 때 보고 받을 리스너(옵저버)를 등록한다
    addApplicationListener(new BoardDataLoaderListener());
    
    //[23] 보관소 정보 추가
    addApplicationListener(new MemberDataLoaderListener());
    addApplicationListener(new LessonDataLoaderListener());

    //[6] 삭제
    //    loadLessonData();
    //    loadMemberData();
    //    loadBoardData();

    //[18] 애플리케이션이 시작될 때 등록된 리스너(옵저버)에게 보고한다
    for(ApplicationListener observer : observers) {
      try {
        observer.startApplication(context);
      } catch (Exception e){}
    }
  


    //[10] : 이 안에 키보드 객체와 lessonList 객체가 없으니 가져오기
    Scanner keyboard = (Scanner) context.get("keyboard");
    ArrayList<Lesson> lessonList = (ArrayList<Lesson>) context.get("lessonList");
    Map<String,Command> commandMap = new HashMap<>();
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));

    //[10]
    LinkedList<Member> memberList = (LinkedList<Member>) context.get("memberList");
    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));

    //[10]
    ArrayList<Board> boardList = (ArrayList<Board>) context.get("boardList");
    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));

    //[11]
    Stack<String> commandHistory = (Stack<String>) context.get("commandHistory");
    Queue<String> commandHistory2 = (Queue<String>) context.get("commandHistory2");

    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령을 스택에 보관한다.
      commandHistory.push(command);

      // 사용자가 입력한 명령을 큐에 보관한다.
      commandHistory2.offer(command);

      // 사용자가 입력한 명령으로 Command 객체를 찾는다.
      Command commandHandler = commandMap.get(command);

      if (commandHandler != null) {
        try {
          commandHandler.execute();
        } catch (Exception e) {
          System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        }
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;

      } else if (command.equals("history")) {
        printCommandHistory();

      } else if (command.equals("history2")) {
        printCommandHistory2();

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }

      System.out.println(); 
    }

    keyboard.close();

    //[19] 아래 삭제
//    saveLessonData();
//    saveMemberData();
//    saveBoardData();
    
    //[20] 애플리케이션이 종료될 때 등록된 리스너(옵저버)에게 보고한다  
    for(ApplicationListener observer : observers) {
      try {
        observer.endApplication(context);
      } catch (Exception e){}
    }
  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory() {

    Stack<String> commandHistory = (Stack<String>) context.get("commandHistory"); //[12]
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }

  @SuppressWarnings("unchecked")
  private static void printCommandHistory2() {

    Queue<String> commandHistory2 = (Queue<String>) context.get("commandHistory2"); //[13]
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private static String prompt() {
    Scanner keyboard = (Scanner) context.get("keyboard"); //[14]
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

  //[15] saveData loadData 메서드 잘라내서 DataLoaderListener 에 붙여넣기
}
