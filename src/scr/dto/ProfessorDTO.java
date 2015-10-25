package scr.dto;

public class ProfessorDTO {

	private int professorId;
	private String professorName;
	private int officeNo;
	private String officeTel;
	private String phone;
	
	
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
	public void setOfficeNo(int officeNo){
		this.officeNo=officeNo;
	}
	public int getOfficeNo(){
		return officeNo;
	}
	public void setOfficeTel(String officeTel){
		this.officeTel=officeTel;
	}
	public String getOfficeTel(){
		return officeTel;
	}
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	
	
}
