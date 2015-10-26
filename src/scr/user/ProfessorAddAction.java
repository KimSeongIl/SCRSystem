package scr.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import scr.action.AjaxAction;
import scr.dao.ProfessorDAO;
import scr.dao.UserDAO;
import scr.dto.ProfessorDTO;
import scr.dto.UserDTO;
import scr.util.JsonUtil;

public class ProfessorAddAction implements AjaxAction{

	public Map<String,Object> responseBody(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		request.setCharacterEncoding("UTF-8");
		if(!"POST".equals(request.getMethod())){
			return JsonUtil.putFailJsonContainer("ProfessorAddAction NotPost 001", "비정상적인 접근방식입니다");
		}
		HttpSession session=request.getSession();
		if(!"관리자".equals(session.getAttribute("auth"))){
			return JsonUtil.putFailJsonContainer("ProfessorAddAction NoSession", "권한이 없습니다.");
		}
		int professorId=Integer.parseInt(request.getParameter("professorId"));
		String professorName=request.getParameter("professorName");
		int officeNo=0;
		if(!"".equals(request.getParameter("officeNo").trim())){
			officeNo=Integer.parseInt(request.getParameter("officeNo"));
		}

		String officeTel=null;
		if(!"".equals(request.getParameter("officeTel").trim())){
			officeTel=request.getParameter("officeTel");
		}

		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		int departmentId=Integer.parseInt(request.getParameter("departmentId"));
		String departmentList=request.getParameter("departmentList");

		String[] arr=departmentList.split(",");
		UserDTO user=new UserDTO();
		user.setUid(professorId);
		user.setName(professorName);

		user.setPassword(String.valueOf(professorId));
		user.setAuth("교수");
		UserDAO userDao=UserDAO.getInstance();
		userDao.userAdd(user);

		ProfessorDTO professor=new ProfessorDTO();
		professor.setProfessorId(professorId);
		professor.setProfessorName(professorName);
		professor.setOfficeNo(officeNo);
		professor.setOfficeTel(officeTel);
		professor.setPhone(phone);
		professor.setEmail(email);
		professor.setDepartmentId(departmentId);

		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		professorDao.professorAdd(professor);
		for(int i=0;i<arr.length;i++){
			if(!arr[i].equals(""))
				professorDao.professorDepartmentAdd(professorId,Integer.parseInt(arr[i]));
		}

		return JsonUtil.putSuccessJsonContainer(null);

	}
}
