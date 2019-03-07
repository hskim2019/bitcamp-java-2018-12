package ch26.p;

public class Photo {
	
	private int photoNo;
	private String filePath;
	private int boardNo;
	
	@Override
	public String toString() {
		return "Photo [photoNo=" + photoNo + ", filePath=" + filePath + ", boardNo=" + boardNo + "]";
	}

	public int getPhotoNo() {
		return photoNo;
	}

	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	
	
	

}
