package scr.dto;

public class StudentDTO {

	private int studentId;
	private String name;
	private String email;
	private String phone;
	private int departmentId;
	private String departmentName;
	private int minorId;
	private String minorName;
	private int doubleMajorId;
	private String doubleMajorName;
	private String status;
	private int professorId;
	private String professorName;
	
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
	public void setDepartmentName(String departmentName){
		this.departmentName=departmentName;
	}
	public String getDepartmentName(){
		return departmentName;
	}
	public void setMinorId(int minorId){
		this.minorId=minorId;
	}
	public int getMinorId(){
		return minorId;
	}
	public void setMinorName(String minorName){
		this.minorName=minorName;
	}
	public String getMinorName(){
		return minorName;
	}
	public void setDoubleMajorId(int doubleMajorId){
		this.doubleMajorId=doubleMajorId;
	}
	public int getDoubleMajorId(){
		return doubleMajorId;
	}
	public void setDoubleMajorName(String doubleMajorName){
		this.doubleMajorName=doubleMajorName;
	}
	public String getDoubleMajorName(){
		return doubleMajorName;
	}
	public void setStatus(String status){
		this.status=status;
	}
	public String getStatus(){
		return status;
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
}
