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
import scr.dao.DepartmentDAO;
import scr.dao.StudentDAO;
import scr.dto.DepartmentDTO;
import scr.util.JsonUtil;

public class CounselCountProAction implements AjaxAction{

	@SuppressWarnings("deprecation")
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("CounselCountAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		CounselDAO counselDao=CounselDAO.getInstance();
		Date date=new Date();
		
		String year=String.valueOf(date.getYear()+1900);
		int month=date.getMonth()+1;
		int term;
		if(month<=6){
			term=1;
		}else{
			term=2;
		}
		HttpSession session=request.getSession();
		int professorId=(int)session.getAttribute("uid");
		
		
		
		StudentDAO studentDao=StudentDAO.getInstance();
		int count=studentDao.studentCountByProfessor(professorId);
		int success=counselDao.counselSuccessCountByProfessor(year, term, professorId);
		
		Map<String,Object> param=new HashMap<>();
		param.put("count", count);
		param.put("successCount", success);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
