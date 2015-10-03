package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import scr.conn.Conn;
import scr.dto.StudentDTO;
import scr.util.AES256Util;

public class StudentDAO {

	private static StudentDAO instance=new StudentDAO();
	
	private StudentDAO(){
		
	}
	
	public static StudentDAO getInstance(){
		return instance;
	}
	
	public int matchEmail(StudentDTO student){
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select student_id from student where student_id=? and email=?");){
			AES256Util util=new AES256Util();
			
			pstmt.setInt(1, student.getStudentId());
			pstmt.setString(2, util.encrypt(student.getEmail()));
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				return 1;
			}else{
				return 2;
			}
		}catch(Exception e){
			return 2;
		}
	}
	
}
