// 메서드 - 재귀호출
package ch06;

public class Test12 {
  public static void main(String[] args) {
    // 1 + 2 + 3 + 4 + 5 값을 구하기
    // 1)방법 1 
    int result = sum1(5, sum1(4, sum1(3, sum1(2, sum1(1, 0)))));    // sum(n) = n + sum(n-1)
    System.out.println(result);
    
    // 2) 방법 2
    int result2 = 0;
    result2 = sum1(result2, 1);
    result2 = sum1(result2, 2);
    result2 = sum1(result2, 3);
    result2 = sum1(result2, 4);
    result2 = sum1(result2, 5);
    System.out.println(result2);
    
    // 3) 방법 3 - 재귀호출
    System.out.println(sum2(5));
    // 위의 알고리즘은 다음 수학 공식과 같다
    // sum(n) = n + sum(n-1)
    
  }
  
  static int sum1(int a, int b) {
    return a + b;
  }
  
  static long sum2(long n) {
    if (n == 1)
      return n;
    return n + sum2(n -1); 
    
    //재귀호출!
    // => 그냥 다른 메소드를 호출했다고 생각하기
    // => 메서드가 호출되면? 스택에 그 메서드가 사용할 변수가 생성된다
    // => 재귀호출은 수학 공식을 그대로 표현할 수 있어서 읽기도 쉽고 코딩하기도 쉬움
    // => 그러나 계속 메서드를 호출하기 때문에 메모리를 많이 차지 => 실행 속도 느림 =>  stackoverflowError
    // => 메서드 호출이 깊지 않은 간단한 상황에 재귀호출 적합하다
    
    
    //return에서도 sum2 호출이 가능 & 자기가 자기 자신을 호출
    // main에서 값 5넣음
    // sum2(5) 들어감
    // 5 는 1이 아니므로 return이 실행 됨
    // 5 + sum2(4) + sum2(3) + sum2(2) + 1    (sum2(1)은 그냥 n으로 return되어서 1이 됨)
    // 만들어진 메모리는 지워지면서 return n; 자리에 sum2(2) + 1 인 n = 3 , n = 6, n=10, n=15
  }
  
}//class end
