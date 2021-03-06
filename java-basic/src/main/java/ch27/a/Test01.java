// 인터페이스 구현체를 자동으로 생성하기
package ch27.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test01 {

	public static void main(String[] args) throws ClassNotFoundException  {
		// java.lang.reflect.Proxy
		// => 인터페이스 구현체를 만드는 역할을 한다

		// newProxyInstance(구현체를 만들기위해사용하는인터페이스의클래스로더, 구현할 인터페이스 목록, 실제 작업을 수행하는 객체)
		// => 파라미터로 넘겨 받은 인터페이스를 모두 구현한 클래스를 만들어 리턴한다.

		// 클래스로더 => 클래스 정보를 로딩하는 역할을 수행한다
		//            => 알아내는 방법
		//                클래스정보.getClassLoader()
		//            => 클래스 정보
		//               인스턴스.getClass()
		//               클래스명.class
		//               Class.forName("패키지명을 포함한 클래스명")
		// 실제 작업을 수행하는 객체 => java.lang.reflect.InvocationHandler 인터페이스에 따라 동작하는 객체
		//                           => 즉 InvocationHandler 구현체

		// 클래스 정보를 얻는 방법의 예
		// String s = "hello";
		// Class<?> c1 = String.class;  // 클래스의 static 변수인 class의 값을 사용할 수 있다
		// Class<?> c2 = s.getClass();  // 인스턴스로 알아낼 수 있다
		// Class<?> c3 = Class.forName("java.lang.String"); //클래스 정보를 리턴하는 도구를 이용

		//int a = 10, b = 20, c = 30;
		//int[] arr = new int[3];
		//arr[0] = 10;
		//arr[1] = 20;
		//arr[2] = 30;
		//int[] arr2 = new int[] {10, 20, 30};
		//int[] arr3 = {10, 20, 30};

		class MyHandler implements InvocationHandler {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// newProxyInstance()가 생성한 객체에 대해 메서드를 호출할 때마다 이 메서드가 호출된다
				//System.out.println("===>" + method.getName());
				
//				Class<?>[] test =  proxy.getClass().getInterfaces();
//				for(Class<?> t : test) {
//					System.out.println(t);
//				}
				System.out.println("--------------------");
				String a = proxy.getClass().getInterfaces()[0].getName();
			//	String b = proxy.getClass().getInterfaces()[1].getName();
				//String c = proxy.getClass().getInterfaces()[2].getName();
				System.out.println(a);
			//	System.out.println(b);
			//	System.out.println(c);
				
//				int a = (int) args[0];   //auto-unboxing => ((Integer) args[0]).intValue();
//				int b = (int) args[1];
//				
//				switch (method.getName()) {
//				case "plus":
//					return a + b;
//				case "minus":
//					return a - b;
//				}
				return 0; // = Integer.valueOf(0) primative type<=>wrapper객체에 담아줌 자바 컴파일러가 자동으로 오토박싱
			}
		}

		//Class<?>[] classes = new Class[] {Calculator.class};  
		// Calculator 인터페이스를 구현한 클래스를 만들고 그 인스턴스를 생성하여 리턴한다
		Calculator c1 = (Calculator) Proxy.newProxyInstance(
				Calculator.class.getClassLoader(), 
				new Class[] {Calculator.class},
				new MyHandler());
		
		System.out.println(c1.plus(10, 20));
//		System.out.println(c1.minus(10, 20));
//		
//		System.out.println("----------------");
//		Class<?> clazz = Calculator.class;
//		System.out.println(clazz.getClassLoader());
//		System.out.println(clazz.getClass());
		
	}

}
