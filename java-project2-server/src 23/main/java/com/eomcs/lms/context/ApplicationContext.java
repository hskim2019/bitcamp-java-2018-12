// Command 객체를 자동 생성하는 역할을 수행한다
package com.eomcs.lms.context;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

public class ApplicationContext {

	// 인스턴스를 생성할 클래스 정보
	ArrayList<Class<?>> classes = new ArrayList<>();

	// 생성한 인스턴스를 보관하는 저장소
	HashMap<String, Object> beanContainer = new HashMap<>();
	// beanContainer
	// 1) ApplicationInitializer에서 생성자 호출 시 boardDao, memberDao, lessonDao...txManager 프록시 객체 저장
	// 2) prepareComponent() 호출 시 인스턴스 생성 후 클래스 이름(key)과 해당 클래스 인스턴스 저장
	// 3) postProcess() 호출 시 RequestMappingHandlerMapping클래스 map에 Command객체와 메서드 저장 & "handlerMapping"이름으로 beanContainer에도 저장

	//                 key                            |           value
	// 1)       "boardDao"..."txManager"                    BoardDao... txManager구현체                  
	// 2)  "com.eomcs.lms.handler.BoardCommand"                   인스턴스
	// 3)         "handlerMapping"                           Command객체와 메서드     
	//requestMapping.value() = 애노테이션 ex) /board/list ,        handler : Command객체와 메서드

	
	//AppConfig 클래스로부터 Dao, DaoFactory, SqlSessionFactoryProxy, TransactionManager 객체 생성
	public ApplicationContext(Class<?> configClass) throws Exception {
		// IoC 컨테이너와 관련된 설정 정보를 가지고 있는 클래스 정보를 받아서 초기화를 수행한다

		//1) 설정 정보를 가지고 있는 클래스의 인스턴스를 생성한다
		Constructor<?> c = configClass.getConstructor();
		Object config = c.newInstance();
		
		//2) Bean 애노테이션이 붙은 메서드를 모두 찾는다
		ArrayList<Method> factoryMethods = new ArrayList<>();     //factoryMethods : bean애노테이션 붙은 메서드들(boardDao, sqlSessionFactoryProxy..)
		Method[] methods = configClass.getMethods();
		for (Method m : methods) {
			if(m.getAnnotation(Bean.class) !=null) 
				factoryMethods.add(m);
		}

		//3) 팩토리 메서드를 호출하여 그 리턴 값을 beanContainer에 보관한다  (AppConfig의 메서드들을 호출해야 객체 생성 됨)
		while(factoryMethods.size() > 0) { // 메서드가 있으면 호출함
			Method m =  factoryMethods.get(0); // 메서드 목록에서 메서드를 꺼내 
			callFactoryMethod(config, m, factoryMethods, ""); // 호출한다
			factoryMethods.remove(m); // 호출에 성공하든 실패하든 목록에서 제거한다
		}

		//4) ComponentScan 애노테이션을 처리한다
		// => 애노테이션에 지정된 패키지를 탐색하여 객체를 생성한다
		ComponentScan componentScan = configClass.getAnnotation(ComponentScan.class);
		if (componentScan != null) {
			String[] packages = componentScan.basePackages();
			for (String packageName : packages) {
				prepareComponent(packageName);
			}
		}
	}

	public void prepareComponent(String packageName) throws Exception {

		// 1) 패키지명으로 디렉토리 경로를 알아낸다
		File packageDir = Resources.getResourceAsFile(packageName.replace(".", "/")); //home/git/....com/eomcs/lms

		// 2) 해당 패키지 폴더와 그 하위 폴더를 뒤져서 "클래스 이름"을 알아낸다
		// => 인스턴스를 생성할 수 없는 인터페이스나 추상 클래스는 제외한다
		// => 또한 중첩 클래스도 제외한다.
		findClasses(packageDir, packageName);      // lms 디렉토리 안의 public클래스를 찾아 ArrayList에 저장
		//						for(Class<?> clazz : classes) {
		//							System.out.println(clazz.getName());
		//						}

		// 3) Component 애노테이션이 붙은 클래스만 찾아서 인스턴스 생성한다
		// beanContainer에 클래스 이름과 인스턴스 보관
		createComponent();

		// 4) 인스턴스 생성을 완료한 후 작업을 수행
		postProcess();
		// 수행 후, RequestMappingHandlerMapping 의 HashMap에 Command객체 저장 됨
		// key 값: 애노테이션 ex) /board/list
		// value : Command 객체와 메서드 인스턴스

		System.out.println("------------------------------------------");
		Set<String> names = beanContainer.keySet();
		for (String name : names) {
			//System.out.println(name);
			System.out.printf("%s : %s\n", name, beanContainer.get(name).getClass().getSimpleName());
		}

	}


	// 인스턴스를 추가할 때 호출한다
	// 빈(bean) == 인스턴스 == 객체
	private void addBean(String name, Object bean) {
		if(name == null || name.length() == 0 || bean == null)
			return;

		beanContainer.put(name, bean);
	}

	// 저장소에 보관된 인스턴스를 꺼낸다
	public Object getBean(String name) {
		return beanContainer.get(name);
	}

	private void findClasses(File dir, String packageName) throws Exception {  //(home/git....com/eomcs/lms   ,   com/eomcs/lms)

		// 디렉토리를 뒤져서 클래스 파일(.class)이나 하위 디렉토리 목록을 알아낸다
		File[] files = dir.listFiles(new FileFilter() {    //com/eomcs/lms 디렉토리 뒤져서 클래스 파일과 lms보다 하위 디렉토리 찾아 files배열로 저장

			//승인하면 넘어감
			@Override
			public boolean accept(File pathname) {
				if(pathname.isDirectory())
					return true;

				if(pathname.getName().endsWith(".class") && //자바 클래스 파일 
						!pathname.getName().contains("$"))  // 중첩 클래스가 아닌 경우 - navigation에서 중첩클래스 확인할 수 있음 예)ServerApp$중첩클래스
					return true;

				return false;
			}
		});

		for (File f : files) {   // files : com/eomcs/lms 디렉토리 뒤져서 클래스 파일과 lms보다 하위 디렉토리 찾은 것이 저장 된 배열
			if (f.isFile()) {
				// 클래스 파일일 경우
				// => 파라미터로 받은 패키지 명과 파일 이름을 합쳐서 클래스 이름을 만든다
				//    예) com.eomcs.lms(패키지명) + . + ServerApp(파일명)
				//        ==> com.eomcs.lms.ServerApp
				String filename = f.getName();
				String className = packageName + "." + filename.substring(0, filename.indexOf('.'));
				// Helper.class => Helper
				// => 클래스 이름으로 클래스 파일(.class)을 로딩한다
				Class<?> clazz = Class.forName(className);

				// => 클래스 정보를 분석하여 중첩 클래스이거나 인터페이스, Enum이면 무시한다
				if (clazz.isLocalClass() || clazz.isInterface() || clazz.isEnum())
					continue;

				//=> 추상 클래스나 공개되지 않은 클래스(public이 아닌 클래스)도 무시한다
				if (Modifier.isAbstract(clazz.getModifiers()) || !Modifier.isPublic(clazz.getModifiers()))
					continue;

				// 즉 공개된(public) 일반 클래스인 경우 클래스 관리 목록에 추가한다
				classes.add(clazz);    //ArrayList에 public클래스파일만 저장

			} else {
				// 디렉토리일 경우, 그 하위 디렉토리에서 다시 클래스를 찾는다
				// => 하위 디렉토리에서 클래스를 찾을 때 사용할 패키지명을 준비한다
				// => 파라미터로 받은 패키지 이름에 하위 디렉토리 이름을 붙이면 전체 패키지명이 된다
				// => com.eomcs.lms(현재 패키지 이름) + . + dao(디렉토리 이름) = com.eomcs.lms.dao
				findClasses(f, packageName + "." + f.getName());
			}
		}
	}

	private void createComponent() throws Exception {

		for (Class<?> clazz : classes) {    // classes : public 클래스가 담긴 ArrayList

			// 클래스에서 Component 애노테이션 정보를 추출한다
			//애노테이션이름      = 해당클래스.getAnnotation(애노테이션.class) => 클래스에 Component라는 애노테이션이 있으면 얻어오기
			Component compAnno = clazz.getAnnotation(Component.class);

			if (compAnno == null)    //com.eomcs.lms.ApplicationInitializer 클래스는 Component 애노테이션 없으므로 null이고, 다음 clazz로
				continue;

			// Component 애노테이션이 붙은 클래스에 대해 인스턴스를 생성한다 => 애노테이션이 붙은 클래스:BoardCommand/LessonCommand/MemberCommand
			Object obj = createInstance(clazz);

			if(obj != null) { //제대로 생성했으면 beanContainer에 저장한다
				// bean 컨테이너에 객체를 저장할 때 key 값은 Component 애노테이션의 value() 값으로 한다
				// 만약 value 가 빈 문자열이라면 클래스 이름을 사용한다
				// => 클래스에서 getName() 메서드를 알아낸다
				addBean(compAnno.value().length() > 0 ? compAnno.value() : clazz.getName(), obj); 
			}
		} // for end
	}




	private Object createInstance(Class<?> clazz) throws Exception {
		// 파라미터로 주어진 클래스 정보를 가지고 인스턴스를 생성한다
		// => 기본 생성자를 알아낸다

		try {
			Constructor<?> defaultConstructor = clazz.getConstructor();
			return defaultConstructor.newInstance();
		} catch (Exception e) {
			// 기본 생성자를 못 찾으면 예외 발생한다. 그냥 무시하고 다른 생성자를 찾아 인스턴스를 생성한다
		}

		//=> 기본 생성자가 없다면, 다른 생성자 목록을 얻는다
		Constructor<?>[] constructors = clazz.getConstructors();
		for (Constructor<?> c : constructors) {
			// => 생성자를 호출하려면 어떤 타입의 파라미터가 필요한지 알아야 한다
			Class<?>[] paramTypes = c.getParameterTypes();

			//=> 생성자가 요구하는 타입의 파라미터 값이 저장소에 있는지 찾아 본다
			Object[] paramValues = getParameterValues(paramTypes);
			if(paramValues != null) {  //생성자가 요구하는 모든 파라미터 값을 찾았다면
				// 생성자를 통해 인스턴스를 생성하여 리턴한다
				return c.newInstance(paramValues);
			}
		}
		return null;

	}



	// 찾은 파라미터 타입이 저장소에 있는지 찾아보는 메서드
	private Object[] getParameterValues(Class<?>[] paramTypes) {
		// 파라미터 타입에 해당하는 객체를 beanContainer에서 찾아 배열을 만들어 리턴한다
		ArrayList<Object> values = new ArrayList<>();
		for (Class<?> type : paramTypes) {
			Object value = findBean(type);
			if(value != null) {
				values.add(value);
			}
		}

		if(values.size() == paramTypes.length)
			// 파라미터의 타입 목록에 지정된 객체를 모두 찾았으면 배열로 리턴한다
			return values.toArray();
		else // 못 찾았으면 null 리턴
			return null;
	}

	private Object findBean(Class<?> type) {     //type: 파라미터 타입
		// beanContainer에서 특정 타입의 인스턴스 찾기
		// => 먼저 빈 컨테이너에서 인스턴스 목록을 꺼낸다
		Collection<Object> beans = beanContainer.values();    //beanContainer에 BoardDao 객체가 들어있고, BoardAddCommand클래스 생성자의 파라미터가 BoardDao
		for(Object bean : beans) {
			if(type.isInstance(bean))
				return bean;
		}
		return null;
	}

	// bean 생성을 완료한 후 작업 수행
	public void postProcess () {
		// RequestMappingHandler 정보를 관리할 객체 생성
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();

		// beanContainer에서 객체를 모두 꺼낸다
		Collection<Object> beans = beanContainer.values();    //현재 있는 객체 : BoardDao인스턴스 , BoardCommand 인스턴스

		for (Object bean : beans) {
			// 각 객체에 대해 @RequestMapping 메서드를 찾는다
			Method[] methods = bean.getClass().getMethods();        //beanContainer => 객체 꺼냄: bean => 메서드꺼냄: m =>메서드에서 애노테이션
			for(Method m : methods) {
				RequestMapping requestMapping = m.getAnnotation(RequestMapping.class);  //RequestMapping의 애노테이션은 ex)/board/add
				if(requestMapping == null)     //애노테이션이 없으면 다음 메서드에서 다시 찾음
					continue;

				// RequestMapping 이 붙은 메서드를 찾았으면 그 정보를 RequestMappingHandler에 담는다
				RequestMappingHandler handler = new RequestMappingHandler(bean, m);  
				//bean: bean컨테이너에서 꺼낸 객체(호출할 때 사용할 객체 주소), m: 메서드
				//       BoardCommand, LessonCommand 등 Command와 메서드들이 담김

				// 그리고 이 요청 핸들러(RequestMapping 애노테이션이 붙은 메서드)를 저장한다
				handlerMapping.add(requestMapping.value(), handler);    
				//requestMapping.value() = 애노테이션 ex) /board/list ,        handler : Command객체와 메서드
			}
		}
		// ServerApp 에서 꺼낼 수 있도록 RequestMappingHandlerMapping객체를 빈 컨테이너에 저장해둔다
		beanContainer.put("handlerMapping", handlerMapping); 
	}


	private Object callFactoryMethod(Object obj, Method factoryMethod, ArrayList<Method> factoryMethods, String indent) throws Exception {
                                   // 객체,             메서드 ,                      메서드 리스트      , 출력을위한쓸모없는파라미터   
//		System.out.println(indent + "===>" + factoryMethod.getName());

		//1) factoryMethod 메서드에서 호출할 때 사용할 파라미터 정보를 알아낸다
		//    ex) factoryMethod(BoardDao, MemberDao, TransactionManager)
		//        => 파라미터 타입 배열:
		//           {BoardDao.class, MemberDao.class, TransactionManager.class}
		Class<?>[]  paramTypes = factoryMethod.getParameterTypes();
		// 파라미터 타입배열: DaoFactory의 파라미터 : SqlSessionFactoryProxy
		
		// 파라미터 값을 담을 목록을 준비한다
		// ex) {new BoardDao(), new MemberDao(), new TransactionManager()}
		Object[] paramValues = new Object[paramTypes.length];

		for(int i = 0; i < paramTypes.length; i++) {
			//2) BeanContainer에서 파라미터에 해당하는 값을 꺼낸다
			Object paramValue = findBean(paramTypes[i]);
			if (paramValue != null) {
				paramValues[i] =paramValue;
				continue;
			}
			//3) 만약 빈 컨테이너에 파라미터에 해당하는 값이 없다면,
			//   팩토리 메서드를 뒤져서 그 타입의 값을 리턴하는 메서드를 찾아 호출한다
			Method otherFactoryMethod = findMethodByReturnType(factoryMethods, paramTypes[i]);
			if (factoryMethod == null) {
				// 4) 만약 해당 파라미터 타입의 값을 만들어주는 다른 팩토리 메서드가 없다면
				//    factoryMethod 호출을 포기한다
				return null;
			}
			// 파라미터 값을 만들어 줄 다 팩토리 메서드를 찾았다면 해당 메서드를 호출한다
			// 재귀 호출을 사용한다
			paramValue = callFactoryMethod(obj, otherFactoryMethod, factoryMethods, indent + "    ");
			if (paramValue == null) {
				// 파라미터 값을 리턴해주는 팩토리 메서드를 찾긴 했지만
				// 그 메서드를 호출하기 위해 파라미터 값이 필요했는데
				// 그 파라미터 값이 없어서 메서드 호출에 실패하면
				// factoryMethod 호출을 포기한다
				return null;
			}

			// 파라미터 값이 준비 되었으면 저장한다
			paramValues[i] = paramValue;
		}

		// 팩토리 메서드 호출에 성공했다면 다시 호출 할 필요가 없기 때문에 메서드 목록에서 제거한다
		factoryMethods.remove(factoryMethod);

		// 준비한 파라미터 값들을 가지고 팩토리 메서드를 호출한다
		// 그리고 팩토리 메서드가 생성한 객체를 빈 컨테이너에 보관한다
		Object bean = factoryMethod.invoke(obj, paramValues);

		// 팩토리 메서드가 생성한 객체를 저장할 때
		// 애노테이션에 빈의 이름이 지정되어 있다면 그 이름을 사용하고
		// 없다면 메서드 이름을 사용한다
		Bean beanAnno = factoryMethod.getAnnotation(Bean.class);
		beanContainer.put(beanAnno.value().length() > 0 ? beanAnno.value() : factoryMethod.getName(), bean);


//		System.out.println(indent + "      :" + bean.getClass().getSimpleName() + "객체가 보관됨");


		// 그리고 팩토리 메서드가 생성한 객체를 리턴한다
		return bean;
	}



	private Method findMethodByReturnType(List<Method> methods, Class<?> returnType) {
		for (Method m : methods) {
			if(m.getReturnType() == returnType) {
				return m;
			}
		}
		return null;
	}
}
