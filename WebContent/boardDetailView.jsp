<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <%@ page import="scr.dto.BoardDTO" %>
   <%@ page import="java.util.*" %>
   <link rel="stylesheet" type="text/css" href="assets/css/board.css">
  
   
 
  <c:set var="board" value="${boardList}" scope="request"/>
    <c:set var="bId" value="${boardList.getBId()}"/>
  <c:set var="bName" value="${boardList.getBName()}"/>
  <c:set var="bTitle" value="${boardList.getBTitle()}"/>
  <c:set var="bCon" value="${boardList.getBContent()}"/>
  <c:set var="bDate" value="${boardList.getBDate()}"/>
  <c:set var="bFile" value="${boardList.getbFile()}"/>
   
  <c:set var="string1" value="${bCon}"/>
   
  <c:set var="middle" value="src"/>
  <c:set var="after" value="${fn:substringAfter(string1,middle) }"/>
  <c:set var="before" value="${fn:substringBefore(string1,middle) }"/>
    
    
   <c:set var="string2" value="${fn:replace(after, 
                                'upload', 'editor/upload')}" />
                                
  <c:set var="bContent" value="${before}${middle}${string2}"/> 
  
  
  
  <c:if test="${bFile==null}">
  
  </c:if>
  <c:if test="${bFile!=null}">
  
   <form id="downloadForm" action="fileDownload.ajax" method="post">
   <input type="hidden" value="${bFile}" name="bFile">
   </form>
   
  </c:if>

<div id="article" >

<form id="frm" action="boardInsert.do" method="post" >
<table width="100%" class="table">

		<tr>
			<th>����</th>
			<td>${bTitle}</td>
		</tr>
		<tr>
		<th>÷������</th>
		<td><a onclick="fileDownLoad()">${bFile}</a></td>
		</tr>
		<tr id="boardContent">
		
			<th>����</th>
			
			
	<c:if test="${ after=='' }">
	<td>

		${bCon}
	</td>
	</c:if>
	
	<c:if test="${ after!='' }">
	
			<td>

			${bContent}
			</td>
	</c:if>
		
		</tr>
		
		<tr>
		<td></td>
		<td></td>
		</tr>
		
</table>
</form>


<div>
<form class="boardDetail" action="boardUpdateBefore.do"  method="post">
<input type="hidden" name="bId" value="${bId}"/>
<input type="submit"  class="btn btn-primary" value="����" onclick="if(!confirm('������ �����Ͻðڽ��ϱ�?')){return false;}"/>

</form>


<form class="boardDetail" action="boardDelete.do"  method="post">
<input type="hidden" name="bId" value="${bId}"/>
<input type="submit" class="btn btn-default" value="����" onclick="if(!confirm('���� ���� �Ͻðڽ��ϱ�?')){return false;}">

</form>
</div>


<!--  ����κ� -->
<button class="btn btn-default" onclick="history.back()">���</button>

<script src="assets/js/board.js"></script>

</div>

