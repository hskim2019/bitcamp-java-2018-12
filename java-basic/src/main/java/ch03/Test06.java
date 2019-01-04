// 키보드로 입력한 값을 받기 I
package ch03;

public class Test06 {
  public static void main(String[] args) {
    // 1) 키보드로 입력한 데이터를 읽을 때 사용할 도구를 준비한다
    java.io.InputStream in = System.in;
    
    // 2) InputStream은 바이트 단위로 읽는 기능이 있다
    //     바이트 단위로 읽어서 int나 문자열로 바꾸려면 또 코딩해야 하는 불편함이 있다
    //     이런 불편함을 줄이기 위해 자바에서는 바이트를 적절한 개발자가 원하는 값으로 바꿔주는 기능을 제공
    //     ex ) 11숫자입력 = int   okok입력 = string
    java.util.Scanner keyboard = new java.util.Scanner(in);
    
    // 사용자에게 입력하라고 간단히 출력하자
    System.out.println("이름을 입력하세요: ");
    
    // 3) Scanner에 들어 있는 nextLine() 
    //     사용자가 한 줄을 입력할 때까지(LF 코드를 읽을 때까지) 기다리다가
    //     한줄을 입력하면 그 값을 문자열로 만들어 리턴
    java.lang.String str = keyboard.nextLine();
    
    // 사용자가 입력한 문자열을 출력한다
    System.out.printf("당신의 이름은 %s 입니다.\n", str);
  }
}

/*
 키보드에 입력된 데이터를 읽자. 입력 된 것을 in이라고 하자
 입력 된 데이터 in을 적절한 바이트 단위로 바꾸고 이것을 keyboard라고 하자
 사용자가 한 줄 입력 할 때 까지(nextLine) 기다리다가 입력하면 적절한 바이트 단위로 만들어(keyboard) 그것을 str에 담자
 str에 '담긴' 값 출력
 */

