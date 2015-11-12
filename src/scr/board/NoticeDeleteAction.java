package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import scr.action.CommandAction;
import scr.dao.NoticeDAO;

public class NoticeDeleteAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		String id=request.getParameter("nId");
		System.out.println("nId->"+id);
		int nId=Integer.parseInt(id);
		NoticeDAO notice=NoticeDAO.getInstance();
		System.out.println("a");
		notice.deleteNotice(nId);
		System.out.println("b");


		return "noticeDelete.jsp";


	}

}
