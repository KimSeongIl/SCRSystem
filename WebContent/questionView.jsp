<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="java.util.*" %>
    <%@ page import="scr.dto.QuestionDTO"%>
    <%@ page import="scr.dao.QuestionDAO"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
    <link rel="stylesheet" type="text/css" href="assets/css/question.css">
    
    
    
    <div id="article">
    
  <div id="questionLine">
  
  <c:if test="${sessionScope.auth=='包府磊'}">
  <h1>Q & A 包府</h1>
  <hr>
  
  		<table class="table">
			<tr>
				<th>no</th>
				<th>累己磊</th>
				<th>力格</th>
				<th>累己老</th>
				<th></th>
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
	
			out.println("<td><form class='' action='questionDelete.do'  method='post'><input type='hidden' name='qid' value='"+question.getQid()+"'/><input type='submit' class='btn btn-default' value='昏力' onclick='if(!confirm('沥富 昏力 窍矫摆嚼聪鳖?')){return false;}'></form></td>");
			
			out.println("</tr>");
		}
	}
	%>

		</table>
  </c:if>
  
  <c:if test="${sessionScope.auth!='包府磊'}">
  <h1>Q & A</h1>
  <hr>
  
  		<table class="table">
			<tr>
				<th>no</th>
				<th>累己磊</th>
				<th>力格</th>
				<th>累己老</th>
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
  </c:if>

		
		

	</div>
	
	
	<!-- 其捞瘤 扁过 何盒  -->
		<center>
		<div id="page">
			<%
				List paging = (List) request.getAttribute("paging");

				for (int i = 0; i < paging.size(); i++) {
					out.print(paging.get(i));
				}
			%>
		</div>
	</center>
	
	
	<c:if test="${sessionScope.auth=='切积'}">
	<button id="questionWrite" class="btn btn-default" onclick="location.href='questionWrite.do'">臂静扁</button>
    </c:if>
    
    
    
    </div>