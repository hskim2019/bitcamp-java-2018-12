// java.util.ArrayList 사용법 - contains()
package ch20.a;

import java.util.ArrayList;

public class Test03 {

  public static void main(String[] args) {

    String s1 = new String("aaa");
    String s2 = new String("bbb");
    String s3 = new String("ccc");
    
    String s4 = new String("bbb");
    
    System.out.println(s2 == s4);    //인스턴스는 다르지만
    System.out.println(s2.equals(s4));  // 내용물은 같다
    System.out.println(s2.hashCode() == s4.hashCode());  // true
    
    ArrayList<String> list = new ArrayList<>();
    
    list.add(s1);
    list.add(s2);
    list.add(s3);
    
    System.out.println(list);
    
    // contains()
    // 인스턴스가 다르더라도 equals()의 리턴 값이 true이고 hashCode()의 리턴 값이 같다면
    // 목록에 있는 것으로 판단한다
    System.out.println(list.contains(s2));  // list 가 s2를 포함하고 있는지 물어보자
    System.out.println(list.contains(s4));  

  }
}
