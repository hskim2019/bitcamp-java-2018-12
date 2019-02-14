package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;

  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    // ====원래 Lesson Update Command===
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    // ====원래 Lesson Update Command===

    try {
      //==== detailCommd에서 가져 옴, lesson data====
      Lesson lesson = LessonAgent.get(no, in, out);
      //==== detailCommd에서 가져 옴, lesson data====

      // ==== 원래 Lesson Updte Commd 있던 내용2====
      Lesson temp = lesson.clone();

      System.out.printf("수업명(%s)? ", lesson.getTitle());
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setTitle(input);

      System.out.printf("설명(%s)? ", lesson.getContents());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setContents(input);

      System.out.printf("시작일(%s)? ", lesson.getStartDate());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setStartDate(Date.valueOf(input));

      System.out.printf("종료일(%s)? ", lesson.getEndDate());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setEndDate(Date.valueOf(input));

      System.out.printf("총수업시간(%d)? ", lesson.getTotalHours());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setTotalHours(Integer.parseInt(input));

      System.out.printf("일수업시간(%d)? ", lesson.getDayHours());
      if ((input = keyboard.nextLine()).length() > 0)
        temp.setDayHours(Integer.parseInt(input));
      // ==== 원래 Lesson Updte Commd 있던 내용2====


      // ==== boardTest===
      LessonAgent.update(temp, in, out);
      // ==== boardTest=== 

      System.out.println("수업을 변경했습니다.");

    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }

}
