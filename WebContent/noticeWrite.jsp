
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<script type="text/javascript" src="editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<div id="article" >

<form id="frm" action="noticeView.do" method="post" >
<table width="100%">
		<tr>
			<td>제목</td>
			<td><input type="text" id="title" name="title" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea rows="10" cols="30" id="ir1" name="content" style="width:766px; height:412px; "></textarea>
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
    oEditors.getById["textAreaContent"].exec("PASTE_HTML", [sHTML]);
}
</script>
