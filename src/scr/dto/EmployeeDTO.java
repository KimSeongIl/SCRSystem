package scr.dto;

public class EmployeeDTO {

	private int employeeId;
	private String employeeName;
	private String phone;
	private int departmentId;
	
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
	public void setPhone(String phone){
		this.phone=phone;
	}
	public String getPhone(){
		return phone;
	}
	public void setDepartmentId(int departmentId){
		this.departmentId=departmentId;
	}
	public int getDepartmentId(){
		return departmentId;
	}
}
