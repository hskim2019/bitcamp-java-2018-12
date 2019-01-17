package com.bitcamp.lms.handler;

import com.bitcamp.lms.domain.Lesson;

public class LessonList {

  static final int LENGTH = 10;
  Lesson[] arr = new Lesson[LENGTH];
  int size = 0;
  
  public Lesson[] toArray() {
    Lesson[] a = new Lesson[this.size];
    for(int i = 0; i < size; i++) {
      a[i] = arr[i];
    }
    return a;
  }
  
  public void add(Lesson lesson) {
    if (size == arr.length) {
      Lesson[] a = new Lesson[arr.length + (arr.length >> 1)];
      for(int i = 0; i < arr.length; i++) {
        a[i] = arr[i];
      }
      arr = a;
    }
    
    arr[size++] = lesson;
  }
  
  
  
  
}
  
