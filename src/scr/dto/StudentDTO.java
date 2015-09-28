package scr.dto;

public class StudentDTO {

	private int studentId;
	private String name;
	private String email;
	private String phone;
	private int departmentId;
	private int minorId;
	private int doubleMajorId;
	private String status;
	
	public void setStudentId(int studentId){
		this.studentId=studentId;
	}
	public int getStudentId(){
		return studentId;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getEmail(){
		return email;
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
	public void setMinorId(int minorId){
		this.minorId=minorId;
	}
	public int getMinorId(){
		return minorId;
	}
	public void setDoubleMajorId(int doubleMajorId){
		this.doubleMajorId=doubleMajorId;
	}
	public int getDoubleMajorId(){
		return doubleMajorId;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
	}
}
