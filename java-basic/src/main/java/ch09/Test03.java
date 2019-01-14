// 클래스 필드의 한계
package ch09;

public class Test03 {

  public static void main(String[] args) {
    // 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 8 = ?
    
    // Calculator2의 result변수는 오직 한 개만 존재
    // 두 개의 계산식을 동시에 수행할 수 없다
    // Calculator1은 호출하는 쪽에서 결과를 관리해서 가능
    Calculator2.plus(2);   // 식1
    Calculator2.plus(6);   // 식2
    
    Calculator2.multiple(3); // 식1
    Calculator2.divide(2);   // 식2
    
    Calculator2.minus(2);     //식1
    Calculator2.plus(8);      //식2
    
    Calculator2.plus(7);     //식1
    
    System.out.println(Calculator2.result);
    
  }
}
// Calculator2는 계산 결과를 클래스에서 자체적으로 관리하기 때문에 
// 사용하기 편리하다
// 클래스 메서드들이 작업한 결과를 그 클래스에서 관리하면
// 소스 코드 유지보수가 쉽다

