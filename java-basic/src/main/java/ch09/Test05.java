// 인스턴스 필드의 등장 - that & 스테틱 메서드 사용
package ch09;

public class Test05 {

  public static void main(String[] args) {
    // Calculator3를 사용하여 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 8 = ?
    
    // Calculator3 설계도에 따라 result 변수를 준비한다
    Calculator3 c1 = new Calculator3();
    Calculator3 c2 = new Calculator3();
    //c1, c2는 result변수가 있는 인스턴스 주소(레퍼런스 변수)
    
    Calculator3.plus(c1, 2);
    Calculator3.plus(c2, 6);
    
    Calculator3.multiple(c1, 3);
    Calculator3.divide(c2, 2);
    
    Calculator3.minus(c1, 2);
    Calculator3.plus(c2, 8);
    
    Calculator3.plus(c1, 7);
    
    System.out.println(c1.result);
    System.out.println(c2.result);
    
  }
}

// Calculator1 을 사용할 경우 계산 결과를 직접 관리해야 하기 때문에 불편하다
// 그러나 여러 계산식을 동시에 처리할 수 있는 이점이 있다
// Calculator2를 사용할 경우 계산 결과를 직접 관리하지 않아도 되기 때문에 편하지만
// 그러나 계산 결과를 클래스에서 한 개만 관리하기 때문에 여러 계산식을 동시에 실행할 수 없다

// 클래스에서 여러 결과를 따로 따로 관리하는 방법
// => 인스턴스 필드를 사용하는 것

// result를 인스턴스 필드로 선언하면서 계산 결과를 개별적으로 관리할 수 있다
// 파라미터로 인스턴스 주소를 넘겨 줘야 하는 불편함이 생겼다
// => 인스턴스 메서드 사용하라
