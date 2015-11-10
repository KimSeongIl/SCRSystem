<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <%@ page import="scr.dto.NoticeDTO" %>
   <%@ page import="java.util.*" %>
   <script type="text/javascript" src="editor/js/HuskyEZCreator.js" charset="utf-8"></script>
   
   
   <c:set var="notice" value="${noticeList}" scope="request"/>
   <c:set var="nName" value="${noticeList.getNName()}"/>
   <c:set var="nTitle" value="${noticeList.getNTitle()}"/>
   <c:set var="nContent" value="${noticeList.getNContent()}"/>
   <c:set var="nDate" value="${noticeList.getNDate()}"/>

<div id="article" >

<form id="frm" action="noticeInsert.do" method="post" >
<table width="100%">
		<tr>
			<td>����</td>
			<td><input type="text" id="title" name="nTitle" /></td>
		</tr>
		<tr>
			<td>����</td>
			<td>
				<textarea rows="10" cols="30" id="ir1" name="nContent" style="width:850px; height:500px; " readonly>
			${nContent}
				</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="save" value="����"/>
				<input type="button" value="���"/>
			</td>
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
						//SmartEditor2Skin.html ������ �����ϴ� ���
						sSkinURI: "editor/SmartEditor2Skin.html",	
						htParams : {
							// ���� ��� ���� (true:���/ false:������� ����)
							bUseToolbar : true,				
							// �Է�â ũ�� ������ ��� ���� (true:���/ false:������� ����)
							bUseVerticalResizer : true,		
							// ��� ��(Editor | HTML | TEXT) ��� ���� (true:���/ false:������� ����)
							bUseModeChanger : true,			
							fOnBeforeUnload : function(){
								
							}
						}, 
						fOnAppLoad : function(){
							//���� ����� ������ text ������ �����ͻ� �ѷ��ְ��� �Ҷ� ���
							//oEditors.getById["ir1"].exec("PASTE_HTML", ["���� DB�� ����� ������ �����Ϳ� ������ ����"]);
						},
						fCreator: "createSEditor2"
					});
					
					$("#save").click(function(){
						oEditors.getById["ir1"].exec("UPDATE_CONTENTS_FIELD", []);
						$("#frm").submit();
					})
					
					
});


function pasteHTML(filepath){
	
    var sHTML = '<img src="<%=request.getContextPath()%>/C:/project/SRcSystem/WebContent/editor/upload/'+filepath+'">';
    oEditors.getById["textAreaContent"].exec("PASTE_HTML", [sHTML]);
}
</script>
