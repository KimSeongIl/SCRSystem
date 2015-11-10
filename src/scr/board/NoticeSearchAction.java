package scr.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.NoticeDAO;
import scr.dto.NoticeDTO;

public class NoticeSearchAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		String s= request.getParameter("select");
		int select=Integer.parseInt(s);
		String value= request.getParameter("value");
		//1  name 2 title 3 content

		NoticeDAO notice=NoticeDAO.getInstance();
		
		List noticeList=null;
		
		System.out.println("select->"+select);

		System.out.println("value->"+value);
		
		if(select==1){
			noticeList=notice.searchNoticeByName(value);
			
		}else if(select==2){
			noticeList=notice.searchNoticeByTitle(value);
			
		}else if(select==3){
			noticeList=notice.searchNoticeByContent(value);
			
		}

		request.setAttribute("noticeList", noticeList);
		
		
		return "noticeView.jsp";

	}

}
