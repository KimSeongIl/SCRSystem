package scr.dto;

public class CounselRecordDTO {

	private int counselId;
	private String counselDate;
	private String content;
	private String recordDate;
	
	public void setCounselId(int counselId){
		this.counselId=counselId;
	}
	public int getCounselId(){
		return counselId;
	}
	public void setCounselDate(String counselDate){
		this.counselDate=counselDate;
	}
	public String getCounselDate(){
		return counselDate;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setRecordDate(String recordDate){
		this.recordDate=recordDate;
	}
	public String getRecordDate(){
		return recordDate;
	}
}
