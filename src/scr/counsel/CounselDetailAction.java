package scr.counsel;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.CommandAction;
import scr.dao.CounselDAO;
import scr.dao.StudentDAO;
import scr.dto.CounselDTO;
import scr.dto.CounselRecordDTO;
import scr.dto.StudentDTO;

public class CounselDetailAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{

		HttpSession session=request.getSession();
		String auth=(String)session.getAttribute("auth");
		if(!"교수".equals(auth)){
			return "permission.jsp";
		}
		
		int counselId=Integer.parseInt(request.getParameter("cid"));
		StudentDAO studentDao=StudentDAO.getInstance();
		StudentDTO student=studentDao.studentInfo(counselId);
		
		CounselDAO counselDao=CounselDAO.getInstance();
		CounselDTO counsel=counselDao.counselInfo(counselId);
		
		request.setAttribute("student", student);
		request.setAttribute("counsel", counsel);
		if("집단상담".equals(counsel.getCounselCategory())){
			List<StudentDTO> list=counselDao.groupCounselList(counselId);
			
			request.setAttribute("groupList", list);
		}
		if("완료".equals(counsel.getStatus())){
			CounselRecordDTO counselRecord=counselDao.getCounselRecord(counselId);
			request.setAttribute("counselRecord", counselRecord);
		}
		return "counselDetail.jsp";
	}
}
