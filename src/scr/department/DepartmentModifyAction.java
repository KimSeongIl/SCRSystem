package scr.department;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.DepartmentDAO;
import scr.dto.DepartmentDTO;
import scr.util.JsonUtil;

public class DepartmentModifyAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("EmployeeAddAction NotPost 001", "비정상적인 접근방식입니다");
		}
		HttpSession session=request.getSession();
		if(!"관리자".equals(session.getAttribute("auth"))){
			return JsonUtil.putFailJsonContainer("DepartmentAddAction NoSession", "권한이 없습니다.");
		}
		int originId=Integer.parseInt(request.getParameter("originId"));
		int departmentId=Integer.parseInt(request.getParameter("departmentId"));
		String departmentName=request.getParameter("departmentName");
		int officeNo=Integer.parseInt(request.getParameter("officeNo"));
		String officeTel=request.getParameter("officeTel");
		int employeeId=Integer.parseInt(request.getParameter("employeeId"));
		
		DepartmentDTO department=new DepartmentDTO();
		department.setDepartmentId(departmentId);
		department.setDepartmentName(departmentName);
		department.setOfficeNo(officeNo);
		department.setOfficeTel(officeTel);
		department.setEmployeeId(employeeId);
		
		DepartmentDAO departmentDao=DepartmentDAO.getInstance();
		boolean result=departmentDao.departmentModify(originId,department);
		Map<String,Object> param=new HashMap<>();
		param.put("updated", result);
		
		return JsonUtil.putSuccessJsonContainer(param);
		
	}
}
