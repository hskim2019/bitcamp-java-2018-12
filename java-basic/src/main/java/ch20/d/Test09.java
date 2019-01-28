// Hashtable에서 value 목록 꺼내기 - elements()
package ch20.d;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class Test09 {

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
    
    Student s = new Student("안중근", 25);
    map.put("ccc",s);
    map.put("ddd",s);

    // value 목록 꺼내기
    Enumeration<Student> values = map.elements();
    while (values.hasMoreElements()) {
      System.out.println(values.nextElement());
    }
    // for문은 java.util.collection에서 가능
    
    
  }// main end

}//class end

/*
                       List 와  Set 과 Map
 항목                       List               Set                                       Map
 1) 중복 저장               가능               불가능                               key는 불가능, value는 중복 가능        
 2) null 허용 여부          가능               가능(중복 때문에 한 개만 가능)           HashMap(key/value둘 다null값으로 가능), Hashtable(불가능)

 */
