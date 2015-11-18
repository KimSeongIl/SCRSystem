package scr.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import scr.action.CommandAction;
import scr.dao.QuestionDAO;
import scr.dto.QuestionDTO;

public class QuestionDetailViewAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		String id=request.getParameter("qid");
		int qid=Integer.parseInt(id);
		QuestionDAO question=QuestionDAO.getInstance();
		
		QuestionDTO questionList=question.questionViewById(qid);
		
		request.setAttribute("questionList", questionList);
		
		return "questionDetailView.jsp";
		
	}
}
