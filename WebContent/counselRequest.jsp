<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/counsel.css">

<div id="article">
	<h1>상담신청</h1>
	
	<form class="form-inline" id="professorSearch" >
		<select class="form-control" id="searchCategory">
			<option value="professor">교수명</option>
			<option value="department">학과</option>
		</select>
		<input type="search" class="form-control" required id="searchContent">
		<button type="submit" class="btn btn-default" id="searchBtn"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>검색</button>
	</form>
	
	<div id="professorListContainer">
		
	</div>
	
</div>

<script type="text/javascript" src="assets/js/counselRequest.js"></script>