package scr.counsel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.CounselDAO;
import scr.dto.CounselDTO;
import scr.util.JsonUtil;

public class CounselListByDateProAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("CounselListByDateProAction NotPost 001", "비정상적인 접근방식입니다");
		}
		HttpSession session=request.getSession();
		int professorId=(int)session.getAttribute("uid");
		
		CounselDAO counselDao=CounselDAO.getInstance();
		String year=request.getParameter("year");
		int term=Integer.parseInt(request.getParameter("term"));
		
		int page=Integer.parseInt(request.getParameter("page"));
		double count =0;
		int limit;
		if(request.getParameter("limit")==null)
			limit=10;
		else
			limit=Integer.parseInt(request.getParameter("limit"));
		
		String type=request.getParameter("type");
		count=counselDao.counselCountByDatePro(year,term,professorId,type);
		
		
		List<CounselDTO> list=counselDao.counselListByDatePro((page-1)*limit,limit,year, term,professorId,type);
		
		Map<String,Object> param=new HashMap<>();
		double pageCount=count/limit;
		param.put("pageCount", Math.ceil(pageCount));
		param.put("counselList", list);
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
