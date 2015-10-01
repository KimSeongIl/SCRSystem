package scr.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;

public class LoginAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		return "login.jsp";
	}
}
