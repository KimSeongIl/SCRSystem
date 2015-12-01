package scr.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.UserDAO;
import scr.dto.UserDTO;

public class LoginProAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		int uid;
		try{
			uid=Integer.parseInt(request.getParameter("uid"));
		}catch(Exception e){
			return "login.jsp";
		}
		String password=request.getParameter("password");
		UserDTO dto=new UserDTO();
		dto.setUid(uid);
		dto.setPassword(password);
		UserDAO dao=UserDAO.getInstance();
		UserDTO user=dao.login(dto);
		
		request.setAttribute("user", user);
		
		return "loginPro.jsp";
	}
}
