package com.eomcs.util;

public interface Iterator<E> {
  // 데이터 목록에서 꺼낼 값이 있다면 true, 없다면 false
  boolean hasNext();
  
  // 데이터 목록에서 값을 꺼낸다
  E next();
}
