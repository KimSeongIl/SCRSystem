<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="scr.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/myPage.css">

<c:set var="list" value="${requestScope.employeeUpdate }" />
	
<div id="article">

	<c:import url="myPageMenu.jsp" />
		
	<div id="myPagePW">
			<h2>정보수정</h2>
		<form method="post" id="updateForm" action="employeeUpdatePro.do">
		<div id="updateTable">
			<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="uname" value="${ list.employeeName} " class="form-control"></td>				
				</tr>	
				<tr>
					<td>학번</td>
					<td><input type="number" name="uid" value="${ list.employeeId}" class="form-control" readonly></td>								
				</tr>		
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" placeholder="비밀번호 입력" class="form-control"></td>									
				</tr>	
				<tr>
					<td>비번확인</td>
					<td><input type="password" name="passwordConfirm1" class="form-control" required
				title="영어,숫자,특수문자 조합(6~12)"
				pattern="(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}" placeholder="비밀번호 재확인" > </td>					
				</tr>	
				
				<tr>
					<td>핸드폰번호</td>
					<td><input type="text" name="phone" value="${ list.phone}" class="form-control" ></td>	
									
				</tr>	
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="${ list.email}" class="form-control"></td>	
								
				</tr>	
				
			</table>	
			</div>
			<input type="submit" class="btn btn-primary" id="updateBtn" value="수정하기"  />
		</form>			
				
				<script src="assets/js/update.js"></script>
		<br><br><br>
	</div>
</div>

