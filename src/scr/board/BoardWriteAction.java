package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;

public class BoardWriteAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		String management=request.getParameter("management");
		String category=request.getParameter("category");
		
		request.setAttribute("management", management);
		request.setAttribute("category", category);
		
		return "boardWrite.jsp";
	}
}
