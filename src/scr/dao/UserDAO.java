package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



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
		try(
			Connection conn=Conn.getConnection();
			PreparedStatement pstmt=conn.prepareStatement("insert into student values(?,?,?,?,?,?,?,?)");){
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
	
	
	
}
