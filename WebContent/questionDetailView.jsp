<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="scr.dto.QuestionDTO"%>
<%@ page import="java.util.*"%>

<c:set var="question" value="${questionList}" scope="request" />
<c:set var="qId" value="${questionList.getQid()}" />
<c:set var="uId" value="${questionList.getUid()}" />
<c:set var="qTitle" value="${questionList.getqTitle()}" />
<c:set var="qContent" value="${questionList.getqContent()}" />
<c:set var="aContent" value="${question.getqAnswerContent()}"/>
<c:set var="sessionNumber" value="${sessionScope.uid}" />
<c:set var="sessionAuth" value="${sessionScope.auth}" />




<div id="article">

	<div id="questionBorder">
		<table id="question">
			<tr>
				<td>제목</td>
				<td>${qTitle}</td>
				<td>작성자</td>
				<td>${uId }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td colspan="3">${qContent}</td>
			</tr>
		</table>
	</div>


	<c:if test="${aContent!=null}">

		<div id="answer"><p>${aContent}</p></div>
	</c:if>
	
	
	
	<!--  교수일때만  -->
	<c:if test="${aContent==null}">
	<div id="answerBorder">

		<table>
			<tr>
				<td><input type="hidden" value="${sessionNumber}" name="aid" />
				<textarea class="form-control" name="aContent"></textarea></td>
				<td><button type="submit" onclick="answerWrite(${qId})">답변쓰기</button></td>
			</tr>
		</table>

	</div>
</c:if>

	<button class="btn btn-default" onclick="history.back()">목록</button>
</div>


<link rel="stylesheet" type="text/css" href="assets/css/question.css">
<script src="assets/js/question.js"></script>
