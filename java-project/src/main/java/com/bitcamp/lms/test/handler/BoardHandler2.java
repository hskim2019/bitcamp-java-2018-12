package com.bitcamp.lms.test.handler;

import java.sql.Date;
import java.util.Scanner;
import com.bitcamp.lms.test.domain.Board;

public class BoardHandler2 {

  public static Scanner keyboard;
  static final int LENGTH = 10;
  
  
  static Board[] boards = new Board[LENGTH];
  static int boardIdx = 0;
  
  public static void listBoard() {
    for(int c = 0; c < boardIdx; c++) {
      System.out.printf("%d, %-20s, %s, %d\n", boards[c].no, boards[c].info, boards[c].creatDate, boards[c].countView);
    }
    System.out.println();
  }

  public static void addBoard() {
    Board board = new Board();

    System.out.print("번호? ");
    board.no = Integer.parseInt(keyboard.nextLine());

    System.out.print("내용? ");
    board.info = keyboard.nextLine();

    board.creatDate = new Date(System.currentTimeMillis());

    board.countView = 0;

    boards[boardIdx++] = board;

    System.out.println();
  }
  
}
