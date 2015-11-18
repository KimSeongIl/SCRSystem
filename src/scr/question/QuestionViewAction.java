package scr.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import scr.action.CommandAction;
import scr.dao.QuestionDAO;
import scr.dto.QuestionDTO;

public class QuestionViewAction implements CommandAction{
	
	 public String requestPro(HttpServletRequest request,HttpServletResponse ressponse)throws Throwable{
		 
		 QuestionDAO question=QuestionDAO.getInstance();
		 
		 List questionList=question.questionView();
		 
		 request.setAttribute("questionList", questionList);
		 
		 return "questionView.jsp";
	 }

}
