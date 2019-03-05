// 애플리케이션의 상태 변경을 보고 받는 옵저버가 지켜야 할 규칙
package com.eomcs.lms.context;

import java.util.Map;

public interface ApplicationContextListener {
  
  // 이 메서드는 애플리케이션이 시작될 때 호출된다
  void contextInitialized(Map<String,Object> context) throws ApplicationContextException;

  // 이 메서드는 애플리케이션이 종료될 때 호출된다
  void contextDestroyed(Map<String,Object> context) throws ApplicationContextException;

}
