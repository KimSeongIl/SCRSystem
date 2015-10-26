package scr.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.EmployeeDAO;
import scr.dto.EmployeeDTO;
import scr.util.JsonUtil;

public class EmployeeListAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		HttpSession session=request.getSession();
		String auth=(String) session.getAttribute("auth");
		if(!"관리자".equals(auth)){
			return JsonUtil.putFailJsonContainer("ProfessorListAction NoSession", "권한이 없습니다.");
		}
		List<EmployeeDTO> list=null;
		
		EmployeeDAO employeeDao=EmployeeDAO.getInstance();
		list=employeeDao.employeeList();
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("employeeList", list);
		
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
