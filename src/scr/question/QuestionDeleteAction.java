package scr.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import scr.action.CommandAction;
import scr.dao.QuestionDAO;
import scr.dto.QuestionDTO;

public class QuestionDeleteAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		String q=request.getParameter("qid");
	
		int qid=Integer.parseInt(q);
		
		QuestionDAO question=QuestionDAO.getInstance();
		
		question.deleteQuestion(qid);
		
		return "questionDelete.jsp";
		
		
	}

}
