package com.eomcs.lms.domain;
import java.sql.Date;

public class Lesson implements Cloneable {
  private int no;
  private String title;
  private String contents;
  private Date startDate;
  private Date endDate;
  private int totalHours;
  private int dayHours;
  
  @Override
  public Lesson clone() throws CloneNotSupportedException {
    return (Lesson) super.clone();
  }
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getContents() {
    return contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }
  public Date getStartDate() {
    return startDate;
  }
  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
  public Date getEndDate() {
    return endDate;
  }
  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }
  public int getTotalHours() {
    return totalHours;
  }
  public void setTotalHours(int totalHours) {
    this.totalHours = totalHours;
  }
  public int getDayHours() {
    return dayHours;
  }
  public void setDayHours(int dayHours) {
    this.dayHours = dayHours;
  }
  
  /**
   * 
   * @param csv "번호,제목,내용,시작일(yyyy-MM-dd),종료일(yyyy-MM-dd),총강의시간,일강의시간"
   * @return
   */
  
  //[10] App.java에서 가져옴
  public static Lesson valueOf(String csv) { // csv는 파일에서 가져 온 한 줄
    String[] values = csv.split(","); // 컴마로 자른 것들을 배열로 만듦   . 읽은 것은 컴마로 자름
    
    Lesson lesson = new Lesson();     // 빈 lesson 객체 만듦
    lesson.setNo(Integer.parseInt(values[0]));
    lesson.setTitle(values[1]);
    lesson.setContents(values[2]);
    lesson.setStartDate(Date.valueOf(values[3]));
    lesson.setEndDate(Date.valueOf(values[4]));
    lesson.setTotalHours(Integer.parseInt(values[5]));
    lesson.setDayHours(Integer.parseInt(values[6]));
    
    return lesson;
  }
}
