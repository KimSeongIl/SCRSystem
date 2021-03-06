package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.BoardDAO;
import scr.dto.BoardDTO;

//공지사항 수정전에 거치는 단계
public class BoardUpdateBeforeAction implements CommandAction  {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		String category=request.getParameter("category");
		String management=request.getParameter("management");
		String id=request.getParameter("bId");
		int bId=Integer.parseInt(id);
		
		System.out.println("management->>before->>"+management);
		
		BoardDTO boardList=new BoardDTO();
		
		BoardDAO board=BoardDAO.getInstance();
		
		boardList=board.BoardViewById(bId);
		
		request.setAttribute("category", category);
		request.setAttribute("management", management);
		request.setAttribute("boardList", boardList);
		
		
		return "boardWrite.jsp";
		
	}
}
