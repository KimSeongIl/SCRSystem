package scr.util;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
 
public class SMTPAuthenticatior extends Authenticator{
 
	
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
    	
    	try{
    		Properties props=new Properties();
    		
    		InputStream fis=getClass().getResourceAsStream("email.properties");
    		
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
