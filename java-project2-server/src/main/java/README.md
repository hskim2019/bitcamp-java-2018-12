# 54

 31 단계: Tomcat 서버 적용하기
 => 웹 브라우저와의 통신을 전문적으로 담당할 서버를 도입한다
 => ServerApp은 Tomcat에서 호출할 수 있도록 규칙에 따라 변경한다

작업
1) 톰켓 서버 설치
   => tomcat.apache.org 사이트에서 다운로드 받는다
   => ~/server/$톰캣홈
   
2) 자바 웹 프로젝트로 전환
  => build.gradle 변경
  => 'eclipse-wtp' 플러그인과 'war' 플러그인 추가한다
  => 'servlet-api' 라이브러리추가  (providedCompile group)
  => $gradle eclipse 실행
  => 프로젝트 refresh
       - 이클립스 웹 프로젝트 관련 디렉토리와 파일이 추가되었다
       
3) ServerApp 변경
  => Servlet 이라는 규칙에 따라 클래스를 변경한다
  => 이 규칙에 따라 작성해야만 톰캣 서버가 호출해 줄 것이다
  => ServletRequest와 ServletResponse 클래스를 제거한다
 
4) Command 변경
  => ServletRequest와 ServletResponse를
       servlet-api 에서 제공하는 인터페이스로 바꾼다

---------------------------------------------------------------------------------------------------       
5) 자바 웹 배포 파일을 생성한다
  => $gradle build 실행
  (폴더 - build - libs - .war 파일 생성 되었는지 확인해보기)
  
6) 웹 배포 파일을 톰캣 서버에 배치한다
  => $톰캣홈/webapps/ 폴더에 *.war 파일을 둔다
     (생성된 war 파일을 server-톰캣폴더-webapps 폴더에 붙여넣기)
  => 톰캣 서버를 다시 실행한다
       $톰캣홈/bin$ ./shutdown.sh
       $톰캣홈/bin$ ./startup.sh
  => 톰캣 서버를 실행하면 .war 파일이 자동으로 풀리고 서버에 저장된다
--------------------------------------------------------------------------------------------------- 

7) 웹 애플리케이션 실행하기 
   => 예) http://localhost:8080/java-project2-server/board/list

 [웹 애플리케이션 자동 배포하기]
 1) 이클립스에 톰캣 서버 경로를 설정한다
     - Window/Preference 메뉴 클릭
     - Server 노드 선택
     - Runtime Environments 노드 선택
     - OS 에 설치한 톰켓 서버의 경로를 등록
     
  2) 웹 애플리케이션을 테스트 할 때 사용 할 톰캣 배치 폴더 생성
     - 이클립스에서 'Servers' 뷰 선택
     - New/Server 메뉴 선택
     - 이클립스에 등록된 서버 중에서 테스트 환경을 구축할 서버 선택
     - 서버 이름 지정한 후 확인 클릭 (ex. java-project2-server 로 지정함)
     - 이클립스 서버 테스트 환경을 다룰 'Server' 프로젝트가 추가된다
     - 물론 기존에 있다면 테스트 환경을 위한 설정을 담은 폴더만 추가된다
     - 생성된 배치 폴더의 경로는
       이클립스워크스페이스폴더/.metadata/.plugins/org.eclipse.wst.server.core
       
  3) 웹 애플리케이션을 테스트 용으로 만든 배치 폴더에 배포한다
     -'gradle build'를 실행할 필요가 없다
     - 이클립스의 'Servers' 뷰 탭 선택
     - 테스트 서버에 대해 컨텍스트 메뉴 출력 (폴더 선택 후 마우스 오른쪽 버튼 클릭)
     - 'Add and Remove...' 메뉴 선택
     - 배포할 웹 프로젝트를 선택하여 추가한다
     - 외부에서 별도로 톰캣 서버를 실행했다면 종료하라 (bin $./shutdown.sh, tail log 종료)
  4) 테스트 용으로 설정한 톰캣 서버 실행
     - 'Servers' 뷰 선택
     - 테스트 서버에 대해 컨텍스트 메뉴 출력
     - Start/Stop 실행
        -> 수정 후 서버를 실행시키려면 server만 restart, gradle build 하지 않아도 됨
     
    
톰캣폴더-logs - $tail -f catalina.out    =>log 보기
매번 프로젝프 폴더에서 gradle build -> 프로젝프 폴더에 있는 war파일 apache의 webapps



 
 
  

  
  
  