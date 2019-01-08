// 비트이동연산자 >>, >>>, <<  [<<]
package ch04;

public class Test16 {
  public static void main(String[] args) {
    // << 연산자
    // => 왼쪽으로 비트를 이동시킨다. 
    // => 왼쪽 경계를 넘어 가는 값은 버린다. 
    // => 오른쪽 빈자리는 무조건 0으로 채운다.
    // => n * 2**x 한 것과 같은 결과가 나온다.
    
    int a = 0xc9; // =201
    System.out.println("16진수표기: " + Integer.toHexString(a << 1));
    System.out.println("10진수표기: " + (a << 1));
    //  00000000_00000000_000000000_11001001   
    //0|0000000_00000000_000000000_11001001
    //  0000000_00000000_000000000_110010010 = 192
  
    System.out.println(Integer.toHexString(a << 2)); 
    System.out.println(a << 2);                      
    
    System.out.println(Integer.toHexString(a << 3)); 
    System.out.println(a << 3);                     
    
    System.out.println(Integer.toHexString(a << 4)); 
    System.out.println(a << 4);                     
  
    
    System.out.println("==========음수의 이동===========");
    // 음수의 이동
    // => n * 2**x 한 것과 같은 결과가 나온다.
    // 주의! 음수는 양수로 바뀔 수도 있다
    a = -202; // 11111111_11111111_11111111_00110110
    System.out.println(a << 1); // = -202 / 2**1  
    System.out.println(a << 2); // = -202 / 2**2
    System.out.println(a << 3);
    System.out.println(a << 4);
    System.out.println(Integer.MAX_VALUE);
    
    System.out.println();
    // 음수를 왼쪽으로 이동할 때는 부호비트에 상관없이 무조건 이동
    a = -0x7f_ff_ff_fa; //-2147483642
    // 0111 1111 1111 1111 1111 1111 1111 1010 =  21_4748_3642
    // 1000 0000 0000 0000 0000 0000 0000 0110 = -21_4748_3642
    // 1|0000 0000 0000 0000 0000 0000 0000 1100 = 12
    
    System.out.println(a);
    System.out.println(a << 1);   
    System.out.println(a << 2); 
    System.out.println(a << 3);
    System.out.println(a << 4);
        
    //결론
    // 왼쪽으로 x만큼 비트를 이동시키는 것
    // n * 2**x
    // 오른쪽에 부호비트를 넣을 수 없어서 <<< 연산은 없음
    // 주의!
    // 음수는 양수로 바뀔 수도 있다
    
     }
}
