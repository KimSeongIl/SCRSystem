package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import scr.conn.Conn;
import scr.dto.ProfessorDTO;
import scr.util.AES256Util;

public class ProfessorDAO {

	private static ProfessorDAO instance=new ProfessorDAO();

	private ProfessorDAO(){

	}

	public static ProfessorDAO getInstance(){
		return instance;
	}

	public double professorCount(){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) \"count\" from professor");){

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

	public double professorSearchCountByProfessor(String content){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) \"count\" from professor where professor_name like concat ('%', ?, '%') ");){

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

	public double professorSearchCountByDepartment(String content){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) \"count\" from professor where department_id in (select department_id from department where department_name like concat ('%', ?, '%') ) or professor_id in (select professor_id from pro_dept where department_id in (select department_id from department where department_name like concat ('%', ?, '%') ));");){

			pstmt.setString(1, content);
			pstmt.setString(2, content);

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
	
	
	public List<ProfessorDTO> professorSearchListByProfessor(int start,int limit,String content){
		List<ProfessorDTO> list=new ArrayList<>();


		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select professor_id,professor_name,department_id,"
						+ "ifnull((select department_name from department where department_id=professor.department_Id),'없음') \"department\" "
						+ " from professor where professor_name like concat ('%', ?, '%')  order by department_id,professor_id limit ?,?");){

			pstmt.setString(1, content);
			pstmt.setInt(2, start);
			pstmt.setInt(3, limit);
			
			try(ResultSet rs=pstmt.executeQuery();){
				

				if(rs.next()){
					do{

						ProfessorDTO professor=new ProfessorDTO();

						professor.setProfessorId(rs.getInt("professor_id"));
						professor.setProfessorName(rs.getString("professor_name"));
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

	public List<ProfessorDTO> professorSearchListByDepartment(int start,int limit,String content){
		List<ProfessorDTO> list=new ArrayList<>();


		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select professor_id,professor_name,department_id,"
						+ "ifnull((select department_name from department where department_id=professor.department_Id),'없음') \"department\" "
						+ " from professor where department_id in (select department_id from department where department_name like concat ('%', ?, '%')) or professor_id in (select professor_id from pro_dept where department_id in (select department_id from department where department_name like concat ('%', ?, '%'))) order by department_id,professor_id limit ?,?");){

			pstmt.setString(1, content);
			pstmt.setString(2, content);
			pstmt.setInt(3, start);
			pstmt.setInt(4, limit);
			
			try(ResultSet rs=pstmt.executeQuery();){
				

				if(rs.next()){
					do{

						ProfessorDTO professor=new ProfessorDTO();

						professor.setProfessorId(rs.getInt("professor_id"));
						professor.setProfessorName(rs.getString("professor_name"));
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
	public List<ProfessorDTO> professorList(int start,int limit){
		List<ProfessorDTO> list=new ArrayList<>();


		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select professor_id,professor_name,office_no,office_tel,phone,email,department_id,"
						+ "ifnull((select department_name from department where department_id=professor.department_Id),'없음') \"department\" "
						+ " from professor order by department_id,professor_id limit ?,?");){

			pstmt.setInt(1, start);
			pstmt.setInt(2, limit);
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
						professor.setEmail(util.decrypt(rs.getString("email")));
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
		String column="professor_id,professor_name,phone,email";
		String param="?,?,?,?";
		String query;
		int num=0;
		int num1=0;
		int num2=0;
		int num3=0;


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
		if(professor.getImg()!=null){
			param+=",?";
			column+=",img";
			num3++;
		}

		query="insert into professor("+column+") values("+param+")";



		try(
				Connection conn=Conn.getConnection();

				PreparedStatement pstmt=conn.prepareStatement(query);){
			AES256Util util=new AES256Util();
			pstmt.setInt(1, professor.getProfessorId());

			pstmt.setString(2,professor.getProfessorName());
			pstmt.setString(3, util.encrypt(professor.getPhone()));
			pstmt.setString(4, util.encrypt(professor.getEmail()));
			if(professor.getOfficeNo()!=0){
				pstmt.setInt(5,professor.getOfficeNo());
			}

			if(professor.getOfficeTel()!=null){
				pstmt.setString(4+num+num1,professor.getOfficeTel());
			}

			if(professor.getDepartmentId()!=0){
				pstmt.setInt(4+num+num1+num2, professor.getDepartmentId());
			}
			if(professor.getImg()!=null){
				pstmt.setString(4+num+num1+num2+num3, professor.getImg());
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


	public int matchEmail(ProfessorDTO professor){

		try(
				Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select professor_id from professor where professor_id=? and email=?");){
			AES256Util util=new AES256Util();

			pstmt.setInt(1, professor.getProfessorId());
			pstmt.setString(2, util.encrypt(professor.getEmail()));
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
