// import 명령문
package ch07;

import ch07.sub.Score12;

public class Test11 {

  public static void main(String[] args) {
    // 다른 패키지의 클래스를 사용하려면 다음과 같이 패키지명까지 지정해야 한다

        ch07.sub.Score12 s1 = new ch07.sub.Score12();
    
    // 문제는 코드가 길어진다는 것이다
    // 이를 해결하기 위해 자바는 import라는 명령 제공
    // 클래스를 사용하기 전에 미리 해당 클래스가 어느 패키지에 있는지 지정한 다음에 사용
        // import 패키지명.클래스명;
    
        // import 패키지명.* // 해당 패키지의 모든 클래스를 패키지명 없이 사용할 수 있다
                           // 특정 패키지의 클래스를 많이 사용한다면 다음과 같이 패키지명 다음 whildcard* 지정
                           // 소스코드를 읽을 때 어떤 클래스가 어떤 패키지에 있는지 바로 확인할 수 없는 불편함
                           // 단 서브 패키지는 해당 안된다
                           // 대부분의 개발자들은 널리 알려진 클래스가 아닌 경우 * 사용하지 않고 패키지명, 클래스명 정확히 명시 함
    // 단 import명령은 package 명령 다음에 와야 한다
    // 클래스 선언 전에 와야 한다 
    
    Score12 s2 = new Score12();
    
    // java.lang 패키지는 우리가 import하지 않아도 자동으로 import 되어 있다
    // java.lang 패키지의 클래스를 사용할 때는 import 없이 사용
    // java.lang.annotation, java.lang.invoke 등 하위 패키지는 해당 안 된다

  }//main end

}//class end
