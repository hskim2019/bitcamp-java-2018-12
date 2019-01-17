package com.bitcamp.lms.handler;

import com.bitcamp.lms.domain.Member;

public class MemberList {

  static final int LENGTH = 10;
  Member[] arr = new Member[LENGTH];
  int size = 0;
  

  public Member[] toArray() {
    Member[] a = new Member[this.size];
    for(int i = 0; i < size; i++) {
      a[i] = arr[i];
    }
    return a;
  }
  
  
  public void add(Member member) {
    if(size == arr.length) {
      Member[] a = new Member[arr.length + (arr.length >> 1)];
      for(int i = 0; i < arr.length; i++) {
        a[i] = arr[i];
      }
      arr = a;
    }
    arr[size++] = member;
  }

}
