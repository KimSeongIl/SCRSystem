<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import="scr.dto.NoticeDTO" %>
    <%@ page import="java.util.*" %>
  
<%

NoticeDTO notice=(NoticeDTO)request.getAttribute("noticeList");

String nName=notice.getNName();
String nTitle=notice.getNTitle();
String nContent=notice.getNContent();
String nDate=String.valueOf(notice.getNDate());




%>
    
    <div id="article">
    
   <table width="100%">
		<tr>
			<td>제목</td>
			<td><%=nTitle %></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<div rows="10" cols="30"  name="nContent" style="width:766px; height:412px; "><%=nContent %></div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="save" value="저장"/>
				<input type="button" value="취소"/>
			</td>
		</tr>
</table>

    </div>