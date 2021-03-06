// 제네릭 적용하기 (수정필요)
package algorithm.data_structure.linkedlist3;

// LinkedList 에 보관되는 값의 타입을 E라고 가정한다
// => E가 타입이라고 가정하고 코드를 작성한다
// => (수정필요)
public class LinkedList<E> {

  protected Node<E> head;    //protected 붙이지 않으면 그냥 두면 다른 패키지에서 못 씀
  protected Node<E> tail;
  protected int size = 0;

  // 생성자
  public LinkedList() {
    head = new Node<>(); // 빈 노드 만들기
    tail = head; //tail이 head를 가리킴
    size = 0; // 현재는 size 0
  }

  // LinkedList는 add() 할 때 마다 노드를 만들어 값을 저장하기 때문에
  // ArrayList처럼 한 번에 메모리를 준비 할 필요가 없다
  // => 그러나 값 이외에 다음 노드와 이전 노드의 주소를 담기 위해 추가로 메모리를 사용한다(예비노드)
  public void add(E value) {

    // 현재 tail이 가리키는 Node에 value값 넣는다
    tail.value = value;

    // 새 노드를 준비한다
    Node<E> node = new Node<>();

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

  // ArrayList와 달리 해당 인덱스를 찾아 가려면 링크를 따라가야 하기 때문에
  // 조회 속도가 느리다
  public E get(int index) {
    if(index < 0 || index >= size)
      return null;

    Node<E> cursor = head; // 해당 노드를 찾기 위해 head(첫 번째 노드)부터 찾음
    // 해당 인덱스로 이동한다
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;
    }

    // cursor가 가리키는 노드의 주소를 리턴하는 것이 아니라
    // => 노드의 ****값*****을 리턴해야 함
    return cursor.value;
  }

  public Object[] toArray() {
    Object[] arr = new Object[size()]; // 현재 사이즈 길이 만큼의 arr 배열 만듦
    Node<E> cursor = head; // cursor가 가리키는 값을 찾아야 함. head부터 시작
    int i = 0;
    while(cursor != tail) { // 커서가 tail을 가리킨다는 것은 빈 노드 
      arr[i++] = cursor.value;
      cursor = cursor.next; // 커서가 다음 노드로 가서 value를 가져올 수 있게
    }
    return  arr; // 배열 주소 리턴
  }
  
  public E set(int index, E value) {
    if(index < 0 || index >= size)
      return null;
    
    Node<E> cursor = head;
    // 교체할 값이 들어 있는 노드로 이동한다
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next; // 다음 주소로 
    }
    
    // 변경 전에 이전 값을 보관한다
    E old = cursor.value;
    
    // 값을 변경한다
    cursor.value = value;
    
    // 이전 값을 리턴한다. 쓰든 안 쓰든 호출하는 사람이 알아서 할 일
    return old;
  }
  
  // 값을 삽입하는 경우에는 ArrayList 방식보다 효율적이다
  // 삽입 위치에 있는 노드를 찾은 후에 새 노드를 앞, 뒤 노드와 연결하면 된다.
  public int insert(int index, E value) {
    if(index < 0 || index >= size)
      return -1;
    
    // 새 노드를 만들어 값을 담는다
    Node<E> node = new Node(value);
    
    // 삽입 할 위치에 있는 원래 노드를 찾는다
    Node<E> cursor = head;
    for(int i = 1; i <= index; i++) {
      cursor = cursor.next;  //이동 할 때 마다 다음 노드 주소를 알아야 커서가 다음 노드에 가서 값과 다음 노드 주소 등을 찾을 수 있다
    }
    
    // 새 노드가 찾은 노드를 가리키게 한다
    node.next = cursor;
    
    // 찾은 노드의 prev 이전 노드 주소를 새 노드의 prev 이전 노드 주소로 설정한다
    node.prev = cursor.prev;
    
    // 찾은 노드의 이전 노드(prev)로 새 노드를 가리키게 한다
    cursor.prev = node;
    
    if (node.prev !=null) {
    // 이전 노드의 next가 새 노드를 가리키게 해야 함
    node.prev.next = node;
    } else {
      // 맨 앞에 노드를 추가할 때는 head를 변경해야 한다
      head = node;
    }
    // 크기를 늘린다
    size++;
    
    return 0;
  }
  
  public E remove(int index) {
    if(index < 0 || index >= size)
      return null;
    
    // index 위치에 있는 Node를 찾는다
    Node<E> cursor = head;
    for (int i = 1; i <= index; i++) {
      cursor =cursor.next;
    }
    
    if (cursor.prev !=null) {
    // 찾은 노드의 이전 노드가 다음 노드를 가리키게 한다
    cursor.prev.next = cursor.next;
    } else {
      // 맨 처음 노드를 삭제할 때
      head = cursor.next;
    }
    // 찾은 노드의 다음 노드가 이전 노드를 가리키게 한다
    cursor.next.prev = cursor.prev;
    
    // 가비지를 효과적으로 계산 할 수 있도록 
    // 가비지가 된 객체는 다른 객체를 가리키지 않도록 한다
    
    E old = cursor.value;
    
    cursor.value = null;
    cursor.prev = null; //help GC
    cursor.next = null;
    
    // 크기를 줄인다
    size--;
    
    // 호출 한 쪽에서 필요하면 사용하라고 삭제된 값을 리턴해 준다
    return old;
    
  }
  
  
  // LinkedLIst 에서만 쓰이는 Node 클래스를 중첩 클래스로 만든다
  // => Node 클래스는 LinkedList 의 특정 인스턴스를 사용하지 않는다
  // => 그래서 static 중첩 클래스로 정의하는 것이다
  // => 외부에 공개할 일이 없기 때문에 private로 접근을 제한한다
  
  // Node 가 다루는 타입의 값을 제네릭(generic)으로 선언한다
  // => 즉 Node가 다루는 데이터 타입을 E라고 명명하고 코드를 작성한다
  // => Node 클래스를 사용하는 시점에 E가 무슨 타입인지 결정될 것이다
  private static class Node<E> {
  // LinkedList 내부에서만 사용하기 때문에 Node의 멤버를 public으로 공개할 필요 없이 default로 두기
    E value;
    Node<E> prev; // 이전 Node 주소 담는 필드
    Node<E> next; // 다음 Node 주소 담는 필드
    
    // 생성자
    Node() {
    }
    
    Node(E value) {
      this.value = value;
    }
  }

  
}
