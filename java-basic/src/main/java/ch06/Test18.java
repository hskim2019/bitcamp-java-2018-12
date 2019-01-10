// 메서드 - JVM 아규먼트 응용 II
package ch06;

public class Test18 {
  public static void main(String[] args) {
    // JVM에 기본으로 설정되어 있는 property를 모두 출력하라
    // System이라는 도구는 JVM을 다루는 도구
    
    //System클래스의 getProperties()를 호출하면 시스템과 관련된 속성이 저장된 Properties를 가져올 수 있다
    
    // JVM의 전체 프로퍼티 목록 가져오기
    java.util.Properties props = System.getProperties();
    
    java.util.Set keySet = props.keySet();
    
    for (Object key : keySet) {
      String value = System.getProperty((String)key);
      System.out.printf("%s = %s\n", key, value);
    }

  } // main end

}//class end
