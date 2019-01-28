// ???? Hashtable에서 Iterator를 얻은 후 값을 변경할 때 
package ch20.d;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class Test08 {

  public static void main(String[] args) {
    class Student {
      String name;
      int age;
      
      public Student(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
      }
    } // 로컬 class end

    
    Hashtable<String, Student> map = new Hashtable<>();
    
    map.put("aaa", new Student("홍길동",20));
    map.put("bbb", new Student("임꺽정",30));
    map.put("ccc", new Student("안중근",25));

    Set<String> keySet = map.keySet();
    
    // Set에서 값을 꺼내기 위해 Iterator의 도움을 받는다
    Iterator<String> iterator = keySet.iterator();
    
    System.out.println(iterator.next());
    System.out.println(iterator.next());
    System.out.println(iterator.next());
    
    System.out.println("---------------------");
    // Iterator를 사용하는 중에 Set의 값을 변경하면
    // 더 이상 Iterator는 유효하지 않게 된다
    // 따라서 다음과 같이 Iterator를 실행하려하면 실행 오류가 발생한다
    // 해결책?
    // => 값을 변경하면 다시 Iterator를 얻어야 한다
    map.put("bba", new Student("bba", 20));
    map.put("bbc", new Student("bbc", 20));
    Iterator<String> iterator2 = keySet.iterator();
    
    System.out.println(iterator2.next());
    System.out.println(iterator2.next());
    System.out.println(iterator2.next());
    System.out.println(iterator2.next());
    System.out.println(iterator2.next());

    
  }// main end

}//class end

/* 
                   HashMap과 Hashtable의 비교
          항목                   HashMap               Hashtable
---------------------------------------------------------------
1) key, value null허용               Yes                    No
2) Thread-safe  지원                 No   (안 막음)          Yes    (multi Thread 가 값을 변경하는 것을 막음)
3) 멀티 스레드 환경에서의 실행 속도       속도 빠름               속도 느림 (막아서 느림)
4) 고수준의 동기화 처리                  No               ConcurrentHashMap 사용을 권장한다  
*/

