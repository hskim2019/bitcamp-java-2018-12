// BeanPostProcessor - @Autowired + @Qualifier = @Resource (자바 표준 애노테이션)
package ch29.h;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test08 {
  public static void main(String[] args) {
	  
    ApplicationContext iocContainer = 
        new ClassPathXmlApplicationContext("ch29/h/application-context-08.xml");
    
    System.out.println("===================================");
    //@Qualifier("객체이름") 을 사용하여 어떤 객체를 꼽을 것인지 지정하라
    System.out.println(iocContainer.getBean("c1"));
    
    System.out.println("===================================");
    
    
  }
}






