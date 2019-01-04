package ch03;

public class Test01 {
  public static void main(String[] args) {
    
    // 1byte 정수 값을 담을 메모리 준비
    byte b1;
    byte b2;
    byte b3;
    
    // ** 기본적으로 정수는 4byte로 인식
    b1 = -128; // 리터럴 값이 4바이트 크기지만 메모리에 넣을 수 있다면 허락
    //b2 = 127L; 8 바이트 값은 허락하지 않음. 컴파일 오류
    b2 = 127;
    //b3 = 128; -128~127
        
    // 2byte 정수 값을 담을 메모리 준비
    short s1;
    short s2;
    short s3;
    
    s1 = -32768;
    s2 = 32767;
    //s2 = 300L; 컴파일 오류
        
    // 4byte 정수 값을 담을 메모리 준비
    int i1;
    int i2;
    int i3;
    
    i1 = -2100000000;
    i2 = 2100000000;
    //i3 = 2100000000L; 
    
    // 8byte 정수 값을 담을 메모리 준비
    long l1;
    long l2;
    long l3;
    
    l1 = 9000000000000000000l;
        
    // 4byte 부동소수점을 담을 메모리 준비
    float f1;
    float f2;
            
    f1 = 98765.43f;
    f2 = 987655.43456789f; // 유효 자리수를 넘어가는 경우 뒷자리는 잘려서 저장
                               // 정수 메모리와 달리 컴파일 오류가 발생하지 않음
                               // 오류가 뜨지 않으므로 더욱 주의해서 사용해야 함
   f1 = 9876.543f;
   f2 = 12.34567f;
   
   float f3;
   f3 = f1 + f2;
   
   double d3;
   d3 = f1 + f2; // 기대하는 값 = 9888.88867 / 출력값 = 9888.888671875
   
   System.out.println(f1);
   System.out.println(f2);
   System.out.println(f3);
   System.out.println(d3);
    
    // 8byte 부동소수점을 담을 메모리 준비
    double d1;
    double d2;
        
    d1 = 98765.43;
    d2 = 98765.43456789;
    System.out.println(d1);
    System.out.println(d2);
    
    // 논리 값을 담을 메모리 준비
    boolean bool1;
    boolean bool2;
    boolean bool3;
    
    bool1 = true;
    bool2 = false;
    //bool3 = 1; true, false 외의 값은 저장 할 수 없다
    
    // 문자의 UTF-16 코드 값을 담을 메모리 준비
    char c1;
    char c2;
    char c3;
    
    c1 = 44032; // 4바이트 정수 리터럴이더라도 0~65535까지의 값이면
                  // char 메모리에 저장하는 것을 허락
    c2 = 0xac00;
    c3 = '가'; // ''의 리턴 값은 2byte unicode 값
    System.out.println(c2);
  }
}

/*
#변수
- 값을 저장하는 메모리 

# 변수 선언
- 값을 저장할 메모리의 위치와 크기를 결정하고 그 메모리에 이름을 부여함

# 메모리 종류
1) primitive data type(자바 원시 데이터 타입, 자바 기본 데이터 타입)
- 정수
  -byte (1byte) : 숫자 -128 ~ 127
  -short(2byte) :     -32760 ~  
  -int  (4byte) :     -21억 ~
  -long (8byte) :     -900 경 ~
  
  -부동소수점
    -float (4byte) : 유효자리수 7
    -double (8byte) : 유효자리수 15
  
  -논리
    -boolean (JVA에서 int)
  
  -문자
    -char(2byte) : 0~65535 UTF-16
    
 2) 레퍼런스(reference)
   -객체(데이터 덩어리)의 주소를 저장하는 변수
   -자바 기본 타입을 제외한 나머지 모두
   
  #변수의 이름
  -보통 소문자로 시작
  -대소문자 구분
  -낙타 ex)firstName
  -상수인 경우 대문자로 이름 지음, 단어와 단어 사이는 언더바_ 사용 ex)USER_TYPE
  
*/