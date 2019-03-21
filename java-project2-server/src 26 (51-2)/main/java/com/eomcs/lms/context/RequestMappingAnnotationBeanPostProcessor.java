package com.eomcs.lms.context;

import java.lang.reflect.Method;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

// 이 객체는 스프링 IoC 컨테이너가 인스턴스를 생성할 때마다 보고 받는다 *****
// 스프링 IoC 컨테이너로부터 인스턴스가 생성 되었다고 보고를 받으면 
// 생성된 인스턴스를 조사하여 @RequestMapping이 붙은 메서드를 찾는다
// 그리고 RequestMappingHandlerMapping 객체에 기록한다
// 이렇게 기록된 메서드는 클라이언트로부터 명령어가 들어왔을 때
// ServerApp에 호출 될 것이다
@Component
public class RequestMappingAnnotationBeanPostProcessor implements BeanPostProcessor{

	RequestMappingHandlerMapping handlerMapping;

	public RequestMappingAnnotationBeanPostProcessor(RequestMappingHandlerMapping handlerMapping) {
		this.handlerMapping = handlerMapping;
	}


	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

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

		return bean;
	}
}
