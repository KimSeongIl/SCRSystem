<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <%@ page import="scr.dto.BoardDTO" %>
   <%@ page import="java.util.*" %>
  
   
 
  <c:set var="board" value="${boardList}" scope="request"/>
    <c:set var="bId" value="${boardList.getBId()}"/>
  <c:set var="bName" value="${boardList.getBName()}"/>
  <c:set var="bTitle" value="${boardList.getBTitle()}"/>
  <c:set var="bCon" value="${boardList.getBContent()}"/>
  <c:set var="bDate" value="${boardList.getBDate()}"/>
   
  <c:set var="string1" value="${bCon}"/>
   
  <c:set var="middle" value="src"/>
  <c:set var="after" value="${fn:substringAfter(string1,middle) }"/>
  <c:set var="before" value="${fn:substringBefore(string1,middle) }"/>
    
    
   <c:set var="string2" value="${fn:replace(after, 
                                'upload', 'editor/upload')}" />
                                
  <c:set var="bContent" value="${before}${middle}${string2}"/> 

<div id="article" >

<form id="frm" action="boardInsert.do" method="post" >
<table width="100%">
		<tr>
			<td>제목</td>
			<td>${bTitle}</td>
		</tr>
		<tr>
		
			<td>내용</td>
			
			
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
		
</table>
</form>


<div>
<form action="boardUpdateBefore.do" method="post">
<input type="hidden" name="bId" value="${bId}"/>
<input type="submit"  value="수정" onclick="if(!confirm('정말로 수정하시겠습니까?')){return false;}"/>

</form>


<form action="boardDelete.do" method="post">
<input type="hidden" name="bId" value="${bId}"/>
<input type="submit" value="삭제" onclick="if(!confirm('정말 삭제 하시겠습니까?')){return false;}">

</form>
</div>


<!--  공통부분 -->
<button class="btn btn-default" onclick="history.back()">목록</button>


</div>


