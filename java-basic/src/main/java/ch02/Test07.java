// 문자 리터럴
package ch02;

public class Test07 {
  
  public static void main(String[] args) {
    // '가' 문자를 출력하라
    System.out.println(0xac00); //UTF-16 코드 값을 지정한다
    // 해당 숫자가 UTF-16의 문자 코드임을 알려주지 않으면 println()은 일반 숫자로 인식
    // 숫자 앞에 (char)를 붙여 이 값이 숫자가 아닌 문자의 UTF-16 코드 값임을 알림
    System.out.println((char)0xac00);
    
    // 문자의 코드를 알지 못하면 작은 따옴표(' ') 이용
    // 한글 '가'의 UTF-16 값을 리턴한다. 또한 이 값이 문자의 코드 값임을 알려준다는 의미
    System.out.println('가'); // '가' = (char)0xac00
    
    System.out.println('가' + 2);
    System.out.println((char)('가'+2));
    
    // UTF-16은 2byte크기
    // 코드 값은 0~65535
    // 음수가 없음
    // 숫자 2byte의 범위는 -32768 ~ 32767

    // 작은 따옴표 안에 직접 유니코드(UTF-16)를 표기할 수 있다
    System.out.println('\uac00');
    
    // 작은 따옴표 안에 직접 유니코드를 지정하는 경우 = 특수문자를 출력하고 싶을 때
    // 코드에 해당하는 문자를 콘솔 창에 출력할 때는 콘솔 창에서 사용하는 폰트에서 해당 문자를 찾음
    System.out.println('\u32d4');
  }
}

// 문자를 컴퓨터에 저장하는 방법 = 2진수화시켜서(encoding) 저장
// 문자를 2진수로 변환하는 규칙 = 문자집합 (character set)
// 1) ASCII (7bit)
//    -미국 국가 표준 협회(ANSI)에서 영어 알파벳, 숫자, 특수 문자 등을 컴퓨터에 저장 할 수 있도록
//    7bit 2진수로 정의한 인코딩 규칙 ex) A=0x41, 스페이스(0x20)
//     윈도우 OS에서는 LFCR 두 바이트를 사용하여 줄 바꿈 표시
//     macOS, Linux, Unix 에서는 LF 1바이트만 사용하여 줄 바꿈 표현

// 2) ISO-8859-1(ISO-latin-1)
//     - ASCII문자에 유럽 문자까지 포함하는 국제 표현 문자 인코딩 규칙

// 3) EUC - KR (한글 2560자 + 한자 등 포함) (2byte)
//      - 국제표준
//      - 한글 음절 한 개에 대해 인코딩 규칙을 정의한 완성형 인코딩 규칙이다
//      - 모든 한글 음절을 표현할 수 없다
//      - 가(0xb0a1), 각(0xb0a2), 똘(0xb6ca), 똠(?)

// 4) 조합형 (2byte)
//     - 국제 표준이 아님
//     - 한글(1bit) + 초성(5bit) + 중성(5bit) + 종성(5bit)
//     - 초성 : ㄱ(00010), ㄲ(00011)
//     - 중성 : ㅑ(01010)
//      - ex) 꺅 (1000 1100 1010 0010 = 0x8ca2)

// 5) MS949(=CP949) (2byte)
//     - 윈도우 OS의 인코딩 규칙
//    - EUC-KR + 현재 유통되는 한글 음절 추가 (11172글자 + 한국 전용 한자 + 옛한글 등)
//     - 기존의 EUC-KR 에 문자를 추가했기 때문에 정렬할 때 문제가 발생함
//      - ex) 똘똠똡똥 (b6ca 8c63 bc64 b6cb) 문자를 정렬하면 숫자 크기에 따라 똠똡똘똥으로 나열

// 6) Unicode (2byte) (=UTF-16)
//     - 국제 표준 인코딩 규칙
//     - 영어, 한글 모두 2바이트로 인코딩
//     - 기존의 EUC-KR 과 MS949 코드와 호환되지 않음
//    - MS949의 모든 문자가 포함 되어 있음
//     - 자바 JVM은 내부에서 문자열을 다룰 떄 UTF-16 사용
//      - 즉, 영어, 한글 모두 2 byte 유니코드

// 7) UTF-8 (1~4byte) (Unicode Transformation Format)
//    - Unicode에서 영어권 문자를 그대로 1바이트로 인코딩하기 위해 탄생함
//    - Unicode(UTF16)을 그대로 사용하면, 기존의 OS를 모두 변경해야 한다
//    - 기존의 OS는 ISO-8859-1 규칙에 따라 영어를 다루기 때문
//    - 한,중,일 처럼 2바이트를 사용하는 문자를 다루기 위해 전 세계의 모든 컴퓨터의 운영체제를 바꿀 수 없음
//    - 영어권 PC는 Unicode를 사용하더라도 변경 할 필요가 없도록 UTF8을 만듦
//    - 0000~007F(7bit ASCII) : 이전과 똑같이 1byte로 표현
//    - 0080~07ff : 2바이트로 인코딩
//     - 0800 ~ ffff : 3바이트로 인코딩
//     - 010000 ~ 10ffff : 4바이트로 인코딩
//     - 한글은(ac00~ d7af) 0800~ffff사이에 속함: 3바이트로 변환
//     - UTF-16 '가(0xac00)'를 UTF-8로 인코딩
//          => 1010 1100 0000 0000 (UTF-16)
//            => 11101010 101100 00 1000 0000 (UTF-8)
//            => 0xEAB080
