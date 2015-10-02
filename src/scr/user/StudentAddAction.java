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
		StudentDTO student=new StudentDTO();
		
		if(request.getParameter("department")!=null){
			int department=Integer.parseInt(request.getParameter("department"));
			student.setDepartmentId(department);
		}
		System.out.println(request.getParameter("minor"));
		System.out.println(request.getParameter("doubleMajor"));
		
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
		
		System.out.println(student.getDepartmentId()+"\n"+student.getDoubleMajorId()+"\n"+student.getEmail());
		System.out.println(student.getMinorId()+"\n"+student.getName()+"\n"+student.getPhone()+"\n"+student.getStatus()+"<<상태");
		
		
		
		student.setStatus(status);
		
		UserDAO dao=UserDAO.getInstance();
		dao.studentAdd(user);
		dao.studentInfoAdd(student);
		return "main.jsp";
	}
}
