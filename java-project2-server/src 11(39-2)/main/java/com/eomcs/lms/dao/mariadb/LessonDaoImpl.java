package com.eomcs.lms.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.util.ConnectionFactory;

public class LessonDaoImpl implements LessonDao {

	// DAO가 사용하는 커넥션 객체를 외부에서 주입 받는다
	//Connection con;

	//public LessonDaoImpl(Connection con) {
	//  this.con = con;
	//}

	public List<Lesson> findAll() { //list

		try (Connection con = ConnectionFactory.create();
				PreparedStatement stmt = con.prepareStatement(
						"select lesson_id, sdt, edt, tot_hr, day_hr, titl, conts from lms_lesson"
								+ " order by lesson_id desc")) {

			try (ResultSet rs = stmt.executeQuery()) {

				ArrayList<Lesson> list = new ArrayList<>();
				while (rs.next()) {
					Lesson lesson = new Lesson();
					lesson.setNo(rs.getInt("lesson_id"));
					lesson.setStartDate(rs.getDate("sdt"));
					lesson.setEndDate(rs.getDate("edt"));
					lesson.setTotalHours(rs.getInt("tot_hr"));
					lesson.setDayHours(rs.getInt("day_hr"));
					lesson.setTitle(rs.getString("titl"));
					lesson.setContents(rs.getString("conts"));

					list.add(lesson);
				}
				return list;
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public List<Lesson> findByKeyword(String keyword) { // 검색

		try (Connection con = ConnectionFactory.create();
				PreparedStatement stmt = con.prepareStatement(
						"select lesson_id, sdt, edt, tot_hr, day_hr, titl, conts from lms_lesson"
								+ " where titl like concat('%', ?, '%')"
								+ " or conts like concat('%', ?, '%')"
								+ " order by lesson_id desc")) {

			stmt.setString(1, keyword);
			stmt.setString(2, keyword);

			try (ResultSet rs = stmt.executeQuery()) {

				ArrayList<Lesson> list = new ArrayList<>();
				while (rs.next()) {
					Lesson lesson = new Lesson();
					lesson.setNo(rs.getInt("lesson_id"));
					lesson.setStartDate(rs.getDate("sdt"));
					lesson.setEndDate(rs.getDate("edt"));
					lesson.setTotalHours(rs.getInt("tot_hr"));
					lesson.setDayHours(rs.getInt("day_hr"));
					lesson.setTitle(rs.getString("titl"));
					lesson.setContents(rs.getString("conts"));

					list.add(lesson);
				}
				return list;
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}




	public void insert(Lesson lesson) {   //add

		try(Connection con = ConnectionFactory.create();
				PreparedStatement stmt = con.prepareStatement(
						"insert into lms_lesson(titl, conts, sdt, edt, tot_hr, day_hr) values(?, ?, ?, ?, ?, ?)")) {   //SQL문에 ; 있어도 되고 없어도 됨
			stmt.setString(1, lesson.getTitle());
			stmt.setString(2, lesson.getContents());
			stmt.setDate(3, lesson.getStartDate());
			stmt.setDate(4, lesson.getEndDate());
			stmt.setInt(5, lesson.getTotalHours());
			stmt.setInt(6, lesson.getDayHours());

			stmt.executeUpdate();

		}   catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public Lesson findByNo(int no) {  //detail

		try(Connection con = ConnectionFactory.create();
				PreparedStatement stmt = con.prepareStatement(
						"select lesson_id, sdt, edt, tot_hr, day_hr, titl, conts from lms_lesson where lesson_id = ?")) {

			stmt.setInt(1, no);

			try(ResultSet rs = stmt.executeQuery()) {  //ResultSet rs 는 결과를 가져 올 도구

				if(rs.next()) {               //rs.next() : 가져올 것이 있으면 return true
					Lesson lesson = new Lesson();
					lesson.setNo(rs.getInt("lesson_id"));
					lesson.setStartDate(rs.getDate("sdt"));
					lesson.setEndDate(rs.getDate("edt"));
					lesson.setTotalHours(rs.getInt("tot_hr"));
					lesson.setDayHours(rs.getInt("day_hr"));
					lesson.setTitle(rs.getString("titl"));
					lesson.setContents(rs.getString("conts"));
					return lesson;
				} else {
					return null;
				}
			}

		} catch(Exception e) {
			throw new RuntimeException(e);
		}

	}

	public int update(Lesson lesson) {

		try(Connection con = ConnectionFactory.create();
				PreparedStatement stmt = con.prepareStatement(
						"update lms_lesson set sdt =?, edt =?, tot_hr =?, day_hr =?, titl =?, conts =? where lesson_id =?")) {

			stmt.setDate(1, lesson.getStartDate());
			stmt.setDate(2, lesson.getEndDate());
			stmt.setInt(3, lesson.getTotalHours());
			stmt.setInt(4, lesson.getDayHours());
			stmt.setString(5, lesson.getTitle());
			stmt.setString(6, lesson.getContents());
			stmt.setInt(7,  lesson.getNo());

			return stmt.executeUpdate();

		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	public int delete(int no) {

		try(Connection con = ConnectionFactory.create();
				PreparedStatement stmt = con.prepareStatement(
						"delete from lms_lesson where lesson_id = ?")) {

			stmt.setInt(1, no);
			return stmt.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}









