package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import scr.conn.Conn;
import scr.dto.EmployeeDTO;

public class EmployeeDAO {

	private static EmployeeDAO instance=new EmployeeDAO();
	
	private EmployeeDAO(){
		
	}
	public static EmployeeDAO getInstance(){
		return instance;
	}
	
	public EmployeeDTO getDepartmentId(EmployeeDTO employee){
		EmployeeDTO result=null;
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select department_id from employee where employee_id=?");){
			
			pstmt.setInt(1, employee.getEmployeeId());
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					result=new EmployeeDTO();
					result.setDepartmentId(rs.getInt("department_id"));
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
			
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return result;
	}
}
