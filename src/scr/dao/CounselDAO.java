package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import scr.conn.Conn;
import scr.dto.CounselDTO;

public class CounselDAO {

	private static CounselDAO instance=new CounselDAO();
	
	private CounselDAO(){
		
	}
	
	public static CounselDAO getInstance(){
		return instance;
	}
	
	
	public void counselAdd(CounselDTO counsel){
		
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into counsel(counsel_division,counsel_category,term,student_id,professor_id,want_date,reason,file,status) values(?,?,?,?,?,?,?,?,?);")){
			
			pstmt.setString(1, counsel.getCounselDivision());
			pstmt.setString(2,counsel.getCounselCategory());
			pstmt.setInt(3, counsel.getTerm());
			pstmt.setInt(4, counsel.getStudentId());
			pstmt.setInt(5,counsel.getProfessorId());
			pstmt.setString(6, counsel.getWantDate());
			pstmt.setString(7, counsel.getReason());
			pstmt.setString(8, counsel.getFile());
			pstmt.setString(9, counsel.getStatus());
			
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void groupCounselAdd(int professorId,int studentId){
		
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into group_counsel(counsel_id,professor_id,student_id) values(LAST_INSERT_ID(),?,?);")){
			
			pstmt.setInt(1, professorId);
			pstmt.setInt(2, studentId);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
