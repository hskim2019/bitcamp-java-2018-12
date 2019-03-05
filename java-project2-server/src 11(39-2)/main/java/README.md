 #39-2 (=src10)
 10단계: 멀티 스레드 상황에서 DB커넥션을 공유할 때의 문제점과 그 해결책

 [멀티 스레드에서 DB커넥션 공유할 때의 문제점 확인하기]
 1) 클라이언트1
      - /photoboard/add 를 실행한다
       - 사진 제목은 'aaaa', 수업은 101로 입력
       - 사진 파일은 a.gif, b.gif를 입력한다. 그리고 파일 입력을 잠시 멈춘다.
      - mysql 클라이언트 프로그램을 이용하여 commit이 수행되기 전 상태를 확인한다
       - 그리고 파일 입력을 잠시 멈춘다
 2) 클라이언트2
     - /board/add 를 실행
      - mysql 클라이언트 프로그램을 이용하여 lms_board에 입력된 것을 확인한다
       - 또한 lms_photo와 lms_photo_file 테이블도 확인한다
       - "클라이언트1"이 insert한 데이터도 들어가 있다
       - 왜? 클라이언트1과 클라이언트2의 요청을 처리할 때 사용하는 DB 커넥션이 같기 때문이다
 3) 클라이언트1
        - 파일명을 255가 넘어가게 입력한다
        - 예외가 발생하면 rollback() 할 것이다
        - 그러나 이미 이전에 insert 한 작업들이 클라이언트2가 commit하면서 테이블에 저장되었기 때문에
           rollback 할 수 없다
        - 이것이 멀티 스레드에서 DB 커넥션을 공유할 때의 문제점이다

 [해결책1]
 => DAO가 작업할 때 매번 새 커넥션을 사용한다
 => Connection 팩토리를 사용하여 커넥션 객체를 준비한다 

 작업:
 1) DB 커넥션 팩토리 객체를 생성한다
    => com.eomcs.util.ConnectionFactory 클래스를 준비한다
 2) DAO 구현체 변경
    => 작업을 수행할 때마다 ConnectionFactory에서 새 Connection을 얻은 다음에 작업을 수행한다
    => BoardDao, LessonDao, MemberDao, PhotoBoardDao, PhotoFileDao 구현체 변경
 3) ApplicationInitializer 변경
    => DB 커넥션은 DAO에서 ConnectionFactory를 통해 얻기 때문에
        이 클래스에서는 더이상 DB 커넥션 객체를 관리하지 않는다
    => 또한 DAO 객체를 생성할 때 생성자에 파라미터 값으로 커넥션 객체를 넘겨주지 않는다
 4) AbstractCommand 변경
    => execute() 호출이 완료되었을 때 commit() 또는 rollback()을 호출하지 않는다
        DAO가 사용하는 커넥션 객체를 모르기 때문에 사실상 commit(), rollback()을 호출할 수 없다

[이 방식의 문제점]
=> DAO에서 메서드가 호출될 때 새 커넥션을 사용하게 되면
   트랜잭션 관리가 불가능하다
   다음 절차에 따라 확인해 보라
실습:
1) /board/add 실행한다
2) /board/list를 실행하여 입력된 결과를 확인한다
3) /photoboard/add 실행한다
4) /photoboard/list 실행하여 입력된 결과를 확인한다
5) /photoboard/add 실행한다
    =>이 때 첨부파일 두 개를 입력한 후, 세 번째 입력할 때 예외가 발생하도록
      긴 이름의 파일명을 입력한다
    => 예외가 발생했다는 메세지를 받을 것이다
6) /photoboard/list 실행한다
   => 예외가 발생하기 전까지 입력했던 데이터가 그대로 DB에 보관된 것을 확인할 수 있다
   => 즉 트랜잭션을 다룰 수 없었기 때문이다