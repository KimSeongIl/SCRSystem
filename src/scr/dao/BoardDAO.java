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

	//board의 count 수 
	public int getBoardCount(String category){
		int count=0;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) from board where board_category=?");){
			pstmt.setString(1, category);
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					count=rs.getInt(1);
				}
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
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
	public void insertBoard(int uId,String bTitle,String bContent,String category,String fileName ){
		System.out.println("bTitle"+bTitle);
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into board(user_id,board_title,board_content,board_category,board_file) values(?,?,?,?,?)");){

			pstmt.setInt(1,uId);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, category);
			pstmt.setString(5, fileName);

			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}


	}
	//작성자명으로 검색할때 paging처리하기위해 ->작성자 별은 보류 
	public int getSearchNameCount(String category,String value){
		int count=0;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) from board where board_category=? and user_id like ? order by board_id desc ")){

			pstmt.setString(1, category);
			pstmt.setString(2, "%"+value+"%");

			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					count=rs.getInt(1);
				}

			}catch(Exception ex){
				ex.printStackTrace();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	//제목별로 검색할때 paging처리하기위해 
	public int getSearchTitleCount(String category,String value){
		int count=0;

		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) from board  where board_category=? and board_title like ?")){

			pstmt.setString(1, category);
			pstmt.setString(2, "%"+value+"%");
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					count=rs.getInt(1);
				}

			}catch(Exception ex){
				ex.printStackTrace();
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}
	//내용별로 검색할때 paging처리하기위해 
	public int getSearchContentCount(String category,String value){
		int count=0;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select count(*) from board where board_category=? and board_content like ?")){

			pstmt.setString(1, category);
			pstmt.setString(2, "%"+value+"%");
			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					count=rs.getInt(1);
				}
			}catch(Exception ee){
				ee.printStackTrace();
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return count;

	}


	//작성자명 별로 공지사항정보 가져오기->>보류
	public List searchBoardByName(String value){
		List boardList=null;
		BoardDTO board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from board where user_id like ? order by board_id desc");){

			pstmt.setString(1,"%"+value+"%");
			ResultSet rs=pstmt.executeQuery();


			if(rs.next()){
				boardList=new ArrayList();
				do{
					board=new BoardDTO();
					board.setBId(rs.getInt("board_id"));
					board.setBName(rs.getString("user_id"));
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

	//board 제목으로 검색 
	public List searchBoardByTitle(String category,String value,int start,int end){
		List boardList=null;
		BoardDTO board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from board where board_category=? and board_title like ? order by board_id desc limit ?,? ");){

			pstmt.setString(1, category);
			pstmt.setString(2,"%"+value+"%");
			pstmt.setInt(3,start);
			pstmt.setInt(4,end);
			
			
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()){
				boardList=new ArrayList();
				do{
					board=new BoardDTO();
					board.setBId(rs.getInt("board_id"));
					board.setBName(rs.getString("user_id"));
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
	public List searchBoardByContent(String category,String value,int start,int end){
		List boardList=null;
		BoardDTO board=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from board where board_category=? and board_content like ? order by board_id desc limit ?,? ");){

			pstmt.setString(1, category);
			pstmt.setString(2,"%"+value+"%");
			pstmt.setInt(3, start);
			pstmt.setInt(4,end);
			ResultSet rs=pstmt.executeQuery();

			if(rs.next()){
				boardList=new ArrayList();
				do{
					board=new BoardDTO();
					board.setBId(rs.getInt("board_id"));
					board.setBName(rs.getString("user_id"));
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
	public List viewBoard(String category,int start,int end){
		List boardList=null;
		BoardDTO board=null;

		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select board_id,name,board_title,board_content,board_date from board b join user u on b.user_id=u.user_id where board_category=? order by board_id desc limit ?,?");){ //rs->resultSet

			pstmt.setString(1, category);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			try(ResultSet rs=pstmt.executeQuery();){

				if(rs.next()){
					boardList=new ArrayList();
					do{

						board=new BoardDTO();
						board.setBId(rs.getInt("board_id")); //getInt(디비에 저장된 칼럼 명)
						board.setBName(rs.getString("name"));
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
					board.setBName(rs.getString("user_id"));
					board.setBTitle(rs.getString("board_title"));
					board.setBContent(rs.getString("board_content"));
					board.setBDate(rs.getTimestamp("board_date"));
					board.setbFile(rs.getString("board_file"));



				}

			}catch(Exception ee){

			}

		}catch(Exception e){
			e.printStackTrace();
		}

		return board;
	}




}
