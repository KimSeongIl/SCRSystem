package scr.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.BoardDAO;

public class BoardUpdateAction implements CommandAction  {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		
		String category=request.getParameter("category");
		String management=request.getParameter("management");
		String id=request.getParameter("bid");
		int bId=Integer.parseInt(id);
		String bTitle=request.getParameter("bTitle");
		String bContent=request.getParameter("bContent");
		
		BoardDAO board=BoardDAO.getInstance();
		
		board.updateBoard(bId,bTitle, bContent);
		
		System.out.println("notcie->>>update->>"+category);
		System.out.println("management->>>update->>"+management);
		request.setAttribute("category", category);
		
		if(management!=null){
			System.out.println("c");
			return "boardManagementUpdate.jsp";
		}else{
			System.out.println("d");
			return "boardUpdate.jsp";
		}
		
		
		
	}

}
