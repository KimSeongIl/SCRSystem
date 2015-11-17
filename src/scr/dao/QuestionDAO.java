package scr.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.*;

import scr.dto.NoticeDTO;
import scr.dto.QuestionDTO;
import scr.action.CommandAction;
import scr.conn.Conn;

public class QuestionDAO {

	private static QuestionDAO instance=new QuestionDAO();
	
	private QuestionDAO(){
		
	}
	
	public static QuestionDAO getInstance(){
		return instance;
	}
	
	//질의 응답 id 로 삭제하기 
	public  void deleteQuestion(int qid){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("delete from question where question_id=?");){
			pstmt.setInt(1,qid);
			
			pstmt.executeUpdate();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	//질문 삽입하기 
	public void insertQuestion(String qName,String qTitle,String qContent){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("insert into question(question_name,question_title,question_content) values(?,?,?)");){
            
			pstmt.setString(1,qName);
			pstmt.setString(2,qTitle);
			pstmt.setString(3,qContent);

			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	// 답변 삽입하기 
	public void insertAnswer(int qid,String qAnswer,String qAnswerContent){
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("update question set question_answer=?,question_answer_content=? where question_id=?");){
            
			pstmt.setString(1,qAnswer);
			pstmt.setString(2,qAnswerContent);
			pstmt.setInt(3,qid);

			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	//qid 기준으로 질의 응답 정보 가져오기 
	public QuestionDTO questionViewById(int qid){
		
		QuestionDTO question=null;
		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from question where question_id=?");){

			pstmt.setInt(1, qid);

			try(ResultSet rs=pstmt.executeQuery();){
				if(rs.next()){
					
					question=new QuestionDTO();
					
					question.setQid(rs.getInt("question_id")); //getInt(디비에 저장된 칼럼 명)
					question.setqName(rs.getString("question_name"));
					question.setqTitle(rs.getString("question_title"));
					question.setqContent(rs.getString("question_content"));
					question.setqDates(rs.getTimestamp("question_dates"));
					question.setqAnswer(rs.getString("question_answer"));
					question.setqAnswerContent(rs.getString("question_answer_content"));
				}

			}catch(Exception ee){

			}

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return question;
	 }
	
	//전체 질의 응답 정보 가져오기 
	
	public List questionView(){
		List questionList=null;
		QuestionDTO question=null;

		try(Connection conn=Conn.getConnection();
				PreparedStatement pstmt=conn.prepareStatement("select * from question");
				ResultSet rs=pstmt.executeQuery();){ //rs->resultSet
			if(rs.next()){
				questionList=new ArrayList();
				do{

					question=new QuestionDTO();
					question.setQid(rs.getInt("question_id")); //getInt(디비에 저장된 칼럼 명)
					question.setqName(rs.getString("question_name"));
					question.setqTitle(rs.getString("question_title"));
					question.setqContent(rs.getString("question_content"));
					question.setqDates(rs.getTimestamp("question_dates"));
					question.setqAnswer(rs.getString("question_answer"));
					question.setqAnswerContent(rs.getString("question_answer_content"));

					questionList.add(question);



				}while(rs.next());

			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return questionList;
		
		
	}
	
	
}
