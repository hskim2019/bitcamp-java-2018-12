package com.bitcamp.lms.test.handler;

import java.sql.Date;
import java.util.Scanner;
import com.bitcamp.lms.test.domain.Lesson;

public class LessonHandler {

  public Scanner keyboard;
  static final int LENGTH = 10;
  
  Lesson[] lessons = new Lesson[LENGTH];
  int lessonIdx = 0;
  
  public void listLesson() {
    int count = 0;
    while(count < lessonIdx) {
      System.out.printf("%d, %-20s, %s ~ %s, %4d\n"
          ,lessons[count].no,lessons[count].title, lessons[count].startDate, lessons[count].endDate , lessons[count].totalHour );
      count++;
    }
    System.out.println();
  }

  public void addLesson() {
    Lesson lesson = new Lesson();
    
    System.out.print("번호? ");
    lesson.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("수업명? ");
    lesson.title = keyboard.nextLine();

    System.out.print("설명? ");
    lesson.content = keyboard.nextLine();

    System.out.print("시작일? ");
    lesson.startDate = Date.valueOf(keyboard.nextLine());

    System.out.print("종료일? ");
    lesson.endDate = Date.valueOf(keyboard.nextLine());

    System.out.print("총수업시간? ");
    lesson.totalHour = Integer.parseInt(keyboard.nextLine());

    System.out.print("일수업시간? ");
    lesson.dayHour = Integer.parseInt(keyboard.nextLine());

    System.out.println("저장하였습니다.\n");

    lessons[lessonIdx++] = lesson;
  }
}
