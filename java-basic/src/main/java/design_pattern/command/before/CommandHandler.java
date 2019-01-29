package design_pattern.command.before;

public class CommandHandler {

  public void addBoard() {
    System.out.println("Board 입력 처리!");
  }

  public void detailBoard() {
    System.out.println("Board 상세조회 처리!");
  }

  public void listBoard() {
    System.out.println("Board 목록조회 처리!");
  }

  public void updateBoard() {
    System.out.println("Board 변경 처리!");
  }

  public void deleteBoard() {
    System.out.println("Board 삭제 처리");
  }
  

  public void addMember() {
    System.out.println("member 입력 처리!");
  }

  public void detailMember() {
    System.out.println("member 상세조회 처리!");
  }

  public void listMember() {
    System.out.println("member 목록조회 처리!");
  }

  public void updateMember() {
    System.out.println("member 변경 처리!");
  }

  public void deleteMember() {
    System.out.println("member 삭제 처리");
  }

}
