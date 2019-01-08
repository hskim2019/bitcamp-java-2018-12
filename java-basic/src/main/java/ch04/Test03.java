// 연산의 결과는 피연산자의 데이터 타입과 같다
package ch04;

public class Test03 {
  public static void main(String[] args) {
    
    //int 와 int의 연산 결과는 int
    float r = 5 / 2;
    System.out.println(r);
    
    // 해결책
    // => 두 개의 정수 값을 제대로 float으로 계산하고 싶으면 형변환을 하라
    // => 형변환 (type conversion)(type casting)? 
    //      :다른 타입의 메모리를 임시로 만들어 값을 넣는 방법
    
    //명시적 형변환
    float r2 = (float)5 / (float)2;
    System.out.println(r2);
    // float 타입의 임시 메모리가 생성된 후 정수 5가 저장된다
    // float 타입의 임시 메모리가 생성된 후 정수 2가 저장된다
    
    //암시적 형변환
    // 타입이 다른 경우 연산을 수행할 수 없다
    // => 반드시 계산을 수행하는 피연산자의 타입이 같아야 함
    //    다르다면 내부적으로 두 피연산자의 값을 같은 타입으로 만든 후에 계산을 수행
    //    개발자가 지시하지 않아도 내부적으로 같은 타입으로 만드는 것
    //    '암시적 형변환(implicit type conversion)
    float f = 5 / (float)2;
    System.out.println(f);
    
    byte b1 = 20;
    byte b2 = 30;
//    byte b3 = b1 + b2;  오류
    int b3 = b1 + b2;
    
    short s1 = 20;
    short s2 = 30;
//    short s3 = s1 + s2;
    int xi = s1 + s2;
    
    int i1 = 100;
    float f1 = 200.5f;
    float i2 = i1 + f1;
    
    float f3 = 9876.543f;
    float f4 = 12.34567f;
    double d1 = f3 +f4;
    System.out.println(d1);//float 과 float의 계산 결과는 float
    //d1에 저장되기 전에 자릿수 7자리를 초과한 값은 오차값으로 저장
    //d1 출력하면 오차가 있는 값이 출력
    
    double d7 = 9876.543;
    double d8 = 12.34567;
    double d9 = d7+ d8;
    System.out.println(d9);
    
//    arr1 = new int[5];
    //암시적 형변환의 규칙
   // byte,short,char => int => long => float => double
    // 예1) byte + short + char - float + long + int + double
    //    (int) + (int) : int 임시 메모리가 생성되고 byte 값이 저장
    //          (int)  + char
    //                (int)   - float
    //                (float) - float
    //                        (float)  + long
    //                        (float)  + (float)
    //                                 (float) + int
    //                                     (float) + double
    //                                                      double
    
    
    
  }
}
