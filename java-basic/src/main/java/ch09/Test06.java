// 인스턴스 메서드의 등장 - this & 인스턴스 메서드 사용
// Test05와 같이 일일히 파라미터 값 넣어주는 것은 번거로움
// 인스턴스 메서드는 인스턴스 주소를 파라미터로 넘겨주는 것이 아니라
// 메서드를 호출하는 코드 앞에 둔다
// 메서드가 사용할 인스턴스 주소를 파라미터가 아닌 메서드 호출 앞에 둔다
// 인스턴스 주소를 넘기기 쉽다

package ch09;

public class Test06 {

  public static void main(String[] args) {
    // Calculator3를 사용하여 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 8 = ?
    
    Calculator4 c1 = new Calculator4();
    Calculator4 c2 = new Calculator4();
    
    
    c1.plus(2);
    c2.plus(6);
    
    c1.multiple(3);
    c2.divide(2);
    
    c1.minus(2);
    c2.plus(8);
    
    c1.plus(7);
    
    System.out.println(c1.result);
    System.out.println(c2.result);
    
//    Calculator4.plus(3); 컴파일 오류! 인스턴스 메서드는 인스턴스 주소 없이 호출 못 함
//    Calculator4 c3 = null;
//    c3.plus(3); // 런타임 오류 인스턴스 주소가 없기 때문
  }
}
//Calculator1 을 사용할 경우 계산 결과를 직접 관리해야 하기 때문에 불편하다
//그러나 여러 계산식을 동시에 처리할 수 있는 이점이 있다
//Calculator2를 사용할 경우 계산 결과를 직접 관리하지 않아도 되기 때문에 편하지만
//그러나 계산 결과를 클래스에서 한 개만 관리하기 때문에 여러 계산식을 동시에 실행할 수 없다

//클래스에서 여러 결과를 따로 따로 관리하는 방법
//=> 인스턴스 필드를 사용하는 것

//result를 인스턴스 필드로 선언하면서 계산 결과를 개별적으로 관리할 수 있다
//파라미터로 인스턴스 주소를 넘겨 줘야 하는 불편함이 생겼다
//=> 인스턴스 메서드 사용하라