// try-with-resources 문법 : 사용 후
package ch21.f;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class Test02 {

  public static void main(String[] args) { 
    // 자바에서는 자원 해제를 자동화시키는 try~ catch 문법을 제공한다
    // 개발자가 finally에서 자원을 해제시키는 코드를 작성할 필요가 없다
    // 단, java.lang.AutoCloseable 구현체인 경우에만 해당한다
    // 사용법
    //      try (java.lang.AutoCloseable 구현체의 변수를 선언) {
    //                    ......
    //     } catch (...) {
    //                    .....
    //     }


    try(Scanner keyboard = new Scanner(System.in)) {  // scanner를 알아서 해제해라
      System.out.print("값? ");
      int a = Integer.parseInt(keyboard.nextLine());
      int result = sum(a);
      System.out.println(result);

    } catch (Exception e) {

      try (
          StringWriter out = new StringWriter();
          PrintWriter out2 = new PrintWriter(out);
          ) {     
        e.printStackTrace(out2);

        String str = out.toString();
        System.out.println(str);
      }  catch (Exception e2) {
      }

      // StringWriter 객체에 저장된 문자열 꺼내기

    } finally {
      // try-with-resources 문법을 사용하면
      // JVM이 try() 에 선언한 레퍼런스에 대해 try 블록을 벗어나기 전에 close()를 자동 호출하기 때문에 개발자가 직접 close() 호출하는 코드를 작성할 필요가 없다
      // keyboard.close();

    }
  }

  static int sum(int value) { // f(n) = n + f(n-1)
    if(value == 0)
      return 1;
    return value + sum(value - 1);
  }

}


