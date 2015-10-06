package scr.dto;

import java.sql.Timestamp;

public class NoticeDTO {

	private int nId;
	private String nName;
	private String nTitle;
	private String nContent;
	private Timestamp nDate;
	
	public int getNId() {
		return nId;
	}
	public void setNId(int nId) {
		this.nId = nId;
	}
	
	
	public String getNName() {
		return nName;
	}
	public void setNName(String nName) {
		this.nName = nName;
	}
	
	
	public String getNTitle() {
		return nTitle;
	}
	public void setNTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	
	
	public String getNContent() {
		return nContent;
	}
	public void setNContent(String nContent) {
		this.nContent = nContent;
	}
	
	
	public void setNDate(Timestamp nDate){
		this.nDate=nDate;
	}
	public Timestamp getNDate(){
		return nDate;
	}
	

}
