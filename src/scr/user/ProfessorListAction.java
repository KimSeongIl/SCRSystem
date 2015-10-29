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
		
		String category=request.getParameter("category");
		String content=request.getParameter("content");
		
		List<ProfessorDTO> list=null;
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		
		int page=Integer.parseInt(request.getParameter("page"));
		double count=0;
		final int limit=5;
		
		Map<String,Object> param=new HashMap<String,Object>();
		if(category==null){
			count=professorDao.professorCount();
			list=professorDao.professorList((page-1)*limit,limit);
		}
		else if("professor".equals(category)){
			count=professorDao.professorSearchCountByProfessor(content);
			list=professorDao.professorSearchListByProfessor((page-1)*limit, limit, content);
			param.put("category", category);
			param.put("content", content);
		}else if("department".equals(category)){
			count=professorDao.professorSearchCountByDepartment(content);
			list=professorDao.professorSearchListByDepartment((page-1)*limit, limit, content);
			param.put("category", category);
			param.put("content", content);
		}
		 
		
		
		double pageCount=count/limit;

		
		
		
		
		
		
		param.put("professorList", list);
		param.put("pageCount", Math.ceil(pageCount));
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
