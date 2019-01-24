// Object 클래스 - getClass() 와 배열
package ch15;

public class Test13 {
  public static void main(String[] args) {
    String obj1 = new String();
    
    // 레퍼런스를 통해서 인스턴스의 클래스 정보를 알아낼 수 있다.
    Class classInfo = obj1.getClass();
    
    // 클래스 정보로부터 다양한 값을 꺼낼 수 있다. 
    System.out.println(classInfo.getName());  //java.lang.string
    
    String[] obj2 = new String[10]; // 레퍼런스 배열
    classInfo = obj2.getClass();
    System.out.println(classInfo.getName()); //[Ljava.lang.String;
    
    int[] obj3 = new int[10];
    classInfo = obj3.getClass();
    System.out.println(classInfo.getName()); //[I
    
    float[] obj4 = new float[10];
    classInfo = obj4.getClass();
    System.out.println(classInfo.getName()); //[F
    
    double[] obj5 = new double[10];
    classInfo = obj5.getClass();
    System.out.println(classInfo.getName()); //[D
    
  }
}
