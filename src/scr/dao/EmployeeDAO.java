package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import scr.conn.Conn;
import scr.dto.EmployeeDTO;
import scr.util.AES256Util;

public class EmployeeDAO {

	private static EmployeeDAO instance=new EmployeeDAO();
	
	private EmployeeDAO(){
		
	}
	public static EmployeeDAO getInstance(){
		return instance;
	}
	
	public List<EmployeeDTO> employeeList(){
		List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select employee_id,employee_name,phone,email,"
						+ "ifnull((select department_id from department where employee_id=employee.employee_id),0) \"department_id\", "
						+ "ifnull((select department_name from department where employee_id=employee.employee_id),'없음') \"department\" "
						+ " from employee order by employee_id")){
			try(ResultSet rs=pstmt.executeQuery();){
				
				AES256Util util=new AES256Util();
				if(rs.next()){
					do{
						EmployeeDTO employee=new EmployeeDTO();
						employee.setEmployeeId(rs.getInt("employee_id"));
						employee.setEmployeeName(rs.getString("employee_name"));
						employee.setPhone(util.decrypt(rs.getString("phone")));
						employee.setEmail(util.decrypt(rs.getString("email")));
						employee.setDepartmentId(rs.getInt("department_id"));
						employee.setDepartmentName(rs.getString("department"));
						list.add(employee);
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
	
	public void employeeAdd(EmployeeDTO employee){
		
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into employee(employee_id,employee_name,phone,email) values(?,?,?,?)");){
			AES256Util util=new AES256Util();
			pstmt.setInt(1, employee.getEmployeeId());
			pstmt.setString(2, employee.getEmployeeName());
			pstmt.setString(3, util.encrypt(employee.getPhone()));
			pstmt.setString(4, util.encrypt(employee.getEmail()));
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public int matchEmail(EmployeeDTO employee){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select employee_id from employee where employee_id=? and email=?");){
			AES256Util util=new AES256Util();

			pstmt.setInt(1, employee.getEmployeeId());
			pstmt.setString(2, util.encrypt(employee.getEmail()));
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
	
	
}
