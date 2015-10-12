package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import scr.dto.*;
import scr.conn.Conn;
import scr.util.*;

public class UserDAO {

	private static UserDAO instance=new UserDAO();
	
	
	private UserDAO(){
		
	}
	
	
	public static UserDAO getInstance(){
		return instance;
	}
	
	public void studentAdd(UserDTO user) {
		
		try (
			Connection conn=Conn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into user values(?,?,?,?)");){
			pstmt.setInt(1, user.getUid());
		    pstmt.setString(2, Sha256.encrypt(user.getPassword()));
		    pstmt.setString(3, user.getName());
		    pstmt.setString(4, user.getAuth());
		    pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	}
	public void studentInfoAdd(StudentDTO student) {

		String column="student_id,name,email,phone,department_id";
		String param="?,?,?,?,?,?";
		String query;
		int num1=0;
		int num2=0;
		if(student.getMinorId()!=0){
			param+=",?";
			column+=",minor_id";
			num1++;
			
		}
			
		if(student.getDoubleMajorId()!=0){
			param+=",?";
			column+=",double_major_id";
			num2++;
		}
		column+=",status";
		query="insert into student("+column+") values("+param+")";
		
	
		
		try(
			Connection conn=Conn.getConnection();
			
			PreparedStatement pstmt=conn.prepareStatement(query);){

			AES256Util util=new AES256Util();
			pstmt.setInt(1, student.getStudentId());
			pstmt.setString(2,student.getName());
			pstmt.setString(3, util.encrypt(student.getEmail()));
			pstmt.setString(4,util.encrypt(student.getPhone()));
			pstmt.setInt(5,student.getDepartmentId());
			pstmt.setInt(6, student.getMinorId());
			pstmt.setInt(7, student.getDoubleMajorId());
			pstmt.setString(8, student.getStatus());
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
	public UserDTO login(UserDTO user){
		UserDTO dto=null;
		try(
			Connection conn=Conn.getConnection();
			PreparedStatement pstmt=conn.prepareStatement("select user_id,name,auth from user where user_id=? and password=?");){
			pstmt.setInt(1, user.getUid());
			pstmt.setString(2, Sha256.encrypt(user.getPassword()));
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				dto=new UserDTO();
				dto.setUid(rs.getInt("user_id"));
				dto.setName(rs.getString("name"));
				dto.setAuth(rs.getString("auth"));
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}

	public void setTempPassword(UserDTO user){
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update user set password=? where user_id=?");){
			
			pstmt.setString(1, Sha256.encrypt(user.getPassword()));
			pstmt.setInt(2, user.getUid());
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
public boolean passwordCheck(UserDTO user) {
		boolean check = false;
		try (
			Connection conn=Conn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select user_id from user where user_id=? and password=? ");){
			pstmt.setInt(1, user.getUid());
		    pstmt.setString(2, Sha256.encrypt(user.getPassword()));
		    ResultSet rs=pstmt.executeQuery();
		    if(rs.next()){		    	
		    	check=true;
		    }else{
		    	boolean dto ;
		    	check=false;
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}	   
		return check;
	}
	
	
}
