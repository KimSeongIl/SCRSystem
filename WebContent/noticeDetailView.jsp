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
			<td>����</td>
			<td>${nName}</td>
		</tr>
		<tr>
		
			<td>����</td>
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
<input type="submit" value="����">


</form>


<form action="noticeDelete.do" method="post">
<input type="hidden" name="nId" value="${nId}"/>
<input type="submit" value="����" onclick="if(!confirm('���� ���� �Ͻðڽ��ϱ�?')){return false;}">
</form>
</div>


<!--  ����κ� -->
<button class="btn btn-default" onclick="history.back()">���</button>


</div>


