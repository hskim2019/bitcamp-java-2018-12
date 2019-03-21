package ch30.e;

import org.springframework.stereotype.Component;

@Component
public class X {

	public int caclulate(int i, int j, String op) {

		// 이 메서드에 기능을 추가하기 위해 별도로 코드를 작성할 필요가 없다
		// 그래서 기능을 붙이고 추가하고 제거할 때 아무런 영향을 끼치지 않는다 
		System.out.println("X.calculate");
		
		switch(op) {
		case "+" : return i + j;
		case "-" : return i - j;
		case "*" : return i * j;
		case "/" : return i / j;
		default:
			throw new RuntimeException("지원하지 않는 연산자입니다");
		}
	}

}
