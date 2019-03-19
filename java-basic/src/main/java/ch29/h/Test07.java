// BeanPostProcessor - @Autowired 사용법: 같은 타입의 객체가 여러개 있을 경우
package ch29.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test07 {
  public static void main(String[] args) {
	  
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/h/application-context-07.xml");
    
    System.out.println("===================================");
    //@Qualifier("객체이름") 을 사용하여 어떤 객체를 꼽을 것인지 지정하라
    System.out.println(iocContainer.getBean("c1"));
    
    System.out.println("===================================");
    
    
  }
}






