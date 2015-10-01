package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import scr.conn.Conn;
import scr.dto.DepartmentDTO;;

public class DepartmentDAO {

	private static DepartmentDAO instance=new DepartmentDAO();
	
	private DepartmentDAO(){
		
	}
	public static DepartmentDAO getInstance(){
		return instance;
	}
	
	
	public List<DepartmentDTO> viewDepartment(){
		List<DepartmentDTO> list=new ArrayList<DepartmentDTO>();
		
		
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select department_id,department_name,office_no,office_tel from department");){

			try( ResultSet rs=pstmt.executeQuery(); ){
				
				if(rs.next()){
					do{
						DepartmentDTO department=new DepartmentDTO();
						department.setDepartmentId(rs.getInt("department_id"));
						department.setDepartmentName(rs.getString("department_name"));
						department.setOfficeNo(rs.getString("office_no"));
						department.setOfficeTel(rs.getString("office_tel"));
						list.add(department);
						
					}while(rs.next());
				}
					
					


				
			}catch(Exception ee){}
		}catch(Exception e){
			e.printStackTrace();
		}

		return list;
	}
			

			
			
	
	
	
	
}
