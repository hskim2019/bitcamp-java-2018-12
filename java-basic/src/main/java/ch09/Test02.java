// 클래스 필드가 필요한 이유 II  - 클래스 필드+클래스메서드 사용
// 메서드가 사용하는 변수는 그 메서드가 있는 클래스에 두는 것이 좋다
// => 클래스 필드 등장
package ch09;

public class Test02 {

  public static void main(String[] args) {
    // 계산하기
    // => 2 * 3 - 2 + 7 = ?
    
    Calculator2.plus(2);
    Calculator2.multiple(3);
    Calculator2.minus(2);
    Calculator2.plus(7);
    
    System.out.println(Calculator2.result);
    
  }
}
// Calculator2는 계산 결과를 클래스에서 자체적으로 관리하기 때문에 
// 사용하기 편리하다
// 클래스 메서드들이 작업한 결과를 그 클래스에서 관리하면
// 소스 코드 유지보수가 쉽다

