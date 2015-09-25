package scr.dao;

import java.sql.Connection;

import scr.conn.Conn;

public class UserDAO {

	private static UserDAO instance=new UserDAO();
	
	private UserDAO(){
		try {
			Connection conn=Conn.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static UserDAO getInstance(){
		return instance;
	}
	
	
	
}
