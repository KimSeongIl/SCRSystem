package scr.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public String sendMail(String uemail,String subject,String content,String alert){
		DefaultContext dc=DefaultContext.getInstance();
		try(FileInputStream fis=new FileInputStream(dc.getPath()+"/WEB-INF/email.properties");){
			Properties props=new Properties();
    		
    		
    		
    		
    		props.load(new BufferedInputStream(fis));
    		
    		String from=props.getProperty("id").trim();
			
    		Properties p = new Properties(); // 정보를 담을 객체

    		p.put("mail.smtp.host","smtp.naver.com"); // 네이버 SMTP

    		p.put("mail.smtp.port", "465");
    		p.put("mail.smtp.starttls.enable", "true");
    		p.put("mail.smtp.auth", "true");
    		p.put("mail.smtp.debug", "true");
    		p.put("mail.smtp.socketFactory.port", "465");
    		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    		p.put("mail.smtp.socketFactory.fallback", "false");
    		
    		
			String to = uemail;
			
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
			
			return alert;
		} catch(Exception e){
			
			e.printStackTrace();
			return "<script>alert('Send Mail Failed..');history.back();</script>";
			
			// 오류 발생시 뒤로 돌아가도록
			
		}
	}
}
