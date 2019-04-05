# 서블릿 프로그래밍

## 자바 웹 프로젝트 만들기
- bitcamp-2018-12/java-web 디렉토리 생성
- $gradle init 실행

- java-web/src/main/webapp 디렉토리 생성
- webapp/index.html 생성 및 편집
- build.gralde 파일 편집
    - 'application' 플러그인 제거 및 그와 관계 된 설정 제거
    - 'eclipse-wtp' 'war' 플러그인 추가
    - servlet-api 라이브러리 추가
- 이클립스 IDE 용 설정파일 생성
    - $ gradle eclipse 실행
- 이클립스 IDE로 프로젝트 import..

## 자바 웹 프로젝트 배치와 실행
 - 톰캣 실행 환경 추가
     - 'Servers' 뷰에서 Tomcat 테스트 환경 추가
 - 톰캣 테스트 환경에 java-web 프로젝트 배치
     - 'Servers' 뷰/java-web 테스트 환경을 선택
     - 컨텍스트 메뉴 'Add and Remove...' 선택
     - java-web 프로젝트 추가
 - 톰캣 테스트 환경 실행
     - 테스트 서버에 대해 컨테스트 메뉴에서 Start 실행
     - 이클립스워크스페이스폴더/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/java-web 디렉토리 확인
 - 웹 브라우저에서 톰캣 서버 접속 확인
    - http://localhost:8080/java-web 주소를 입력한 후 결과 확인