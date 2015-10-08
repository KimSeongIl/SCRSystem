package scr.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.util.Properties;




import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
 
public class SMTPAuthenticatior extends Authenticator{
 
	
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
    	DefaultContext dc=DefaultContext.getInstance();
    	try(FileInputStream fis=new FileInputStream(dc.getPath()+"/WEB-INF/email.properties");){
    		Properties props=new Properties();
    		
    		
    		
    		
    		props.load(new BufferedInputStream(fis));
    		
    		String id=props.getProperty("id").trim();
    		
    		String password=props.getProperty("password").trim();
    		return new PasswordAuthentication(id,password);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
		return null;
        
    }
}
