<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <%@ page import="scr.dto.NoticeDTO" %>
   <%@ page import="java.util.*" %>
  
   
   
   <c:set var="notice" value="${noticeList}" scope="request"/>
   <c:set var="nName" value="${noticeList.getNName()}"/>
   <c:set var="nTitle" value="${noticeList.getNTitle()}"/>
   <c:set var="nContent" value="${noticeList.getNContent()}"/>
   <c:set var="nDate" value="${noticeList.getNDate()}"/>

<div id="article" >

<form id="frm" action="noticeInsert.do" method="post" >
<table width="100%">
		<tr>
			<td>제목</td>
			<td>${nName}</td>
		</tr>
		<tr>
		
			<td>내용</td>
			<td>
			${nTitle}
			
				${nContent}
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="save" value="저장"/>
				<input type="button" value="취소"/>
			</td>
		</tr>
</table>
</form>


</div>


