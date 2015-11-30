package scr.counsel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.StudentDAO;
import scr.util.JsonUtil;

public class UpdateAdviserAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("UpdateAdviserAction NotPost 001", "비정상적인 접근방식입니다");
		}
		StudentDAO studentDao=StudentDAO.getInstance();
		int professorId=Integer.parseInt(request.getParameter("professorId"));
		String student=request.getParameter("studentList");
		studentDao.deleteAdviser(professorId);
		studentDao.updateAdviser(student, professorId);
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
}
