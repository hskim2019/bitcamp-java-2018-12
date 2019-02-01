// java.util.Set 클래스 사용법 - add(), hashCode(), equals()

// ArrayList는 중복으로 값을 넣을 수 있는데
// set은 집합이라 중복으로 값을 넣을 수 없는데, 같은지는 hashCode와 equals로 판단한다
package ch20.c;

import java.util.HashSet;
import java.util.Iterator;

public class Test03 {

  public static void main(String[] args) {

    class Student {
      String name;
      int age;

      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
      }

      @Override
      public boolean equals(Object obj) {
        if (this == obj)
          return true;
        if (obj == null)
          return false;
        if (getClass() != obj.getClass())
          return false;
        Student other = (Student) obj;
        if (age != other.age)
          return false;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false;
        return true;
      }

      public Student(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
      }
    }



    HashSet<Student> set = new HashSet<>();

    //set에 값 추가하기
    set.add(new Student("aaa", 20));
    set.add(new Student("bbb", 30));
    set.add(new Student("ccc", 40));

    // set은 집합의 특성을 따른다
    // => 같은 값을 중복해 넣을 수 없다
    // => 같은 값인지 판단하는 기준은?
    //       equals()의 리턴 값이 true인지 여부,
    //       hashCode()의 값이 같은지 여부
    // => 현재 Student 로컬 클래스는 equals() 와 hashCode()를 오버라이딩 하였다
    //    따라서 인스턴스는 다르지만 equals()의 결과가 true이고,
    //    hashCode()의 리턴 값도 같기 때문에 중복 저장하지 않는다
    // => HashSet에서 값을 저장할 때 그 위치는 hashCode()의 리턴 값으로 결정한다
    set.add(new Student("aaa", 20));
    set.add(new Student("bbb", 30));;

    // Set에 들어 있는 값 꺼내기
    // => HashSet이 상속받은 클래스나 HashSet에는 한 개씩 꺼내는 메서드가 없다
    // => 꺼내주는 객체(iterator)의 도움을 받아야 한다

    // HashSet 이 상속받은 인터페이스 Set은 Iterator<E> 를 상속 받음 
    // Interface Iterator는 hasNext() , next() 메서드를 가지고 있음
    Iterator<Student> iterator = set.iterator();

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

    // 입력한 값의 타입으로 배영을 받고 싶다면?
    // => 파라미터로 넘겨 준 배열이 값을 담을 만큼 크지 않다면, 새 배열 만들어 리턴
    System.out.println("==============================");
    Student[] values2 = set.toArray(new Student[0]);
    for (Student value : values2) {
      System.out.println(value);
    }

  }



}