package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
				PreparedStatement pstmt=conn.prepareStatement("insert into counsel(counsel_division,counsel_category,student_id,professor_id,want_date,reason,file,status) values(?,?,?,?,?,?,?,?);")){
			
			pstmt.setString(1, counsel.getCounselDivision());
			pstmt.setString(2,counsel.getCounselCategory());
			pstmt.setInt(3, counsel.getStudentId());
			pstmt.setInt(4,counsel.getProfessorId());
			pstmt.setString(5, counsel.getWantDate());
			pstmt.setString(6, counsel.getReason());
			pstmt.setString(7, counsel.getFile());
			pstmt.setString(8, counsel.getStatus());
			
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
	
	public List<CounselDTO> getYearList(){
		List<CounselDTO> list=new ArrayList<>();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("SELECT distinct(date_format( counsel_date, '%Y' )) \"year\" FROM counsel order by year;");){
			
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					do{
						CounselDTO counsel=new CounselDTO();
						counsel.setYear(rs.getString("year"));
						list.add(counsel);
					}while(rs.next());
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public double counselCountByDate(String year,int term){
		String comp="";
		if(term==1){
			comp="<=";
		}else{
			comp=">";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) \"count\" from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? ;");){
				pstmt.setString(1, year);
			
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					return rs.getInt("count");
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	public List<CounselDTO> counselListByDate(int start,int limit,String year,int term){
		List<CounselDTO> list=new ArrayList<>();
		String comp="";
		if(term==1){
			comp="<=";
		}else{
			comp=">";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select counsel_id,counsel_division,counsel_category,student_id,(select name from student where student_id=counsel.student_id) \"student_name\","
						+ "professor_id,(select professor_name from professor where professor_id=counsel.professor_id) \"professor_name\","
						+ "want_date,reason,file,counsel_date,status from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? limit ?,?;");){
				pstmt.setString(1, year);
				pstmt.setInt(2,start);
				pstmt.setInt(3,limit);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					
					do{
						CounselDTO counsel=new CounselDTO();
						counsel.setCounselId(rs.getInt("counsel_id"));
						counsel.setCounselDivision(rs.getString("counsel_division"));
						counsel.setCounselCategory(rs.getString("counsel_category"));
						counsel.setStudentId(rs.getInt("student_id"));
						counsel.setStudentName(rs.getString("student_name"));
						counsel.setProfessorId(rs.getInt("professor_id"));
						counsel.setProfessorName(rs.getString("professor_name"));
						counsel.setWantDate(rs.getString("want_date"));
						counsel.setReason(rs.getString("reason"));
						counsel.setFile(rs.getString("file"));
						counsel.setCounselDate(sdf.format(rs.getTimestamp("counsel_date")));
						counsel.setStatus(rs.getString("status"));
						list.add(counsel);
					}while(rs.next());
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
