package scr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.dao.DepartmentDAO;
import scr.dto.DepartmentDTO;

import scr.dao.BoardDAO;
import scr.dto.BoardDTO;

public class MainAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		DepartmentDAO departmentDao=DepartmentDAO.getInstance();
		List<DepartmentDTO> department=departmentDao.departmentList();
		
		BoardDAO board=BoardDAO.getInstance();
		String category1="notice";
		String category2="reference";
		
		List<BoardDTO> noticeList=board.mainViewBoard(category1);
		System.out.println(noticeList);
		List<BoardDTO> referenceList=board.mainViewBoard(category2);
		System.out.println(referenceList);
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("referenceList", referenceList);
		request.setAttribute("department", department);
		return "main.jsp";
	}
}
