// String 클래스 사용법 - String 인스턴스에 있는 값을 비교하기 : equals()
package ch11;

public class Test04 {
  public static void main(String[] args) {
    String s1 = new String("Hello"); // 힙에 생성된다
    String s2 = new String("Hello");
   

    if(s1 ==s2) // 인스턴스가 같은지 비교
      System.out.println("s1 == s2");
    else
      System.out.println("s1 != s2");
    
    if(s1.equals(s2))  // 인스턴스에 있는 문자열이 같은지 비교
      System.out.println("s1 == s2");
    else
      System.out.println("s1 != s2");
    
    String s3 = "hello";
    String s4 = "HELLO";
    
    if(s3.equals(s4))
      System.out.println("s3 == s4");
    else
      System.out.println("s3 != s4");
    
    if(s3.equalsIgnoreCase(s4))
      System.out.println("s3 == s4");

  }
}

