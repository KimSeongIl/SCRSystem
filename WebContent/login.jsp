<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="scr.dto.UserDTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%UserDTO user=(UserDTO)request.getAttribute("user");
if(user==null){
%>
<script>
	alert('아이디 또는 비밀번호가 맞지 않습니다');
	history.back();
</script>
<%}else{
	session.setAttribute("uid",user.getUid());
	session.setAttribute("name",user.getName());
	session.setAttribute("auth",user.getAuth());

	%>
<script>
	location.href="main.do";
</script>
<%} %>

</body>
</html>