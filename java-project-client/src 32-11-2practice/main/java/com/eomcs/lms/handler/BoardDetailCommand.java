package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardDetailCommand implements Command {
  
  Scanner keyboard;
  
  public BoardDetailCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      out.writeUTF("/board/detail");
      
      out.flush();
      if(!in.readUTF().equals("OK"))
        return;
      
      out.writeInt(no);
      out.flush();

      String status = in.readUTF();

      if (!status.equals("OK")) {
        System.out.println("데이터 가져오기 실패!");
        throw new Exception("서버에서 게시글 가져오기 실패!");
      }

      Board board = (Board) in.readObject();
      
      System.out.printf("내용: %s\n", board.getContents());
      System.out.printf("작성일: %s\n", board.getCreatedDate());
      
    } catch (Exception e) {
      System.out.printf("게시글 상세 정보 오류: %s\n", e.getMessage()); 
    }
  }
  
}
