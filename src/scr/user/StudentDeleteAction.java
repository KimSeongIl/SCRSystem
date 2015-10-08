package scr.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.StudentDAO;
import scr.dao.UserDAO;
import scr.dto.UserDTO;
import scr.util.JsonUtil;

public class StudentDeleteAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("StudentDeleteAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		UserDTO user=new UserDTO();
		user.setUid(uid);
		StudentDAO studentDao=StudentDAO.getInstance();
		studentDao.studentDelete(user);;
		UserDAO userDao=UserDAO.getInstance();
		userDao.userDelete(user);
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
}
