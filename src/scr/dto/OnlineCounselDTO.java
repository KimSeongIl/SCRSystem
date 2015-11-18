package scr.dto;

public class OnlineCounselDTO {

	private int onlineCounselId;
	private int studentId;
	private int professorId;
	private String title;
	private String content;
	private String comment;
	
	public void setOnlineCounselId(int onlineCounselId){
		this.onlineCounselId=onlineCounselId;
	}
	public int getOnlineCounselId(){
		return onlineCounselId;
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
	
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	
	public void setComment(String comment){
		this.comment=comment;
	}
	public String getComment(){
		return comment;
	}
}
