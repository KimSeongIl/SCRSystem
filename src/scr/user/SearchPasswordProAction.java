package scr.user;


import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import scr.action.CommandAction;
import scr.dao.StudentDAO;
import scr.dao.UserDAO;
import scr.dto.StudentDTO;
import scr.dto.UserDTO;
import scr.util.SMTPAuthenticatior;

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
		
		
		String from = "kkk4687@naver.com";
		String to = uemail;
		String subject = "성공회대학교 상담관리시스템 임시 비밀번호 입니다.";


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
		
		String content = "성공회대학교 상담관리시스템 임시 비밀번호 입니다 "+tempPassword;

		Properties p = new Properties(); // 정보를 담을 객체

		p.put("mail.smtp.host","smtp.naver.com"); // 네이버 SMTP

		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		

		
		
		
		

		try{
			Authenticator authenticator = new SMTPAuthenticatior();
			Session ses = Session.getInstance(p, authenticator);
			
			ses.setDebug(true);

			MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
			msg.setSubject(subject); // 제목

			Address fromAddr = new InternetAddress(from);
			msg.setFrom(fromAddr); // 보내는 사람

			Address toAddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람

			msg.setContent(content, "text/html;charset=UTF-8"); // 내용과 인코딩

			Transport.send(msg); // 전송
		} catch(Exception e){
			e.printStackTrace();
			
			alert="<script>alert('Send Mail Failed..');history.back();</script>";
			request.setAttribute("alert", alert);
			// 오류 발생시 뒤로 돌아가도록
			return "searchPasswordPro.jsp";
		}
		UserDTO user=new UserDTO();
		user.setUid(uid);
		user.setPassword(tempPassword);
		UserDAO userDao=UserDAO.getInstance();
		userDao.setTempPassword(user);
		alert="<script>alert('성공적으로 발송하였습니다');</script>";
		
		request.setAttribute("alert", alert);
		
		return "searchPasswordPro.jsp";
	}
}
