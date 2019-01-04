// 키보드로 입력한 값을 받기 IV - keyboard.nextLine();
package ch03;

public class Test09 {
  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);

    System.out.print("나이? ");     
    int age = keyboard.nextInt();
  
    // nextInt()는 한 개의 토큰을 읽은 후에 줄 바꿈 코드는 읽기 전 상태로 놔둔다
    // ex) 나이를 20으로 입력한 경우 => 20LF => nextInt가 20만 가져가고
    //                                          남은 LF를 nextLine()이 리턴해버림
    // nextInt()호출 후 nextLine()호출한 결과
    //나이? 12
   // b? 12()

    // 해결방법 : nextInt()를 호출한 후 남아있는 엔터코드를 읽어서 제거하기
    keyboard.nextLine();

    System.out.print("이름? ");     
    String name = keyboard.nextLine();
        
    System.out.printf("%d(%s)\n", age, name);
  }
}

