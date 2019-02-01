// non-static nested class가 활용 된 경우
package ch19.f;


public class Test01 {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add(100);
    list.add(200);
    list.add(300);
    list.add(400);
    list.add(500);
    list.add(600);
    
    // list에 들어 있는 값을 배열로 꺼내보자
    // 배열을 만드는 것은 Array 클래스
    Object[] arr = list.toArray(LinkedList.FORWARD);
    // 1) LinkedList에 배열을 달라고 요청
    // 2) LinkedList는 같은 식구가 된 Array에게 배열을 만들어 달라고 요청한다.
    //    Array는 LinkedList.this라는 이름으로 바깥 클래스의 인스턴스 주소를 알고 있다
    // 3) Array는 LinkedList의 멤버를 사용하여 배열을 만들어 리턴한다
    // 4) LinkedList는 Array로부터 받은 배열을 그대로 리턴한다
    // 5) LlinkedList 리턴한 배열을 출력한다
    for(Object obj : arr) {
      System.out.print(obj + ",");
    }
    System.out.println();
    
    Object[] arr2 = list.toArray(LinkedList.REVERSE);
    for(Object obj : arr2) {
      System.out.print(obj + ",");
    }
    System.out.println();
    
    
    LinkedList list2 = new LinkedList();
    list2.add(10);
    list2.add(20);
    list2.add(30);
    list2.add(40);
    list2.add(50);
    list2.add(60);
    
    Object[] arr3 = list2.toArray(LinkedList.REVERSE);
    for(Object obj : arr3) {
      System.out.print(obj + ",");
    }
    System.out.println();
  }
}

/* 
# 중첩 클래스
=> 어떤 클래스에 식구(멤버)를 만드는 문법
=> 같은 식구가 되면 그 클래스의 모든 멤버를 자기 것처럼 사용할 수 있다
   즉 접근이 쉬워 코딩하기 편하다. 유지 보수도 편하다
=> 식구의 종류에는 크게 두 가지가 있다
   1) static 중첩 클래스
      => 그 집안(바깥 클래스)의 static 멤버만 사용할 수 있다
   2) non-static 중첩 클래스 
      => 그 집안(바깥 클래스)의 static 멤버 뿐만 아니라 non-static 멤버도 사용할 수 있다
non-static 멤버?
=> 인스턴스 필드, 인스턴스 메서드, 생성자, 인스턴스 블록
=> 인스턴스 주소가 있어야만 사용할 수 있는 멤버
 * 
 */
