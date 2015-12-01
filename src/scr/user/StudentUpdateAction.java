package scr.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dao.DepartmentDAO;
import scr.dao.StudentDAO;
import scr.dto.DepartmentDTO;
import scr.dto.StudentDTO;

public class StudentUpdateAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		HttpSession session=request.getSession();
		int studentId = (int)session.getAttribute("uid");
		StudentDTO studentDTO=new StudentDTO();	
		studentDTO.setStudentId(studentId);
		
		StudentDAO studentDAO=StudentDAO.getInstance();
		
		StudentDTO student = studentDAO.studentUpdateInfo(studentDTO);
		
		request.setAttribute("studentUpdate",student);		
		
		DepartmentDAO departmentDAO=DepartmentDAO.getInstance();
		List<DepartmentDTO> list = departmentDAO.departmentList();
		
		request.setAttribute("departmentUpdate",list);	
		
		return "studentMyPage.jsp";
	}
	
}
