package scr.dto;

public class DepartmentDTO {

	private int departmentId;
	private String departmentName;
	private int officeNo;
	private String officeTel;
	private int employeeId;
	private String employeeName;
	
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
	public void setEmployeeId(int employeeId){
		this.employeeId=employeeId;
	}
	public int getEmployeeId(){
		return employeeId;
	}
	public void setEmployeeName(String employeeName){
		this.employeeName=employeeName;
	}
	public String getEmployeeName(){
		return employeeName;
	}
}
