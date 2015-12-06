package scr.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import scr.conn.Conn;
import scr.dto.CounselDTO;
import scr.dto.CounselRecordDTO;
import scr.dto.StudentDTO;

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
	public int counselSuccessCountByDate(String year,int term,String department){
		String comp="";
		if(term==1){
			comp="<=";
		}else{
			comp=">";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(distinct(student_id)) \"count\" from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? and student_id in (select student_id from student where department_id in ("+department+")) and status='완료';");){
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
	public int counselSuccessCountByProfessor(String year,int term,int professorId){
		String comp="";
		if(term==1){
			comp="<=";
		}else{
			comp=">";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(distinct(student_id)) \"count\" from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? and professor_id=? and status='완료';");){
				pstmt.setString(1, year);
				pstmt.setInt(2, professorId);
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
	public double counselCountByDate(String year,int term,String department){
		String comp="";
		if(term==1){
			comp="<=";
		}else{
			comp=">";
		}
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(distinct(student_id)) \"count\" from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? and student_id in (select student_id from student where department_id in ("+department+") or minor_id in ("+department+") or double_major_id in("+department+"));");){
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
	
	public double counselCountByDatePro(String year,int term,int professorId,String type){
		String comp="";
		if(term==1){
			comp="<=";
		}else{
			comp=">";
		}
		String str="";
		if(!"전체".equals(type)){
			str="and status='"+type+"'";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(distinct(student_id)) \"count\" from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? and professor_id=? "+str+";");){
				pstmt.setString(1, year);
				pstmt.setInt(2, professorId);
			
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
	public List<CounselDTO> counselListByDate(int start,int limit,String year,int term,String department){
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
						+ "want_date,reason,file,counsel_date,status from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? and student_id in (select student_id from student where department_id in ("+department+") or minor_id in ("+department+") or double_major_id in ("+department+")) limit ?,?;");){
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
	
	public List<CounselDTO> counselListByDatePro(int start,int limit,String year,int term,int professorId,String type){
		List<CounselDTO> list=new ArrayList<>();
		String comp="";
		if(term==1){
			comp="<=";
		}else{
			comp=">";
		}
		String str="";
		if(!"전체".equals(type)){
			str="and status='"+type+"'";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select counsel_id,counsel_division,counsel_category,student_id,(select name from student where student_id=counsel.student_id) \"student_name\","
						+ "professor_id,(select professor_name from professor where professor_id=counsel.professor_id) \"professor_name\","
						+ "want_date,reason,file,counsel_date,status from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? and professor_id=? "+str+" order by status,student_id limit ?,?;");){
				pstmt.setString(1, year);
				pstmt.setInt(2, professorId);
				pstmt.setInt(3,start);
				pstmt.setInt(4,limit);
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
	public List<CounselDTO> groupByProfessorListAndCount(int departmentId,String year,int term){
		List<CounselDTO> list=new ArrayList<>();
		String comp="";
		if(term==1){
			comp="<=";
		}else{
			comp=">";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select professor_id,professor_name,(select count(student_id) from student where professor_id=professor.professor_id and department_id=?) \"count\" ,(select count(distinct(student_id)) from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? and status='완료' and professor_id=professor.professor_id and student_id in(select student_id from student where department_id=? and status='재학생'))\"success\" from professor where professor_id in (select professor_id from professor where department_id =? ) or professor_id in (select professor_id from pro_dept where department_id=?) group by professor_id")){
			pstmt.setInt(1, departmentId);
			pstmt.setString(2, year);
			pstmt.setInt(3,departmentId);
			pstmt.setInt(4,departmentId);
			pstmt.setInt(5,departmentId);
			
			try(ResultSet rs=pstmt.executeQuery();){
				
				if(rs.next()){
					do{
						CounselDTO counsel=new CounselDTO();
						counsel.setProfessorId(rs.getInt("professor_id"));
						counsel.setProfessorName(rs.getString("professor_name"));
						counsel.setCount(rs.getInt("count"));
						counsel.setSuccess(rs.getInt("success"));
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
	
	public List<CounselDTO> groupByDepartmentListAndCount(int professorId,String year,int term){
		List<CounselDTO> list=new ArrayList<>();
		String comp="";
		if(term==1){
			comp="<=";
		}else{
			comp=">";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select department_id,department_name,(select count(student_id) from student where professor_id=? and (department_id=department.department_id or minor_id=department.department_id or double_major_id=department.department_id)) \"count\" ,(select count(distinct(student_id)) from counsel where date_format(counsel_date,'%m')"+comp+"6 and date_format(counsel_date,'%Y')=? and status='완료' and professor_id=? and student_id in(select student_id from student where (department_id=department.department_id or minor_id=department.department_id or double_major_id=department.department_id) and status='재학생'))\"success\" from department where department_id in (select department_id from professor where professor_id =? ) or department_id in (select department_id from pro_dept where professor_id=?) group by department_id")){
			pstmt.setInt(1, professorId);
			pstmt.setString(2, year);
			pstmt.setInt(3,professorId);
			pstmt.setInt(4,professorId);
			pstmt.setInt(5,professorId);
			
			try(ResultSet rs=pstmt.executeQuery();){
				
				if(rs.next()){
					
					do{
						CounselDTO counsel=new CounselDTO();
						counsel.setDepartmentId(rs.getInt("department_id"));
						counsel.setDepartmentName(rs.getString("department_name"));
						counsel.setCount(rs.getInt("count"));
						counsel.setSuccess(rs.getInt("success"));
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
	
	public CounselDTO counselInfo(int counselId){
		CounselDTO counsel=new CounselDTO();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from counsel where counsel_id=?");){
			pstmt.setInt(1, counselId);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					counsel.setCounselId(counselId);
					counsel.setCounselCategory(rs.getString("counsel_category"));
					counsel.setCounselDate(sdf.format(rs.getTimestamp("counsel_date")));
					counsel.setCounselDivision(rs.getString("counsel_division"));
					counsel.setReason(rs.getString("reason"));
					counsel.setWantDate(rs.getString("want_date"));
					counsel.setFile(rs.getString("file"));
					counsel.setStatus(rs.getString("status"));
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return counsel;
	}
	public List<StudentDTO> groupCounselList(int counselId){
		List<StudentDTO> list=new ArrayList<>();
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select student_id,name from student where student_id in(select student_id from group_counsel where counsel_id=?)");){
			pstmt.setInt(1,counselId);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					do{
						StudentDTO student=new StudentDTO();
						student.setStudentId(rs.getInt("student_id"));
						student.setName(rs.getString("name"));
						list.add(student);
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
	
	public void updateStatus(int counselId,String status){
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update counsel set status=? where counsel_id=?");){
			
			pstmt.setString(1, status);
			pstmt.setInt(2, counselId);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void counselReturn(int counselId,String returnReason){
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update counsel set status='반려',returnReason=? where counsel_id=?");){
			
			pstmt.setString(1, returnReason);
			pstmt.setInt(2, counselId);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void counselRecordAdd(int counselId,String content,String counselDate){
		Date date=Date.valueOf(counselDate);
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into counsel_record(counsel_id,counsel_date,content) values(?,?,?)");){
			
			pstmt.setInt(1, counselId);
			pstmt.setDate(2, date);
			pstmt.setString(3, content);
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public CounselRecordDTO getCounselRecord(int counselId){
		CounselRecordDTO counselRecord=new CounselRecordDTO();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from counsel_record where counsel_id=?");){
			pstmt.setInt(1,counselId);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
					counselRecord.setCounselDate(sdf.format(rs.getDate("counsel_date")));
					counselRecord.setContent(rs.getString("content"));
					sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					counselRecord.setRecordDate(sdf.format(rs.getTimestamp("record_date")));
					
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return counselRecord;
	}
	
}
