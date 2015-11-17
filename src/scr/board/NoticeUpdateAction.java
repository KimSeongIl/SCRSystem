package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.NoticeDAO;

public class NoticeUpdateAction implements CommandAction  {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		
		String id=request.getParameter("nid");
		int nId=Integer.parseInt(id);
		String nTitle=request.getParameter("nTitle");
		String nContent=request.getParameter("nContent");
		
		NoticeDAO notice=NoticeDAO.getInstance();
		
		notice.updateNotice(nId,nTitle, nContent);
		
		System.out.println("noticeUpdate");
		
		
		
		return "noticeUpdate.jsp";
		
	}

}