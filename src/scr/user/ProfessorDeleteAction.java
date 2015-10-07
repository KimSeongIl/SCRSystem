package scr.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.AjaxAction;
import scr.dao.ProfessorDAO;
import scr.dao.UserDAO;
import scr.dto.UserDTO;
import scr.util.JsonUtil;

public class ProfessorDeleteAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("ProfessorDeleteAction NotPost 001", "비정상적인 접근방식입니다");
		}
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		
		UserDTO user=new UserDTO();
		user.setUid(uid);
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		professorDao.professorDelete(user);;
		UserDAO userDao=UserDAO.getInstance();
		userDao.userDelete(user);
		
		return JsonUtil.putSuccessJsonContainer(null);
	}
}
