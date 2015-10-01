<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/login.css">
<div id="article">

	<div id="loginSub">
		<div id="loginSubDiv">
			<h2>메 뉴</h2>
			<hr>
			<ul>
				<li>로그인</li>
				<li>회원가입</li>
				<li>비밀번호 찾기</li>
			</ul>
		</div>
	</div>
	<div id="loginContent">
		<h1>Log in</h1>
		<hr>
		<form method="post" action="loginPro.do">
			<table>
				<tr>
					<th>ID</th>
					<td><input type="text" name="uid" placeholder="ID" class="form-control" autofocus></td>
				</tr>
				<tr>
					<th>PW</th>
					<td><input type="password" name="password" placeholder="PW" class="form-control"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-default" value="Log in"></td>
				</tr>
			</table>
		</form>
	</div>
</div>