package design_pattern.command.after;

public class MemberAddCommand implements Command {

  @Override
  public void execute() {
    System.out.println("member 입력 처리!");
    
  }

  
}
