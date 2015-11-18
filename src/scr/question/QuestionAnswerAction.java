package scr.question;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

import scr.action.AjaxAction;
import scr.dao.NoticeDAO;
import scr.dao.QuestionDAO;
import scr.dto.QuestionDTO;
import scr.util.JsonUtil;

public class QuestionAnswerAction implements AjaxAction {
	
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

        request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("qid");
		int qId=Integer.parseInt(id);
		String aName=request.getParameter("aName");
		String aContent=request.getParameter("aContent");
		
		QuestionDAO question=QuestionDAO.getInstance();
		
		
		question.insertAnswer(qId, aName, aContent);
		
	
		
		return JsonUtil.putSuccessJsonContainer(null);
	}

}
