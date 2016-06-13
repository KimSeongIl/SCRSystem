package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import scr.conn.Conn;
import scr.dto.DepartmentDTO;
import scr.util.AES256Util;

public class DepartmentDAO {

	private static DepartmentDAO instance=new DepartmentDAO();

	private DepartmentDAO(){

	}
	public static DepartmentDAO getInstance(){
		return instance;
	}

	public void departmentAdd(DepartmentDTO department){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into department values(?,?,?,?,?)");){

			AES256Util util=new AES256Util();
			pstmt.setInt(1, department.getDepartmentId());
			pstmt.setString(2, department.getDepartmentName());
			pstmt.setInt(3, department.getOfficeNo());
			pstmt.setString(4,util.encrypt(department.getOfficeTel()));
			pstmt.setInt(5, department.getEmployeeId());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public List<DepartmentDTO> departmentList(){
		List<DepartmentDTO> list=new ArrayList<DepartmentDTO>();

		
		try(Connection conn=Conn.getConnection();
				
				PreparedStatement pstmt=conn.prepareStatement("select department_id,department_name,office_no,office_tel,employee_id,(select employee_name from employee where employee_id=department.employee_id) \"employee_name\" from department order by department_id;");){

			try( ResultSet rs=pstmt.executeQuery(); ){
				
				if(rs.next()){
					AES256Util util=new AES256Util();
					do{
						DepartmentDTO department=new DepartmentDTO();
						department.setDepartmentId(rs.getInt("department_id"));
						department.setDepartmentName(rs.getString("department_name"));
						department.setOfficeNo(rs.getInt("office_no"));
						department.setOfficeTel(util.decrypt(rs.getString("office_tel")));
						department.setEmployeeId(rs.getInt("employee_id"));
						department.setEmployeeName(rs.getString("employee_name"));
						list.add(department);

					}while(rs.next());
				}





			}catch(Exception ee){ee.printStackTrace();}
		}catch(Exception e){
			e.printStackTrace();
		}

		return list;
	}

	public boolean departmentModify(int originId,DepartmentDTO department){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update department set department_id=?,department_name=?,office_no=?,office_tel=?,employee_id=? where department_id=?");){

			AES256Util util=new AES256Util();
			pstmt.setInt(1, department.getDepartmentId());
			pstmt.setString(2, department.getDepartmentName());
			pstmt.setInt(3, department.getOfficeNo());
			pstmt.setString(4, util.encrypt(department.getOfficeTel()));
			pstmt.setInt(5, department.getEmployeeId());
			pstmt.setInt(6, originId);
			pstmt.executeUpdate();

		}catch(Exception e){
			return false;
		}
		return true;
	}

	public void departmentDelete(DepartmentDTO department){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from department where department_id=?");){

			pstmt.setInt(1, department.getDepartmentId());
			pstmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
		}
	}


	public List<DepartmentDTO> departmentListByEmployee(int employeeId){
		List<DepartmentDTO> list=new ArrayList<>();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select department_id,department_name from department where employee_id=?");){
			
			pstmt.setInt(1, employeeId);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					do{
						DepartmentDTO department=new DepartmentDTO();
						department.setDepartmentId(rs.getInt("department_id"));
						department.setDepartmentName(rs.getString("department_name"));
						list.add(department);
					}while(rs.next());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<DepartmentDTO> departmentListByProfessor(int professorId){
		List<DepartmentDTO> list=new ArrayList<>();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select department_id,department_name from department where department_id=(select department_id from professor where professor_id=?) or department_id in (select department_id from pro_dept where professor_id=?)");){
			
			pstmt.setInt(1, professorId);
			pstmt.setInt(2, professorId);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					do{
						DepartmentDTO department=new DepartmentDTO();
						department.setDepartmentId(rs.getInt("department_id"));
						department.setDepartmentName(rs.getString("department_name"));
						list.add(department);
					}while(rs.next());
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	



}
