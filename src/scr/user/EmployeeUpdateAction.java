package scr.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dao.EmployeeDAO;
import scr.dto.EmployeeDTO;

public class EmployeeUpdateAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		HttpSession session=request.getSession();
		int employeeId = (int)session.getAttribute("uid");
		EmployeeDTO employeeDTO=new EmployeeDTO();	
		employeeDTO.setEmployeeId(employeeId);
		
		EmployeeDAO employeeDAO=EmployeeDAO.getInstance();
		
		EmployeeDTO employee = employeeDAO.employeeUpdateInfo(employeeDTO);
		System.out.println("employee->"+employee);
		
		request.setAttribute("employeeUpdate",employee);		
				
		return "employeeMyPage.jsp";
	}
}
