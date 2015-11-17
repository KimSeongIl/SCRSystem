<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="scr.dto.UserDTO" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="user" value="${requestScope.user }" />
<c:choose>
	<c:when test="${empty user }">
		<script>
			alert('아이디 또는 비밀번호가 맞지 않습니다');
			history.back();
		</script>
	</c:when>
	<c:otherwise>
		<c:set var="uid" value="${user.uid }" scope="session" />
		<c:set var="name" value="${user.name }" scope="session" />
		<c:set var="auth" value="${user.auth }" scope="session" />
		<script>
			location.href="main.do";
		</script>
	</c:otherwise>
</c:choose>

 

 


</body>
</html>