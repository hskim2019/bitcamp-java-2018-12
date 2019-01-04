// 콘솔로 출력하기 II - 형식을 갖춰 출력하기
package ch02;

public class Test12 {
  
  public static void main(String[] args) {
    System.out.printf("Hello!\n");
    
    // %s : 지정한 자리에 문자열을 삽입
    //        삽입할 값은 오른쪽에 설정
    System.out.printf("이름: %s\n", "홍길동");
    System.out.printf("안녕하세요! %s입니다.\n", "임꺽정");
    
    // %d : 정수값을 10진수 문자열로 만들어 삽입
    // %x : 정수값을 16진수 문자열로 만들어 삽입
    // %c : 정수값을 문자로 만들어 삽입
    // %b : true / false 값을 문자열로 만들어 삽입
    System.out.printf("%d %x %c %b\n", 65, 65, 65, true);
    
    // 한 개의 값을 여러 곳에 삽입할 수 있다
    // %n$s : n은 값의 순서를 지정한다. 순서는 1부터 증가한다.
    // 65, 66, 67 중 두번째 값인 66을 가지고 10진수 문자열, 16진수 문자열, 문자로 출력
    System.out.printf("%2$d %2$x %2$c\n", 65, 66, 67);
    
    // 값을 출력할 때 사용할 공간을 지정할 수 있다
    // %사용할 공간 너비 s
    // - 마이너스표기는 왼쪽 정렬 / 붙이지 않으면 오른쪽 정렬
    System.out.printf("'%-10s' '%10s'\n", "홍길동", "임꺽정");
    System.out.printf("'%-10d' '%10d'\n", 12345, 12345);
    
    // %0사용할공간너비d : 앞의 빈자리는 0으로 채움
    System.out.printf("'%010d' '%07d'\n", 12345, 12345);
    
    // 부호+는 해당 자리에 부호를 넣으라는 의미
    System.out.printf("'%+010d' '%+07d'\n", 12345, -12345);  
    System.out.printf("'%+d' '%+d'\n", 12345, 12345);

  }
}
