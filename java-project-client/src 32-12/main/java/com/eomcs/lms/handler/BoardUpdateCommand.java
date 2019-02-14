package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import com.eomcs.lms.agent.BoardAgent;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {

  Scanner keyboard;

  public BoardUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    //==
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());
    //==
    try { 
      //====detailcommand에서 가져 옴


      Board board = BoardAgent.get(no, in, out);
      //====detailcommand에서 가져 옴

      //==2
      Board temp = board.clone();

      System.out.printf("내용? ");
      String input = keyboard.nextLine();
      if (input.length() > 0) 
        temp.setContents(input);
      //==2  


      //boardtest에서 가져 온 내용  => BoardAgent로 옮김
      BoardAgent.update(temp, in, out);

      //boardtest에서 가져 온 내용 

      System.out.println("게시글을 변경했습니다.");

    } catch (Exception e) {
      System.out.println("변경 중 오류 발생!");
    }
  }
}