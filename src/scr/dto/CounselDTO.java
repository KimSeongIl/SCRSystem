package scr.dto;

import java.sql.Timestamp;
import java.util.Date;

public class CounselDTO {

	private int counselId;
	private String counselDivision;
	private String counselCategory;
	private int studentId;
	private String studentName;
	private int professorId;
	private String professorName;
	private String wantDate;
	private String reason;
	private String file;
	private String counselDate;
	private String status;
	private String year;
	private int term;
	private int count;
	private int success;
	
	
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
	
	
	public void setStudentId(int studentId){
		this.studentId=studentId;
	}
	public int getStudentId(){
		return studentId;
	}
	public void setStudentName(String studentName){
		this.studentName=studentName;
	}
	public String getStudentName(){
		return studentName;
	}
	
	public void setProfessorId(int professorId){
		this.professorId=professorId;
	}
	public int getProfessorId(){
		return professorId;
	}
	public void setProfessorName(String professorName){
		this.professorName=professorName;
	}
	public String getProfessorName(){
		return professorName;
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
	
	public void setCounselDate(String counselDate){
		this.counselDate=counselDate;
	}
	public String getCounselDate(){
		return counselDate;
	}
	
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
	public void setYear(String year){
		this.year=year;
	}
	public String getYear(){
		return year;
	}
	public void setTerm(int term){
		this.term=term;
	}
	public int getTerm(){
		return term;
	}
	public void setCount(int count){
		this.count=count;
	}
	public int getCount(){
		return count;
	}
	public void setSuccess(int success){
		this.success=success;
	}
	public int getSuccess(){
		return success;
	}
}
