// 팩토리 클래스를 통해 객체 생성하기 II (팩토리 메서드가 인스턴스 메서드인 경우 - 인스턴스를 생성 후 메서드 호출)
package ch29.f;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {
  public static void main(String[] args) {
	  
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/f/application-context-02.xml");
    
    System.out.println("===================================");
    
    System.out.println(iocContainer.getBean("c1"));
  }
}






