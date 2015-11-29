<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="article">

	<h1>
		담당학생관리 (${requestScope.professorName })
	</h1>
	<hr>
	<div id="studentContainer" did="${requestScope.departmentId }" pid="${requestScope.professorId }">
	</div>
	
	<div id="btnDiv" style="text-align:center;margin-top:50px;">
		<input type="button" class="btn btn-primary" value="저장">
		<input type="button" class="btn btn-default" value="돌아가기" onclick="history.back()">
	</div>
</div>

<script src="assets/js/adviserStudent.js"></script>