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
		//List<BoardDTO> boardList=board.viewBoard();
		
		//request.setAttribute("boardList", boardList);
		//잠시 테스트
		request.setAttribute("department", department);
		return "main.jsp";
	}
}
