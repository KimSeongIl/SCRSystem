package scr.dto;

import java.sql.Timestamp;

public class QuestionDTO {
	
	private int qid;
	private String qName;
	private String qTitle;
	private String qContent;
	private Timestamp qDates;
	private String qAnswer;
	private String qAnswerContent;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public String getqName() {
		return qName;
	}
	public void setqName(String qName) {
		this.qName = qName;
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
	public String getqAnswer() {
		return qAnswer;
	}
	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}
	public String getqAnswerContent() {
		return qAnswerContent;
	}
	public void setqAnswerContent(String qAnswerContent) {
		this.qAnswerContent = qAnswerContent;
	}
	
	


}
