package scr.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.EmployeeDAO;
import scr.dao.StudentDAO;
import scr.dto.EmployeeDTO;
import scr.dto.StudentDTO;
import scr.util.JsonUtil;

public class StudentListAction implements AjaxAction{
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		HttpSession session=request.getSession();
		int uid=(int)session.getAttribute("uid");
		String auth=(String)session.getAttribute("auth");
		List<StudentDTO> list=null;
		StudentDAO studentDao=StudentDAO.getInstance();
		if("직원".equals(auth)){
			EmployeeDTO employee=new EmployeeDTO();
			employee.setEmployeeId(uid);
			EmployeeDAO employeeDao=EmployeeDAO.getInstance();
			EmployeeDTO departmentId=employeeDao.getDepartmentId(employee);
			list=studentDao.studentList(departmentId);
		}else if("관리자".equals(auth)){
			list=studentDao.studentList(null);
		}else{
			return null;
		}
		
		Map<String,Object> param=new HashMap<String,Object>();
		param.put("studentList", list);
		
		return JsonUtil.putSuccessJsonContainer(param);
		
	}
}
