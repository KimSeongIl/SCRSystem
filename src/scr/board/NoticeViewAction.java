package scr.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.NoticeDAO;
import scr.dto.NoticeDTO;

public class NoticeViewAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		NoticeDAO notice=NoticeDAO.getInstance();//NoticeDAO 객체 생성 
		
	    List noticeList=notice.viewNoticeBoard();//공지사항 받아온 정보를 List에 넣기 
	    
	    
	    request.setAttribute("noticeList", noticeList);
	   
		
		return "noticeView.jsp";
	}
}
