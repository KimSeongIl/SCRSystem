package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import scr.action.CommandAction;


import scr.dao.BoardDAO;
import scr.dto.BoardDTO;

public class BoardDetailView implements CommandAction {
	
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		
		int bId=Integer.parseInt(request.getParameter("bid"));
		String category=request.getParameter("category");
		String management=request.getParameter("management");
		
		BoardDTO boardList=null;
		BoardDAO board=BoardDAO.getInstance();
		
		boardList=board.BoardViewById(bId); //BoardDTO형 
		
		request.setAttribute("management", management);
		request.setAttribute("category", category);
		request.setAttribute("boardList", boardList);
		
		
		return "boardDetailView.jsp";
	}

}
