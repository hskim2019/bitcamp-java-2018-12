package com.bitcamp.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.bitcamp.lms.domain.Board;

public class BoardHandler {

  Scanner keyboard;
  static final int LENGTH = 10;  //=> [1]board list로 이동, 없애기 ,데이터 저장할 배열 관련이므로
  Board[] boards = new Board[LENGTH]; // =>[1] board list로 이동, 없애기
  int boardIdx = 0;   // =>[1] board list로 이동, 없애기
  // [2]BoardList boardList = new BoardList(); 이 부분 추가하기  데이터 관리는 BoardList가
  
  //생성자
  public BoardHandler (Scanner keyboard) {
    this.keyboard = keyboard;
  }
  
  public void listBoard() {
    //Board[] boards = boardList.toArray(); [4] boards는 배열주소/ toArray의 ArrayList는 Board가 아니라 Object 타입이므로 Board[] boards ==> Object[] objects로 변경/ 받아 올 공간일 뿐 추가   목록을 배열로 만들어라
    // for - each 문으로 변경로
    // for (Board board : boards) { board.getNo() ....}    // 위에서 Object배열로 만들었기 때문에 Board배열이 아님, Boardboard : boards ==>for(Object object : objects)
    //     값을받아줄변수  : 모두 출력할 배열 변수 이름              // 대신 다시 Board board = (Board) object;추가해서 Object에서 Board형으로 형변환
    for (int j = 0; j < boardIdx; j++) { // 옆에 for는 위의 for-each문으로 대체
      System.out.printf("%3d, %-20s, %s, %d\n", 
          this.boards[j].getNo(), this.boards[j].getContents(), this.boards[j].getCreatedDate(), this.boards[j].getViewCount());
    } //현재는 BoardHandler의 boards[j] 배열에 가서 주소를 찾아가지만, 데이터를 BoardList에 저장했기 때문에
      // board(번지)에 찾아가면 됨
  }

  public void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.setNo(Integer.parseInt(keyboard.nextLine()));

    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    board.setCreatedDate(new Date(System.currentTimeMillis())); 

    board.setViewCount(0);

    this.boards[this.boardIdx] = board; // 없애기: 이제 index 관리는 보드리스트가
    this.boardIdx++;               // 없애기 :이제 index 관리는 보드 리스트가
    // => boardList.add(board); [3]  //값이 담겨있는 인스턴스 주소를 Board list에 전달, Boardlist는 받아서 arr 배열에 주소 저장

    System.out.println("저장하였습니다.");
  }
  
  

}
