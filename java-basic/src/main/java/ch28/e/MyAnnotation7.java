package ch28.e;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // 메모리 로딩 가능, 애노테이션 정보 추출 가능
@Target(ElementType.TYPE)            // 클래스 위에만 주석 붙일 수 있음
public @interface MyAnnotation7 {
	String[] value() default {"aaa", "bbb"};
	String name ();
	int age();
	boolean working() default true;
}
