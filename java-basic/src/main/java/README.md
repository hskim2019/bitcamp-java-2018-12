# src/main/java
애플리케이션 관련 자바 패키지 폴더와 소스 파일을 두는 폴더이다.

#변수와 선언
- 리터럴의 타입과 표기법 ......................... ch02 Test01
- 정수 리터럴의 메모리 크기와 표기법 ................ ch02 Test02
- 정수 리터럴의 자릿수 표기법 ...................... ch02 Test03
- 정수 값을 메모리에 저장하는 원리 ................... ch02 Test04
- 부동소수점의 리터럴 메모리 크기와 표기법 ...............ch02 Test05
- 부동소수점이 메모리에 저장되는 원리 ...................ch02 Test06
- 문자 리터럴....................................... ch02 Test07
- 논리 리터럴  ...................................  ch02 Test08
- 문자열 리터럴   ................................ ch02 Test09
- 문자 제어 코드 ex)%d, \n  .........................ch02 Test10
- 콘솔로 출력하기I-데이터 형태에 따라  .................... ch02 Test11
- 콘솔로 출력하기II-문자제어코드 활용                ch02 Test12
- 콘솔로 출력하기III-날짜값 출력하기                ch02 Test13

- 변수 선언과 메모리 크기                        ch03 Test01 - Test04
- 일반 변수와 레퍼런스 변수                       ch03 Test05
- 키보드 입력 받기, System.in과 Scanner          ch03 Test06 - Test10

# 배열
- 배열 다루기                                  ch03 Test11 - Test13
- 인스턴스와 레퍼런스                             ch03 Test14
- 가비지와 가비지 컬렉터                          ch03 Test15

# 연산자
- 산술 연산자, 동일 타입 연산 동일 타입 결과          ch04 Test01 - Test03
- 명시적 형변환과 암시적 형변환                     ch04 Test04
- 연산자 우선순위                                ch04 Test05
- 관계연산자와 등위 연산자                         ch04 Test06
- 부동소수점의 비교 오류                           ch04 Test07
- 전위 연산자와 후위 연산자                        ch04 Test08 - Test09
- 논리 연산자와 비트 연산자                        ch04 Test10 - Test12
- 비트 이동 연산자                               ch04 Test13 - Test16
- 조건 연산자                                   ch04 Test17
- 할당 연산자                                   ch04 Test18

#흐름제어문
- if 조건문                                     ch05 Test01
- if ~else                                    ch05 Test02 - Test03
- switch 문과 break                            ch05 Test04 - Test05
- swtich 문과 enum(기초)                        ch05 Test06
- switch 문에서 break 안 쓰는 경우                ch05 Test07
- while 반복문, break와 continue                ch05 Test08 - Test09
- 중첩 while문                                  ch05 Test10  
- do - while문                                 ch05 Test11
- for문  (배열과의 활용)                          ch05 Test12 - Test15

#메서드
- 메서드형태                                      ch06 Test01
- 메서드와 파라미터/아규먼트                           ch06 Test02
- 메서드의 리턴값                                   ch06 Test03
- 파라미터(매개변수)와 리턴값                          ch06 Test04
- 메서드 중첩호출                                   ch06 Test05
- 가변 파라미터 (로컬변수란)                          ch06 Test06
- 가변 파라미터 vs 배열 레퍼런스                      ch06 Test07
- 가변 파라미터의 단점                              ch06 Test08
- 로컬변수의 생성과 소멸                             ch06 Test09
- 로컬변수와 스택 메모리                             ch06 Test10
- call by value , call by reference             ch06 Test11
- 재귀호출                                        ch06 Test12
- main() 파라미터 - 프로그램 argument                ch06 Test13
- main() 파라미터 응용                              ch06 Test14 - Test15
- JVM 아규먼트                                    ch06 Test16
- JVM 아규먼트 응용                                 ch06 Test17 - Test18

#클래스
- 클래스 사용 전                                   ch07 Test01 - Test02
- 클래스와 인스턴스                                 ch07 Test03 - Test05
- 가비지, 레퍼런스 카운터                            ch07 Test06
- 로컬변수와 인스턴스 필드의 초기화                     ch07 Test07
- 인스턴스 배열                                     ch07 Test08
- 패키지 멤버 클래스와 중첩 클래스                      ch07 Test09
- 패키지 접근 범위(public)                           ch07 Test10 & ch12.c
- import (다른 패키지 클래스 사용하기)                  ch07 Test11

# 클래스2
- 클래스 필드                                        ch08 Test01
- 클래스 로딩, 클래스 필드 생성, Method Area의 관계       ch08 Test02
- 클래스 필드와 인스턴스 필드                           ch08 Test03
- 그 밖의 클래스 멤버들 (클래스 필드, 스테틱 블록, 클래스 메서드) ch08 Test04
- 클래스 필드 공유                                     ch08 Test05
- 클래스 문법의 또 다른 용도 - 클래스 사용 전               (ch08 Test06)
- 클래스 문법의 용도 - 같은 패키지 내 클래스 사용하기          ch08 Test07
- 클래스 문법의 용도 - 다른 패키지 내 클래스 사용하기          ch08 Test08

- 클래스 필드가 필요한 이유 I - 클래스 메서드만 이용           ch09 Test01
- 클래스 필드가 필요한 이유 II  - 클래스 필드+클래스메서드 사용  ch09 Test02
- 클래스 필드의 한계                                     ch09 Test03

- 인스턴스 필드가 필요한 이유                              ch09 Test04
- 인스턴스 필드 - that & static 필드 사용                 ch09 Test05
- 인스턴스 메서드의 등장 - this & 인스턴스 메서드 사용         ch09 Test06
- 클래스 필드와 인스턴스 필드                              ch10 Test01
- 인스턴스 멤버(인스턴스필드, 블록, 생성자,메서드)             ch10 Test02
- 인스턴스 필드의 초기화I,II - 초기화 문장                   ch10 Test03 - Test04
- 인스턴스 필드의 초기화III - 인스턴스 블록                   ch10 Test05
- 인스턴스 필드의 초기화IV - 생성자                          ch10 Test06
- 인스턴스 필드의 초기화V - 초기화 절차                       ch10 Test07

# 생성자
- 생성자를 정의하는 방법 - 기본생성자                         ch10 Test08
- 기본생성자                                             ch10 Test09 - Test10
- 여러개의 생성자                                         ch10 Test11
- 생성자 - 생성자와 this()                                ch10 Test12
- 초기화 블록 - 클래스 로딩과 스테틱 블록 실행 과정 .............ch10 Test13
- 생성자 활용 - String 클래스의 생성자 활용                   ch10 Test14

# String 클래스
- String 클래스 사용법                                    ch11 Test01
- String 상수 pool                                      ch11 Test02
- heap에 있는 스트링 인스턴스를 상수풀에도 만들기               ch11 Test03
- String 인스턴스에 있는 값 비교 - equals()                 ch11 Test04
- immutable 객체 (.replace)                             ch11 Test05
- 기타 메서드 (String.format, String.valueof)             ch11 Test06
- StringBuffer 클래스                                    ch11 Test07
- StringBuffer 클래스 - equals()                         ch11 Test08
- Wrapper 클래스                                         ch11 Test09
- Wrapper 클래스와 오토박싱/오토언박싱                        ch11 Test10
- Wrapper 클래스 생성자                                    ch11 Test11

- 캡슐화가 필요한 이유                                      ch12. a
- 캡슐화 & getter/setter                                 ch12. b

- 클래스 상속이 필요한 이유                                  ch13. a
- 클래스 상속 방법과 기능추가                                ch13. b
- 상속의 의미                                             ch13. c
- 상속 관계에서 인스턴스 생성 과정                             ch13. d
- 상속 관계에서 인스턴스 초기화 과정                           ch13. e
- 상속 관계에서 생성자 호출, 다중상속 불가능                     ch13. f

- 오버라이딩 : 상속 받은 메서드를 서브 클래스의 역할에 맞게 재정의
             다른 클래스에서 상속 받고 나서 같은 이름의 메서드로 재정의 해도 됨
             단, 파라미터 개수와 타입 맞춰야 함
             메서드 호출 시 this와 super로 오버라이딩 전/후 메서드 호출 가능 
- 오버로딩   : 재정의 x, 같은 이름의 메서드지만 파라미터 다르게 추가 가능
- 다형성 - 오버라이딩 하는 이유                               ch14. a
- 오버라이딩 규칙, this와 super 호출 차이                     ch14. b
- 오버로딩 테스트                                           ch14. c
- 오버로딩 규칙                                            ch14. d
- 다형적 변수                                             ch14. e
- 형 변환, 오버라이딩 메서드, 추상 메서드                       ch14. f


 
