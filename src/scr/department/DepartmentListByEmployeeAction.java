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

public class DepartmentListByEmployeeAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		if(!"직원".equals(auth)){
			return JsonUtil.putFailJsonContainer("ProfessorListAction NoSession", "권한이 없습니다.");
		}
		int employeeId=(int)session.getAttribute("uid");
		DepartmentDAO departmentDao=DepartmentDAO.getInstance();
		List<DepartmentDTO> list=departmentDao.departmentListByEmployee(employeeId);
		
		Map<String,Object> param=new HashMap<>();
		param.put("department",list);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
