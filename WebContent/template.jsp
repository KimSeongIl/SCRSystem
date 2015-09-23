<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성공회대학교 상담 관리 시스템</title>
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/earlyaccess/hanna.css">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/main.css">
<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
</head>
<body>
<% //String article=(String)request.getAttribute("article"); %>
	<jsp:include page="header.jsp" flush="false" />
	<jsp:include page="nav.jsp" flush="false" />
	<jsp:include page="<%//=article %>" flush="false" />
	<jsp:include page="footer.jsp" flush="false" />
</body>
</html>