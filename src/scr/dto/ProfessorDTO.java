package scr.dto;

import java.util.ArrayList;

public class ProfessorDTO {

	private int professorId;
	private String professorName;
	private int officeNo;
	private String officeTel;
	private String phone;
	private String email;
	private int departmentId;
	private String departmentName;
	private String img;
	private ArrayList<DepartmentDTO> departmentList;
	
	
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
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	public void setDepartmentId(int departmentId){
		this.departmentId=departmentId;
	}
	public int getDepartmentId(){
		return departmentId;
	}
	public void setDepartmentName(String departmentName){
		this.departmentName=departmentName;
	}
	public String getDepartmentName(){
		return departmentName;
	}
	public void setImg(String img){
		this.img=img;
	}
	public String getImg(){
		return img;
	}
	public void setDepartmentList(ArrayList<DepartmentDTO> departmentList){
		this.departmentList=departmentList;
	}
	public ArrayList<DepartmentDTO> getDepartmentList(){
		return departmentList;
	}
}
