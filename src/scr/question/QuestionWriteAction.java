package scr.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.QuestionDAO;

public class QuestionWriteAction implements CommandAction {
	
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
	
		
		
		return "questionWrite.jsp";
	}

}
