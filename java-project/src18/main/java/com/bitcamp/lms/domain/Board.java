package com.bitcamp.lms.domain;

import java.sql.Date;

public class Board {
  private int no;
  private String contents;
  private Date createdDate;
  private int viewCount;

  public int getNo() {
    return this.no;
  }
  public void setNo(int no) {
    this.no = no;
  }

  public String getContents() {
    return this.contents;
  }
  public void setContents(String contents) {
    this.contents = contents;
  }

  public Date getCreatedDate() {
    return this.createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  
  public int getViewCount() {
    return this.viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }


}
