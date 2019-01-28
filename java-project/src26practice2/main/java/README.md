# src/main/java

[1] Command interface 만들기
    - 규칙을 정한다
    
[2] BoardAddCommand 클래스 만들기 (기존 BoardHandler 복사하여 이용) (Command interface 를 상속)
[3] add에 해당하는 메서드만 남기고, 메서드 이름을 execute()로 변경해준다

[4] BoardListCommand 클래스 만들기 (Command interface 를 상속)
[5] list 에 해당하는 메서드만 남기고, 메서드 이름을 execute()로 변경해준다

=====ArrayList 클래스 이용
      App class에서
[6-1] ArrayList를 클래스를 이용한 boardList라는 객체 준비, 해당 객체에 값을 담음
[6-2] BoardAddCommand, BoardListCommand 생성자 호출
    
[7] 메서드 호출을 아래와 같이 변경 해 준다
    else if (command.equals("/board/add")) {
        boardAddCommand.execute();
  } else if (command.equals("/board/list")) {
        boardListCommand.execute();
  }
  
======HashMap 클래스 이용, key 값

[8-1] HashMap 생성자 호출
[8-2] HashMap의 push() 메서드를 이용해서 key값과, value 값 넣어줌
      [6-2]는 value값으로 합쳐졌으므로 삭제해준다

[9] 조건문 변경
    이런 이름으로 저장 된 command가 없으면 (null) 실행할 수 없는 명령이라고 출력하게 하고
    그 밖에 해당되는 command가 있으면 execute() 실행 될 수 있도록 함
    
[10] 기존에 있던 [7]번에 추가한 if문은 삭제
     
    