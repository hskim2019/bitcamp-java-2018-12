package ch28.d;

import java.lang.annotation.Repeatable;

//애노테이션 반복 사용- 이 애노테이션을 반복 사용하려면 다른 애노테이션이 필요
@Repeatable(MyAnnotation2s.class)
public @interface MyAnnotation2 {

}
