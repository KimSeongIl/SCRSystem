<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="nav">
	<div id="logo">
		
		 <img src="assets/img/cap.png" alt="logo" onclick="location.href='main.do'"> 	
		
	</div>
	<div id="navContent">
		<ul>
			<li onclick="location.href='main.do'">Home</li>
			
			<c:choose>
				<c:when test="${empty sessionScope.auth || sessionScope.auth eq \"학생\" }">
					<li onclick="location.href='noticeView.do'">공지사항</li>
					<li>이용안내</li>
					<li onclick="location.href='counselRequest.do'">상담신청</li>
					<li>자료실</li>
				</c:when>
				<c:when test="${sessionScope.auth eq \"교수\" || sessionScope.auth eq \"직원\"}">
					<li>공지사항</li>
					<li>이용안내</li>
					<li>상담관리</li>
					<li>자료실</li>
				</c:when>
				<c:when test="${sessionScope.auth eq \"관리자\" }">
					<li onclick="location.href='userManagement.do'">회원관리</li>
					<li onclick="location.href='departmentManagement.do'">학과관리</li>
					<li>상담관리</li>
					<li>게시판관리</li>
				</c:when>
			</c:choose>
			
			
		</ul>
	</div>
	
</div>

<div id="headline"></div>