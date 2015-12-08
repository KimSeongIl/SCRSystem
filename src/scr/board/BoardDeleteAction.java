package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

import scr.action.CommandAction;
import scr.dao.BoardDAO;

public class BoardDeleteAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		String id=request.getParameter("bId");
		String management=request.getParameter("management");
		String category=request.getParameter("category");
		
		System.out.println("category->>"+category);
		System.out.println("nId->"+id);
		System.out.println("mana->>"+management);
		int bId=Integer.parseInt(id);
		BoardDAO board=BoardDAO.getInstance();
		System.out.println("a");
		board.deleteBoard(bId);
		System.out.println("b");

		
		request.setAttribute("category", category);

		if(management!=null){
			System.out.println("c");
			return "boardManagementDelete.jsp";
		}else{
			System.out.println("d");
		return "boardDelete.jsp";
		}

	}

}
