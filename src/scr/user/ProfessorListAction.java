package scr.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import scr.action.AjaxAction;
import scr.dao.ProfessorDAO;
import scr.dto.ProfessorDTO;
import scr.util.JsonUtil;

public class ProfessorListAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		if(!("관리자".equals(auth)) && !("학생".equals(auth))){
			return JsonUtil.putFailJsonContainer("ProfessorListAction NoSession", "권한이 없습니다.");
		}
		
		
		List<ProfessorDTO> list=null;
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		
		int page=Integer.parseInt(request.getParameter("page"));
		double count=professorDao.professorCount();
		
		int limit=5;
		double pageCount=count/limit;

		
		list=professorDao.professorList((page-1)*limit,limit);
		
		
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("professorList", list);
		param.put("pageCount", Math.ceil(pageCount));
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
