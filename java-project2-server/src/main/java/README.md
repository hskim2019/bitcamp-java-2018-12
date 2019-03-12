# 45
16단계: DAO 구현체 자동 생성하기
=> java.lang.reflect.Proxy 를 이용해 DAO 인터페이스를 구현한 객체를 자동으로 생성한다

작업:
1) DaoInvocationHandler 생성
   => 실제 DAO 작업을 수행할 InvocationHandler 구현체를 만든다