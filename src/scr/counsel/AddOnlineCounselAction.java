package scr.counsel;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.OnlineCounselDAO;
import scr.dto.OnlineCounselDTO;
import scr.util.JsonUtil;

public class AddOnlineCounselAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("AddOnlineCounselAction NotPost 001", "비정상적인 접근방식입니다");
		}
		HttpSession session=request.getSession();
		int studentId=(int)session.getAttribute("uid");
		int professorId=Integer.parseInt(request.getParameter("professorId"));
		String title=request.getParameter("title");
		String content=request.getParameter("content");
		
		OnlineCounselDTO online=new OnlineCounselDTO();
		online.setStudentId(studentId);
		online.setProfessorId(professorId);
		online.setTitle(title);
		online.setContent(content);
		
		OnlineCounselDAO onlineDao=OnlineCounselDAO.getInstance();
		onlineDao.addOnlineCounsel(online);
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
}
