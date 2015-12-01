package scr.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dao.UserDAO;
import scr.dto.UserDTO;

public class MyPageCheckAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		HttpSession session=request.getSession();
		int id = (int)session.getAttribute("uid");
		UserDTO dto=new UserDTO();
		String password=request.getParameter("password");
		dto.setUid(id);
		dto.setPassword(password);		
		UserDAO dao=UserDAO.getInstance();
		boolean check=dao.passwordCheck(dto);
		request.setAttribute("check", check);
		
		return "myPagePro.jsp" ;
		
		
	}
}
