// 비트이동연산자 >>, >>>, <<  [>>>]
package ch04;

public class Test15 {
  public static void main(String[] args) {
    // >>> 연산자
    // => 오른쪽으로 비트를 이동시킨다. 
    // => 경계를 넘어 가는 값은 버린다. 
    // => 왼쪽 빈자리는 무조건 0으로 채운다.  // 비트부호가 아닌 0으로
    // 양수 비트 이동에서는 >>와 차이가 없다
    int a = 0xca; // =202
    System.out.println(Integer.toHexString(a >>> 4)); //16진수로  0xC
    System.out.println(a >>> 4);  // 10진수로 출력          12
    // 00000000_00000000_000000000_11001010   (int는 8bit 가 4개인 4byte)
    //     0000_00000000_000000000_00001100|1010     //빈자리는 비트부호로채움
    // 00000000_00000000_000000000_00001100        
  
    System.out.println(Integer.toHexString(a >> 3)); // 0x19
    System.out.println(a >>> 3);                      // 25
    
    System.out.println(Integer.toHexString(a >> 2)); // 0x32
    System.out.println(a >>> 2);                      // 50
    
    System.out.println(Integer.toHexString(a >> 1)); // 0x65
    System.out.println(a >>> 1);                       // 101
  
    
    System.out.println("========음수의 이동=========");
    // 음수의 이동
    a = -202;
// 11111111_11111111_11111111_00110110
//  11111111_11111111_11111111_0011011|0  <== 넘어 가는 값은 버린다.
// 01111111_11111111_11111111_10011011    <== 빈자리는 0으로, 즉 음수(1) -> 양수(0)로 바뀜
// 0x7f_ff_ff_9b = 
    System.out.println(a >>> 1); // = -202 / 2**1  
    System.out.println(a >>> 2); // = -202 / 2**2
    System.out.println(a >>> 3);
    System.out.println(a >>> 4);
    System.out.println(Integer.MAX_VALUE);
    
    
    
     }
}
