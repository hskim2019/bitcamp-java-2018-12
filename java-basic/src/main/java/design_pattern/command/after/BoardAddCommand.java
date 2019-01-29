package design_pattern.command.after;

public class BoardAddCommand implements Command {

  @Override
  public void execute() {
    System.out.println("Board 입력 처리!");
    
  }

  
}
