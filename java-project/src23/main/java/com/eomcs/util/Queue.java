// 제네릭 적용 + Cloneable 구현
package com.eomcs.util;

public class Queue<E> extends LinkedList<E> implements Cloneable {

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

  //[6] 클론 오버라이딩하기
  // => 그냥 Object에서 상속 받은 clone() 메서드를 오버라이딩 하면 된다
  // => public으로 공개한다
  // => return type 을 클래스 타입으로 변경한다
  // => 클래스에 대해 복제를 허락허도록 java.lang.cloneable 인터페이스를 구현
  //  @SuppressWarnings("unchecked")
  //  @Override
  //  public Queue<E> clone() throws CloneNotSupportedException {  //자기자신을 복제하므로 리턴타입 Queue
  //    return (Queue<E>) super.clone();
  //  }
  
  //[7] 클론 오버라이딩 다시 하기
  // Object에서 상속 받은 clone()은
  // 인스턴스 필드의 값만 복제한다
  // 인스턴스 필드가 가리키는 다른 인스턴스는 복제하지 않는다
  // 예를 들어 Stack의 list 배열 레퍼런스가 가리키는 배열 인스턴스는 복제하지 않는다
  // 배열 인스턴스까지 복제(deep clone)하려면 개발자가 직접 코드를 작성해야 한다 
  @SuppressWarnings("unchecked")
  @Override
  public Queue<E> clone() throws CloneNotSupportedException {  //자기자신을 복제하므로 리턴타입 Queue
    Queue<E> temp = new Queue<>();
    for(int i = 0; i < this.size(); i++) {
      temp.add(this.get(i));
    }
    return temp;
  }
    // LinkedList 에도 클론 하러 가기 => 상속받은 클래스이므로
  }