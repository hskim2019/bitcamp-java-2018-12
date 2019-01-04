// 키보드로 입력한 값을 받기 II - 한 줄의 문자열 읽기
package ch03;

public class Test07 {
  public static void main(String[] args) {
    
    // java.io.InputStream in = System.in;
    // java.util.Scanner keyboard = new java.util.Scanner(in);
    // 아래와 같이 합침
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.print("이름을 입력하세요: ");     
    java.lang.String name = keyboard.nextLine();
    
    System.out.print("나이를 입력하세요: ");     
    String age = keyboard.nextLine(); 
    //java.lang 패키지 멤버를 사용할때 패키지 이름을 적지 않아도 됨
    
    // 사용자가 입력한 문자열을 출력한다
    System.out.printf("%s(%s) 입니다.\n", name, age);
  }
}

/*
 키보드에 입력된 데이터를 읽자. 입력 된 것을 in이라고 하자
 입력 된 데이터 in을 적절한 바이트 단위로 바꾸고 이것을 keyboard라고 하자
 사용자가 한 줄 입력 할 때 까지(nextLine) 기다리다가 입력하면 적절한 바이트 단위로 만들어(keyboard) 그것을 str이라고 하자
 str을 출력한다
 */

