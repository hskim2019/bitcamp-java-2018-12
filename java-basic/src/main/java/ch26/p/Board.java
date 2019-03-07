package ch26.p;

import java.util.List;

public class Board {
	
	private int no;     
	private String contents;
	private String createdDate;
	private int viewCount;
	
	List<Photo> files;
	
	public List<Photo> getFiles() {
		return files;
	}


	public void setFiles(List<Photo> files) {
		this.files = files;
	}


	@Override
	public String toString() {
		return "Board [no=" + no + ", contents=" + contents + ", createdDate=" + createdDate + ", viewCount="
				+ viewCount + "]";
	}
	
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	

}
