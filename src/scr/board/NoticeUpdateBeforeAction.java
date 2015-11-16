package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.NoticeDAO;
import scr.dto.NoticeDTO;

//공지사항 수정전에 거치는 단계
public class NoticeUpdateBeforeAction implements CommandAction  {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("nId");
		int nId=Integer.parseInt(id);
		System.out.println("nId->"+nId);
		NoticeDTO noticeList=new NoticeDTO();
		
		NoticeDAO notice=NoticeDAO.getInstance();
		
		noticeList=notice.noticeViewById(nId);
		System.out.println(noticeList);
		
		request.setAttribute("noticeList", noticeList);
		
		
		return "noticeWrite.jsp";
		
	}
}
