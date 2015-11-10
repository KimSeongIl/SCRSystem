package scr.counsel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.StudentDAO;
import scr.dto.StudentDTO;
import scr.util.JsonUtil;

public class StudentSearchByNameAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("StudentSearchByNameAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		StudentDAO studentDao=StudentDAO.getInstance();
		String name=request.getParameter("studentName");
		List<StudentDTO> list=studentDao.studentSearchByName(name);
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("list", list);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
