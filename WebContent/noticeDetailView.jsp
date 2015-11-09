<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
   <%@ page import="scr.dto.NoticeDTO" %>
   <%@ page import="java.util.*" %>
   
   <c:set var="notice" value="${noticeList}" scope="request"/>
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
                                
                               

  
<%

//NoticeDTO notice=(NoticeDTO)request.getAttribute("noticeList");

//String nName=notice.getNName();
//String nTitle=notice.getNTitle();
//String nContent=notice.getNContent();
//String nDate=String.valueOf(notice.getNDate());




%>
    
    <div id="article">
    
   <table width="100%">
		<tr>
			<td>力格${nName}</td>
			<td></td>
		</tr>
		<tr>
			<td>郴侩${nContent}</td>
			<td>
				<div rows="10" cols="30"  name="nContent" style="width:766px; height:412px; "></div>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="button" id="save" value="历厘"/>
				<input type="button" value="秒家"/>
			</td>
		</tr>
</table>

    </div>