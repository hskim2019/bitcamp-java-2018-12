// Object 클래스 - getClass() 와 배열의 항목 이름
package ch15;

public class Test14 {
  public static void main(String[] args) {
    String obj1 = new String();
    
    
    
    String[] obj2 = new String[10]; // 레퍼런스 배열
    Class classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); //[Ljava.lang.String;
    
    // 배열 항목의 타입 정보를 가져온다
    Class compTypeInfo = classInfo.getComponentType();
    System.out.println(classInfo.getComponentType());   //class java.lang.String
    
    
    // 값을 한 번 밖에 사용하지 않을 것이라면
    // 위의 경우처럼 한 번씩 호출하고, 리턴 값을 가지고 또 호출하는 방식으로 값을 꺼내지 않는다
    // 체인(chain) 방식으로 호출한다
    System.out.println(obj2.getClass().getComponentType().getName());
  }
}
