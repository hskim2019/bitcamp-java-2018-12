package design_pattern.command.after;

public class MemberDeleteCommand implements Command {

  @Override
  public void execute() {
    System.out.println("member 삭제 처리");
    
  }

  
}
