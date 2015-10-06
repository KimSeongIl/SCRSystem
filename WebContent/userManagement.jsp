<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="assets/css/userManagement.css">

<c:if test="${\"직원\" ne sessionScope.auth && \"관리자\" ne sessionScope.auth}">
	<script>
		alert('권한이 없습니다');
		history.back();
	</script>
</c:if>

<div id="article">

	<h1>
		회원관리
	</h1>
	<hr>
	
	<ul class="nav nav-tabs" id="userManagementMenu">
  		<li role="presentation" class="active"><a href="#">학생</a></li>
  		<li role="presentation"><a href="#">교수</a></li>
  		
<c:if test="${\"관리자\" eq sessionScope.auth }">
  		<li role="presentation"><a href="#">직원</a></li>
</c:if>
	</ul>
	
	<div id="userManagementContainer">
	
	</div>
</div>

<script type="text/javascript" src="assets/js/userManagement.js"></script>