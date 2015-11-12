<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <%@ page import="scr.dto.NoticeDTO" %>
   <%@ page import="java.util.*" %>
  
   
 
  <c:set var="notice" value="${noticeList}" scope="request"/>
    <c:set var="nId" value="${noticeList.getNId()}"/>
  <c:set var="nName" value="${noticeList.getNName()}"/>
  <c:set var="nTitle" value="${noticeList.getNTitle()}"/>
  <c:set var="nCon" value="${noticeList.getNContent()}"/>
  <c:set var="nDate" value="${noticeList.getNDate()}"/>
   
  <c:set var="string1" value="${nCon}"/>
   
  <c:set var="middle" value="src"/>
  <c:set var="after" value="${fn:substringAfter(string1,middle) }"/>
  <c:set var="before" value="${fn:substringBefore(string1,middle) }"/>
    
    
   <c:set var="string2" value="${fn:replace(after, 
                                'upload', 'editor/upload')}" />
                                
  <c:set var="nContent" value="${before}${middle}${string2}"/> 

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
		
</table>
</form>


<div>
<form action="#" method="post">
<input type="hidden" name="#" value="#"/>
<input type="hidden" name="#" value="#"/>
<input type="submit" value="수정">


</form>


<form action="noticeDelete.do" method="post">
<input type="hidden" name="nId" value="${nId}"/>
<input type="submit" value="삭제" onclick="if(!confirm('정말 삭제 하시겠습니까?')){return false;}">
</form>
</div>


<!--  공통부분 -->
<button class="btn btn-default" onclick="history.back()">목록</button>


</div>


