package scr.counsel;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.CounselDAO;
import scr.dao.DepartmentDAO;
import scr.dao.StudentDAO;
import scr.dto.DepartmentDTO;
import scr.util.JsonUtil;

public class CounselCountAction implements AjaxAction{
	@SuppressWarnings("deprecation")
	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("CounselCountAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		CounselDAO counselDao=CounselDAO.getInstance();
		Date date=new Date();
		
		String year=String.valueOf(date.getYear()+1900);
		int month=date.getMonth()+1;
		int term;
		if(month<=6){
			term=1;
		}else{
			term=2;
		}
		HttpSession session=request.getSession();
		int employeeId=(int)session.getAttribute("uid");
		DepartmentDAO department=DepartmentDAO.getInstance();
		List<DepartmentDTO> departmentList=department.departmentListByEmployee(employeeId);
		String str="";
		for(int i=0;i<departmentList.size();i++){
			if(i!=(departmentList.size()-1)){
				str+=departmentList.get(i).getDepartmentId()+",";
			}else{
				str+=departmentList.get(i).getDepartmentId();
			}
		}
		StudentDAO studentDao=StudentDAO.getInstance();
		int count=studentDao.studentCountByDepartment(str);
		int success=counselDao.counselSuccessCountByDate(year, term, str);
		
		Map<String,Object> param=new HashMap<>();
		param.put("count", count);
		param.put("successCount", success);
		
		return JsonUtil.putSuccessJsonContainer(param);
	}
}
