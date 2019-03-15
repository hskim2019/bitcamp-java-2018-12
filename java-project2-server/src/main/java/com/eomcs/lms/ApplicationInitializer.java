package com.eomcs.lms;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.eomcs.lms.context.ApplicationContextException;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.context.RequestMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping;
import com.eomcs.lms.context.RequestMappingHandlerMapping.RequestMappingHandler;

// App 객체의 상태가 변경될 때 마다 보고 받는 옵저버가 되려면
// ApplicationContextListener 규격에 따라 작성해야 한다
public class ApplicationInitializer implements ApplicationContextListener {


	@Override
	public void contextInitialized(Map<String, Object> context) {
		try {
		    //Spring IoC 컨테이너 준비
			// AppConfig : Dao, DaoFactory, SqlSessionFactoryProxy, TransactionManager객체
		    ApplicationContext appCtx = new AnnotationConfigApplicationContext(AppConfig.class);
		    
		    // ServerApp 쪽에서 사용할 수 있도록 ApplicationContext를 맵에 저장
		    context.put("applicationContext", appCtx);
		    
		    // RequestMappingHandlerMapping 객체 준비
		    context.put("handlerMapping", prepareRequestMappingHandlerMapping(appCtx));

		} catch (Exception e) {
			throw new ApplicationContextException(e);
		}
	}

	@Override
	public void contextDestroyed(Map<String, Object> context) {
	}

	
	public RequestMappingHandlerMapping prepareRequestMappingHandlerMapping (
			ApplicationContext iocContainer) {
		// RequestMappingHandler 정보를 관리할 객체 생성
		RequestMappingHandlerMapping handlerMapping = new RequestMappingHandlerMapping();

		// iocContainer에서 객체를 모두 꺼낸다 : Command
		Collection<Object> beans = iocContainer.getBeansWithAnnotation(Component.class).values();

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
		// ServerApp 에서 꺼낼 수 있도록 RequestMappingHandlerMapping객체를 리턴한다
		return handlerMapping;
	}

}
