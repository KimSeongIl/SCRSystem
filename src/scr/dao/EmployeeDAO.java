package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import scr.conn.Conn;
import scr.dto.EmployeeDTO;
import scr.dto.StudentDTO;
import scr.util.AES256Util;

public class EmployeeDAO {

	private static EmployeeDAO instance=new EmployeeDAO();
	
	private EmployeeDAO(){
		
	}
	public static EmployeeDAO getInstance(){
		return instance;
	}
	
	public double employeeCount(){
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) \"count\" from employee");){
			
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
	
	
	
	public double employeeSearchCountByName(String content){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) \"count\" from employee where employee_name like concat ('%', ?, '%') ");){

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
	
	
	public List<EmployeeDTO> employeeSearchListByName(int start,int limit,String content){
		List<EmployeeDTO> list=new ArrayList<>();
		

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select employee_id,employee_name,phone,email"
						
						+ " from employee where employee_name like concat ('%', ?, '%')  order by employee_id limit ?,?");){

			pstmt.setString(1, content);
			pstmt.setInt(2, start);
			pstmt.setInt(3, limit);
			AES256Util util=new AES256Util();
			try(ResultSet rs=pstmt.executeQuery();){
				

				if(rs.next()){
					do{

						EmployeeDTO employee=new EmployeeDTO();

						employee.setEmployeeId(rs.getInt("employee_id"));
						employee.setEmployeeName(rs.getString("employee_name"));
						employee.setPhone(util.decrypt(rs.getString("phone")));
						employee.setEmail(util.decrypt(rs.getString("email")));
						
						
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
	
	public List<EmployeeDTO> employeeList(){
		List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select employee_id,employee_name,phone,email from employee order by employee_id")){
			
	
			try(ResultSet rs=pstmt.executeQuery();){
				
				AES256Util util=new AES256Util();
				if(rs.next()){
					do{
						EmployeeDTO employee=new EmployeeDTO();
						employee.setEmployeeId(rs.getInt("employee_id"));
						employee.setEmployeeName(rs.getString("employee_name"));
						employee.setPhone(util.decrypt(rs.getString("phone")));
						employee.setEmail(util.decrypt(rs.getString("email")));
						
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
	public List<EmployeeDTO> employeeList(int start,int limit){
		List<EmployeeDTO> list=new ArrayList<EmployeeDTO>();
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select employee_id,employee_name,phone,email from employee order by employee_id limit ?,?")){
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, limit);
			try(ResultSet rs=pstmt.executeQuery();){
				
				AES256Util util=new AES256Util();
				if(rs.next()){
					do{
						EmployeeDTO employee=new EmployeeDTO();
						employee.setEmployeeId(rs.getInt("employee_id"));
						employee.setEmployeeName(rs.getString("employee_name"));
						employee.setPhone(util.decrypt(rs.getString("phone")));
						employee.setEmail(util.decrypt(rs.getString("email")));
						
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
	
	public EmployeeDTO employeeUpdateInfo(EmployeeDTO employeedto) {
		EmployeeDTO employee=new EmployeeDTO();
		try (
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt = conn.prepareStatement("select employee_id,employee_name,email,phone from employee where employee_id=?");){
				pstmt.setInt(1, employeedto.getEmployeeId());
			    
			    try(ResultSet rs=pstmt.executeQuery();){	
			    	AES256Util util=new AES256Util();
			    	if(rs.next()){		    	
			    		do{						
			    					
			    			employee.setEmployeeId(rs.getInt("employee_id"));
			    			employee.setEmployeeName(rs.getString("Employee_name"));
			    			employee.setEmail(util.decrypt(rs.getString("email")));
			    			employee.setPhone(util.decrypt(rs.getString("phone")));
			    			
			    		}while(rs.next());
			    	}
			    	}catch(Exception e){
			    		e.printStackTrace();
			    	}				
			}catch(Exception e){
				e.printStackTrace();
			}						
		return employee;
	}
	
	
	public void employeeUpdate(EmployeeDTO employee) {

		String column="employee_id,employee_name,email,phone";
		
		String param="?,?,?,?";
		String query="UPDATE employee SET employee_name=?,email=?,phone=?";
		
		
		query+=" where employee_id=?";
		System.out.println(query);	
		try(
			Connection conn=Conn.getConnection();
			
			PreparedStatement pstmt=conn.prepareStatement(query);){
			
			AES256Util util=new AES256Util();
			
			pstmt.setString(1,employee.getEmployeeName());
			pstmt.setString(2, util.encrypt(employee.getEmail()));
			pstmt.setString(3,util.encrypt(employee.getPhone()));			
			pstmt.setInt(4, employee.getEmployeeId());
			
			pstmt.executeUpdate();			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
	
	
	
}
