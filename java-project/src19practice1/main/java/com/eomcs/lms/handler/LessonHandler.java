package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ArrayList;

public class LessonHandler {

  Scanner keyboard;
  ArrayList<Lesson> list;

  public LessonHandler(Scanner keyboard) {
    this.keyboard = keyboard;
    list = new ArrayList<>();
  }

  public void listLesson() {
    Lesson[] lessons = list.toArray(new Lesson[0]);
    for (Lesson lesson : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          lesson.getNo(), lesson.getTitle(), 
          lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours());
    }
  }

  public void addLesson() {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("수업명? ");
    lesson.setTitle(keyboard.nextLine());

    System.out.print("설명? ");
    lesson.setContents(keyboard.nextLine());

    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));

    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));

    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

    list.add(lesson);

    System.out.println("저장하였습니다.");
  }

  //[1] App에서 detailLesson으로 else if 만들고, method도 만들기
  public void detailLesson() {
    //    System.out.print("번호? ");
    //    int no = Integer.parseInt(keyboard.nextLine());//사용자가 조회하고 싶은 번호 받기
    // => 아래와 같이 메서드로 변경
    int no = promptLessonNo();   // 수업번호 입력받고

    //    Lesson lesson = null; // 반복문 돌면서 저장 된 번호중에 사용자가 입력한 번호와 같은 것 찾게 하기 => 반복문을 list개수만큼 돌면 됨
    //    int size = list.size(); //ArrayList의 list의 개수를 알아내기 위해서 ArrayList size()메서드 만들고 호출
    //    for (int i = 0; i < size; i++) {    //list 개수만큼 for문 반복 함
    //      Lesson item = list.get(i); //i번째 객체를 리턴 => ArrayList에 get() 메서드 만들기 (그림1 참조) => ex)list.get(0) 는 list[0]객체 의미
    //      if (item.getNo() == no) {    // lesson에 저장 된 주소로 찾아가서 no값이 사용자가 입력한 값(detailLesson메서드의 int no)과 같은가?
    //        lesson = item;          // 같으면 저장
    //        break;
    //      }
    //    }
    // => 아래와 같이 메서드로 변경    
    
    int index = indexOf(no);      // 방번호 찾기
    if(!validate(index))         // 방번호가 유효하지 않으면
      return;                    // 함수 종료
    Lesson lesson = list.get(index); // 찾은 방 번호의 주소를 lesson에 넣어주기


    if (lesson == null) {  // 사용자가 입력한 값이랑 같은 거 없는 경우(for 반복문을 다 돌았는데도 같은 값 못 찾은 경우)
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return; //메서드 호출을 멈추고 되돌아가라
    }

    //일치하는 번호 찾았으면 나머지 detail 출력해주기
    System.out.printf("수업명: %s\n", lesson.getTitle());
    System.out.printf("수업내용: %s\n", lesson.getContents());
    System.out.printf("수업기간: %s ~ %s\n", lesson.getStartDate(), lesson.getEndDate());
    System.out.printf("총수업시간: %d\n", lesson.getTotalHours());
    System.out.printf("일수업시간: %d\n", lesson.getDayHours());
  }

  public void deleteLesson() { //[2]
    int no = promptLessonNo();   // 수업번호 입력받고
    int index = indexOf(no);      // 방번호 알아낸다
    if(!validate(index))         // 방번호가 유효하지 않으면
      return;                    // 함수 종료

    list.remove(index); // 해당 수업을 찾았으면 삭제 => ArrayList에 remove ()메서드 만들기
    System.out.println("수업을 삭제했습니다.");
  }

  public void updateLesson() { //[3]
//    int no = promptLessonNo();
//
//    int index = indexOf(no);
//    if (index == -1) {  
//      System.out.println("해당 수업을 찾을 수 없습니다.");
//      return; 
//
//    }
    // 위 내용 대신 메서드 사용해서 중복 코드 줄이기
    int no = promptLessonNo();   // 수업번호 입력받고
    int index = indexOf(no);      // 방번호 알아낸다
    if(!validate(index))         // 방번호가 유효하지 않으면
      return;                    // 함수 종료

    Lesson lesson = list.get(index);
    Lesson temp = new Lesson(); // 아래 update로 수정 입력한 내용 저장할 집 만들기

    temp.setNo(lesson.getNo());  // 기존 번호는 그대로 저장하기

    System.out.printf("수업명(%s)? ", lesson.getTitle());
    String input = keyboard.nextLine();
    if (input.length() > 0) {
      temp.setTitle(input);
    } else {
      temp.setTitle(lesson.getTitle()); // 원래 값 집어넣기   //ArrayList에 set() 메서드 있어야 됨
    }

    System.out.printf("수업내용? ");
    input = keyboard.nextLine();
    temp.setContents(input.length() > 0 ? input : lesson.getContents()); 
    // input된 것의 길이가 0 보다 크면 뭔가 입력 되었다는 것. 입력 값이 있으면 input값을 넣고, 그렇지 않으면 원래 값을 준다(lesson.getContents)

    System.out.printf("시작일(%s)?", lesson.getStartDate());
    input = keyboard.nextLine();
    temp.setStartDate(input.length() > 0 ? 
        Date.valueOf(input) : lesson.getStartDate()); //입력한 값을 Date로 바꾸기 => Date.valueOf(input)

    System.out.printf("종료일(%s)?", lesson.getEndDate());
    input = keyboard.nextLine();
    temp.setEndDate(input.length() > 0 ?
        Date.valueOf(input) : lesson.getEndDate());

    System.out.printf("총수업시간(%d)? ", lesson.getTotalHours());
    input = keyboard.nextLine();
    temp.setTotalHours(input.length() > 0?
        Integer.parseInt(input) : lesson.getTotalHours());

    System.out.printf("일수업시간(%d)?", lesson.getDayHours());
    input = keyboard.nextLine();
    temp.setDayHours(input.length() > 0?
        Integer.parseInt(input) : lesson.getDayHours());

    list.set(index, temp); //새로 만든 lesson을 index번호 찾아서 값 넣기
  }

  //내부적으로 쓸 것, 계속 반복되는 index 넘버 찾는 것을 하나로 리펙토링
  private int indexOf(int lessonNo) {
    for (int i = 0; i < list.size(); i++) {
      Lesson item = list.get(i); 
      if (item.getNo() == lessonNo) {    
        return i;
      }
    }
    return -1;  // 찾으면 i리턴하고, 못 찾으면 -1 리턴(방은 0번부터 존재하고 -1번방은 없으므로)
                // -1이 리턴되면 validate 메서드에서 "해당수업찾을수없음"출력함
  }

  private int promptLessonNo() {
    System.out.print("번호? ");
    return Integer.parseInt(keyboard.nextLine());
  }

  // index 유효한 지 검사
  private boolean validate(int index) {
    if(index == -1) {
      System.out.println("해당 수업을 찾을 수 없습니다.");
      return false;
    }
    return true;
  }
}
