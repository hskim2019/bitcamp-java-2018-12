package com.eomcs.lms.handler;

import java.io.BufferedReader;
import java.io.PrintWriter;

public abstract class AbstractCommand implements Command {

	protected String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// 추상클래스의 목적?
	// => 서브 클래스에게 필드나 메서드를 상속해 주는 용도,
	// => 추상클래스를 직접 사용하지 못한다
	@Override
	public void execute(BufferedReader in, PrintWriter out) {
		
		try{
			execute(new Response(in, out));
		}  catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void execute(Response response) throws Exception{
		// 서브 클래스에서 오버라이딩 해야할 메서드이다
		// 그러나 서브 클래스가 반드시 오버라이딩 하도록 강요하지 않기 위해 추상 메서드로 선언하지 않는다.
		// 왜? 서브 클래스는 Command의 execute(BufferedReader in, PrintWriter out)를
		// 오버라이딩 할 지도 모르기 때문이다
	}

}
