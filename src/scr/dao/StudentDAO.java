package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import scr.conn.Conn;
import scr.dto.EmployeeDTO;
import scr.dto.StudentDTO;
import scr.dto.UserDTO;
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
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					return 1;
				}else{
					return 2;
				}
			}catch(Exception e){
				return 2;
			}
			
			
		}catch(Exception e){
			return 2;
		}
	}
	
	public List<StudentDTO> studentList(EmployeeDTO check){
		List<StudentDTO> list=new ArrayList<>();
		String where="";
		if(check!=null){
			where=" where department_id=?";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select student_id,name,email,phone,department_id,"
						+ "(select department_name from department where department_id=student.department_Id) \"department\",minor_id,"
						+ "ifnull((select department_name from department where department_id=minor_id),'없음') \"minor\",double_major_id,"
						+ "ifnull((select department_name from department where department_id=double_major_Id),'없음') \"double_major\",status from student "+where+" order by student_id");){
			if(check!=null){
				pstmt.setInt(1, check.getDepartmentId());
			}
			try(ResultSet rs=pstmt.executeQuery();){
				AES256Util util=new AES256Util();
				
				if(rs.next()){
					do{
						
						StudentDTO student=new StudentDTO();
						
						student.setStudentId(rs.getInt("student_id"));
						student.setName(rs.getString("name"));
						student.setEmail(util.decrypt(rs.getString("email")));
						student.setPhone(util.decrypt(rs.getString("phone")));
						student.setDepartmentId(rs.getInt("department_id"));
						student.setDepartmentName(rs.getString("department"));
						student.setMinorId(rs.getInt("minor_id"));
						student.setMinorName(rs.getString("minor"));
						student.setDoubleMajorId(rs.getInt("double_major_id"));
						student.setDoubleMajorName(rs.getString("double_major"));
						student.setStatus(rs.getString("status"));
						
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
	
	

	
	
}
