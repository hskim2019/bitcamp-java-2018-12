// Stack 클래스 사용법 - search() + get()
//empty()   peek()  pop()   push​(E item) search​(Object o)

// stack 의 상속관계 - 상속받은 클래스의 메서드도 사용 할 수 있음
//java.lang.Object
    //java.util.AbstractCollection<E>
        //java.util.AbstractList<E>
               //java.util.Vector<E>
                    //java.util.Stack<E>

package ch20.b;

import java.util.Stack;

public class Test05 {

  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    // push() - 스택의 맨 마지막에 값을 추가한다
    stack.push("1aaa");
    stack.push("2bbb");
    stack.push("3ccc");

    // 거꾸로 뽑아내는 것 가능
    for (int i = 0; i < stack.size(); i++) {
      System.out.println(stack.get(i));
    }

  }

}
