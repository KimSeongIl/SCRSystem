package scr.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.EmployeeDAO;
import scr.dao.UserDAO;
import scr.dto.EmployeeDTO;
import scr.dto.UserDTO;
import scr.util.JsonUtil;

public class EmployeeAddAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
	
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("EmployeeAddAction NotPost 001", "비정상적인 접근방식입니다");
		}
		HttpSession session=request.getSession();
		if(!"관리자".equals(session.getAttribute("auth"))){
			return JsonUtil.putFailJsonContainer("EmployeeAddAction NoSession", "권한이 없습니다.");
		}
		int employeeId=Integer.parseInt(request.getParameter("employeeId"));
		String employeeName=request.getParameter("employeeName");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		
		UserDTO user=new UserDTO();
		user.setUid(employeeId);
		user.setName(employeeName);

		user.setPassword(String.valueOf(employeeId));
		user.setAuth("직원");
		UserDAO userDao=UserDAO.getInstance();
		if(!userDao.overlapCheck(user)){
			userDao.userAdd(user);
			
			EmployeeDTO employee=new EmployeeDTO();
			employee.setEmployeeId(employeeId);
			employee.setEmployeeName(employeeName);
			employee.setPhone(phone);
			employee.setEmail(email);
			
			EmployeeDAO employeeDao=EmployeeDAO.getInstance();
			employeeDao.employeeAdd(employee);
		}else{
			return JsonUtil.putFailJsonContainer("EmployeeAddAction OverLapId", "직원번호가 중복됩니다.");
		}
		
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
	
}
