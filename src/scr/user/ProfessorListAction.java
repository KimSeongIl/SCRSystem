package scr.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;

import scr.action.AjaxAction;
import scr.dao.EmployeeDAO;
import scr.dao.ProfessorDAO;
import scr.dto.EmployeeDTO;
import scr.dto.ProfessorDTO;
import scr.util.JsonUtil;

public class ProfessorListAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		HttpSession session=request.getSession();
		if(session.getAttribute("uid")==null){
			return JsonUtil.putFailJsonContainer("ProfessorListAction NoSession", "권한이 없습니다.");
		}
		int uid=(int)session.getAttribute("uid");
		String auth=(String)session.getAttribute("auth");
		List<ProfessorDTO> list=null;
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		if("직원".equals(auth)){
			EmployeeDTO employee=new EmployeeDTO();
			employee.setEmployeeId(uid);
			EmployeeDAO employeeDao=EmployeeDAO.getInstance();
			EmployeeDTO departmentId=employeeDao.getDepartmentId(employee);
			list=professorDao.professorList(departmentId);
		}else if("관리자".equals(auth) || "학생".equals(auth)){
			list=professorDao.professorList(null);
		}else{
			return null;
		}
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("professorList", list);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
