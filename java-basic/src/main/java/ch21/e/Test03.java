// 예외 정보 출력하기 II
package ch21.e;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Test03 {

  public static void main(String[] args) throws Exception { 
    Scanner keyboard = null;

    try {
      keyboard = new Scanner(System.in);
      System.out.print("값? ");
      int a = Integer.parseInt(keyboard.nextLine());

      int result = sum(a);
      System.out.println(result);
    } catch (Exception e) {
      FileWriter out = new FileWriter("test03-2019-01-30.log");
      PrintWriter out2 = new PrintWriter(out);   //PrintStream 이 println() 등의 메서드로 콘솔창에 출력하게 한다면
                                                 //PrintWriter는 FileWriter로 만든 외부 파일에 출력하게 해주는 메서드
      
      // 외부 파일에 출력하기
      e.printStackTrace(out2);
      out2.close();
      out.close();
    } finally {
      keyboard.close();
      
    }
  }

  static int sum(int value) { // f(n) = n + f(n-1)
    if(value == 0)
      return 1;
    return value + sum(value - 1);
  }

}

