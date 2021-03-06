package design_pattern.template_method;

// 이 클래스는 직접 사용할 클래스가 아니다
// => 건물을 짓는데 필요한 "기본 필드"와 "메서드"를 ====> 서브 클래스에게 상속해주는 용도로 사용한다
// => 일부 메서드는 추상 메서드이다 =====> 따라서 이 클래스는 추상 클래스가 되어야 한다 ( 추상 메서드가 있으면 => 클래스도 추상으로 바꿔야)
public abstract class Unit {

  // 건물의 type 값을 지정할 때 직접 숫자를 사용하면 나중에 알아보기 힘들다
  // 유지보수가 쉬우려면 숫자 대신 문자를 사용 하는 것이 낫다  ====> 상수 변수로
  public static final int GENERAL_BUILDING = 0;
  public static final int DEFENSE_BUILDING = 1;
  public static final int ATTACk_BUILDING = 2;

  protected String name;  //서브 클래스에서 사용할 수 있도록 protected로 선언
  protected int area;     //  대신 직접 사용하지 않도록 getter/setter 만들어주기
  protected int type;  //상업용 건물, 주거 건물

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getArea() {
    return area;
  }
  public void setArea(int area) {
    this.area = area;
  }
  public int getType() {
    return type;
  }
  public void setType(int type) {
    this.type = type;
  }
  
  // ***** 기능 줄 것 => 일반 구현 메서드 , 기능은 안 주고 틀만 줄 것이면 => 추상메서드로 & 구현은 서브 클래스에서
  // 수퍼 클래스에서 기본 흐름을 정의한다 => 그래서 build() 메서드는 구현 메서드로 정의한다
  public void build() {
    prepare(); //건물을 지을 땅을 준비한다
    construct(); // 건물 뼈대를 짓는다
    install(); // 배선 및 단열, 외장을 설치한다
    interior(); // 내부 인테리어를 한다
  }
  
  // 유닛의 종류에 따라 건물을 짓는 방식이 다르기 때문에
  // 구체적인 작업 (= 구현)은 서브 클래스에게 맡긴다
  // => 따라서 build()가 호출하는 메서드는 추상 메서드로 선언
  public abstract void prepare();
  public abstract void construct();
  public abstract void install();
  public abstract void interior();

}
