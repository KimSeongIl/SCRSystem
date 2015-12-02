package scr.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dao.DepartmentDAO;
import scr.dao.ProfessorDAO;
import scr.dto.DepartmentDTO;
import scr.dto.ProfessorDTO;

public class ProfessorUpdateAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		HttpSession session=request.getSession();
		int professorId = (int)session.getAttribute("uid");
		ProfessorDTO professorDTO=new ProfessorDTO();	
		professorDTO.setProfessorId(professorId);
		
		ProfessorDAO professorDAO=ProfessorDAO.getInstance();
		
		ProfessorDTO professor = professorDAO.professorUpdateInfo(professorDTO);
		
		request.setAttribute("professorUpdate",professor);		
		
		DepartmentDAO departmentDAO=DepartmentDAO.getInstance();
		List<DepartmentDTO> list = departmentDAO.departmentList();
		
		request.setAttribute("departmentUpdate",list);	
		
		return "professorMyPage.jsp";
	}
	
}
