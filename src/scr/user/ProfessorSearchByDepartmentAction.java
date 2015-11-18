package scr.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.ProfessorDAO;
import scr.dto.ProfessorDTO;
import scr.util.JsonUtil;

public class ProfessorSearchByDepartmentAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("ProfessorSearchByDepartmentAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		int departmentId=Integer.parseInt(request.getParameter("departmentId"));
		
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		List<ProfessorDTO> professor=professorDao.professorSearchListByDepartment(departmentId);
		
		Map<String,Object> param=new HashMap<>();
		param.put("professor", professor);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
