package scr.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.EmployeeDAO;
import scr.util.JsonUtil;

public class EmployeeListAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		EmployeeDAO employeeDao=EmployeeDAO.getInstance();
		//List<EmployeeDTO> list=employeeDao.
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
}
