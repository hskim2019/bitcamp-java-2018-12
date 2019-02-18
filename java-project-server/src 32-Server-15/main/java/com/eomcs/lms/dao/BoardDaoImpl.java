// 14단계: 실제로 일을 하는 클래스 
package com.eomcs.lms.dao;

import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardDaoImpl extends AbstractDao<Board> implements BoardDao {

  public BoardDaoImpl(String filepath) {
    this.filepath = filepath;
  }

  // interface 에서는 insert메서드에 예외를 던지지 않는 것으로 되어 있으나, 추상클래스에서 받은 saveData메서드는 예외 던지기가 있음
  // 이 메서드를 호출한 쪽에는 오류 발생을 알려줘야 하므로 RuntimeException으로 던져준다
  public void insert(Board board) {
    try {
      list.add(board);
      this.saveData();
    } catch(Exception e) {
      throw new RuntimeException(e);
    }
  }

  public List<Board> findAll() {
    return list;
  }

  public Board findByNo(int no) {
    for (Board obj : list) {
      if (obj.getNo() == no) {
        return obj;
      }
    }
    return null;
  }

  public int update(Board board) {
    try {
      int index = 0;
      for (Board obj : list) {
        if (obj.getNo() == board.getNo()) {
          list.set(index, board);
          this.saveData();
          return 1;
        }
        index++;
      }
      return 0;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public int delete(int no){
    try {
      int index = 0;
      for (Board obj : list) {
        if (obj.getNo() == no) {
          list.remove(index);
          this.saveData();
          return 1;
        }
        index++;
      }
      return 0;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
