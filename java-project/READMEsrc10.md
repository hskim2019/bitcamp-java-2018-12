
# 07 - 클래스로 데이터 타입 정의하기

## 학습 목표

- 클래스를 활용하여 여러 개의 데이터를 한 단위로 묶을 수 있다.
- 클래스와 인스턴스의 관계를 이해한다.
- 인스턴스와 레퍼런스의 관계를 이해한다.
- 레퍼런스 배열을 이해한다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/Lesson.java 추가
- src/main/java/com/eomcs/lms/Member.java 추가
- src/main/java/com/eomcs/lms/Board.java 추가
- src/main/java/com/eomcs/lms/App.java 변경
- src/main/java/com/eomcs/lms/App2.java 변경
- src/main/java/com/eomcs/lms/App3.java 변경

## 실습

### 작업1) `수업` 데이터를 저장할 데이터 타입을 정의하라.

- Lesson.java
    - 수업 데이터를 저장할 새 데이터 타입을 정의한다.
- App.java
    - Lesson 클래스를 사용하여 수업 데이터를 다룬다.

### 작업2) `회원` 데이터를 저장할 데이터 타입을 정의하라.

- Member.java
    - 회원 데이터를 저장할 새 데이터 타입을 정의한다.
- App2.java
    - Member 클래스를 사용하여 회원 데이터를 다룬다.

### 작업3) `게시글` 데이터를 저장할 데이터 타입을 정의하라.

- Board.java
    - 게시글 데이터를 저장할 새 데이터 타입을 정의한다.
- App3.java
    - Board 클래스를 사용하여 게시글 데이터를 다룬다.



 # 08 - 기본 문법의 활용

## 학습 목표

- 변수, 상수, 연산자, 조건문, 반복문, 블록, 배열 등의 문법을 활용할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/App.java 변경
- src/main/java/com/eomcs/lms/App2.java 삭제
- src/main/java/com/eomcs/lms/App3.java 삭제

## 실습

### 작업1) 사용자의 명령에 따라 수업 등록 및 목록 출력을 처리하도록 변경하라.

- App.java (App.java.01)
    - 사용자로부터 명령을 입력 받는 부분을 추가한다.
    - 조건문을 사용하여 명령어 따라 처리를 분기하도록 변경한다.
    - `quit` 명령이 입력 될 때 실행을 종료하게 한다.
    - 일치하는 명령이 없을 경우 안내 메시지를 출력하게 한다.

#### 실행 결과

```
명령>

명령> /lesson/add
번호? 1
수업명? 자바 프로젝트 실습
수업내용? 자바 프로젝트를 통한 자바 언어 활용법 익히기
시작일? 2019-01-02
종료일? 2019-05-28
총수업시간? 1000
일수업시간? 8
저장하였습니다.

명령> /lesson/list
1, 자바 프로젝트 실습     , 2019-01-02 ~ 2019-05-28, 1000
2, 자바 프로그래밍 기초    , 2019-02-01 ~ 2019-02-28,  160
3, 자바 프로그래밍 고급    , 2019-03-02 ~ 2019-03-30,  160

명령> board/view
실행할 수 없는 명령입니다.

명령> quit
안녕!
```

### 작업2) 사용자의 명령에 따라 회원 등록 및 목록 출력을 처리하도록 변경하라.

- App.java (App.java.02)
    - `App2.java` 클래스에 있는 코드를 `App.java` 로 옮긴다.
    - `App2.java` 는 삭제한다.

#### 실행 결과

```
명령> /member/add
번호? 1
이름? 홍길동
이메일? hong@test.com
암호? 1111
사진? hong.png
전화? 1111-2222
저장하였습니다.

명령> /member/list
1, 홍길동 , hong@test.com       , 1111-2222      , 2019-01-01
2, 임꺽정 , lim@test.com        , 1111-2223      , 2019-01-01
3, 전봉준 , jeon@test.com       , 1111-2224      , 2019-01-01
```

### 작업3) 사용자의 명령에 따라 게시물 등록 및 목록 출력을 처리하도록 변경하라.

- App.java
    - `App3.java` 클래스에 있는 코드를 `App.java` 로 옮긴다.
    - `App3.java` 는 삭제한다.

#### 실행 결과

```
명령> /board/add
번호? 1
내용? 게시글입니다.
저장하였습니다.

명령> /board/list
1, 게시글입니다.              , 2019-01-01, 0
2, 두 번째 게시글입니다.        , 2019-01-01, 0
3, 세 번째 게시글입니다.        , 2019-01-01, 0
```

# 09 - 메서드의 존재 이유

## 학습 목표

- 메서드를 활용하여 코드를 기능 단위로 분리할 수 있다.
- 리팩토링의 개념을 이해한다.
- 리팩토링 기법 중에서 '메서드 추출(Extract Method)'이라는 것을 수행할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/App.java 변경

## 실습

### 작업1) 수업 데이터를 처리하는 코드를 메서드로 분리하라.

- App.java (App.java.01)
    - 수업 등록 코드를 addLesson() 메서드로 분리한다.
    - 수업 목록 출력 코드를 listLesson() 메서드로 분리한다.
    - 두 메서드가 공통으로 사용하는 변수를 `클래스 변수`로 전환한다.

### 작업2) 회원 데이터를 처리하는 코드를 메서드로 분리하라.

- App.java (App.java.02)
    - 회원 등록 코드를 addMember() 메서드로 분리한다.
    - 회원 목록 출력 코드를 listMember() 메서드로 분리한다.
    - 두 메서드가 공통으로 사용하는 변수를 `클래스 변수`로 전환한다.


### 작업3) 게시물 데이터를 처리하는 코드를 메서드로 분리하라.

- App.java
    - 게시물 등록 코드를 addBoard() 메서드로 분리한다.
    - 게시물 목록 출력 코드를 listBoard() 메서드로 분리한다.
    - 두 메서드가 공통으로 사용하는 변수를 `클래스 변수`로 전환한다.

### 작업4) 사용자 입력을 처리하는 코드를 메서드로 분리하라.

- App.java
    - 키보드로부터 입력 받는 코드를 prompt() 메서드로 분리한다.





# 10 - 클래스로 메서드를 분류하기

## 학습 목표

- 클래스를 이용하여 관련 메서드를 묶어 관리할 수 있다.
- 리팩토링 기법 중에서 '클래스 추출(Extract Class)'을 수행할 수 있다.

## 실습 소스 및 결과

- src/main/java/com/eomcs/lms/App.java 변경
- src/main/java/com/eomcs/lms/LessonHandler.java 추가
- src/main/java/com/eomcs/lms/MemberHandler.java 추가
- src/main/java/com/eomcs/lms/BoardHandler.java 추가

## 실습

### 작업1) 수업 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- LessonHandler.java
    - 수업 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 수업관리와 관련된 변수와 메서드를 `LessonHandler` 클래스로 옮긴다.
- App.java (App.java.01)
    - `LessonHandler` 클래스 사용한다.


### 작업2) 회원 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- MemberHandler.java
    - 회원 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 회원관리와 관련된 변수와 메서드를 `MemberHandler` 클래스로 옮긴다.
- App.java (App.java.02)
    - `MemberHandler` 클래스 사용한다.


### 작업3) 게시물 데이터 처리와 관련된 메서드를 별도의 클래스로 분리하라.

- BoardHandler.java
    - 게시물 관리와 관련된 메서드를 담을 클래스를 만든다.
    - `App.java` 에서 게시물관리와 관련된 변수와 메서드를 `BoardHandler` 클래스로 옮긴다.
- App.java
    - `BoardHandler` 클래스 사용한다.






# 11 - 패키지로 클래스를 분류하기

## 학습 목표

- 패키지를 이용하여 역할에 따라 클래스를 분류할 수 있다.

## 실습 소스 및 결과

- com.eomcs.lms.handler 패키지 추가
- src/main/java/com/eomcs/lms/handler/LessonHandler.java 변경
- src/main/java/com/eomcs/lms/handler/MemberHandler.java 변경
- src/main/java/com/eomcs/lms/handler/BoardHandler.java 변경
- com.eomcs.lms.domain 패키지 추가
- src/main/java/com/eomcs/lms/domain/Lesson.java 변경
- src/main/java/com/eomcs/lms/domain/Member.java 변경
- src/main/java/com/eomcs/lms/domain/Board.java 변경
- src/main/java/com/eomcs/lms/App.java 변경

## 실습

### 작업1) 데이터 타입 클래스를 별도의 패키지로 분류하라.

- 도메인 패키지 생성
    - `com.eomcs.lms.domain` 패키지 생성
- 도메인 클래스를 `domain` 패키지로 이동
    - `Lesson`, `Member`, `Board` 클래스를 `com.eomcs.lms.domain` 패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- 핸들러 클래스에 import 문 추가
    - `LessonHandler`, `MemberHandler`, `BoardHandler` 클래스를 변경한다.


### 작업2) 사용자 명령을 처리하는 클래스를 별도의 패키지로 분류하라.

- 핸들러 패키지 생성
    - `com.eomcs.lms.handler` 패키지 생성
- 핸들러 클래스를 `handler` 패키지로 이동
    - `LessonHandler`, `MemberHandler`, `BoardHandler` 클래스를 `com.eomcs.lms.handler` 패키지로 옮긴다.
    - 다른 패키지에서 변수에 접근할 수 있도록 접근 제어를 `public` 으로 변경
- App.java 변경
    - 핸들러 클래스에 대해 import 문 추가

