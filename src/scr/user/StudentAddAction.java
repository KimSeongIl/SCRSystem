package scr.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.UserDAO;
import scr.dto.*;

public class StudentAddAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		int uid=Integer.parseInt(request.getParameter("uid"));
		String name=request.getParameter("uname");
		String password=request.getParameter("password");
		int department=Integer.parseInt(request.getParameter("department"));
		int minor=Integer.parseInt(request.getParameter("minor"));
		int doubleMajor=Integer.parseInt(request.getParameter("doubleMajor"));
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String status=request.getParameter("status");
		
		UserDTO user=new UserDTO();
		user.setUid(uid);
		user.setName(name);
		user.setPassword(password);
		user.setAuth("학생");
		
		StudentDTO student=new StudentDTO();
		student.setStudentId(uid);
		student.setName(name);
		student.setPhone(phone);
		student.setEmail(email);
		student.setDepartmentId(department);
		student.setMinorId(minor);
		student.setDoubleMajorId(doubleMajor);
		student.setStatus(status);
		
		UserDAO dao=UserDAO.getInstance();
		dao.studentAdd(user);
		dao.studentInfoAdd(student);
		return "main.jsp";
	}
}
