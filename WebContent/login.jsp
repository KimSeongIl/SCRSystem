<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/login.css">
<div id="article">

	<c:import url="loginMenu.jsp" />
	<div id="loginContent">
		<h1>로그인</h1>
		<hr>
		<form method="post" action="loginPro.do">
			<table>
				<tr>
					<th>학번</th>
					<td><input type="text" name="uid" placeholder="ID" class="form-control" autofocus></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type="password" name="password" placeholder="PW" class="form-control"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-default" value="로그인"></td>
				</tr>
			</table>
		</form>
	</div>
</div>