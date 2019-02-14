// 서버에서 데이터 가져오는 건 여기서 

package com.eomcs.lms.agent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import com.eomcs.lms.domain.Board;

public class BoardAgent {
  @SuppressWarnings("unchecked")
  public static List<Board> list(ObjectInputStream in, ObjectOutputStream out) throws Exception { //list

    out.writeUTF("/board/list"); 
    out.flush();
    if (!in.readUTF().equals("OK"))
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

    String status = in.readUTF();

    if (!status.equals("OK")) 
      throw new Exception("서버에서 게시글 목록 가져오기 실패!");

    return (List<Board>) in.readObject();
  }


  public static void add(Board board, ObjectInputStream in, ObjectOutputStream out) throws Exception { // add
    out.writeUTF("/board/add"); 
    out.flush();
    if(!in.readUTF().equals("OK"))
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");

    out.writeObject(board);
    out.flush();

    String status = in.readUTF();

    if (!status.equals("OK"))
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");
  }


  public static Board get(int no, ObjectInputStream in, ObjectOutputStream out) throws Exception { // detail

    out.writeUTF("/board/detail");
    out.flush();
    if(!in.readUTF().equals("OK"))
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다.");


    out.writeInt(no);
    out.flush();

    String status = in.readUTF();

    if (!status.equals("OK")) {
      throw new Exception("서버에서 게시글 가져오기 실패!");
    }

    return (Board) in.readObject();
  }


  public static void update(Board board, ObjectInputStream in, ObjectOutputStream out) throws Exception{  //update

    out.writeUTF("/board/update");
    out.flush();
    if(!in.readUTF().equals("OK"))
      throw new Exception("서버에서 게시글 가져오기 실패!");

    out.writeObject(board);
    out.flush();

    String status = in.readUTF();
    if (!status.equals("OK")) 
      throw new Exception("서버에서 게시글 변경하기 실패!");

  }
  
  
  public static void delete(int no, ObjectInputStream in, ObjectOutputStream out) throws Exception { // delete
    out.writeUTF("/board/delete");

    out.flush();
    if(!in.readUTF().equals("OK"))
      throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

    out.writeInt(no);
    out.flush();

    String status = in.readUTF();

    if (!status.equals("OK"))
      throw new Exception("서버에서 게시글을 삭제하는데 실패!");
  }

}
