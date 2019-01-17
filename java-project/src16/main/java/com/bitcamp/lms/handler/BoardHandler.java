package com.bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.bitcamp.lms.domain.Board;

public class BoardHandler {

  Scanner keyboard;
  BoardList boardList = new BoardList();
  
  //생성자
  public BoardHandler (Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void listBoard() {
    Board[] boards = boardList.toArray(); // 추가  목록을 배열로 만들어라
    // for - each 문으로 변경로
    // for (Board board : boards) { board.getNo() ....}
    //     값을받아줄변수  : 모두 출력할 배열 변수 이름
    for (Board board : boards) { // 옆에 for는 위의 for-each문으로 대체
      System.out.printf("%3d, %-20s, %s, %d\n", 
          board.getNo(), board.getContents(), board.getCreatedDate(), board.getViewCount());
    }
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setViewCount(0);

    boardList.add(board);   //값이 담겨있는 인스턴스 주소를 Board list에 전달, Boardlist는 받아서 arr 배열에 주소 저장

    System.out.println("저장하였습니다.");
  }
  
  

}
