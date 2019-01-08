// 비트이동연산자 >>, >>>, <<  [ >> ]
package ch04;

public class Test14 {
  public static void main(String[] args) {
    // >>  오른쪽으로 비트를 이동시킨다. 
    //     왼쪽 빈자리는 부호비트로 채운다, 양수는 0, 음수는 1
    int a = 0xca; // =202
    System.out.println(Integer.toHexString(a >> 4)); //16진수로  0xC
    System.out.println(a >> 4);  // 10진수로 출력          12
    // 00000000_00000000_000000000_11001010   (int는 8bit 가 4개인 4byte)
    //     0000_00000000_000000000_00001100|1010     //빈자리는 비트부호로채움
    // 00000000_00000000_000000000_00001100        
  
    System.out.println(Integer.toHexString(a >> 3)); // 0x19
    System.out.println(a >> 3);                      // 25
    
    System.out.println(Integer.toHexString(a >> 2)); // 0x32
    System.out.println(a >> 2);                      // 50
    
    System.out.println(Integer.toHexString(a >> 1)); // 0x65
    System.out.println(a >> 1);                       // 101
    
    // 오른쪽 비트 이동의 효과
    // 1비트 이동할 때 마다 2로 나누는 효과가 있다   202, 101, 50, 25, 12
    // 예) n에 대해 x비트를 오른쪽으로 이동 = n / 2**x (2의 x승)
    // 나누기 연산보다 계산 속도가 빠름
    // ex)int newCapacity = oldCapacity + (oldCapacity >> 1);
    
    // 음수의 이동
    // =>2의 n승으로 나눈 것과 같다
    // => 소수점 이하는 반올림
    System.out.println("========음수의 이동==========");
    
    a = -202; 
    // 11111111_11111111_11111111_00110110 = 0xff_ff_ff_36
    //  11111111_11111111_11111111_0011011|0  <== 넘어 가는 값은 버린다.
    // 11111111_11111111_11111111_10011011    <== 빈자리는 부호비트로 채운다.
    // 0xff_ff_ff_9b = -101
    System.out.println(a >> 1); // = -202 / 2**1  
    System.out.println(a >> 2); // = -202 / 2**2 
    
     }
}
