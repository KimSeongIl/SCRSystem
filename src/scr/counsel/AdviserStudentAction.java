package scr.counsel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dao.ProfessorDAO;

public class AdviserStudentAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		if(!"직원".equals(auth)){
			return "permission.jsp";
		}
		
		int departmentId=Integer.parseInt(request.getParameter("did"));
		int professorId=Integer.parseInt(request.getParameter("pid"));
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		String professorName=professorDao.selectProfessorName(professorId);
		request.setAttribute("departmentId", departmentId);
		request.setAttribute("professorName", professorName);
		request.setAttribute("professorId", professorId);
		return "adviserStudent.jsp";
	}
}
