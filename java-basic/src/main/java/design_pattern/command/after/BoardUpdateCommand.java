package design_pattern.command.after;

public class BoardUpdateCommand implements Command {

  @Override
  public void execute() {
    System.out.println("Board 변경 처리!");
    
  }

  
}
