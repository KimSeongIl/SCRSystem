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
	//작성자명 별로 공지사항정보 가져오기
	public List searchNoticeByName(String value){
		List noticeList=null;
		NoticeDTO notice=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from notice where notice_name like ?");){
			
			pstmt.setString(1,"%"+value+"%");
			ResultSet rs=pstmt.executeQuery();
			
			
			if(rs.next()){
			noticeList=new ArrayList();
			do{
				notice=new NoticeDTO();
				notice.setNId(rs.getInt("notice_id"));
				notice.setNName(rs.getString("notice_name"));
				notice.setNTitle(rs.getString("notice_title"));
				notice.setNContent(rs.getString("notice_content"));
				notice.setNDate(rs.getTimestamp("notice_date"));
				
				noticeList.add(notice);
				
			}while(rs.next());
				
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return noticeList;
	}
	
	//공지사항 제목으로 검색 
	public List searchNoticeByTitle(String value){
		List noticeList=null;
		NoticeDTO notice=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from notice where notice_title like ? ");){
			
			pstmt.setString(1,"%"+value+"%");
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()){
			noticeList=new ArrayList();
			do{
				notice=new NoticeDTO();
				notice.setNId(rs.getInt("notice_id"));
				notice.setNName(rs.getString("notice_name"));
				notice.setNTitle(rs.getString("notice_title"));
				notice.setNContent(rs.getString("notice_content"));
				notice.setNDate(rs.getTimestamp("notice_date"));
				
				noticeList.add(notice);
				
			}while(rs.next());
				
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return noticeList;
	}
	
	//공지사항 내용별로 검색 
	public List searchNoticeByContent(String value){
		List noticeList=null;
		NoticeDTO notice=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from notice where notice_content like ? ");){
			
			pstmt.setString(1,"%"+value+"%");
			ResultSet rs=pstmt.executeQuery();
			
			if(rs.next()){
			noticeList=new ArrayList();
			do{
				notice=new NoticeDTO();
				notice.setNId(rs.getInt("notice_id"));
				notice.setNName(rs.getString("notice_name"));
				notice.setNTitle(rs.getString("notice_title"));
				notice.setNContent(rs.getString("notice_content"));
				notice.setNDate(rs.getTimestamp("notice_date"));
				
				noticeList.add(notice);
				
			}while(rs.next());
				
			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return noticeList;
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

					notice=new NoticeDTO();
					notice.setNId(rs.getInt("notice_id")); //getInt(디비에 저장된 칼럼 명)
					notice.setNName(rs.getString("notice_name"));
					notice.setNTitle(rs.getString("notice_title"));
					notice.setNContent(rs.getString("notice_content"));
					notice.setNDate(rs.getTimestamp("notice_date"));

					noticeList.add(notice);



				}while(rs.next());

			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return noticeList;

	}

	//공지사항 게시판 nid기준으로 자료가져오기
	public NoticeDTO noticeViewById(int nId){
		
		
		NoticeDTO notice=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from notice where notice_id=?");){

			pstmt.setInt(1, nId);

			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					
					notice=new NoticeDTO();
					
					notice.setNName(rs.getString("notice_name"));
					notice.setNTitle(rs.getString("notice_title"));
					notice.setNContent(rs.getString("notice_content"));
					notice.setNDate(rs.getTimestamp("notice_date"));
					


				}

			}catch(Exception ee){

			}

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return notice;
	}




}
