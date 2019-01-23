package algorithm.data_structure.nodepractice;

public class LinkedList {

 Node head;
 Node tail;
 int size = 0;
 
 public LinkedList() {
   head = new Node();
   tail = head;
   size = 0;
 }
 
 public void add(Object value) {
   tail.value = value;
   
   Node node = new Node();
   
   tail.next = node;
   node.prev = tail;
   tail = node;
   size++;
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
 
 public Object[] toArray() {
   Object[] arr = new Object[size()];
   Node cursor = head;
   for(int i = 0; i < size; i++) {
     arr[i] = cursor.value;
     cursor = cursor.next;
   }
   return arr;
 }
 
 public int insert(int index, Object value) {
   if(index < 0 || index >= size)
     return -1;
   
   Node node = new Node(value);
   
   // 인덱스 값 찾아서, 해당 인덱스 prev주소를 새 node에 
   // 새 node의 next에는 원래 인덱스 주소
   Node cursor = head;
   for(int i = 1; i <= index; i++) {
     cursor = cursor.next;
   }
   node.prev = cursor.prev;
   node.next = cursor;
   
   // 이전 인덱스가 새 node를 가리키게
   if(node.prev != null) {
   node.prev.next = node;
   } else {
     head = node;
   }
   cursor.prev = node;
     
   size++;
   return 0;
   
 }
 
 public Object remove(int index) {
   if(index < 0 || index >= size)
     return null;
   Node cursor = head;
   for(int i = 1; i <= index; i++) {
     cursor = cursor.next;
   }
   if(cursor.prev !=null) {
   cursor.prev.next = cursor.next;
   cursor.next.prev = cursor.prev;
   } else {
     head = cursor.next;
   }
   
   Object old = cursor.value;
   cursor.value = null;
   cursor.prev = null;
   cursor.next = null;
   size--;
   return old;
   
 }
 public int size() {
   return size;
 }
}
