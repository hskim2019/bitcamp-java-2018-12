// Object 클래스 - hashCode() 오버라이딩

package ch15;

// Map에 값을 저장하는 key로 사용할 때 hashCode()를 오버라이딩 하라
// 보통 값이 같은지 비교할 때 equals() 와 함께 사용된다
// 그래서 hashCode()를 오버라이딩 할 때 equals()도 함께 오버라이딩한다
// ##### 해시코드 오버라이딩 하면 => 데이터가 같으면 같은 해시값을 가지게 함#####

class My7 {
  String name;
  int age;
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    My6 other = (My6) obj;
    if (age != other.age)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    return true;
  }
}
public class Test07 {

  public static void main(String[] args) {

    My7 obj1 = new My7();
    obj1.name = "홍길동";
    obj1.age = 20;

    My7 obj2 = new My7();
    obj2.name = "홍길동";
    obj2.age = 20;
  
    System.out.println(obj1 == obj2);
    
    System.out.println(Integer.toHexString(obj1.hashCode()));
    System.out.println(Integer.toHexString(obj2.hashCode()));
    
    System.out.println(obj1);
    System.out.println(obj2);
    
    // hash value?
    // - 데이터를 다른 데이터와 구분하기 위해 사용하는 특별한 정수값이다
    // - 특정 수학 공식에 다라 값을 계산한다
    // - 데이터가 같은지 비교할 때 사용한다
    // - 즉 모든 데이터를 일일이 비교하는 대신에 미리 생성된 정수 값을 비교함으로써
    //   빠르게 두 값이 같은지 알아낼 수 있다
    // - 매우 낮은 확률이지만 데이터가 다르더라도 같은 정수 값이 나올 수 있다
    //   특별한 계산 공식을 통해 4바이트 정수 값으로 표현한다는 것은
    //   언제든 다른 데이터에 대해 같은 값이 나올 수 있다
    //   다만 확률이 얼마나 낮은가의 문제이다
    //   즉 다른 데이터에 대해 같은 정수 값이 나올 확률이 낮을수록 안심하고 사용할 수 있다
    //   이런 이유로 hash 값을 '디지털지문'이라 부른다
    // - 목적?
    //     => 데이터가 같은지 빠르게 비교하기 위해서
    // - 응용?
    //     => 인증서 
    //     => 원본 파일의 위변조 검사  
    //         ex)git에서 커밋 시 고유번호를 붙이는데 바로 해시 값이다
    //         ex)파일 다운로드 사이트에서 제공하는 해시 값
    //         ex) 파일 공유사이트에서 파일을 구분할 때 해시 값 사용
    //             사용자가 파일 이름을 변경하더라도 데이터만 바꾸지 않는다면 
    //             파일의 해시 값은 같다
    //  - 해시 알고리즘
    //    => SHA, MD, PGP 등
    
    // 해시코드 오버라이딩 하면 => 데이터가 같으면 같은 해시값을 가지게 함
  } 

}
