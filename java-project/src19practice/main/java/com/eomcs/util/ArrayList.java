package com.eomcs.util;

import java.util.Arrays;

public class ArrayList<E> {

  static final int DEFAULT_CAPACITY = 10;
  Object[] list;
  int size = 0;

  public ArrayList() {
    list = new Object[DEFAULT_CAPACITY];
  }

  public ArrayList(int initialCapacity) {
    if (initialCapacity > DEFAULT_CAPACITY)
      list = new Object[initialCapacity];
    else
      list = new Object[DEFAULT_CAPACITY];
  }

  @SuppressWarnings("unchecked")
  public E[] toArray(E[] sampleArr) {
    return (E[]) Arrays.copyOf(list, size, sampleArr.getClass());
    /*
    E[] arr = Arrays.copyOf(sampleArr, size);
    for (int i = 0; i < size; i++) {
      arr[i] = (E) list[i];
    }
    return arr;
     */
  }

  public void add(E obj) {
    if (size >= list.length) {
      int oldCapacity = list.length;
      int newCapacity = oldCapacity + (oldCapacity >> 1);
      list = Arrays.copyOf(list, newCapacity);
    }

    list[size++] = obj;
  }
  
  @SuppressWarnings("unchecked")
  public E get(int index) { //[1] index 가 유효 범위에 있어야 함
    if(index < 0 || index >= size)
      return null;            // 유효 범위 안이면 list를 리턴하고, 그렇지 않으면 null로
    return (E) list[index]; //add(E obj)에 넣는 타입에 따라 결정 되도록 (E)라는 타입으로
  }

  public E set(int index, E value) {  //[3]
    // index : 값을 변경할 배열의 항목 위치
    // value : 해당 위치에 있는 값을 대체할 값 
    // 리턴 값 : 대체되기 전의 기존 값
    if (index < 0 || index >= size)
    return null;
    
    @SuppressWarnings("unchecked")
    E obj = (E) list[index];
    
    list[index] = value;
    
    return obj;
  }

  @SuppressWarnings("unchecked")
  public E remove(int index) {
    // index : 삭제할 배열의 항목 위치
    // 리턴값: 삭제된 이전 값
    // 힌트: System.arraycopy() 참고! 
    E obj = (E) list[index];  //현재 방에 있는 주소 저장하기
    
    if(index < 0 || index >= size)
      return null;   
    for(int i = index; i <= size -1; i++)
     list[i] = list[i + 1];  //삭제 된 이후 앞으로 당기기, 반복문 돌면서(예)index 2 번에 있는 값을 index 1로)
  
     size--;
     return obj;
  }

  public int size() {
    return this.size; //사이즈가 얼마나 되는지 리턴 받기 
  }
}









