package com.eomcs.lms.handler;

import com.eomcs.lms.context.Component;
import com.eomcs.lms.context.RequestMapping;

@Component
public class HelloCommand  {

	@RequestMapping("/hello")
	public void execute(Response response) throws Exception{

		response.println("안녕하세요"); 
	}
	
}