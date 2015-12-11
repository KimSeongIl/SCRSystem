<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="scr.dto.BoardDTO"%>
<%@ page import="scr.dao.BoardDAO"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="assets/css/board.css">

<c:set var="category" value="${category}" scope="request" />
<c:set var="management" value="management"/>


<div id="article">
	<div id="noticeLine">



		
				<h1>게시판 관리</h1>
				<hr>
				<button id="boardManagementWrite" class="btn btn-primary" onclick="location.href='boardWrite.do?category=${category}&management=${management}'">게시판
					작성하기</button>
				<ul class="nav nav-tabs" id="boardManagementMenu">
					<li role="presentation" class="active" id="studentList" onclick="location.href='boardManagement.do?category=notice'"><a href="#">공지사항</a></li>
					<li role="presentation" id="professorList" onclick="location.href='boardManagement.do?category=reference'"><a href="#">자료실</a></li>
					

				</ul>
		





		<table class="table">
			<tr>
				<th>no</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
				<th></th>
			</tr>
			<%
				List boardList = (List) request.getAttribute("boardList");
			    String management="management";

				if (boardList != null) {

					for (int i = 0; i < boardList.size(); i++) {
						BoardDTO board = (BoardDTO) boardList.get(i);

						out.println("<tr>");
						out.println("<td>" + board.getBId() + "</td>");
						out.println("<td>" + board.getBName() + "</td>");
						out.println("<td><a href='boardDetail.do?bid=" + board.getBId() + "&category="+board.getCategory()+"&management="+management+"'>" + board.getBTitle()
								+ "</a></td>");
						out.println("<td>" + board.getBDate() + "</td>");
						
						
						out.println("<td><form class='' action='boardDelete.do'  method='post'><input type='hidden' name='bId' value='"+board.getBId()+"'/><input type='hidden' name='category' value='"+board.getCategory()+"'/><input type='hidden' name='management' value='management'/><input type='submit' class='btn btn-default' value='삭제' onclick='if(!confirm('정말 삭제 하시겠습니까?')){return false;}'></form></td>");

						out.println("</tr>");
					}
				}
			%>


		</table>


	</div>
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

	<c:if test="${ category=='notice'||category=='reference'}">
		<center>

			<select id="searchSelect">
				<option>작성자</option>
				<option>제목</option>
				<option>내용</option>
			</select> <input type="search" id="searchValue"><input type="hidden"
				id="searchCategory" value="${category}"> <input
				type="button" value="검색" onclick="boardSearch()">



		</center>
	</c:if>
	
	
<!--  
	<c:choose>

		<c:when test="${sessionScope.auth=='학생'||sessionScope.auth==''}">

		</c:when>

		<c:otherwise>
			<button class="btn btn-default"
				onclick="location.href='boardWrite.do?category=${category}'">게시판 작성 </button>
		</c:otherwise>
	</c:choose>
-->


</div>

<script src="assets/js/board.js"></script>


