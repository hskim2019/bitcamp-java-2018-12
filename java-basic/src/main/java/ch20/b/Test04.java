// Stack 클래스 사용법 - search()
package ch20.b;

import java.util.Stack;

public class Test04 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다
    stack.push("1aaa");
    stack.push("2bbb");
    stack.push("3ccc");
//    stack.push("4ddd");

    // search() - 맨 위에서부터 해당 값을 찾는다. 1부터 시작한다
    System.out.println(stack.search(new String("3ccc"))); // 1번째
    System.out.println(stack.search(new String("2bbb")));  // 2번째
    System.out.println(stack.search(new String("1aaa")));  // 3번째
    System.out.println(stack.search(new String("xxx"))); // 없으면 -1

  }

}
