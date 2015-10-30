package scr.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import scr.action.CommandAction;
import scr.dao.StudentDAO;
import scr.dao.UserDAO;
import scr.dto.*;

public class StudentAddAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		int uid=Integer.parseInt(request.getParameter("uid"));
		String name=request.getParameter("uname");
		String password=request.getParameter("password");
		StudentDTO student=new StudentDTO();
		
		if(request.getParameter("department")!=null){
			int department=Integer.parseInt(request.getParameter("department"));
			student.setDepartmentId(department);
		}
		
		
		if(!"없음".equals(request.getParameter("minor"))){//없음이 아닌상태
			int minor=Integer.parseInt(request.getParameter("minor"));
			student.setMinorId(minor);
		}
		if(!"없음".equals(request.getParameter("doubleMajor"))){
			int doubleMajor=Integer.parseInt(request.getParameter("doubleMajor"));
			student.setDoubleMajorId(doubleMajor);
		}
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String status=request.getParameter("status");
		
		UserDTO user=new UserDTO();
		user.setUid(uid);
		user.setName(name);
		user.setPassword(password);
		user.setAuth("학생");
		
		
		student.setStudentId(uid);
		student.setName(name);
		student.setPhone(phone);
		student.setEmail(email);
		
		
		
		
		
		student.setStatus(status);
		
		UserDAO dao=UserDAO.getInstance();
		dao.userAdd(user);
		StudentDAO studentDao=StudentDAO.getInstance();
		studentDao.studentAdd(student);
		return "main.jsp";
	}
}
