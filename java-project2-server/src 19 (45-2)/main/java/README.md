# 45-2
ver 5.4.1 - MyBatis의 SqlSession을 이용하여 DAO 구현체를 자동으로 생성한다.

17단계: Mybatis의 SqlSession을 이용하여 DAO 구현체 자동 생성하기
=> SqlSession에는 DAO 인터페이스 구현체를 자동으로 생성해주는 메서드가 있다
=> 이 기능을 사용하여 DAO 구현체를 생성하여 사용한다
   단점: 자바 코드가 mybatis에 종속되는 문제가 있다
         다른 persistance framwork로 교체하면 전체 코드를 고쳐야 한다

작업:
1) Command 변경
   => Command에 DAO를 직접 주입하는 대신에  SqlSessionFactory를 주입한다
   => DB 작업은 SqlSession으로부터 얻은 DAO 구현체를 사용한다
 
2) DaoFactory 삭제
  => 기존에 사용했던 DAO 구현체 자동 생성기를 제거한다
 
