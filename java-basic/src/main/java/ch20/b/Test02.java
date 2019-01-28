// Stack 클래스 사용법 - empty()
package ch20.b;

import java.util.Stack;

public class Test02 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();
    
    // push() - 스택의 맨 마지막에 값을 추가한다
    stack.push("1aaa");
    stack.push("2bbb");
    stack.push("3ccc");

    while(!stack.empty()) { //비어있지 않다면 꺼내겠다
      System.out.println(stack.pop());
    }
  }

}
