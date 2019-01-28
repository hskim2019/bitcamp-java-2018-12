// java.util.Set 클래스 사용법 - add(), Iterator
// => Set은 클래스가 아니라 인터페이스, Set을 구현한 클래스를 의미
// => 이 chapter에서는 Set 인터페이스를 구현한 HashSet 클래스를 살펴 본다
// => Set을 구현한 HashSet 클래스에는 한 개씩 뽑아내는 get이 없음 ->해결방법: 다른 객체의 도움을 받는다
package ch20.c;

import java.util.HashSet;
import java.util.Iterator;

public class Test01 {

  public static void main(String[] args) {
    HashSet<String> set = new HashSet<>();

    //set에 값 추가하기
    //HashSet의 add의 특성 :  **if not already exist**  Adds the specified element to this set if it is not already present.
    // hashCode로 값을 정렬하기 때문에 넣은 순서대로 출력 되지 않는다
    set.add("aaa");
    set.add("bbb");
    set.add("ccc");

    // set은 집합의 특성을 따른다
    // => 같은 값을 중복해 넣을 수 없다
    set.add("aaa");// ArrayList에서는 똑같은 내용물을 넣을 수 있었음.
    set.add("bbb");
    // null 은 넣을 수는 있지만, 마찬가지로 중복해서 넣지는 못 함
    set.add(null); 
    set.add(null);

    // Set에 들어 있는 값 꺼내기
    // => HashSet이 상속받은 클래스나 HashSet에는 한 개씩 꺼내는 메서드가 없다
    // => 꺼내주는 객체(iterator)의 도움을 받아야 한다

    // HashSet 이 상속받은 인터페이스 Set은 Iterator<E> 를 상속 받음 
    // Interface Iterator는 hasNext() , next() 메서드를 가지고 있음
    Iterator<String> iterator = set.iterator();

    while(iterator.hasNext()) {   //hasNext() - 꺼낼 값이 있는 동안
      System.out.println(iterator.next());   // next() 꺼내기 : 꺼낼 때 순서대로 뽑을 수는 없음, get이 없으면 순서대로 못 뽑는다
    }

    // 출력 결과를 보면 입력 순서로 꺼낼 수 없다
    // 이유?
    // => 저장할 때 각 인스턴스에 대해 hashCode()의 리턴 값으로 위치를 정하기 때문이다

    System.out.println("==============================");

    Object[] values = set.toArray();
    for (Object value : values) {
      System.out.println(value);
    }

    // 입력한 값의 타입으로 배열을 받고 싶다면?
    // => 파라미터로 넘겨 준 배열이 값을 담을 만큼 크지 않다면, 새 배열 만들어 리턴
    System.out.println("==============================");
    String[] temp = new String[0];
    String[] values2 = set.toArray(new String[0]);
    System.out.println(temp == values2);   //false
    
    for (String value : values2) {
      System.out.println(value);
    }
    
    // 입력한 값의 타입으로 배열을 받고 싶다면?
    // => 파라미터로 넘겨 준 배열이 값을 담을 만큼 충분히 크다면, 새 배열을 리턴하지 않는다
    System.out.println("==============================");
    String[] values3  = new String[set.size()];
    String[] values4 = set.toArray(values3);
    System.out.println(values3 == values4);      //true
    set.toArray(values3);
    for (String value : values3) {
      System.out.println(value);
    }
  }

}
