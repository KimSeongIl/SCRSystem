<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="scr.dto.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/myPage.css">
<c:set var="department" value="${requestScope.departmentUpdate }" />
<c:set var="list" value="${requestScope.professorUpdate }" />
	
<div id="article">

	<c:import url="myPageMenu.jsp" />
		
	<div id="myPagePW">
			<h2>정보수정</h2>
		<form method="post" id="updateForm" action="professorUpdatePro.do" enctype="multipart/form-data">
		<div id="updateTable">
			
			
			
			<table>
				<tr>
					<td>이미지</td>
					<td><img id="professorImg" width="140px" height="140px" style='margin:auto;' src="assets/img/profile/${list.img }" onerror="this.src='assets/img/sample.png'"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type='file' class='form-control' onchange='readImg(this)' name="professorImg"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="uname" value="${ list.professorName} " class="form-control"></td>				
				</tr>	
				<tr>
					<td>교수번호</td>
					<td><input type="number" name="uid" value="${ list.professorId}" class="form-control" readonly></td>								
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
					<td>학과</td>
					<td><select class="form-control" name="department">
					<c:forEach var="i" items="${ department }">
					
					<c:if test="${i.departmentId eq list.departmentId}">
						<option value="${i.departmentId }" selected>${ i.departmentName } </option>
					</c:if>
					<c:if test="${i.departmentId ne list.departmentId }">
						<option value="${i.departmentId }">${ i.departmentName } </option>
					</c:if>
					
					</c:forEach>
			</select></td>		
								
				</tr>	
				
				<tr>
					<td>핸드폰번호</td>
					<td><input type="text" name="phone" value="${ list.phone}" class="form-control" ></td>	
									
				</tr>	
				<tr>
					<td>이메일</td>
					<td><input type="email" name="email" value="${ list.email}" class="form-control"></td>	
								
				</tr>	
				<tr>
					<td>연구실번호</td>
					<td><input type="text" name="office_no" value="${ list.officeNo}" class="form-control"></td>								
				</tr>
				<tr>
					<td>연구실전화번호</td>
					<td><input type="text" name="office_tel" value="${ list.officeTel}" class="form-control"></td>								
				</tr>		
			</table>	
			</div>
			<input type="submit" class="btn btn-primary" id="updateBtn" value="수정하기"  />
		</form>			
				
				<script src="assets/js/update.js"></script>
		<br><br><br>
	</div>
</div>

<script src="assets/js/professorUpdate.js"></script>
