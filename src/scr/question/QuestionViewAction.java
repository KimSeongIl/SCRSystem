package scr.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;

public class QuestionViewAction implements CommandAction{
	
	 public String requestPro(HttpServletRequest request,HttpServletResponse ressponse)throws Throwable{
		 
		 
		 return "questionView.jsp";
	 }

}
