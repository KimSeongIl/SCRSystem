package scr.dto;

public class UserDTO {

	private int uid;
	private String password;
	private String name;
	private String auth;
	
	public void setUid(int uid){
		this.uid=uid;
	}
	public int getUid(){
		return uid;
	}
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setAuth(String auth){
		this.auth=auth;
	}
	public String getAuth(){
		return auth;
	}
}
