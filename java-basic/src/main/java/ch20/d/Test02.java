// Map 클래스 사용법 - HashMap과 Hashtable
package ch20.d;

import java.util.HashMap;
import java.util.Hashtable;

public class Test02 {

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

    
    HashMap<String, Student> map = new HashMap<>();
    Hashtable<String, Student> table = new Hashtable<>();
    
    // HashMap과 Hashtable은 기본 사용법이 같다
    map.put("aaa", new Student("홍길동",20));
    table.put("aaa", new Student("홍길동",20));
    
    System.out.println(map.get("aaa"));
    System.out.println(table.get("aaa"));
    
    // 다른 점 - HashMap은 key를 null로도 사용 가능한데, Hashtable은 key로 null을 사용할 수 없다
    //          value 자리에 null 허용,                           value 자리에 null 허용 안 함
    map.put(null, new Student("임꺽정", 30));
    System.out.println(map.get(null));
    
//    table.put(null, new Student("임꺽정", 30));
//    System.out.println(table.get(null));
    
    System.out.println("------------------------------");
    map.put("ccc", null);
    System.out.println(map.get("ccc"));
    
//    table.put("ccc", null);
//    System.out.println(table.get("ccc"));
    
  }// main end

}//class end
