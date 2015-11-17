package scr.dto;

import java.sql.Timestamp;

public class CounselDTO {

	private int counselId;
	private String counselDivision;
	private String counselCategory;
	private int term;
	private int studentId;
	private int professorId;
	private String wantDate;
	private String reason;
	private String file;
	private Timestamp counselDate;
	private String status;
	
	
	public void setCounselId(int counselId){
		this.counselId=counselId;
	}
	public int getCounselId(){
		return counselId;
	}
	
	public void setCounselDivision(String counselDivision){
		this.counselDivision=counselDivision;
	}
	public String getCounselDivision(){
		return counselDivision;
	}
	
	public void setCounselCategory(String counselCategory){
		this.counselCategory=counselCategory;
	}
	public String getCounselCategory(){
		return counselCategory;
	}
	
	public void setTerm(int term){
		this.term=term;
	}
	public int getTerm(){
		return term;
	}
	
	public void setStudentId(int studentId){
		this.studentId=studentId;
	}
	public int getStudentId(){
		return studentId;
	}
	
	public void setProfessorId(int professorId){
		this.professorId=professorId;
	}
	public int getProfessorId(){
		return professorId;
	}
	
	public void setWantDate(String wantDate){
		this.wantDate=wantDate;
	}
	public String getWantDate(){
		return wantDate;
	}
	
	public void setReason(String reason){
		this.reason=reason;
	}
	public String getReason(){
		return reason;
	}
	
	public void setFile(String file){
		this.file=file;
	}
	public String getFile(){
		return file;
	}
	
	public Timestamp getCounselDate(){
		return counselDate;
	}
	
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
}
