package design_pattern.command.after;

public class MemberUpdateCommand implements Command {

  @Override
  public void execute() {
    System.out.println("member 변경 처리!");
    
  }

  
}
