<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="scr.dto.BoardDTO"%>
<%@ page import="scr.dao.BoardDAO"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="assets/css/board.css"> 



<div id="article">
	<div id="noticeLine">

		<h1>공 지 사 항</h1>

		<table class="table">
			<tr>
				<th>no</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			<%
	List boardList=(List)request.getAttribute("boardList");
	
	if(boardList !=null){
		
		for(int i=0;i<boardList.size();i++){
			BoardDTO board=(BoardDTO)boardList.get(i);
			
			out.println("<tr>");
			out.println("<td>"+board.getBId()+"</td>");
			out.println("<td>"+board.getBName()+"</td>");
			out.println("<td><a href='boardDetail.do?bid="+board.getBId()+"'>"+board.getBTitle()+"</a></td>");
			out.println("<td>"+board.getBDate()+"</td>");
			
			out.println("</tr>");
		}
	}
	
	%>


		</table>
		

	</div>
	<center>
	
	 <select id="searchSelect">
	 <option>작성자</option>
	 <option>제목</option>
	 <option>내용</option>
	 </select>
	 <input type="search" id="searchValue">
	 <input type="button" value="검색" onclick="boardSearch()">
	 
	 
	 
	 </center>
	 <button onclick="location.href='boardWrite.do'">글쓰기</button>


</div>

<script src="assets/js/board.js"></script>


