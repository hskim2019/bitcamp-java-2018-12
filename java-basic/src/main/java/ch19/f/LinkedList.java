// 특정 클래스에 의해서만 사용되는 클래스가 있다면 그 클래스 안에 정의하라!
package ch19.f;

// Array 클래스는 LinkedList 클래스에서만 사용한다
// 그래서 패키지 멤버 클래스에서 중첩 클래스로 옮겼다
// 즉 LinkedList 클래스 안에 Array 클래스를 정의하였다
public class LinkedList {

  public static final int FORWARD = 1;
  public static final int REVERSE = 2;

  protected Node head;    //protected 붙이지 않으면 그냥 두면 다른 패키지에서 못 씀
  protected Node tail;
  protected int size = 0;

  // 생성자
  public LinkedList() {
    head = new Node(); // 빈 노드 만들기
    tail = head; //tail이 head를 가리킴
    size = 0; // 현재는 size 0
  }

  // LinkedList는 add() 할 때 마다 노드를 만들어 값을 저장하기 때문에
  // ArrayList처럼 한 번에 메모리를 준비 할 필요가 없다
  // => 그러나 값 이외에 다음 노드와 이전 노드의 주소를 담기 위해 추가로 메모리를 사용한다(예비노드)
  public void add(Object value) {

    // 현재 tail이 가리키는 Node에 value값 넣는다
    tail.value = value;

    // 새 노드를 준비한다
    Node node = new Node();

    // 마지막 노드 next에 다음 노드 주소를 넣는다
    // 마지막 노드의 next로 새 노드를 가리키게 한다
    tail.next = node;

    // 새 노드의 prev에 이전 노드 주소 넣는다
    node.prev = tail; 

    // tail이 새로 추가 된 노드를 가리키게 한다
    tail = node;

    // 항목 개수를 증가시킨다
    size++;

  }

  public int size() {
    return size;
  }

  public Object get(int index) {
    if(index < 0 || index >= size)
      return null;

    Node cursor = head; 
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    return cursor.value;
  }

  public Object[] toArray(int direction) {
    // 이제 Array 클래스는 남이 아니다
    // LinkedList의 멤버를 사용할 수 있다
    // Array 클래스가 non-static nested class이기 때문에 LinkedList 객체 주소를 넘겨 줄 필요가 없다
    Array helper = new Array(); //<== LinkedLIst객체 주소를 넘긴다   => 필요 없다

    if (direction == FORWARD) {
      
      return helper.copy();
    } else {
      return helper.reverseCopy();
    }
  }

  public Object set(int index, Object value) {
    if(index < 0 || index >= size)
      return null;

    Node cursor = head;
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;  
    }
    Object old = cursor.value;

    cursor.value = value;

    return old;
  }

  public int insert(int index, Object value) {
    if(index < 0 || index >= size)
      return -1;

    Node node = new Node(value);

    Node cursor = head;
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next; 
    }
    node.next = cursor;

    node.prev = cursor.prev;

    cursor.prev = node;

    if (node.prev !=null) {
      node.prev.next = node;
    } else {
      head = node;
    }
    size++;

    return 0;
  }

  public Object remove(int index) {
    if(index < 0 || index >= size)
      return null;

    // index 위치에 있는 Node를 찾는다
    Node cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor =cursor.next;
    }

    if (cursor.prev !=null) {
      cursor.prev.next = cursor.next;
    } else {
      head = cursor.next;
    }
    cursor.next.prev = cursor.prev;

    Object old = cursor.value;

    cursor.value = null;
    cursor.prev = null; //help GC
    cursor.next = null;

    size--;

    return old;
  }

  // 중첩 클래스는 크게 static 이냐 non-static이냐로 나눌 수 있는데
  // 바깥 클래스의 특정 인스턴스를 사용하지 않는다면 static nested class로 선언하라
  // 그러나 바깥 클래스의 특정 인스턴스를 사용한다면 그 인스턴스에 종속되기 때문에
  // non-static nested class로 선언하라
  // => 다음 Array 클래스는 LinkedList의 특정 인스턴스 값을 사용해야 하기 때문에
  //    non-static class로 선언한다
  // => 내부에서만 사용할 클래스라면 비공개로 처리하라
  private class Array {
    // 이제 Array 클래스는 LinkedList의 인스턴스 멤버가 되었다
    // => 즉 인스턴스 필드나, 메서드처럼 특정 인스턴스에 대해 주소를 받는다는 것
    // => 따라서 바깥 클래스의 인스턴스를 마음대로 사용할 수 있다. 그냥 인스턴스 메서드라 생각하라

    //    LinkedList list;  <== 필요 없음
    //  public Array(LinkedList list) {   // <=== 생성자 만들어서 주소 받을 필요도 없다
    //  this.list = list;
    // }

    // 입력 된 순서대로 배열을 만든다
    // 바깥 클래스의 인스턴스 주소는 다음과 같이 사용해야 한다
    //        바깥클래스명.this.인스턴스멤버
    // 만약 바깥 클래스의 인스턴스 멤버명이 내부 클래스의 멤버 이름과 충돌하지 않는다면
    //      바깥클래스명.this를 생략해도 된다
    public Object[] copy() {
      Object[]arr = new Object[LinkedList.this.size()];

      for (int i = 0; i < LinkedList.this.size(); i++) {
        arr[i] = LinkedList.this.get(i);
      }
      return arr;
    }

    // 입력 된 순서의 반대로 배열을 만든다
    public Object[] reverseCopy() {
      Object[] arr = new Object[size()];

      for(int i = size() -1, j = 0; i >=0; i--, j++) {
        arr[j] = get(i);
      }
      return arr;
    }
  }

}
