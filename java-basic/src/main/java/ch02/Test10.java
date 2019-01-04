// 문자 제어 코드
package ch02;

public class Test10 {
  
  public static void main(String[] args) {
    System.out.println("Hello,\nworld"); // 줄바꿈은 이 제어 문자를 사용하라
    System.out.println("Hello,\rworld");
    System.out.println("Hello,\b\b\bworld");// backspace키 눌렀을 때 처럼 뒤로 글자 하나씩 삭제 됨
    System.out.println("Hello,\tworld");
    System.out.println("Hello,\\\\world");
    System.out.println("Hello,\fworld");
    System.out.println("Hello,\"w\"orld");
    System.out.println("Hello,'w'orld");
    System.out.println('\'');
    System.out.println('"');

  }
}

//#문자 제어 코드 = 이스케이프 문자(escape character)
// ASCII
// ex)\n - Line Feed(LF), 0x0a
//    \r - Carriage Return(CR), 0x0d
//    \f - (form feed FF, Unicode \u000c)
//    \t - Tab, 0x09
//    \b - Backspace, 0x08
//    \' - Single quote, 0x27
//    \" - Double quote, 0x22
//    \\ - Backslash, 0x5c
