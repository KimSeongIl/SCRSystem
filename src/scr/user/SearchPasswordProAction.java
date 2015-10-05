package scr.user;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.StudentDAO;
import scr.dao.UserDAO;
import scr.dto.StudentDTO;
import scr.dto.UserDTO;

import scr.util.SendMail;

public class SearchPasswordProAction implements CommandAction{

	public String requestPro(HttpServletRequest request,HttpServletResponse response)throws Throwable{
		String alert;
		request.setCharacterEncoding("utf-8");
		String auth=request.getParameter("user");
		int uid=Integer.parseInt(request.getParameter("uid"));
		String uemail=request.getParameter("uemail");
		if("학생".equals(auth)){
			StudentDTO student=new StudentDTO();
			student.setStudentId(uid);
			student.setEmail(uemail);
			StudentDAO studentDao=StudentDAO.getInstance();
			int result=studentDao.matchEmail(student);
			
			if(result==2){
				alert="<script>alert('정보가 맞지 않거나 오류가 발생했습니다');history.back();</script>";
				request.setAttribute("alert", alert);
				return "searchPasswordPro.jsp";
			}
			
		}else if("교수".equals(auth)){
			
		}else if("직원".equals(auth)){
			
		}
		
		
		


		String tempPassword="";

		for(int i=0;i<10;i++){
			int num=(int)(Math.random()*3);
			char c = 0;
			if(num==0){
				c=(char)((int)(Math.random()*10)+48);
			}else if(num==1){
				c=(char)((int)(Math.random()*26)+65);
			}else if(num==2){
				c=(char)((int)(Math.random()*26)+97);
			}


			tempPassword+=c;

		}
		String subject = "성공회대학교 상담관리시스템 임시 비밀번호 입니다.";
		String content = "성공회대학교 상담관리시스템 임시 비밀번호 입니다 "+tempPassword;

		alert="<script>alert('임시비밀번호를 메일로 발송하였습니다');</script>";
		

		
		SendMail sendMail=new SendMail();
		
		alert=sendMail.sendMail(uemail, subject, content, alert);
		
		

		
		UserDTO user=new UserDTO();
		user.setUid(uid);
		user.setPassword(tempPassword);
		UserDAO userDao=UserDAO.getInstance();
		userDao.setTempPassword(user);
		
		
		request.setAttribute("alert", alert);
		
		return "searchPasswordPro.jsp";
	}
}
