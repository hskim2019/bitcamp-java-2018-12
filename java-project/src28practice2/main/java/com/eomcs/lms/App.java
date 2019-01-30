package com.eomcs.lms;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;
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

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>(); 
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>(); 

  //[2] main()에 있던 것을 밖으로 뺀다, static으로 만들어 줌 : 아래 loadlessonData메서드가 이용할 수 있게 
  static ArrayList<Lesson> lessonList = new ArrayList<>();

  public static void main(String[] args) {
    
    //[9] 데이터 로딩 - 프로그램 시작할 때 실행 됨
    loadLessonData();

    ArrayList<Board> boardList = new ArrayList<>();
    ArrayList<Member> memberList = new ArrayList<>();

    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/board/add",new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));

    commandMap.put("/member/add",new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));

    commandMap.put("/lesson/add",new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));



    while (true) {
      String command = prompt();

      commandHistory.push(command);
      commandHistory2.offer(command);

      if (command.equals("quit")) {
        quit();  //[6] 메서드로 따로 빼주기 (saveLessonData()메서드 실행하고, quit이라고 입력하면 "안녕"출력하는 메서드 )
        break;

      } else if (command.equals("history")) {
        printCommandHistory(new Iterator<String>(){ 
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

      } else {
        Command commandHandler = commandMap.get(command);
        if(commandHandler == null)
          System.out.println("실행할 수 없는 명령입니다.");
        {
          try {   //[]
            commandHandler.execute();
          } catch (Exception e) {
            System.out.printf("작업중오류발생: %s\n", e.toString());
          }  //[]
        }
      }

      System.out.println(); 
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

  //[7] quit()메서드 만들어주기- " saveLessonData(데이터 저장)메서드 실행 + "안녕"을 출력" 
  private static void quit() {
    saveLessonData();
    System.out.println("안녕!");
  }

  //[8] 아래 생성자는 두 개의 예외 발생 
  //     Scanner 는 한 줄씩 읽는 기능을 위해 넣음
  private static void loadLessonData() {
    try ( FileReader in = new FileReader("lesson.csv");       //lesson.csv라는 파일을 읽어 올 준비, FileReader클래스
        Scanner in2 = new Scanner(in)) {    //Scanner 클래스를 사용하는 이유: 파일을 읽어올 때 한 단어씩이 아니라 Scanner 클래스의nextLine()을 이용해 한 줄씩 읽어오기 위해서
       while(true) { //더 이상 읽을 것이 없으면 오류 -> catch -> "수업 데이터 로딩 완료"
         String line = in2.nextLine(); //line은 in2(lesson.csv)파일에서 한 줄 : 번호,제목,내용,시작일,종료일,총강의시간,일강의시간 => 한 줄
         String[] values = line.split(","); // 읽어 온 '한 줄'을 컴마 단위로 자름 : String클래스의 split()메서드 : 문자열을 배열로 만들되, 특정 분리자(ex: ,(컴마))를 기준으로 문자열이 여러 토막으로 분해 됨
         Lesson lesson = new Lesson();     // 빈 lesson 객체 만듦
         lesson.setNo(Integer.parseInt(values[0]));   //set : no = (파라미터에 넣은 값)
         lesson.setTitle(values[1]);
         lesson.setContents(values[2]);
         lesson.setStartDate(Date.valueOf(values[3]));
         lesson.setEndDate(Date.valueOf(values[4]));
         lesson.setTotalHours(Integer.parseInt(values[5]));
         lesson.setDayHours(Integer.parseInt(values[6]));
         
         lessonList.add(lesson); //lessonList에 lessons 데이터를 넣는다
         
       }
    } catch (FileNotFoundException e) {
      e.printStackTrace();

    } catch (IOException e1) {
      e1.printStackTrace();
    } catch (NoSuchElementException e) { //Scaner nextLine()메서드와 관련 된 예외처리 때문에 넣어줌
      System.out.println("수업데이터 로딩 완료"); //이것이 출력 됐다는 것은 더 이상 읽을 것이 없다는 의미
    }
  }

  //[1] 내부적으로 쓸 것이므로 private ;  //이 메서드는 quit으로 종료하고 나면 따로 file을 만들어서 입력한 내용을 출력해준다. openwith texteditor로 파일 열면 확인 가능
  private static void saveLessonData() {
  //[3] 텍스트를 출력할 때 사용하는 FileWriter(FileWriter는 파일로 데이터를 출력하기 위한 출력 스트림을 제공) //
    //     FileWriter의 write() 메서드 : ***파일***에 데이터를 출력해 줌, println이 아닌 write를 쓰는 이유는 출력을 console이 아닌 파일에 출력 할 것이기 때문에
    //[4] out을 따로 close 해주지 않기 위해 try() 가로 안에 넣는다 try with resources 문법 활용
    // [5] String 클래스의 format 메서드 : printf를 쓸 수 없기 때문에 format()사용하지 않으면 out.write(lesson.getNo() + "," + lesson.getTitle() +",") 형식으로 입력해야 함
    try (FileWriter out = new FileWriter("lesson.csv");){  //별도로 생성 될 파일 이름은 lesson.csv
      for(Lesson lesson : lessonList) {
        out.write(String.format("%s,%s,%s,%s,%s,%d,%d\n",
            lesson.getNo(), lesson.getTitle(), lesson.getContents(), lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours(), lesson.getDayHours()));
      }
    } catch (IOException e) {
      e.printStackTrace();  // 예외가 있으면 상세히 출력
    }
  }

}
