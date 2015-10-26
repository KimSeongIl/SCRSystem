package scr.dto;

public class EmployeeDTO {

	private int employeeId;
	private String employeeName;
	private String phone;
	private String email;
	
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
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
	}
	
}
