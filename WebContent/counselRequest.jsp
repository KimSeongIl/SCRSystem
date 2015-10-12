<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="assets/css/counsel.css">

<div id="article">
	<h1>상담신청</h1>
	
	<form class="form-inline" id="professorSearch" method="post">
		<select class="form-control">
			<option>교수명</option>
			<option>학과</option>
		</select>
		<input type="search" class="form-control" required>
		<button class="btn btn-default"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>검색</button>
	</form>
	
	
	<div id="professorListContainer">
		<table class="table table-hover">
			<thead>
				<tr>
					<th>교수번호</th>
					<th>교수명</th>
					<th>학과</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
	</div>
	
</div>

<script type="text/javascript" src="assets/js/counselRequest.js"></script>