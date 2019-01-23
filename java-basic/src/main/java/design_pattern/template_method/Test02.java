// 템플릿 메서드 패턴 + 팩토리 메서드 패턴
package design_pattern.template_method;

public class Test02 {
  public static void main(String[] args) {
    // Unit 객체를 직접 생성하지 않고 UnitFactory 객체를 이용해서 생성
    
    UnitFactory unitFactory = new UnitFactory();
    // 식당 짓기
    Unit u1 = unitFactory.createUnit(UnitFactory.RESTAURANT);
    
    u1.build(); // 수퍼 클래스에서 상속받은 메서드 호출성

    System.out.println("--------------------------");
    // 훈련소 짓기
    Unit u2 = unitFactory.createUnit(UnitFactory.TRAINING_CENTER);
    u2.setType(Unit.GENERAL_BUILDING);
    u2.build();
  }
}
