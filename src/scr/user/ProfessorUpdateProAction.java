package scr.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import scr.action.CommandAction;
import scr.dao.ProfessorDAO;
import scr.dao.UserDAO;
import scr.dto.*;

public class ProfessorUpdateProAction implements CommandAction{
	
	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		
		/*request.setCharacterEncoding("UTF-8");
		int uid=Integer.parseInt(request.getParameter("uid"));
		String name=request.getParameter("uname");
		String password=request.getParameter("password");
		ProfessorDTO professor=new ProfessorDTO();
		
		if(request.getParameter("department")!=null){
			int department=Integer.parseInt(request.getParameter("department"));
			professor.setDepartmentId(department);
		}
		
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		int office_no=Integer.parseInt(request.getParameter("office_no"));
		String office_tel=request.getParameter("office_tel");
		String img=request.getParameter("img");
		
		
		UserDTO user=new UserDTO();
		user.setUid(uid);
		user.setName(name);
		user.setPassword(password);
		user.setAuth("교수");
				
		professor.setProfessorId(uid);
		professor.setProfessorName(name);
		professor.setPhone(phone);
		professor.setEmail(email);	
		professor.setOfficeNo(office_no);	
		professor.setOfficeTel(office_tel);	
		
	
		
		UserDAO dao=UserDAO.getInstance();
		
		dao.userUpdate(user);
		
		ProfessorDAO professorDao=ProfessorDAO.getInstance();
		professorDao.professorUpdate(professor);*/
		
		MultipartRequest multi = null;
		int maxSize = 10*1024*1024;
		String encType = "utf-8";
		String realFolder = request.getServletContext().getRealPath("/assets/img/profile");
		
		multi = new MultipartRequest( request,realFolder,maxSize,encType,new DefaultFileRenamePolicy());
		
		
		int professorId=Integer.parseInt(multi.getParameter("uid"));
		String professorName=multi.getParameter("uname");
		int officeNo=0;
		if(!"".equals(multi.getParameter("office_no").trim())){
			officeNo=Integer.parseInt(multi.getParameter("office_no"));
		}

		String officeTel=null;
		if(!"".equals(multi.getParameter("office_tel").trim())){
			officeTel=multi.getParameter("office_tel");
		}

		String phone=multi.getParameter("phone");
		String email=multi.getParameter("email");
		int departmentId=Integer.parseInt(multi.getParameter("department"));
		
		String img=null;
		
		if(multi.getFilesystemName("professorImg")!=null){
			img=multi.getFilesystemName("professorImg");
		}
		//String departmentList=multi.getParameter("departmentList");

		//String[] arr=departmentList.split(",");
		UserDTO user=new UserDTO();
		user.setUid(professorId);
		user.setName(professorName);
	
		user.setPassword(multi.getParameter("password"));
		
		UserDAO userDao=UserDAO.getInstance();
		userDao.userUpdate(user);

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
		professorDao.professorUpdate(professor);
		/*
		for(int i=0;i<arr.length;i++){
			if(!arr[i].equals(""))
				professorDao.professorDepartmentAdd(professorId,Integer.parseInt(arr[i]));
		}*/
		return "professorUpdatePro.jsp";
	}
}