package scr.dto;

import java.sql.Timestamp;

public class QuestionDTO {
	
	private int qid;
	private int uid;
	private String qName;
	private String qTitle;
	private String qContent;
	private Timestamp qDates;
	private int aid;
	private String qAnswerContent;
	
	
	public String getqName() {
		return qName;
	}
	public void setqName(String qName) {
		this.qName = qName;
	}
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	
	
	
	
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	
	
	
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	
	
	
	public Timestamp getqDates() {
		return qDates;
	}
	public void setqDates(Timestamp qDates) {
		this.qDates = qDates;
	}
	
	
	
	
	public String getqAnswerContent() {
		return qAnswerContent;
	}
	public void setqAnswerContent(String qAnswerContent) {
		this.qAnswerContent = qAnswerContent;
	}
	
	


}
