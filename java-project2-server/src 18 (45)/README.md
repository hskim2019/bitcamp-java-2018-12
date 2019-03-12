# 45
16단계: DAO 구현체 자동 생성하기
=> java.lang.reflect.Proxy 를 이용해 DAO 인터페이스를 구현한 객체를 자동으로 생성한다

작업:
1) DaoInvocationHandler 생성
   => 실제 DAO 작업을 수행할 InvocationHandler 구현체를 만든다
 
2) ApplicationInitializer 변경
  => 기존에 생성한 DAO 구현체 대신 Proxy.newProxyInstance()가 생성한 DAO 구현체를 사용한다
 
 3) 매퍼파일 변경
   => namespace 이름을 DAO 인터페이스 이름(패키지명 포함)으로 변경한다
   => SQL ID는 반드시 메서드명과 일치시킨다
 
 => Dao 에서 빠진 메서드 작성해준다 ex) increaseCount  
 
 4) DaoFactory 생성
   => DAO 구현체를 생성해주는 역할 수행
   
   
   ***********************************
           <BoardDao>                                
               | 주입   
              /|/
   +--<ApplicationInitializer>--+              +----<DaoFactory> implements InvocationHandler--------------------------------+
   |  대행자                    |              |  SQL 실행                                                                   |
   |  Proxy.newProxyInstance()  |  ------->    |  DAOImpl의 역할:실제로 작업을하는 객체                                      |
   +----------------------------+  invoke()    |  BoardDao인터페이스의 메서드가 실행 될 때 마다 이 invoke()메서드가 실행 됨  | 
                                               +-----------------------------------------------------------------------------+
    