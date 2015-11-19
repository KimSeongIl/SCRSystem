package scr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.dao.DepartmentDAO;
import scr.dto.DepartmentDTO;

import scr.dao.NoticeDAO;
import scr.dto.NoticeDTO;

public class MainAction implements CommandAction {

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		DepartmentDAO departmentDao=DepartmentDAO.getInstance();
		List<DepartmentDTO> department=departmentDao.departmentList();
		
		NoticeDAO notice=NoticeDAO.getInstance();
		List<NoticeDTO> noticeList=notice.viewNoticeBoard();
		
		request.setAttribute("noticeList", noticeList);
		request.setAttribute("department", department);
		return "main.jsp";
	}
}
