package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import scr.conn.Conn;
import scr.dto.EmployeeDTO;
import scr.dto.ProfessorDTO;
import scr.dto.UserDTO;
import scr.util.AES256Util;

public class ProfessorDAO {

	private static ProfessorDAO instance=new ProfessorDAO();
	
	private ProfessorDAO(){
		
	}
	
	public static ProfessorDAO getInstance(){
		return instance;
	}
	
	public List<ProfessorDTO> professorList(EmployeeDTO check){
		List<ProfessorDTO> list=new ArrayList<>();
		String where="";
		if(check!=null){
			where=" where department_id=?";
		}
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select professor_id,professor_name,office_no,office_tel,phone,department_id,"
						+ "ifnull((select department_name from department where department_id=professor.department_Id),'없음') \"department\" "
						+ " from professor "+where+" order by professor_id");){
			if(check!=null){
				pstmt.setInt(1, check.getDepartmentId());
			}
			try(ResultSet rs=pstmt.executeQuery();){
				AES256Util util=new AES256Util();
				
				if(rs.next()){
					do{
						
						ProfessorDTO professor=new ProfessorDTO();
						
						professor.setProfessorId(rs.getInt("professor_id"));
						professor.setProfessorName(rs.getString("professor_name"));
						professor.setOfficeNo(rs.getInt("office_no"));
						professor.setOfficeTel(rs.getString("office_tel"));
						professor.setPhone(util.decrypt(rs.getString("phone")));
						professor.setDepartmentId(rs.getInt("department_id"));
						professor.setDepartmentName(rs.getString("department"));
					
						
						list.add(professor);
						
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
	public void professorAdd(ProfessorDTO professor) {
		String column="professor_id,professor_name,phone";
		String param="?,?,?";
		String query;
		int num=0;
		int num1=0;
		int num2=0;
		
		
		if(professor.getOfficeNo()!=0){
			param+=",?";
			column+=",office_no";
			num++;
			
		}
			
		if(professor.getOfficeTel()!=null){
			param+=",?";
			column+=",office_tel";
			num1++;
		}
		
		if(professor.getDepartmentId()!=0){
			param+=",?";
			column+=",department_id";
			num2++;
		}
		
		query="insert into professor("+column+") values("+param+")";
		
	
		
		try(
			Connection conn=Conn.getConnection();
			
			PreparedStatement pstmt=conn.prepareStatement(query);){
			AES256Util util=new AES256Util();
			pstmt.setInt(1, professor.getProfessorId());
			
			pstmt.setString(2,professor.getProfessorName());
			pstmt.setString(3, util.encrypt(professor.getPhone()));
			if(professor.getOfficeNo()!=0){
				pstmt.setInt(4,professor.getOfficeNo());
			}
			
			if(professor.getOfficeTel()!=null){
				pstmt.setString(3+num+num1,professor.getOfficeTel());
			}
			
			if(professor.getDepartmentId()!=0){
				pstmt.setInt(3+num+num1+num2, professor.getDepartmentId());
			}
			
			pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public void professorDepartmentAdd(int professorId,int departmentId){
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into pro_dept values(?,?);");){
			pstmt.setInt(1, professorId);
			pstmt.setInt(2, departmentId);
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void professorDelete(UserDTO user){
		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from professor where professor_id=?");){
			
			pstmt.setInt(1, user.getUid());
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
