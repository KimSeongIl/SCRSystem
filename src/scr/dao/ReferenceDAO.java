package scr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.*;

public class ReferenceDAO {
	
	private static ReferenceDAO instance=new ReferenceDAO();
	
	private ReferenceDAO(){
		
	}
	
	private static ReferenceDAO getInstance(){
		return instance;
	}

}
