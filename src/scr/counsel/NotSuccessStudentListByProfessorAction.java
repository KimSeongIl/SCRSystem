package scr.counsel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.StudentDAO;
import scr.dto.StudentDTO;
import scr.util.JsonUtil;

public class NotSuccessStudentListByProfessorAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("NotSuccessStudentListByProfessorAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		int professorId=Integer.parseInt(request.getParameter("professorId"));
		int departmentId=Integer.parseInt(request.getParameter("departmentId"));
		Date date=new Date();
		
		String year=String.valueOf(date.getYear()+1900);
		int month=date.getMonth()+1;
		int term;
		if(month<=6){
			term=1;
		}else{
			term=2;
		}
		
		StudentDAO studentDao=StudentDAO.getInstance();
		List<StudentDTO> list=studentDao.notSuccessStudentListByProfessor(professorId,departmentId, year, term);
		
		Map<String,Object> param=new HashMap<>();
		param.put("professorList", list);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
