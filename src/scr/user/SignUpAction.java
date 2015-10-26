package scr.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import scr.action.CommandAction;
import scr.dao.DepartmentDAO;
import scr.dto.DepartmentDTO;

public class SignUpAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		DepartmentDAO department=DepartmentDAO.getInstance();
		

		
		List<DepartmentDTO> list=department.departmentList();
		
		
		request.setAttribute("department",list);
		
		
		
		return "signUp.jsp";
	}
}
