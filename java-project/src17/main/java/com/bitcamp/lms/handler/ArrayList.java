package com.bitcamp.lms.handler;

import com.bitcamp.lms.domain.Lesson;

public class ArrayList {

  static final int LENGTH = 10;
  Object [] arr = new Object [LENGTH];
  int size = 0;

  public Object [] toArray() {
    Object [] a = new Object [this.size];
    for(int i = 0; i < size; i++) {
      a[i] = arr[i];
    }
    return a;
  }

  public void add(Object object) {
    if (size == arr.length) {
      Object[] a = new Object[arr.length + (arr.length >> 1)];
      for(int i = 0; i < arr.length; i++) {
        a[i] = arr[i];
      }
      arr = a;
    }

    arr[size++] = object;
  }
}
