package scr.department;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.EmployeeDAO;
import scr.dto.EmployeeDTO;

public class DepartmentManagementAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
	
		EmployeeDAO employeeDao=EmployeeDAO.getInstance();
		List<EmployeeDTO> list=employeeDao.employeeList();
		request.setAttribute("employeeList", list);
		return "departmentManagement.jsp";
	}
}
