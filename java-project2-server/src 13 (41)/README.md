# 41
12단계: 커넥션풀(Flyweight 디자인 패턴)을 이용하여 커넥션 객체를 재활용하기
=> 클라이언트 요청을 처리할 때마다 매번 DB 커넥션을 생성한다면
   DB 커넥션 생성에 비용(실행시간, 메모리)이 많이 든다
=> 해결책?
    DB 커넥션을 생성한 다음에 버리지 말고 보관했다가 다시 사용하는 것이다
    
 작업 :
 1) ConnectionFactory 클래스의 이름을 DataSource로 변경한다
	- 생성된 커넥션들을 관리하도록 코드를 변경한다
	- 커넥션을 반납하는 returnConnection() 메서드를 추가한다
2) DAO 구현체를 변경한다
	- DataSource 객체를 의존 객체로 지정한다
	- 생성자에서 DataSource 객체를 받는다
	- 각 메서드는 DataSource 객체를 통해 커넥션을 받는다
3) ApplicationInitializer 변경
	- DataSource 객체 생성
	- DAO DataSource 객체 주입