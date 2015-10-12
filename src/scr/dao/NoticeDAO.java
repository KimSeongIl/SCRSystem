package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class NoticeDAO {
	
	private static NoticeDAO instance=new NoticeDAO();
	
	private NoticeDAO(){
		
	}
	
	public static NoticeDAO getInstance(){
		return instance;
	}
	

}
