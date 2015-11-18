package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import scr.conn.Conn;
import scr.dto.OnlineCounselDTO;

public class OnlineCounselDAO {

	private static OnlineCounselDAO instance=new OnlineCounselDAO();
	
	private OnlineCounselDAO(){
		
	}
	
	public static OnlineCounselDAO getInstance(){
		return instance;
	}
	
	public void addOnlineCounsel(OnlineCounselDTO online){
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into online_counsel(student_id,professor_id,title,content) values(?,?,?,?);");){
			
			pstmt.setInt(1, online.getStudentId());
			pstmt.setInt(2, online.getProfessorId());
			pstmt.setString(3, online.getTitle());
			pstmt.setString(4, online.getContent());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
