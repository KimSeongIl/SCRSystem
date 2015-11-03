package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import scr.conn.Conn;

public class NoticeDAO {
	
	private static NoticeDAO instance=new NoticeDAO();
	
	private NoticeDAO(){
		
	}
	
	public static NoticeDAO getInstance(){
		return instance;
	}
	
	public void insertNoticeBoard(String nName,String nTitle,String nContent ){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into notice(notice_name,notice_title,notice_content) values(?,?,?)");){
 
			pstmt.setString(1, nName);
			pstmt.setString(2, nTitle);
			pstmt.setString(3, nContent);
		
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	

}
