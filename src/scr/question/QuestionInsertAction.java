package scr.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dto.QuestionDTO;
import scr.dao.QuestionDAO;

public class QuestionInsertAction implements CommandAction {

	
	public  String  requestPro(HttpServletRequest request,HttpServletResponse response){
		
	 
		String qName=request.getParameter("qName");
		String qTitle=request.getParameter("qTitle");
		String qContent=request.getParameter("qContent");
		
		QuestionDAO question=QuestionDAO.getInstance();
		
		question.insertQuestion(qName,qTitle,qContent);
		
		
		return "questionInsert.jsp";
	}
}
