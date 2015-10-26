package scr.dto;

public class DepartmentDTO {

	private int departmentId;
	private String departmentName;
	private String officeNo;
	private String officeTel;
	private int employeeId;
	
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
	public void setOfficeNo(String officeNo){
		this.officeNo=officeNo;
	}
	public String getOfficeNo(){
		return officeNo;
	}
	public void setOfficeTel(String officeTel){
		this.officeTel=officeTel;
	}
	public String getOfficeTel(){
		return officeTel;
	}
	public void setEmployeeId(int employeeId){
		this.employeeId=employeeId;
	}
	public int getEmployeeId(){
		return employeeId;
	}
}
