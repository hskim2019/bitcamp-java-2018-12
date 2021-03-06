package algorithm.data_structure.array;

import java.util.Arrays;

public class ArrayList {

  static final int DEFAULT_SIZE= 5;

  Object[] arr;
  int size;

  // 생성자
  public ArrayList() {
    this(0);
  }

  public ArrayList(int capacity) {
    if(capacity > DEFAULT_SIZE)
      arr = new Object[capacity];
    else
      arr = new Object[DEFAULT_SIZE];
  }

  // 새로운 사이즈에 맞춰 새로운 배열 생성
  public Object[] toArray() {
    Object[] list = new Object[this.size];
    for(int i = 0; i < this.size; i++) {
      list[i] = this.arr[i];
    }
    return list;
  }

  public void add(Object value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50%만큼 증가시켜라
    if(this.size == arr.length) {
      increase();
    }
    arr[this.size++] = value; // ex) size =5 이면 arr[5] = value, 이후 size +1 증가
  }

  public int insert(int index, Object value) {
    // 현재 배열이 꽉 찼다면 현재 배열 크기의 50%만큼 증가시켜라
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 저장하지 말라
    // 삽입할 위치의 항목부터 이후의 항목들을 뒤로 밀어라
    if(index < 0 || index >= size)
      return -1;
    
    if(this.size == arr.length) 
      increase();

    for(int i = size - 1; i >=index; i--)
      this.arr[i + 1] = this.arr[i];

    this.arr[index] = value;
    size++;
    
    return 0;   //insert호출 실패하면 -1return하고 이 메서드 수행 중지, 성공하고 나면 0 리턴
                // 메서드 호출 실패 했는지 성공했는지 알고 싶으면 리턴값 확인하면 됨
  }

  public Object get(int index) {
    // 유효인덱스(현재 배열에 데이터가 저장된 방 번호) 가 아니면 null을 리턴하라
    if(index<0 || index >=size)
      return null;
    return this.arr[index];  // 찾는 방 번호가 유효하면 방 번호 전달
  }

  public Object set(int index, Object value) {
    // 유효 인덱스(현재 배열에 데이터가 저장된 방 번호)가 아니면 변경하지 말라. 리턴 값은 null이다
    if(index<0 || index >=size)
      return null;
    
    Object old = this.arr[index];  //원래 값 넣기
    this.arr[index] = value;       // 새로운 값 넣기
    return old;                    //
  }

  public Object remove(int index) {
    // 유효 인덱스가 아니면 삭제하지 말라
    // 삭제한 후 다음 항목을 앞으로 당긴다
    if(index < 0 || index >= size)
      return null;

    Object old = this.arr[index];

    for(int i = index; i < size -1; i++)
      this.arr[i] = this.arr[i + 1];
    size --;                 // index하나 삭제, 줄었으므로 size 하나 줄이기
    return old;

  }

  public int size() {
    return this.size;
  }

  private void increase() {
    int oldLength = arr.length;
    int newLength = oldLength + (oldLength >> 1);
    Object[] temp = new Object[newLength];  // 새 크기에 맞춰 배열 생성
    for (int i = 0; i < this.arr.length; i++) {  // 새로 생성 된 배열에 옛날 값 옮기기
      temp[i] = this.arr[i];                   
    }
    arr = temp;   //  새 배열 주소 arr에 저장하고, 이전 것은 가비지가 됨
  }
}
