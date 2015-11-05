package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import scr.action.CommandAction;


import scr.dao.NoticeDAO;
import scr.dto.NoticeDTO;

public class NoticeDetailView implements CommandAction {
	
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		int nId=Integer.parseInt(request.getParameter("nid"));
		
		NoticeDTO noticeList=null;
		NoticeDAO notice=NoticeDAO.getInstance();
		
		noticeList=notice.noticeViewById(nId); //List형 
		
		
		request.setAttribute("noticeList", noticeList);
		
		
		return "noticeDetailView.jsp";
	}

}
