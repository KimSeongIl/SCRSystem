package scr.department;

import java.util.ArrayList;
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

public class DepartmentListAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		HttpSession session=request.getSession();
		
		String auth=(String)session.getAttribute("auth");
		if(!"관리자".equals(auth)){
			return JsonUtil.putFailJsonContainer("ProfessorListAction NoSession", "권한이 없습니다.");
		}
		DepartmentDAO department=DepartmentDAO.getInstance();
		List<DepartmentDTO> list=(ArrayList<DepartmentDTO>)department.departmentList();
		
		Map<String,Object> param=new HashMap<>();
		param.put("departmentList", list);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
