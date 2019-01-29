package design_pattern.command.after;

public class BoardDetailCommand implements Command {

  @Override
  public void execute() {
    System.out.println("Board 상세조회 처리!");
    
  }

  
}
