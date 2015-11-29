package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import scr.action.CommandAction;
import scr.dao.BoardDAO;

public class BoardDeleteAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		String id=request.getParameter("bId");
		System.out.println("nId->"+id);
		int bId=Integer.parseInt(id);
		BoardDAO board=BoardDAO.getInstance();
		System.out.println("a");
		board.deleteBoard(bId);
		System.out.println("b");


		return "boardDelete.jsp";


	}

}
