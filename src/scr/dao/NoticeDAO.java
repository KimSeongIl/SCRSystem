package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import scr.conn.Conn;
import scr.dto.NoticeDTO;

public class NoticeDAO {

	private static NoticeDAO instance=new NoticeDAO();

	private NoticeDAO(){

	}

	public static NoticeDAO getInstance(){
		return instance;
	}
	
//공지사항 입력 정보 삽입하기 
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

	//공지사항 자료 가져오기
	public List viewNoticeBoard(){
		List noticeList=null;
		NoticeDTO notice=null;

		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from notice");
				ResultSet rs=pstmt.executeQuery();){ //rs->resultSet
			if(rs.next()){
				noticeList=new ArrayList();
				do{
					System.out.println("-----");
					notice=new NoticeDTO();
					notice.setNId(rs.getInt("notice_id"));
					notice.setNName(rs.getString("notice_name"));
					notice.setNTitle(rs.getString("notice_title"));
					notice.setNContent(rs.getString("notice_content"));
					notice.setNDate(rs.getTimestamp("notice_date"));
System.out.println(notice);
					noticeList.add(notice);



				}while(rs.next());

			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return noticeList;

	}
	



}
