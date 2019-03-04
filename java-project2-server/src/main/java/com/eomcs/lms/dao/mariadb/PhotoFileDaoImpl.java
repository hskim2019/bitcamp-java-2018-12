package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.eomcs.lms.dao.PhotoFileDao;
import com.eomcs.lms.domain.PhotoFile;

public class PhotoFileDaoImpl implements PhotoFileDao{

	// DAO가 사용하는 커넥션 객체를 외부에서 주입 받는다
	Connection con;

	public PhotoFileDaoImpl(Connection con) {
		this.con = con;
	}

	@Override
	public List<PhotoFile> findByPhotoBoardNo(int photoBoardNo) {   // list

		try (PreparedStatement stmt = con.prepareStatement(
				"select photo_file_id, photo_id, file_path "
						+ " from lms_photo_file"
						+ " where photo_id = ? "
						+ " order by photo_file_id asc")) {

			stmt.setInt(1, photoBoardNo); //특정 사진 게시물에 대해 첨부 파일을 가져오기
			stmt.executeUpdate();

			try (ResultSet rs = stmt.executeQuery()) {

				ArrayList<PhotoFile> list = new ArrayList<>();
				while (rs.next()) {
					PhotoFile photoFile = new PhotoFile();
					photoFile.setNo(rs.getInt("photo_file_id"));
					photoFile.setPhotoBoardNo(rs.getInt("photo_id"));
					photoFile.setFilePath(rs.getString("file_path"));

					list.add(photoFile);
				}
				return list;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//	  public List<PhotoBoard> findByKeyword(String keyword) {   // 검색 기능
	//
	//	    try (PreparedStatement stmt = con.prepareStatement(
	//	        "select photoBoard_id, conts, cdt, vw_cnt from lms_photoBoard"
	//	        + " where conts like concat('%', ? , '%')"
	//	        + " order by photoBoard_id desc")) {
	//
	//	      stmt.setString(1, keyword);
	//	      
	//	      try (ResultSet rs = stmt.executeQuery()) {
	//
	//	        ArrayList<PhotoBoard> list = new ArrayList<>();
	//	        while (rs.next()) {
	//	          PhotoBoard photoBoard = new PhotoBoard();
	//	          photoBoard.setNo(rs.getInt("photoBoard_id"));
	//	          photoBoard.setContents(rs.getString("conts"));
	//	          photoBoard.setCreatedDate(rs.getDate("cdt"));
	//	          photoBoard.setViewCount(rs.getInt("vw_cnt"));
	//
	//	          list.add(photoBoard);
	//	        }
	//	        return list;
	//	      }
	//	    } catch (Exception e) {
	//	      throw new RuntimeException(e);
	//	    }
	//	  }
	//	  

	@Override
		  public void insert(PhotoFile photoFile) {   //add
	
		    try(PreparedStatement stmt = con.prepareStatement(
		        "insert into lms_photo_file(file_path,photo_id) values(?,?);")) {
		      stmt.setString(1, photoFile.getFilePath());
		      stmt.setInt(2, photoFile.getPhotoBoardNo());
		      stmt.executeUpdate();
		      
		    }   catch (Exception e) {
		      throw new RuntimeException(e);
		    }
		  }
	
	//	  public PhotoBoard findByNo(int no) {    //detail
	//
	//	    try {
	//	      // 조회수 증가
	//	      try (PreparedStatement stmt = con.prepareStatement(
	//	          "update lms_photo set vw_cnt = vw_cnt + 1 where photo_id = ?")) {
	//	        stmt.setInt(1, no);
	//	        stmt.executeUpdate();
	//	      }
	//
	//	      try(PreparedStatement stmt = con.prepareStatement(
	//	          "select photo_id, titl, cdt, vw_cnt, lesson_id from lms_photo"
	//	          + " where photo_id = ?")) {
	//
	//	        stmt.setInt(1, no);
	//
	//	        try(ResultSet rs = stmt.executeQuery()) {  //ResultSet rs 는 결과를 가져 올 도구
	//
	//	          if(rs.next()) {               //rs.next() : 가져올 것이 있으면 return true
	//	            PhotoBoard photoBoard = new PhotoBoard();
	//	            photoBoard.setNo(rs.getInt("photo_id"));
	//	            photoBoard.setTitle(rs.getString("titl"));
	//	            photoBoard.setCreatedDate(rs.getDate("cdt"));
	//	            photoBoard.setViewCount(rs.getInt("vw_cnt"));
	//	            photoBoard.setLessonNo(rs.getInt("lesson_id"));
	//	            return photoBoard;
	//	          } else {
	//	            return null;
	//	          }
	//	        }
	//	      }
	//	    } catch(Exception e) {
	//	      throw new RuntimeException(e);
	//	    }
	//
	//	  }
	//
	//	  public int update(PhotoBoard photoBoard) {
	//
	//
	//	    try(PreparedStatement stmt = con.prepareStatement(
	//	        "update lms_photo set titl =? where photo_id =?")) {
	//
	//	      stmt.setString(1, photoBoard.getTitle());
	//	      stmt.setInt(2, photoBoard.getNo());
	//
	//	      return stmt.executeUpdate();
	//
	//	    } catch(Exception e) {
	//	      throw new RuntimeException(e);
	//	    }
	//	  }
	//
	//	  public int delete(int no) {
	//
	//
	//	    try(PreparedStatement stmt = con.prepareStatement(
	//	        "delete from lms_photo where photo_id = ?")) {
	//
	//	      stmt.setInt(1, no);
	//	      return stmt.executeUpdate();
	//
	//
	//	    } catch (Exception e) {
	//	      throw new RuntimeException(e);
	//	    }
	//	  }
}
