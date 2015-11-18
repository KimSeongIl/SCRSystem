<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*" %>
    <%@ page import="scr.dto.QuestionDTO"%>
    <%@ page import="scr.dao.QuestionDAO"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

    
    
    
    <div id="article">
    
  <div id="questionLine">

		<h1>Q & A</h1>

		<table class="table">
			<tr>
				<th>no</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<%
	List questionList=(List)request.getAttribute("questionList");
	
			
	if(questionList!=null){
		int size=questionList.size();
		for(int i=0;i<size;i++){
			QuestionDTO question=(QuestionDTO)questionList.get(i);
			
			out.println("<tr>");
			out.println("<td>"+question.getQid()+"</td>");
			out.println("<td>"+question.getqName()+"</td>");
			out.println("<td><a href='questionDetail.do?qid="+question.getQid()+"'>"+question.getqTitle()+"</a></td>");
			out.println("<td>"+question.getqDates()+"</td>");
			
			out.println("</tr>");
		}
	}
	
	%>


		</table>
		

	</div>
	
	<button onclick="location.href='questionWrite.do'">글쓰기</button>
    
    
    
    
    </div>