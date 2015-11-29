package scr.counsel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.ProfessorDAO;
import scr.dto.ProfessorDTO;
import scr.util.JsonUtil;

public class ProfessorListByDepartmentAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("ProfessorListByDepartmentAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		int departmentId=Integer.parseInt(request.getParameter("departmentId"));
		
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		List<ProfessorDTO> list=professorDao.professorListByDepartment(departmentId);
		Map<String,Object> param=new HashMap<>();
		param.put("professor", list);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
