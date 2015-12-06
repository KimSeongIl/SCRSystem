package scr.department;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.DepartmentDAO;
import scr.dto.DepartmentDTO;
import scr.util.JsonUtil;

public class DepartmentListByProfessorAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		if(!"교수".equals(auth)){
			return JsonUtil.putFailJsonContainer("DepartmentListByProfessorAction NoSession", "권한이 없습니다.");
		}
		int professorId=(int)session.getAttribute("uid");
		DepartmentDAO departmentDao=DepartmentDAO.getInstance();
		List<DepartmentDTO> list=departmentDao.departmentListByProfessor(professorId);
		
		Map<String,Object> param=new HashMap<>();
		param.put("department",list);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
