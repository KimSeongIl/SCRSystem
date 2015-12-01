package scr.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.EmployeeDAO;
import scr.dao.UserDAO;
import scr.dto.*;

public class EmployeeUpdateProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		int uid=Integer.parseInt(request.getParameter("uid"));
		String name=request.getParameter("uname");
		String password=request.getParameter("password");
		EmployeeDTO employee=new EmployeeDTO();
		
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		UserDTO user=new UserDTO();
		user.setUid(uid);
		user.setName(name);
		user.setPassword(password);
		user.setAuth("직원");
				
		employee.setEmployeeId(uid);
		employee.setEmployeeName(name);
		employee.setPhone(phone);
		employee.setEmail(email);	
				
		UserDAO dao=UserDAO.getInstance();
		
		dao.userUpdate(user);
		
		EmployeeDAO employeeDao=EmployeeDAO.getInstance();
		employeeDao.employeeUpdate(employee);
		return "main.jsp";
	}
}