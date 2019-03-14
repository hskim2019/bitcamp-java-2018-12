package com.eomcs.lms.context;

import java.lang.reflect.Method;
import java.util.HashMap;

// RequestMapping이 붙은 메서드와 그 객체를
// 지정된 이름으로 맵에 보관하고 관리한다
public class RequestMappingHandlerMapping {

	HashMap<String, RequestMappingHandler> handlerMappings = new HashMap<>();
	
	public void add(String name, RequestMappingHandler handler) {
		handlerMappings.put(name, handler);           
		// name : Command 객체의 메서드에 붙은 애노테이션 ex) /board/list
		// handler: Command 객체와 메서드
	}
	
	// 해당 애노테이션을 key로 하는 (객체와) 메서드를 꺼내준다
	public RequestMappingHandler get(String name) {
		return handlerMappings.get(name);
	}
	
	// 스테틱 중첩 클래스
	// RequestMapping 애노테이션이 붙은 그 메서드와 그 객체 정보를 저장한다
	public static class RequestMappingHandler {
		public Object bean;        // BoardCommand, MemberCommand 등 객체
		public Method method;      // 메서드 (add, list...) 
		
		public RequestMappingHandler(Object bean, Method method) {
			this.bean = bean;
			this.method = method;
		}

	}
}
