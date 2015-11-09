package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

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
	
	public double studentCount(){
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) \"count\" from student");){
			
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
	public double studentSearchCountByName(String content){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) \"count\" from student where name like concat ('%', ?, '%') ");){

			pstmt.setString(1, content);

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
	
	public List<StudentDTO> studentSearchListByName(int start,int limit,String content){
		List<StudentDTO> list=new ArrayList<>();
		

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select student_id,name,department_id,phone,email,"
						+ "ifnull((select department_name from department where department_id=student.department_Id),'없음') \"department\",minor_id, "
						+ "ifnull((select department_name from department where department_id=minor_id),'없음') \"minor\",double_major_id,"
						+ "ifnull((select department_name from department where department_id=double_major_Id),'없음') \"double_major\",status"
						+ " from student where name like concat ('%', ?, '%')  order by department_id,student_id limit ?,?");){

			pstmt.setString(1, content);
			pstmt.setInt(2, start);
			pstmt.setInt(3, limit);
			AES256Util util=new AES256Util();
			try(ResultSet rs=pstmt.executeQuery();){
				

				if(rs.next()){
					do{

						StudentDTO student=new StudentDTO();

						student.setStudentId(rs.getInt("student_id"));
						student.setName(rs.getString("name"));
						student.setPhone(util.decrypt(rs.getString("phone")));
						student.setEmail(util.decrypt(rs.getString("email")));
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
	public void studentAdd(StudentDTO student) {

		String column="student_id,name,email,phone,department_id,status";
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
			pstmt.setString(6, student.getStatus());
			if(student.getMinorId()!=0){
				pstmt.setInt(6+num1, student.getMinorId());
			}
			if(student.getDoubleMajorId()!=0){
				pstmt.setInt(6+num1+num2, student.getDoubleMajorId());
			}
			
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
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
	
	public List<StudentDTO> studentList(int start,int limit){
		List<StudentDTO> list=new ArrayList<>();
		
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select student_id,name,email,phone,department_id,"
						+ "(select department_name from department where department_id=student.department_Id) \"department\",minor_id,"
						+ "ifnull((select department_name from department where department_id=minor_id),'없음') \"minor\",double_major_id,"
						+ "ifnull((select department_name from department where department_id=double_major_Id),'없음') \"double_major\",status from student order by department_id,student_id limit ?,?");){
			pstmt.setInt(1, start);
			pstmt.setInt(2, limit);
			
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
