// 키보드로 입력한 값을 받기 V
package ch03;

public class Test10 {
  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.print("나이? ");     
    int age = keyboard.nextInt();
  
    System.out.print("이름? ");     
    String name = keyboard.next();
    // next() 는 토큰 단위로 문자열을 읽는다.
    // nextLine() enter를 만날 때 까지
    // nextInt() 를 호출한 후 엔터코드LF가 남아 있더라도 next()는 공백을 버리기 때문에 영향을 받지 않음
    // keyboard에서 바로 입력 받는 것이 아니라 keyboard -> 버퍼 -> 읽기
    // nextInt() 버퍼에서 int값만 가져가면 버퍼에 LF남아있음
        
    System.out.printf("%d(%s)\n", age, name);
  }
}

