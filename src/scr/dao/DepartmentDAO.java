package scr.dao;

public class DepartmentDAO {

	private static DepartmentDAO instance=new DepartmentDAO();
	
	private DepartmentDAO(){
		
	}
	public static DepartmentDAO getInstance(){
		return instance;
	}
}
