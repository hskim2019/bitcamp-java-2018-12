// 제네릭 적용
package algorithm.data_structure.queue2;

import algorithm.data_structure.linkedlist3.LinkedList;

public class Queue<E> extends LinkedList<E> {

  public void offer(E value) {
    // 상속 받은 메서드를 사용하여 값을 추가하라
      this.add(value);
  }
  
  public E poll() {
    // 상속 받은 메서드를 사용하여 값을 꺼내라
  return this.remove(0);
  }
  
  public boolean empty() {
    // 상속 받은 필드나 메서드를 사용하여 값을 리턴하라
    return this.size == 0;
  }
   
}