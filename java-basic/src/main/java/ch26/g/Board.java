// select 결과를 저장할 클래스
// 필드는 컬럼명과 같게 해 줌
package ch26.g;

import java.sql.Date;

public class Board {

	private int no;  //필드명은 DB 컬럼과 일치하지 않아도 됨
	private String title;
	private String contents;
	private Date createdDate;
	private int viewCount;
	
	@Override
	public String toString() {
		return "Board2 [no=" + no + ", title=" + title + ", contents=" + contents + ", createdDate=" + createdDate
				+ ", viewCount=" + viewCount + "]";
	}
	
	public int getNo() {  // getBoard_id : 와 같이 getter/setter이름(프로퍼티)이 컬럼명과 같으면 인스턴스에 저장 문제 없음 
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	
}
