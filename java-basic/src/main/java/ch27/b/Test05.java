// reflection API - 메서드의 상세정보 꺼내기
package ch27.b;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
// 어떤 클래스나 인터페이스의 스테틱 멤버를 import할 수 있다
import static java.lang.reflect.Modifier.*;

public class Test05 {

	public static void main(String[] args) throws Exception {

		Class<?> clazz = String.class;
		Method[] methods = clazz.getDeclaredMethods();
		for (Method m : methods) {
			System.out.printf("메서드명: %s.%s\n", m.getDeclaringClass().getSimpleName(), m.getName());

			Parameter[] params = m.getParameters();
			System.out.printf("파라미터: %d\n", m.getParameterCount());
			for(Parameter p : params) {
				System.out.printf("      %s: %s\n", 
						p.getName(),         //파라미터명
						p.getType().getName()); //파라미터 타입명
			}

			System.out.println("리턴타입: ");
			System.out.printf("     %s\n", m.getReturnType().getName());

			System.out.println("접근제어: ");
			int modifiers = m.getModifiers(); //public? private
			// 다음과 같이 3가지 방법 모두 가능
			if (Modifier.isPublic(modifiers))
				System.out.println("    public");
			else if ((modifiers & Modifier.PROTECTED) == Modifier.PROTECTED)
				System.out.println("    protected");
			else if ((modifiers & Modifier.PRIVATE) != 0)
				System.out.println("    private");

			if ((modifiers & STATIC) != 0)
				System.out.println("    static");
			if((modifiers & FINAL) != 0)
				System.out.println("    final");
			

			System.out.println("---------------------------------");
		}

	}
}
