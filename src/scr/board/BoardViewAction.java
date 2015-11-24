package scr.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.BoardDAO;
import scr.dto.BoardDTO;

public class BoardViewAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		BoardDAO board=BoardDAO.getInstance();//BoardDAO 객체 생성 
		String category=request.getParameter("category");
		
	    List boardList=board.viewBoard(category);//공지사항 받아온 정보를 List에 넣기 
	    
	    request.setAttribute("category", category);
	    request.setAttribute("boardList", boardList);
	   
		
		return "boardView.jsp";
	}
}
