package com.eomcs.lms.handler;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand extends AbstractCommand {

  LessonDao lessonDao;

  public LessonUpdateCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }


  @Override
  public void execute (Response response) throws Exception {

      Lesson lesson = new Lesson();
      lesson.setNo(response.requestInt("번호? "));
      lesson.setTitle(response.requestString("수업명? "));
      lesson.setContents(response.requestString("설명? "));
      lesson.setStartDate(response.requestDate("시작일? "));
      lesson.setEndDate(response.requestDate("종료일? "));
      lesson.setTotalHours(response.requestInt("총수업시간? "));
      lesson.setDayHours(response.requestInt("일수업시간? "));

      if(lessonDao.update(lesson) == 0) {
        response.println("해당 수업이 없습니다.");
        return;
      }
      response.println("변경했습니다.");

  }
}
