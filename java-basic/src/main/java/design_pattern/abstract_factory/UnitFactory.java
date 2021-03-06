package design_pattern.abstract_factory;

// 추상 팩토리 = 팩토리의 사용 규칙만 정의한다
// => 생산 방식은 같지만 주제에 따라 생산품은 달라진다
// => 생산 방식이 같으려면 메서드의 사용법이 같아야 한다
//     그래서 인터페이스로 팩토리 사용 규칙을 정의하는 것
public interface UnitFactory {

  // 인터페이스의 필드는 모두 public static final이다
  final int RESTAURANT = 1;
  public static final int TRAINING_CENTER = 2;

  //공장 객체의 사용 규칙
  // => 유닛을 생성하고 싶다면 createUnit()을 호출하라!
  // => 사용 규칙은 메서드 시그너처만 선언. 구현하지 않는다
  // => 규칙이기에 무조건 public으로 공개
  // => 추상 메서드
  Unit createUnit(int building); 
}
