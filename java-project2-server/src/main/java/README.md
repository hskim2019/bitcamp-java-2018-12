# 39-3 (=src11)
 11단계: 멀티 스레드 상황에서 DB 커넥션을 공유할 때의 문제점과 그 해결책 II
 => 같은 스레드를 통해 DAO 작업을 수행할 때 같은 커넥션 객체 사용하기
 => 어떻게?
 "스레드 로컬(thread local) 변수"를 이용하여 커넥션 객체를 스레드에 보관한다
  DAO가 작업을 할 때 스레드에 보관된 커넥션 객체를 이용한다.
  
  작업:
  1) ConnectionFactory 변경
      => create() 를 호출할 때 먼저 스레드에 저장된 것이 있는지 검사한 후
           있으면 그 커넥션 객체를 리턴하고
           없으면 새 커넥션을 만들어 리턴한다 
           
  2) AbstractCommand 변경
      => execute()에 commit()과 rollback()을 적용한다
  
  3) Command 구현체 변경
     -> connection을 자동으로 닫지 않도록 한다
