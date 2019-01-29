package design_pattern.command.after;

public class MemberDetailCommand implements Command {

  @Override
  public void execute() {
    System.out.println("member 상세조회 처리!");
    
  }

  
}
