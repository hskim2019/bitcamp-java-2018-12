// 메서드 - call by value 와 call by reference
package ch06;

public class Test11 {
  public static void main(String[] args) {
    int value = 100;
    // 1)call by value
    // 메서드를 값을 넘겨서 호출
    // 메서드를 호출할 때 파라미터의 값으로
    // 기본 데이터 타입(byte,short,int,long,float,double,boolean,char)의 값을 넘겨주는 경우 
    // call by value 라고 부른다
    // 변수의 주소가 넘어가는 것이 아니라 변수의 값이 넘어간다
    m1(value);
    System.out.println(value);
    
    // 2) call by reference
    // 메서드를 주소를 넘겨서 호출
    // 메서드를 호출할 때 파라미터 값으로 메모리의 주소를 넘긴다
    int[] arr = new int[] {100, 200, 300};
    System.out.println(arr[1]);
    m2(arr); // arr의 값을 넘긴다. 
             // 그런데 arr의 값은 배열의 주소이다
             // 이렇게 주소를 넘겨주는 것을 call by reference라 부른다
    System.out.println(arr[1]);
  }

// m1()의 value는 값을 받는 변수
// 따라서 main()의 value 변수와 관계가 없다
  static void m1(int value) {
    value *= 2;
  }
  
  //m1의 arr는 배열 주소를 받는 변수
  static void m2(int[] arr) {
    arr[1] = 111;
  }
}//class end
