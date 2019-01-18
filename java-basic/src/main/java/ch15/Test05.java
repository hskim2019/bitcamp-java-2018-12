// Object 클래스 - equals() 오버라이딩

// 결론!
// => Object에서 상속 받은 것을 그대로 사용하면 equals()는 인스턴스가 같은지 비교한다
// => 인스턴스의 내용물이 같은지 비교하도록 만드록 싶다면 equals()를 오버라이딩 하라
// => String 과 wrapper 클래스들은 equals()를 오버라이딩 하였다. 그래서 단순히 String 을 비교할 때는 equals()
// => StringBuffer 클래스는 equals() 를 오버라이딩 하지 않았다
// 오버라이딩 하지 않았다는 것은 equals()는 인스턴스가 같은지를 비교하는 것, 내용물 비교는 못 함
package ch15;

class My5 {
  String name;
  int age;

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    My5 other = (My5) obj;
    if (age != other.age)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
  
//  @Override
//  public boolean equals(Object obj) {
//    if (obj == null || !(obj instanceof My5))
//      return false;
//    
//    My5 other = (My5) obj;
//    
//    if (!other.name.equals(this.name))
//      return false;
//    
//    if (other.age != this.age)
//      return false;
//    
//    return true;
//  }
  
}
public class Test05 {

  public static void main(String[] args) {

    My5 obj1 = new My5();
    obj1.name = "홍길동";
    obj1.age = 20;

    My5 obj2 = new My5();
    obj2.name = "홍길동";
    obj2.age = 20;
  
    System.out.println(obj1 == obj2);
    
    // Object에서 상속 받은 equals() 는 인스턴스가 같은지 비교한다
    // 만약 내용물이 같은지 비교하고 싶다면 equals()를 재정의
    System.out.println(obj1.equals(obj2));
  }

}
