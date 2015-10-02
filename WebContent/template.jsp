<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>성공회대학교 상담 관리 시스템</title>
<link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/earlyaccess/nanumgothic.css">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="assets/css/common.css">
<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/common.js"></script>
</head>
<body>

	<div id="wrap">
	<c:import url="header.jsp"/> 
	<c:import url="nav.jsp"/> 
	<c:import url="${requestScope.article }"/> 
	<c:import url="footer.jsp"/> 
	<div id="loading"><img src="assets/img/ajax-loader.gif"></div>
	</div>
	
</body>
</html>



