<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="scr.dto.NoticeDTO"%>
<%@ page import="scr.dao.NoticeDAO"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="assets/css/notice.css"> 


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
	List noticeList=(List)request.getAttribute("noticeList");
	
	if(noticeList !=null){
		
		for(int i=0;i<noticeList.size();i++){
			NoticeDTO notice=(NoticeDTO)noticeList.get(i);
			
			out.println("<tr>");
			out.println("<td>"+notice.getNId()+"</td>");
			out.println("<td>"+notice.getNName()+"</td>");
			out.println("<td><a href='noticeDetail.do?nid="+notice.getNId()+"'>"+notice.getNTitle()+"</a></td>");
			out.println("<td>"+notice.getNDate()+"</td>");
			
			out.println("</tr>");
		}
	}
	
	%>


		</table>
		<button onclick="location.href='noticeWrite.do'">글쓰기</button>

	</div>


</div>




