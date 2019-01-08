// 흐름제어문 : switch 문과 enum  (class 배우고 다시 볼 것)
package ch05;

public class Test06 {

  // enum = 상수를 정의하는 문법
static enum UserType {
  MANAGER, MEMBER, GUEST
};

  public static void main(String[] args) {
    UserType type = UserType.MANAGER;

    // switch 의 조건으로 상수를 의미하는 enum 값이 올 수 있다
    switch (type) {
      case MEMBER:
        System.out.println("일반 회원입니다");
      case MANAGER:
        System.out.println("관리자입니다");
        break;
      case GUEST:
        System.out.println("손님입니다");
        break;
       default:
         System.out.println("유효하지 않은 사용자입니다.");
          
    }
  }
}


