
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="scr.dto.BoardDTO,scr.dao.BoardDAO"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<c:set var="category" value="${category}" scope="request" />
<c:set var="management" value="${management }" scope="request"/>
<c:set var="boardList" value="${boardList}" scope="request" />



<c:if test="${ boardList!=null }">
     
    <c:set var="bId" value="${boardList.getBId()}"/>
	<c:set var="bTitle" value="${boardList.getBTitle()}" />
	<c:set var="bContent" value="${boardList.getBContent()}" />


</c:if>

<script type="text/javascript" src="editor/js/HuskyEZCreator.js"
	charset="utf-8"></script>
	
<div id="article">


			<c:if test="${boardList==null&&management=='management'}">
			ss1
				<form id="frm" action="boardInsert.do?category=${category}&management=${management}" method="post" enctype="multipart/form-data">
			</c:if>
		
		    <c:if test="${boardList==null}">
			ss2
			<form id="frm" action="boardInsert.do?category=${category}" method="post" enctype="multipart/form-data">
			</c:if>
	
		
			
			<c:if test="${boardList!=null&&management=='management'}">
			ss3
				<form id="frm" action="boardUpdate.do?bid=${bId}&category=${category}&management=${management}" method="post" >
			
			</c:if>
			
			<c:if test="${boardList!=null}">
			
		<form id="frm" action="boardUpdate.do?bid=${bId}&category=${category}" method="post" >
			
			</c:if>
	
		
		<table width="100%">
			<tr>
				<td>제목</td>
				<td><input type="text" id="title" name="bTitle" class="form-control"
					value="${bTitle}" />
					<input type="hidden" value="${category}" name="category"/>
					</td>
			</tr>
			<tr>
			<td>첨부파일</td>
			<td>
			<input type="file" class="form-control" name="boardFile" >
			</td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="30" id="ir1" name="bContent"
						style="width: 850px; height: 500px;">${bContent}
			
				</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" id="save" value="저장" /> <input
					type="button" value="취소" /></td>
			</tr>
		</table>
	</form>


</div>


<script type="text/javascript">
var oEditors = [];

$(function(){

					nhn.husky.EZCreator.createInIFrame({
						oAppRef: oEditors,
						elPlaceHolder: "ir1",
						//SmartEditor2Skin.html 파일이 존재하는 경로
						sSkinURI: "editor/SmartEditor2Skin.html",	
						htParams : {
							// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseToolbar : true,				
							// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseVerticalResizer : true,		
							// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
							bUseModeChanger : true,			
							fOnBeforeUnload : function(){
								
							}
						}, 
						fOnAppLoad : function(){
							//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
							//oEditors.getById["ir1"].exec("PASTE_HTML", ["기존 DB에 저장된 내용을 에디터에 적용할 문구"]);
						},
						fCreator: "createSEditor2"
					});
					
					$("#save").click(function(){
						oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
						$("#frm").submit();
					})
					
					
});

function pasteHTML(filepath){
	    var sHTML = '<img src="<%=request.getContextPath()%>/C:/project/SRcSystem/WebContent/editor/uploads/'+filepath+'">';
	 	<%
	 	System.out.println("----------------------------------");
	 	System.out.println("getContextPath->>>"+request.getContextPath());
	 	%>
	     var sHTML = '<img src="<%=request.getContextPath()%>/C:/project/SRcSystem/WebContent/editor/upload/'+filepath+'">';
	    oEditors.getById["textAreaContent"].exec("PASTE_HTML", [sHTML]);
	}
	</script>
