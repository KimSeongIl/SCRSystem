package scr.department;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.DepartmentDAO;
import scr.dto.DepartmentDTO;
import scr.util.JsonUtil;

public class DepartmentDeleteAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("UserDeleteAction NotPost 001", "비정상적인 접근방식입니다");
		}
		HttpSession session=request.getSession();
		if(!"관리자".equals(session.getAttribute("auth"))){
			return JsonUtil.putFailJsonContainer("UserDeleteAction NoSession", "권한이 없습니다.");
		}
		
		int did=Integer.parseInt(request.getParameter("did"));
		DepartmentDTO department=new DepartmentDTO();
		department.setDepartmentId(did);
		DepartmentDAO departmentDao=DepartmentDAO.getInstance();
		departmentDao.departmentDelete(department);
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
}
