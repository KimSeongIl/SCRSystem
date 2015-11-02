package scr.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
		
		
		MultipartRequest multi = null;
		int maxSize = 10*1024*1024;
		String encType = "utf-8";
		String realFolder = request.getServletContext().getRealPath("/assets/img/profile");
		
		multi = new MultipartRequest( request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		
			
		int professorId=Integer.parseInt(multi.getParameter("professorId"));
		String professorName=multi.getParameter("professorName");
		int officeNo=0;
		if(!"".equals(multi.getParameter("officeNo").trim())){
			officeNo=Integer.parseInt(multi.getParameter("officeNo"));
		}

		String officeTel=null;
		if(!"".equals(multi.getParameter("officeTel").trim())){
			officeTel=multi.getParameter("officeTel");
		}

		String phone=multi.getParameter("phone");
		String email=multi.getParameter("email");
		int departmentId=Integer.parseInt(multi.getParameter("departmentId"));
		
		String img=null;
		if(multi.getFilesystemName("img")!=null){
			img=multi.getFilesystemName("img");
		}
		String departmentList=multi.getParameter("departmentList");

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
		professor.setImg(img);

		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		professorDao.professorAdd(professor);
		for(int i=0;i<arr.length;i++){
			if(!arr[i].equals(""))
				professorDao.professorDepartmentAdd(professorId,Integer.parseInt(arr[i]));
		}

		return JsonUtil.putSuccessJsonContainer(null);

	}
}
