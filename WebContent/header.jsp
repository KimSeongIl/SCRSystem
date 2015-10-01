﻿<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="header">


<c:choose>
	<c:when test="${empty sessionScope.name}">
		<li id="login" onclick="location.href='login.do'">로그인</li>
		<li id="signUp" onclick="location.href='signUp.do'">회원가입</li>
	</c:when>
	<c:otherwise>
	
		<li id="sessionContent">${sessionScope.name}(${sessionScope.auth})</li>
		<li id="myPage">마이페이지</li>
		<li id="logout" onclick="location.href='logout.do'">로그아웃</li>
	</c:otherwise>
</c:choose>
</div>