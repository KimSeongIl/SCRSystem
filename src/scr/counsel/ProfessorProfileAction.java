package scr.counsel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dao.ProfessorDAO;
import scr.dto.ProfessorDTO;

public class ProfessorProfileAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		if(request.getParameter("pid")==null){
			return "badAccess.jsp";
		}
		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		if( !("학생".equals(auth))){
			return "permission.jsp";
		}
		int pid=Integer.parseInt(request.getParameter("pid"));
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		ProfessorDTO professor=professorDao.selectById(pid);
		
		request.setAttribute("professor", professor);
		return "professorProfile.jsp";
	}
}
