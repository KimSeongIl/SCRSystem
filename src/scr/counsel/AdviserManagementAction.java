package scr.counsel;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;


public class AdviserManagementAction implements CommandAction{

public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		if(!"직원".equals(auth)){
			return "permission.jsp";
		}
		
		
		
		return "adviserManagement.jsp";
	}
	
}
