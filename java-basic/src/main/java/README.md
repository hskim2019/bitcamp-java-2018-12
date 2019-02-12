# src/main/java
애플리케이션 관련 자바 패키지 폴더와 소스 파일을 두는 폴더이다.

#변수와 선언
- 리터럴의 타입과 표기법                                 ch02 Test01
- 정수 리터럴의 메모리 크기와 표기법                      ch02 Test02
- 정수 리터럴의 자릿수 표기법                             ch02 Test03
- 정수 값을 메모리에 저장하는 원리                        ch02 Test04
- 부동소수점의 리터럴 메모리 크기와 표기법                 ch02 Test05
- 부동소수점이 메모리에 저장되는 원리                      ch02 Test06
- 문자 리터럴                                            ch02 Test07
- 논리 리터럴                                            ch02 Test08
- 문자열 리터럴                                          ch02 Test09
- 문자 제어 코드 ex)%d, \n                          ch02 Test10
- 콘솔로 출력하기I-데이터 형태에 따라                      ch02 Test11
- 콘솔로 출력하기II-문자제어코드 활용                     ch02 Test12
- 콘솔로 출력하기III-날짜값 출력하기                     ch02 Test13

- 변수 선언과 메모리 크기                                 ch03 Test01 - Test04
- 일반 변수와 레퍼런스 변수                               ch03 Test05
- 키보드 입력 받기, System.in과 Scanner              ch03 Test06 - Test10

# 배열
- 배열 다루기                                           ch03 Test11 - Test13
- 인스턴스와 레퍼런스                                    ch03 Test14
- 가비지와 가비지 컬렉터                                 ch03 Test15

# 연산자
- 산술 연산자, 동일 타입 연산 동일 타입 결과              ch04 Test01 - Test03
- 명시적 형변환과 암시적 형변환                           ch04 Test04
- 연산자 우선순위                                        ch04 Test05
- 관계연산자와 등위 연산자                                ch04 Test06
- 부동소수점의 비교 오류                                  ch04 Test07
- 전위 연산자와 후위 연산자                               ch04 Test08 - Test09
- 논리 연산자와 비트 연산자                               ch04 Test10 - Test12
- 비트 이동 연산자                                       ch04 Test13 - Test16
- 조건 연산자                                            ch04 Test17
- 할당 연산자                                            ch04 Test18

#흐름제어문
- if 조건문                                            ch05 Test01
- if ~else                                     ch05 Test02 - Test03
- switch 문과 break                             ch05 Test04 - Test05
- swtich 문과 enum(기초)                         ch05 Test06
- switch 문에서 break 안 쓰는 경우                    ch05 Test07
- while 반복문, break와 continue                 ch05 Test08 - Test09
- 중첩 while문                                         ch05 Test10  
- do - while문                                       ch05 Test11
- for문  (배열과의 활용)                               ch05 Test12 - Test15

#메서드
- 메서드형태                                      ch06 Test01
- 메서드와 파라미터/아규먼트                          ch06 Test02
- 메서드의 리턴값                                   ch06 Test03
- 파라미터(매개변수)와 리턴값                         ch06 Test04
- 메서드 중첩호출                                   ch06 Test05
- 가변 파라미터 (로컬변수란)                          ch06 Test06
- 가변 파라미터 vs 배열 레퍼런스                      ch06 Test07
- 가변 파라미터의 단점                               ch06 Test08
- 로컬변수의 생성과 소멸                              ch06 Test09
- 로컬변수와 스택 메모리                              ch06 Test10
- call by value , call by reference              ch06 Test11
- 재귀호출                                         ch06 Test12
- main() 파라미터 - 프로그램 argument                ch06 Test13
- main() 파라미터 응용                              ch06 Test14 - Test15
- JVM 아규먼트                                     ch06 Test16
- JVM 아규먼트 응용                                 ch06 Test17 - Test18

#클래스 1
- 클래스 사용 전                                    ch07 Test01 - Test02
- 클래스와 인스턴스                                  ch07 Test03 - Test05
- 가비지, 레퍼런스 카운터                             ch07 Test06
- 로컬변수와 인스턴스 필드의 초기화                      ch07 Test07
- 인스턴스 배열                                      ch07 Test08
- 패키지 멤버 클래스와 중첩 클래스                       ch07 Test09
- 패키지 접근 범위(public)                            ch07 Test10 & ch12.c
- import (다른 패키지 클래스 사용하기)                  ch07 Test11

# 클래스2
- 클래스 필드                                           ch08 Test01
- 클래스 로딩, 클래스 필드 생성, Method Area의 관계          ch08 Test02
- 클래스 필드와 인스턴스 필드                               ch08 Test03
- 그 밖의 클래스 멤버들 (클래스 필드, 스테틱 블록, 클래스 메서드) ch08 Test04
- 클래스 필드 공유                                       ch08 Test05
- 클래스 문법의 또 다른 용도 - 클래스 사용 전                 (ch08 Test06)
- 클래스 문법의 용도 - 같은 패키지 내 클래스 사용하기            ch08 Test07
- 클래스 문법의 용도 - 다른 패키지 내 클래스 사용하기            ch08 Test08

- 클래스 필드가 필요한 이유 I - 클래스 메서드만 이용             ch09 Test01
- 클래스 필드가 필요한 이유 II  - 클래스 필드+클래스메서드 사용    ch09 Test02
- 클래스 필드의 한계                                       ch09 Test03

- 인스턴스 필드가 필요한 이유                                ch09 Test04
- 인스턴스 필드 - that & static 필드 사용                   ch09 Test05
- 인스턴스 메서드의 등장 - this & 인스턴스 메서드 사용           ch09 Test06
- 클래스 필드와 인스턴스 필드                                ch10 Test01
- 인스턴스 멤버(인스턴스필드, 블록, 생성자,메서드)               ch10 Test02
- 인스턴스 필드의 초기화I,II - 초기화 문장                    ch10 Test03 - Test04
- 인스턴스 필드의 초기화III - 인스턴스 블록                     ch10 Test05
- 인스턴스 필드의 초기화IV - 생성자                            ch10 Test06
- 인스턴스 필드의 초기화V - 초기화 절차                         ch10 Test07

# 생성자
- 생성자를 정의하는 방법 - 기본생성자                           ch10 Test08
- 기본생성자                                                  ch10 Test09 - Test10
- 여러개의 생성자                                              ch10 Test11
- 생성자 - 생성자와 this()                               ch10 Test12
- 초기화 블록 - 클래스 로딩과 스테틱 블록 실행 과정 .............ch10 Test13
- 생성자 활용 - String 클래스의 생성자 활용                    ch10 Test14

# String 클래스
- String 클래스 사용법                                          ch11 Test01
- String 상수 pool                                       ch11 Test02
- heap에 있는 스트링 인스턴스를 상수풀에도 만들기                 ch11 Test03
- String 인스턴스에 있는 값 비교 - equals()                ch11 Test04
- immutable 객체 (.replace)                                 ch11 Test05
- 기타 메서드 (String.format, String.valueof)              ch11 Test06
- StringBuffer 클래스                                         ch11 Test07
- StringBuffer 클래스 - equals()                          ch11 Test08
- Wrapper 클래스                                              ch11 Test09
- Wrapper 클래스와 오토박싱/오토언박싱                         ch11 Test10
- Wrapper 클래스 생성자                                        ch11 Test11

# 캡슐화
- 캡슐화가 필요한 이유                                              ch12. a
- 캡슐화 & getter/setter                                   ch12. b

# 상속
- 클래스 상속이 필요한 이유                                   ch13. a
- 클래스 상속 방법과 기능추가                                 ch13. b
- 상속의 의미                                               ch13. c
- 상속 관계에서 인스턴스 생성 과정                             ch13. d
- 상속 관계에서 인스턴스 초기화 과정                           ch13. e
- 상속 관계에서 생성자 호출, 다중상속 불가능                    ch13. f
- 상속 - specialization                                    ch13. g
- 상속 - generalization                                    ch13. h - ch13. i
- 상속 - 추상 클래스                                         ch13. j

# 오버라이딩/오버로딩
- 오버라이딩 : 상속 받은 메서드(=이미 있는 메서드)를 서브 클래스의 역할에 맞게 재정의
             단, 파라미터 개수와 타입 맞춰야 함
             메서드 호출 시 this와 super로 오버라이딩 전/후 메서드 호출 가능 
- 오버로딩   : 재정의 x, 같은 이름의 메서드지만 파라미터 다르게 추가 가능

- 다형성 - 오버라이딩 하는 이유                                ch14. a
- 오버라이딩 규칙, this와 super 호출 차이                      ch14. b
- 오버로딩 테스트                                            ch14. c
- 오버로딩 규칙                                              ch14. d
- 다형적 변수                                                ch14. e
- 형 변환, 오버라이딩 메서드, 추상 메서드                       ch14. f

# Object 클래스
- Object 클래스                                              ch15 Test01
- Object 클래스의 - toString() 메서드 / 오버라이딩            ch15 Test02 - Test 03
- Object 클래스의 - equals() 메서드 / 오버라이딩              ch15 Test04 - Test05
- Object 클래스의 - hashCode() 메서드 / 오버라이딩            ch15 Test06 - Test11   
- Object 클래스의 - getClass()                           ch15 Test12
- Object 클래스의 - getClass()와 배열                         ch15 Test13스

# 제네릭
- 제네릭 적용 전                                           ch16 Test01 - Test02
- 제네릭 적용                                              ch16 Test03 - Test04
- 제네릭과 배열                                            ch16 Test05

- 추상 메서드, 추상 클래스, 추상 메서드 상속                    ch17.a
- BubbleSort, QuickSort                             ch17.b , c, d
- 추상 메서드의 효용성                                        ch17. e

# 인터페이스
- 인터페이스 구현 기초                                       ch18. a , b
- 다중 인터페이스 구현                                       ch18. c
- 서브 인터페이스 구현                                       ch18. d
- 인터페이스 특성                                           ch18. e
- 인터페이스와 추상메서드, 필드                               ch18. f
- 인터페이스와 필드 특성과 디폴트메서드                        ch18. g
- 인터페이스 구현하는 추상클래스 상속                         ch18. h

# 클래스 3     
- 클래스 종류 & 중첩 클래스 종류                                   ch19.a
- 상수를 다른 클래스로 분리                                        ch19. b, c, d
- 패키지 멤버 클래스 /  패키지 멤버 클래스                          ch19.e
- LinkedList(안에 Array 클래스)                           ch19.f
- File filter : 중첩클래스->로컬클래스->익명클래스               ch19.g
- 람다문법                                                        ch19.h

# 알고리즘
-ArryList
-LinkedList(Node)
-Queue
-Stack

# 디자인 패턴
-abstract_factory
-iterator ***********
-factory_method
-command pattern
-singleton
-template_method

# ========== 알고리즘 살펴보기  ========== #

# ArrayList
- ArrayList 사용법- 제네릭 설정                        ch20.a Test01
- ArrayList 사용법- add,remove,set,get               ch20.a Test02
- ArrayList 사용법 - contains()                      ch20.a Test03 - Test04
- ArrayList 사용법 - indexOf()                       ch20.a Test05
- LinkedList 사용법 - ArrayList와 같음                 ch20.a Test06

# Stack
- Stack 클래스 사용법 - push() pop()                   ch20.b Test01
- Stack 클래스 사용법 - empty()                        ch20.b Test02
- Stack 클래스 사용법 - peek()                         ch20.b Test03
- Stack 클래스 사용법 - search()                       ch20.b Test04
- stack 클래스 사용법 - 상속받은 클래스에 있는 메서드 사용 get() ch20.b Test05

# HashSet (Set 인터페이스를 구현한 HashSet 클래스)               
- add(), Iterator                                     ch20.c Test01
- add(), hashCode(), equals()                         ch20.c Test02 - Test03

# Map
- put(), get()                                               ch20.d Test01
- HashMap과 Hashtable                                        ch20.d Test02
- HashMap에서 key 목록 꺼내기                                         ch20.d Test03 - Test04
- HashMap에서 key, value함께 꺼내기                                  ch20.d Test05
- HashMap에서 Iterator 사용하기                                      ch20.d Test06
- HashMap에서 Iterator를 얻은 후 값을 변경할 때                       ch20.d Test07
- Hashtable에서 Iterator를 얻은 후 값을 변경할 때 - 실행 오류 발생     ch20.d Test08
- Hashtable에서 value 목록 꺼내기 - elements()                   ch20.d Test09 
- 커스텀 key 사용                                                      ch20.d Test10 - Test11
===============================================================================

#예외
- 예외 종류(시스템 예외, 애플리케이션 예외)와 예외처리 필요한 이유    ch21.a
- 애플리케이션 예외 - finally/멀티catch/통합/catch블록순서       ch21.b
- 예외의 종류, 예외처리 방법, 메서드                                ch21.c
- 예외 던지기 throws                                       ch21.d
- 사용자 정의 예외 & 예외정보 출력                                  ch21.e
- try with resources                                     ch21.f

# File 클래
- File 클래스 -디렉토리 정보 조회                                  ch22.a Test01 - Test02
- File 클래스 -디렉토리 생성                                       ch22.a Test03
- File 클래스 -디렉토리 삭제                                       ch22.a Test04
- File 클래스 -파일 생성                                           ch22.a Test05
- File 클래스 -파일 삭제                                           ch22.a Test06
- File 클래스 -폴더와 파일 동시 생성                                ch22.a Test07                      
- File 클래스 -하위폴더 알아내기                                    ch22.a Test08 - Test09
- File 클래스 -필터사용: 
               TextFileFilter implements FilenameFilter  ch22.a Test10 - Test11
- File 클래스 -디렉토리 이름만 추출                                 ch22.a Test12
- File 클래스 -하위폴더가 있는 디렉토리 삭제                         ch22.a Test13
- File 클래스 -특정폴더에서 특정파일 찾아서 출력하기:
                  ClassFileFilter implements FileFilter   ch22.a Test14
 
#바이너리 데이터 입출력 FileOut/InputStream +
 -FileOutputStream/FileInputStream                        ch22.b Test01
 -배열단위로 출력                                                    ch22.b Test02
 -배열의 특정위치값 출력                                              ch22.b Test03
 
 -+BufferedOutputStrea: 버퍼를 사용하는 이유                        ch22.c Test01 - Test02
 -+DataOutputStream : primitive data type의 값의 출력을 도와주는  ch22.c Test03 - Test04
 - IO Stream 정리                                                    ch22.c Test05
 
 
#텍스트 데이터 입출력 FileWriter / FileReader
- 문자 데이터 입출력                                        ch22.d Test01
- 문자 배열 입출력                                          ch22.d Test02
- String 배열 입출력 + BufferedReader                ch22.d Test03  

# 문자열 섞여있으면 바이너리로 입출력
# FileOutputStream/BufferedOutputStream/DataOutputStream
- 인스턴스 출력
 =>문자열이 섞여있으면 바이너리로 출력                           ch22.e Test01
 - 인스턴스 출력 : 배열 활용                                    ch22.e Test02
 - 인스턴스 출력 : ArrayList 활용                               ch22.e Test03
 - ObjectOutputStream                                          ch22.e Test04
 
 - serialize란 (.writeObject)                                  ch22.f Test01 - Test02
 - serialVersionUID                                            ch22.f Test03
 - Serialize - transient 필드                                  ch22.g
 
 
 #Client/Server
 - 대기열의 제한 확인하기                                        ch23.a.Client2
 - 타임아웃 시간 정하기                                          ch23.a.Client3
 - 대기열에서 클라이언트 연결 정보를 꺼내 처리하기                 ch23.a.Client4
 
 - 데이터 주고 받기                                             ch23.b.Client1
 - 에코 클라이언트/서버                                         ch23.b.Client2
 - 파일 보내는 클라이언트 /파일받는 서버                         ch23.b.Client3
 
 - 계산기 만들기 (내가 만든 것)                                 ch23.c
 - 계산기 만들기 (+리팩토링)                                    ch23.test
 
 - stateless 서버/클라이언트                                    ch23.d.1
 - stateful 서버/클라이언트                                     ch23.d.2
 - statless 응용 - 계산결과 유지                                ch23.e.1
 - stateful 응용 - 계산결과 유지                                ch23.e.2
 
 - Connection-Oriented = Connectionful                         ch23.f.1
 - Connectionless                                              ch23.f.2
 
 - HTTP 클라이언트/서버 만들기                                    ch23.g
 -
 

                            



 
