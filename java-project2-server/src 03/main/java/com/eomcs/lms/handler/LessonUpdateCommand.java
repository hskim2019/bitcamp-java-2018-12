package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  LessonDao lessonDao;

  public LessonUpdateCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute(BufferedReader in, PrintWriter out) {

    try {
      out.println("번호? ");
      out.println("!{}!");
      out.flush();

      Lesson lesson = new Lesson();
      lesson.setNo(Integer.parseInt(in.readLine()));


      out.println("수업명? ");
      out.println("!{}!");
      out.flush();
      lesson.setTitle(in.readLine());

      out.println("설명? ");
      out.println("!{}!");
      out.flush();
      lesson.setContents(in.readLine());

      out.println("시작일? ");
      out.println("!{}!");
      out.flush();
      lesson.setStartDate(Date.valueOf(in.readLine()));

      out.println("종료일? ");
      out.println("!{}!");
      out.flush();
      lesson.setEndDate(Date.valueOf(in.readLine()));

      out.println("총수업시간? ");
      out.println("!{}!");
      out.flush();
      lesson.setTotalHours(Integer.parseInt(in.readLine()));

      out.println("일수업시간? ");
      out.println("!{}!");
      out.flush();
      lesson.setDayHours(Integer.parseInt(in.readLine()));

      if(lessonDao.update(lesson) == 0) {
        out.println("해당 수업이 없습니다.");
        return;
      }
      out.println("변경했습니다.");

    } catch (Exception e) {
      out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
