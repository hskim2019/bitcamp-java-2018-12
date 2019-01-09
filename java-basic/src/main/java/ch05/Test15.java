// 흐름제어문:  for 반복문 IV
package ch05;

public class Test15 {
  
  public static void main(String[] args) {
    String[] names = {"홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"};
    
    // 배열을 처음부터 끝까지 반복할 때는 다음의 for문 사용이 편리
    for (String i : names) {
      System.out.print(i + " ");
    }
    // names 배열은 String 형이므로 String i라고 배열값 받을 변수 선언
    // i 에는 배열 값 하나씩 대입 되어 출력 됨
    
    System.out.println();

    //컬렉션 객체 사용
    java.util.ArrayList<String> list = new java.util.ArrayList<>();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    
    for (String name : list) {
      System.out.print(name + " ");
    }
    System.out.println();

  } // main method end
} // class end

/* for (:)
 * - 배열 전체를 반복하거나 컬렉션 객체 전체를 반복할 때 유용하다
 * - 배열의 일부만 반복할 수 있다
 * - 배열의 값을 다룰 때 인덱스를 사용할 필요가 없어 편리하다
 * - 배열의 범위는 조정 못하고 처음부터 끝까지 출력만 가능
 * 
 * for (배열의 항목값을 담을 변수 선언 : 배열, Collection 객체 등)
 *   문장1;
 */
