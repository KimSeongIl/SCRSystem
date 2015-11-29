package scr.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import scr.action.AjaxAction;
import scr.dao.BoardDAO;
import scr.dao.QuestionDAO;
import scr.dto.QuestionDTO;
import scr.util.JsonUtil;

public class QuestionAnswerAction implements AjaxAction {
	
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

        request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("qid");
		int qId=Integer.parseInt(id);
		
		id=request.getParameter("aid");
		int aId=Integer.parseInt(id);
		String aContent=request.getParameter("aContent");
		
		QuestionDAO question=QuestionDAO.getInstance();
		
		
		question.insertAnswer(qId, aId, aContent);
		
	
		
		return JsonUtil.putSuccessJsonContainer(null);
	}

}
