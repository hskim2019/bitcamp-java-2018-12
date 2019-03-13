// Command 객체를 자동 생성하는 역할을 수행한다
package com.eomcs.lms.context;

import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.io.Resources;

import com.eomcs.lms.handler.Command;

public class ApplicationContext {

	// 인스턴스를 생성할 클래스 정보
	ArrayList<Class<?>> classes = new ArrayList<>();
	
	// 생성한 인스턴스를 보관하는 저장소
	HashMap<String, Object> beans = new HashMap<>();

	public ApplicationContext(String packageName, Map<String, Object> beans) throws Exception {
		
		// 외부에서 생성한 인스턴스가 파라미터로 넘어온다면 저장소에 보관한다
		if(beans != null && beans.size() > 0) {
			Set<String> names = beans.keySet();
			for (String name : names) {
				addBean(name, beans.get(name));
			}
		}

		// 1) 패키지명으로 디렉토리 경로를 알아낸다
		File packageDir = Resources.getResourceAsFile(packageName.replace(".", "/")); //home/git/....com/eomcs/lms

		// 2) 해당 패키지 폴더와 그 하위 폴더를 뒤져서 "클래스 이름"을 알아낸다
		// => 인스턴스를 생성할 수 없는 인터페이스나 추상 클래스는 제외한다
		// => 또한 중첩 클래스도 제외한다.
		findClasses(packageDir, packageName);      // lms 디렉토리 안의 public클래스를 찾아 ArrayList에 저장

//				for(Class<?> clazz : classes) {
//					System.out.println(clazz.getName());
//				}

		// 3) Command 인터페이스를 구현한 클래스만 찾아서 인스턴스를 생성한다
		prepareCommand();
	}
	
	// 인스턴스를 추가할 때 호출한다
	// 빈(bean) == 인스턴스 == 객체
	private void addBean(String name, Object bean) {
		if(name == null || name.length() == 0 || bean == null)
			return;
		
		beans.put(name, bean);
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

	private void prepareCommand() throws Exception {
		for (Class<?> clazz : classes) {    // classes : ArrayList에 lms 하위 디렉토리 안의 public 클래스만 저장 되어 있음
		//	System.out.println(clazz.getName()); // 예)com.eomcs.lms.ServerApp
			
			// 클래스 또는 부모 클래스가 구현한 인터페이스 목록을 알아낸다
			List<Class<?>> interfaces = getAllInterfaces(clazz);    // interfaces : public 클래스의 인터페이스 목록을 얻음
			
			for (Class<?> i : interfaces) {
				
				if (i == Command.class) {
					System.out.println(clazz.getName());
					break;
				}
			}
		}
	}

	private List<Class<?>> getAllInterfaces(Class<?> clazz) { //clazz <= classes : public클래스만 저장 된 ArrayList
		
		ArrayList<Class<?>> list = new ArrayList<>();     // list : clazz(public 클래스) 의 인터페이스가 저장 되어있음
		
		while(clazz != Object.class) {  //clazz가 Object가 아닌동안 반복?
           Class<?>[] interfaces = clazz.getInterfaces();   
           for(Class<?> i : interfaces)
        	   list.add(i);
           clazz = clazz.getSuperclass();  //현재 class의 부모 클래스를 가리키게 하고 부모클래스의 인터페이스 목록 얻기
		}
		
		return list;
		
	}
	
	
	
}
