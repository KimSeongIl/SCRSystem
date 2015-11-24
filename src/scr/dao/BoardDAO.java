package scr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import scr.conn.Conn;
import scr.dto.BoardDTO;

public class BoardDAO {

	private static BoardDAO instance=new BoardDAO();

	private BoardDAO(){

	}

	public static BoardDAO getInstance(){
		return instance;
	}



	//공지사항 정보 삭제하기 
	public void deleteBoard(int bId){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from board where board_id=?");){
			pstmt.setInt(1,bId);

			pstmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	//공지사항 정보 수정하기

	public void updateBoard(int bId,String bTitle,String bContent){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update board set board_title=?,board_content=? where board_id=?");){

			pstmt.setString(1,bTitle);
			pstmt.setString(2,bContent);
			pstmt.setInt(3,bId);
			pstmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}

	}

	//공지사항 입력 정보 삽입하기 
	public void insertBoard(String bName,String bTitle,String bContent,String category ){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into board(board_name,board_title,board_content,board_category) values(?,?,?,?)");){

			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, category);

			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}


	}
	//작성자명 별로 공지사항정보 가져오기
	public List searchBoardByName(String value){
		List boardList=null;
		BoardDTO board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from board where board_name like ? order by board_id desc");){

			pstmt.setString(1,"%"+value+"%");
			ResultSet rs=pstmt.executeQuery();


			if(rs.next()){
				boardList=new ArrayList();
				do{
					board=new BoardDTO();
					board.setBId(rs.getInt("board_id"));
					board.setBName(rs.getString("board_name"));
					board.setBTitle(rs.getString("board_title"));
					board.setBContent(rs.getString("board_content"));
					board.setBDate(rs.getTimestamp("board_date"));

					boardList.add(board);

				}while(rs.next());

			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return boardList;
	}

	//공지사항 제목으로 검색 
	public List searchBoardByTitle(String value){
		List boardList=null;
		BoardDTO board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from board where board_title like ? order by board_id desc ");){

			pstmt.setString(1,"%"+value+"%");
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()){
				boardList=new ArrayList();
				do{
					board=new BoardDTO();
					board.setBId(rs.getInt("board_id"));
					board.setBName(rs.getString("board_name"));
					board.setBTitle(rs.getString("board_title"));
					board.setBContent(rs.getString("board_content"));
					board.setBDate(rs.getTimestamp("board_date"));

					boardList.add(board);

				}while(rs.next());

			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return boardList;
	}

	//공지사항 내용별로 검색 
	public List searchBoardByContent(String value){
		List boardList=null;
		BoardDTO board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from board  where board_content like ? order by board_id desc ");){

			pstmt.setString(1,"%"+value+"%");
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()){
				boardList=new ArrayList();
				do{
					board=new BoardDTO();
					board.setBId(rs.getInt("board_id"));
					board.setBName(rs.getString("board_name"));
					board.setBTitle(rs.getString("board_title"));
					board.setBContent(rs.getString("board_content"));
					board.setBDate(rs.getTimestamp("board_date"));

					boardList.add(board);

				}while(rs.next());

			}
		}catch (Exception e){
			e.printStackTrace();
		}
		return boardList;
	}

	//공지사항 자료 가져오기
	public List viewBoard(String category){
		List boardList=null;
		BoardDTO board=null;

		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from board where board_category=? order by board_id desc");){ //rs->resultSet

			pstmt.setString(1, category);
			try(ResultSet rs=pstmt.executeQuery();){

				if(rs.next()){
					boardList=new ArrayList();
					do{

						board=new BoardDTO();
						board.setBId(rs.getInt("board_id")); //getInt(디비에 저장된 칼럼 명)
						board.setBName(rs.getString("board_name"));
						board.setBTitle(rs.getString("board_title"));
						board.setBContent(rs.getString("board_content"));
						board.setBDate(rs.getTimestamp("board_date"));

						boardList.add(board);



					}while(rs.next());

				}
			}catch(Exception ee){
				ee.printStackTrace();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return boardList;

	}

	//공지사항 게시판 nid기준으로 자료가져오기
	public BoardDTO BoardViewById(int bId){


		BoardDTO board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from board where board_id=?");){

			pstmt.setInt(1, bId);

			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){

					board=new BoardDTO();

					board.setBId(rs.getInt("board_id"));
					board.setBName(rs.getString("board_name"));
					board.setBTitle(rs.getString("board_title"));
					board.setBContent(rs.getString("board_content"));
					board.setBDate(rs.getTimestamp("board_date"));



				}

			}catch(Exception ee){

			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return board;
	}




}
