package design_pattern.proxy.before2.client;

import java.util.Scanner;

public class App {
public static void main(String[] args) throws Exception {
  
  Scanner keyboard = new Scanner(System.in);
  
  // 클라이언트 개발자가 원격에 있는 객체를 사용하기 위해서
  // 원격 서버와 통신하는 코드를 프로토콜에 맞춰 직접 작성하였다
  CalculatorClient calcStub = new CalculatorClient();
  
  while(true) {
    System.out.print("계산식> (예: 100 + 200)");
    String input = keyboard.nextLine();
    if(input.equalsIgnoreCase("quit"))
      break;
    
    String[] values = keyboard.nextLine().split(" ");
    try {
      System.out.println(calcStub.compute(Integer.parseInt(values[0]),
          Integer.parseInt(values[2]),
          values[1]));
    } catch (Exception e) {
      System.out.println("식 또는 계산 오류: " +e.getMessage());
    }
  }
  keyboard.close();
}
}
