﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="nav">
	<div id="logo">
		
		 <img src="assets/img/cap.png" alt="logo" onclick="location.href='main.do'"> 	
		
		
	</div>
	<div id="navContent">
		<ul>
			<li onclick="location.href='main.do'">Home</li>
			<li>공지사항</li>
			<li>이용안내</li>
			<c:choose>
				<c:when test="${empty sessionScope.auth || sessionScope.auth eq \"학생\" }">
					<li>상담신청</li>
				</c:when>
				<c:when test="${sessionScope eq \"교수\" }">
					<li>상담관리</li>
				</c:when>
			</c:choose>
			
			<li>자료실</li>
		</ul>
	</div>
	
</div>

<div id="headline"></div>