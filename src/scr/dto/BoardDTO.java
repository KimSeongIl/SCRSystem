package scr.dto;

import java.sql.Timestamp;

public class BoardDTO {

	private int bId;
	private String bName;
	private String bTitle;
	private String bContent;
	private Timestamp bDate;
	private String category;
	private String bFile;
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	public String getbFile() {
		return bFile;
	}
	public void setbFile(String bFile) {
		this.bFile = bFile;
	}
	
	
	
	
	public int getBId() {
		return bId;
	}
	public void setBId(int bId) {
		this.bId = bId;
	}
	
	
	public String getBName() {
		return bName;
	}
	public void setBName(String bName) {
		this.bName = bName;
	}
	
	
	public String getBTitle() {
		return bTitle;
	}
	public void setBTitle(String bTitle) {
		this.bTitle = bTitle;
	}
	
	
	public String getBContent() {
		return bContent;
	}
	public void setBContent(String bContent) {
		this.bContent = bContent;
	}
	
	
	public void setBDate(Timestamp bDate){
		this.bDate=bDate;
	}
	public Timestamp getBDate(){
		return bDate;
	}
	

}
