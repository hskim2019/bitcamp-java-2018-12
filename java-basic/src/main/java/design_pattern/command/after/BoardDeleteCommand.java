package design_pattern.command.after;

public class BoardDeleteCommand implements Command {

  @Override
  public void execute() {
    System.out.println("Board 삭제 처리");
    
  }

  
}
