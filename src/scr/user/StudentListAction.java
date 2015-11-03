package scr.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.StudentDAO;
import scr.dto.StudentDTO;
import scr.util.JsonUtil;

public class StudentListAction implements AjaxAction{
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		HttpSession session=request.getSession();
		
		String auth=(String)session.getAttribute("auth");
		if(!"관리자".equals(auth)){
			return JsonUtil.putFailJsonContainer("ProfessorListAction NoSession", "권한이 없습니다.");
		}
		List<StudentDTO> list=null;
		StudentDAO studentDao=StudentDAO.getInstance();
		
		int page=Integer.parseInt(request.getParameter("page"));
		double count=studentDao.studentCount();
		
		int limit=10;
		double pageCount=count/limit;
		list=studentDao.studentList((page-1)*limit,limit);
		
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("studentList", list);
		param.put("pageCount", Math.ceil(pageCount));
		return JsonUtil.putSuccessJsonContainer(param);
		
	}
}
