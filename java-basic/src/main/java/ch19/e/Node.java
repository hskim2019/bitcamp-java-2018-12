package ch19.e;

// LinkedList에서 다룰 데이터를 담는 그릇이다
public class Node {

  public Object value;
  public Node prev; // 이전 Node 주소 담는 필드
  public Node next; // 다음 Node 주소 담는 필드
  
  // 생성자
  public Node() {
  }
  
  public Node(Object value) {
    this.value = value;
  }
  
  public Node(Object value, Node prev, Node next) {
    this(value); // 위 생성자 호출
    this.prev = prev;
    this.next = next;
  }
}
