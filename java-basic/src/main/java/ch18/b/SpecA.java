// 인터페이스 정의 - public과 abstract는 생략할 수 있다
package ch18.b;

public interface SpecA {
  
  // 규칙이기에 무조건 public
  // private abstract void m1(); // 컴파일 오류!
  // protected abstract void m1(); // 컴파일 오류!
  // abstract void m1(); // default접근 제어가 아니라 public 생략 한 것이다
  void m1(); // public abstract 생략!
  void m2();
  

}
