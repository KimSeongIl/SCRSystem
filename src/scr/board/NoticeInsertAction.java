package scr.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dto.NoticeDTO;

public class NoticeInsertAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		String nName=request.getParameter("nName");
		String nContent=request.getParameter("nContent");
		
		NoticeDTO notice =new NoticeDTO();
		notice.setNName(nName);
		notice.setNContent(nContent);
		
		
		
		return "noticeInsert.jsp";
	}

}
