package scr.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dto.NoticeDTO;
import scr.dao.NoticeDAO;

public class NoticeInsertAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		String nName=(String)session.getAttribute("name");//아이디 이름 
		
		String nTitle=request.getParameter("nTitle");// 게시물 제목
		String nContent=request.getParameter("nContent"); //게시물 내용 
		
		
		System.out.println("nName->"+nName);
		System.out.println("nTitle->"+nTitle);
		System.out.println(nContent);
		
		System.out.println("------------");
		
		/*NoticeDTO notice =new NoticeDTO();
		
		notice.setNName(nName);
		notice.setNTitle(nTitle);
		notice.setNContent(nContent);
		*/
		
		NoticeDAO notice=NoticeDAO.getInstance(); // NoticeDAO의 메소드를 사용하기위해 객체 생성 
		notice.insertNoticeBoard(nName, nTitle, nContent);
		
		
		
		return "noticeInsert.jsp";
	}

}
