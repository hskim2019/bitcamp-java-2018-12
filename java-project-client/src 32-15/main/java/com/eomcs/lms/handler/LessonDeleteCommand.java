package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.proxy.LessonDaoProxy;

public class LessonDeleteCommand implements Command {

  Scanner keyboard;
  LessonDaoProxy lessonDao;
  
  public LessonDeleteCommand(Scanner keyboard, LessonDaoProxy lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
     lessonDao.delete(no);
      System.out.println("삭제했습니다.");
      
    } catch (Exception e) {
      System.out.printf("실행 오류! : %s\n", e.getMessage());
    }
  }
}
