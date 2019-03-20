package ch29.j;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan({"ch29.j", "ch29.j2"})
public class AppConfig1 {
	
	public AppConfig1() {
		System.out.println("AppConfig1()");
	}

}
