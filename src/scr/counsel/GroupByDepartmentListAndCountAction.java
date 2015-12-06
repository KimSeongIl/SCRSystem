package scr.counsel;

import java.util.Date;
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

public class GroupByDepartmentListAndCountAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("GroupByDepartmentListAndAcountAction NotPost 001", "비정상적인 접근방식입니다");
		}
		HttpSession session=request.getSession();
		int professorId=(int)session.getAttribute("uid");
		
		Date date=new Date();
		
		String year=String.valueOf(date.getYear()+1900);
		int month=date.getMonth()+1;
		int term;
		if(month<=6){
			term=1;
		}else{
			term=2;
		}
		CounselDAO counselDao=CounselDAO.getInstance();
		List<CounselDTO> list=counselDao.groupByDepartmentListAndCount(professorId, year, term);
		Map<String,Object> param =new HashMap<>();
		param.put("departmentList", list);
		
		return JsonUtil.putSuccessJsonContainer(param);
		
	}
}
