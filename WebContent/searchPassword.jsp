<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/login.css">

<div id="article">

	<c:import url="loginMenu.jsp" />
	
	<div id="searchPasswordContent">
		<h1>비밀번호 찾기</h1>
		<hr>
		<form method="post" action="searchPasswordPro.do">
			<table>
				<tr>
					<td colspan="2">
						<span>
							<input type="radio" value="student" name="user" id="student"><label for="student">학생</label>
						</span>
						<span>
							<input type="radio" value="professor" name="user" id="professor"><label for="professor">교수</label>
						</span>
						<span>
							<input type="radio" value="employee" name="user" id="employee"><label for="employee">직원</label>
						</span>
						
					</td>
				</tr>
				<tr>
					<th>학번</th>
					<td><input type="text" name="uid" placeholder="찾을 학번 입력" class="form-control" autofocus></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="email" name="uemail" placeholder="가입할때 입력한 이메일 입력" class="form-control"></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" class="btn btn-default" value="비밀번호 찾기"></td>
				</tr>
			</table>
		</form>
	</div>
</div>