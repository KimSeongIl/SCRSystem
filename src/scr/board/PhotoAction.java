package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import scr.action.CommandAction;

public class PhotoAction implements CommandAction{
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		return "file_uploader_html5.jsp";
		
	}
}
