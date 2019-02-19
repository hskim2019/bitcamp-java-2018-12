package ch24.d;

public class ATM extends Thread {
  
  String title; // ATM 기기 명칭
  Account account;
  
  public ATM(String name, Account account) {
    super(name); //thread name을 저장하는 생성자
    this.account = account;
  }
  
  // 반복문 돌면서 100원씩 찾는 메서드
  @Override
 public void run() {
    double sum = 0;
    while(true) {
      double money = account.withdraw(100);
     
      if(money == 0)
        break;
      
      sum += money;
    }
    System.out.printf("%s에서 찾은 금액 합계: %.2f\n", this.getName(), sum);
  }

}
