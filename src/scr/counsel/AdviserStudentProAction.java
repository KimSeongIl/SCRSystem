package scr.counsel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dao.ProfessorDAO;

public class AdviserStudentProAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		if(!"교수".equals(auth)){
			return "permission.jsp";
		}
		int professorId=(int)session.getAttribute("uid");
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		String professorName=professorDao.selectProfessorName(professorId);
		request.setAttribute("professorName", professorName);
		request.setAttribute("professorId", professorId);
		return "adviserStudentPro.jsp";
	}
}
