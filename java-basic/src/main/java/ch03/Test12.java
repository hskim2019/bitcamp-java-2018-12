// 배열 - 일반 변수를 여러개 사용할 때와 배열을 사용할 때의 차이점
package ch03;

public class Test12 {
  public static void main(String[] args) {

    int a1, a2, a3, a4, a5;
    a1 = 100;
    a2 = 90;
    a3 = 80;
    a4 = 70;
    a5 = 60;

    int sum1 = a1 + a2 + a3 + a4 + a5;

    int [] arr1 = new int[5];

    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;

    //배열 변수에 들어 있는 값의 합계를 구해보자
    int sum2 = 0;
    for (int item : arr1) {
      sum2 = sum2 +item;
      System.out.println(sum2);
    }
    // arr1 배열은 자료형이 int
    // 변수 item을 int형으로 선언해준다
    // arr1의 값인 100, 90, 80, 70, 60을 차례대로 item에 대입
    // sum2 = 0 + 100    -> 100 출력
    // sum2 = 100 + 90   -> 190 출력
    //  ..... 반복 출력

    // for(변수 : 배열)
    //예시
    int arr[] = {1,2,3,4};
    for(int num : arr) {
      System.out.println(num);
    }
    //  arr 배열에 들어 있는 값들을 하나씩 'num'변수에 대입
    //  반복문이 돌 때 마다 'num'값이 변함
    //  1,2,3,4 순서대로 num에 대입 되고
    //  4번 반복하며 num 값을 출력
    //  주의! 배열의 자료형과 for문 변수의 자료형은 같아야 함

  }
}

