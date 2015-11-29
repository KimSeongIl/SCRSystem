package scr.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.BoardDAO;
import scr.dto.BoardDTO;

public class BoardSearchAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		String s= request.getParameter("select");
		int select=Integer.parseInt(s);
		String value= request.getParameter("value");
		//1  name 2 title 3 content

		BoardDAO board=BoardDAO.getInstance();
		
		List boardList=null;
		
		
		if(select==1){
			boardList=board.searchBoardByName(value);
			
		}else if(select==2){
			boardList=board.searchBoardByTitle(value);
			
		}else if(select==3){
			boardList=board.searchBoardByContent(value);
			
		}

		request.setAttribute("boardList", boardList);
		
		
		return "boardView.jsp";

	}

}
