package scr.counsel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.CounselDAO;
import scr.dto.CounselDTO;
import scr.util.JsonUtil;

public class CounselListByDateAction implements AjaxAction{
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("CounselListByDateAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
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
		
		count=counselDao.counselCountByDate(year,term);
		
		
		List<CounselDTO> list=counselDao.counselListByDate((page-1)*limit,limit,year, term);
		
		Map<String,Object> param=new HashMap<>();
		double pageCount=count/limit;
		param.put("pageCount", Math.ceil(pageCount));
		param.put("counselList", list);
		return JsonUtil.putSuccessJsonContainer(param);
	}

}
