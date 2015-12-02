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
	
	public void userAdd(UserDTO user) {
		
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
	
	public void userUpdate(UserDTO user) {
		
		try (
			Connection conn=Conn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("update user set name=?,password=? where user_id=?");){			
		    pstmt.setString(1,user.getName());
			pstmt.setString(2, Sha256.encrypt(user.getPassword()));
		    pstmt.setInt(3, user.getUid());
	
		    pstmt.executeUpdate();
		} catch (Exception e) {
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
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					dto=new UserDTO();
					dto.setUid(rs.getInt("user_id"));
					dto.setName(rs.getString("name"));
					dto.setAuth(rs.getString("auth"));
					
				}
			}catch(Exception e){
				e.printStackTrace();
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
	    	
		    	check=false;
		    }
		} catch (Exception e) {
			e.printStackTrace();
		}	   
		return check;
	}

	public boolean userDelete(UserDTO user){
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from user where user_id=?");){
			
			pstmt.setInt(1, user.getUid());
			pstmt.executeUpdate();
		}catch(Exception e){
			return false;
		}
		return true;
	}
	

}
