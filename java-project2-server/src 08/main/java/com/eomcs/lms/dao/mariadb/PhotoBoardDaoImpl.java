package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.dao.PhotoBoardDao;
import com.eomcs.lms.domain.PhotoBoard;

public class PhotoBoardDaoImpl implements PhotoBoardDao{

	 // DAO가 사용하는 커넥션 객체를 외부에서 주입 받는다
	  Connection con;

	  public PhotoBoardDaoImpl(Connection con) {
	    this.con = con;
	  }

	  @Override
	  public List<PhotoBoard> findAll() {   // list

	    try (PreparedStatement stmt = con.prepareStatement(
	        "select photo_id, titl, cdt, vw_cnt, lesson_id from lms_photo"
	            + " order by photo_id desc")) {

	      try (ResultSet rs = stmt.executeQuery()) {

	        ArrayList<PhotoBoard> list = new ArrayList<>();
	        while (rs.next()) {
	          PhotoBoard photoBoard = new PhotoBoard();
	          photoBoard.setNo(rs.getInt("photo_id"));
	          photoBoard.setTitle(rs.getString("titl"));
	          photoBoard.setCreatedDate(rs.getDate("cdt"));
	          photoBoard.setViewCount(rs.getInt("vw_cnt"));
	          photoBoard.setLessonNo(rs.getInt("lesson_id"));

	          list.add(photoBoard);
	        }
	        return list;
	      }
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }
	  }
	  
 
	  
@Override
	  public void insert(PhotoBoard photoBoard) {   //add

	    try(PreparedStatement stmt = con.prepareStatement(
	        "insert into lms_photo(titl,lesson_id) values(?,?)",
	        Statement.RETURN_GENERATED_KEYS)) {
	    	
	      stmt.setString(1, photoBoard.getTitle());  //PhotoBoardAddCommand에서 PhotoBoard에 set 한 Title을 DB의 value에 넣는다
	      stmt.setInt(2, photoBoard.getLessonNo());
	      stmt.executeUpdate();
	      
	      try(ResultSet rs = stmt.getGeneratedKeys()){  //DB에서 insert되면서 자동 생성 된 photo_id를 PhotoBoard의 no변수에 전달 
	    	  rs.next();
	    	  photoBoard.setNo(rs.getInt(1)); // 자동 생성된 PK 값을 파라미터로 받은 객체에 보관한다
	      }
	      
	    }   catch (Exception e) {
	      throw new RuntimeException(e);
	    }
	  }


@Override
	  public PhotoBoard findByNo(int no) {    //detail

	    try {
	      // 조회수 증가
	      try (PreparedStatement stmt = con.prepareStatement(
	          "update lms_photo set vw_cnt = vw_cnt + 1 where photo_id = ?")) {
	        stmt.setInt(1, no);
	        stmt.executeUpdate();
	      }

	      try(PreparedStatement stmt = con.prepareStatement(
	          "select photo_id, titl, cdt, vw_cnt, lesson_id from lms_photo"
	          + " where photo_id = ?")) {

	        stmt.setInt(1, no);

	        try(ResultSet rs = stmt.executeQuery()) {  //ResultSet rs 는 결과를 가져 올 도구

	          if(rs.next()) {               //rs.next() : 가져올 것이 있으면 return true
	            PhotoBoard photoBoard = new PhotoBoard();
	            photoBoard.setNo(rs.getInt("photo_id"));
	            photoBoard.setTitle(rs.getString("titl"));
	            photoBoard.setCreatedDate(rs.getDate("cdt"));
	            photoBoard.setViewCount(rs.getInt("vw_cnt"));
	            photoBoard.setLessonNo(rs.getInt("lesson_id"));
	            return photoBoard;
	          } else {
	            return null;
	          }
	        }
	      }
	    } catch(Exception e) {
	      throw new RuntimeException(e);
	    }

	  }

	  public int update(PhotoBoard photoBoard) {


	    try(PreparedStatement stmt = con.prepareStatement(
	        "update lms_photo set titl =? where photo_id =?")) {

	      stmt.setString(1, photoBoard.getTitle());
	      stmt.setInt(2, photoBoard.getNo());

	      return stmt.executeUpdate();

	    } catch(Exception e) {
	      throw new RuntimeException(e);
	    }
	  }

	  public int delete(int no) {

	    try(PreparedStatement stmt = con.prepareStatement(
	        "delete from lms_photo where photo_id = ?")) {

	      stmt.setInt(1, no);
	      return stmt.executeUpdate();


	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }
	  }
}
