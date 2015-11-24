package scr.board;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dto.BoardDTO;
import scr.dao.BoardDAO;

public class BoardInsertAction implements CommandAction {
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		String bName=(String)session.getAttribute("name");//아이디 이름 
		String category=request.getParameter("category");//카테고리
		
		String bTitle=request.getParameter("bTitle");// 게시물 제목
		String bContent=request.getParameter("bContent"); //게시물 내용 
		
		
		
	
		
		BoardDAO board=BoardDAO.getInstance(); // BoardDAO의 메소드를 사용하기위해 객체 생성 
		board.insertBoard(bName, bTitle, bContent,category);
		
		
		
		return "boardInsert.jsp";
	}

}
