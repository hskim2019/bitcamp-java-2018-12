// 정렬 객체를 일관성 있게 사용하려면 같은 타입으로 묶어야 한다.
package ch17.c;

import ch17.c.Sorter;

public class Test01 {

  public static void main(String[] args) {

    int[] values = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};
    int[] values2 = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};
    int[] values3 = {23, 7, 12, 15, 9, 2, 22, 8, 11, 25, 13, 5};

    // 정렬 객체를 사용하는 방법을 통일하면 사용하기가 쉬워진다
    // 어떻게?
    // => 두 클래스를 같은 부모의 자식 클래스가 되게 하라
    // => 같은 부모라는 뜻은 같은 메서드를 갖는다는 의미이다
    // => 즉 메서드가 같으니 사용법도 같다

    // 두 개의 정렬 객체가 같은 타입이기 때문에 사용하기 편하다
    // => 언제든 다른 객체로 교체할 수 있어 유연하다
    display(new BubbleSort(), values);
    display(new QuickSort(), values2);
    
    // 다음을 막을 수 없다
    // => Sorter는 단지 정렬을 수행하는 클래스를 만들 때 일관성 있게 하려고
    //    수퍼 클래스로서 사용하도록 만든 것이다
    // =>  Sorter는 직접 사용하려고 만든 것이 아니다
    // => 이런 문제를 해결하기 우해 등장한 문법이 추상클래스이다
    display(new Sorter(), values3);
  }

  static void display(Sorter sorter, int[] values) {
    
    // 정렬 객체의 클래스가 뭔지 상관없다.
    // 그 클래스를 사용할 때는 공통 분모가 되는 수퍼 클래스의 메서드를 호출한다
    sorter.sort(values);  //여기서의 sort는 호출한 클래스의 sort
    
    // 정렬된 값을 출력한다
    for (int value : values) {
      System.out.print(value + ",");
    }
    System.out.println();
  }
}
