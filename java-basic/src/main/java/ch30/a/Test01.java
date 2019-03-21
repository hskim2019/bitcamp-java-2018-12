// AOP 사용 전 - X.m1()에 기능을 추가하기 전
package ch30.a;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
  public static void main(String[] args) {
	  
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch30/a/application-context-01.xml");
    
    //@Component 애노테이션이 붙은 클래스의 인스턴스를 자동으로 생성한다
    
    System.out.println("===================================");
    
    String[] names = iocContainer.getBeanDefinitionNames();
    for ( String name : names) {
    	System.out.printf("%s==> %s\n",
    			name, iocContainer.getBean(name).getClass().getName());
    }
    
    System.out.println("===================================");

    X x = (X) iocContainer.getBean("x");
    x.m1();
    
  }
}






