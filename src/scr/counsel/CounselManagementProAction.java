package scr.counsel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;

public class CounselManagementProAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		if(!"교수".equals(auth)){
			return "permission.jsp";
		}


		return "counselManagementProfessor.jsp";
	}
}
