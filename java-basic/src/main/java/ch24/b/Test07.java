// 스레드 우선순위
package ch24.b;

public class Test07 {

  public static void main(String[] args) {

    // 스레드의 우선순위는 1~10까지이다
    // 기본 우선순위는 5이다.

    Thread mainThread = Thread.currentThread();
    System.out.println(mainThread.getPriority());
    
    System.out.printf("우선순위 범위: %s ~ %s\n", mainThread.MIN_PRIORITY, mainThread.MAX_PRIORITY);
  }

}
