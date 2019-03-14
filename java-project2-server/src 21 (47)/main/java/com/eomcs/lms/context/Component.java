package com.eomcs.lms.context;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// IoC 컨테이너가 관리 할 객체에 붙이는 애노테이션이다
// IoC 컨테이너는 이 애노테이션이 붙은 클래스에 대해 인스턴스를 자동으로 생성할 것이다

@Retention(RetentionPolicy.RUNTIME)   // 생성 했는지 추출해서 확인
@Target(ElementType.TYPE)             // 클래스에만
public @interface Component {
	
	String value() default "";  

}
