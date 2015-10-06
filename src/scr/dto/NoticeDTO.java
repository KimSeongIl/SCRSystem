package scr.dto;

import java.sql.Timestamp;

public class NoticeDTO {

	private int nId;
	private String nName;
	private String nTitle;
	private String nContent;
	private Timestamp nDate;
	
	public int getnId() {
		return nId;
	}
	public void setnId(int nId) {
		this.nId = nId;
	}
	
	
	public String getnName() {
		return nName;
	}
	public void setnName(String nName) {
		this.nName = nName;
	}
	
	
	public String getnTitle() {
		return nTitle;
	}
	public void setnTitle(String nTitle) {
		this.nTitle = nTitle;
	}
	
	
	public String getnContent() {
		return nContent;
	}
	public void setnContent(String nContent) {
		this.nContent = nContent;
	}
	
	
	public void setNDate(Timestamp nDate){
		this.nDate=nDate;
	}
	public Timestamp getNDate(){
		return nDate;
	}
	

}
