<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/myPage.css">
<div id="article">

	<c:import url="myPageMenu.jsp" />
	
	<div id="myPagePW">
		
		<h2>정보수정</h2>
		<form method="post" action=".do">
					<table>
				<tr>
					<td>이름</td>
					<td><input type="text" name="name" class="form-control"></td>	
									
				</tr>	
				<tr>
					<td>학번</td>
					<td><input type="text" name="studentId" class="form-control"></td>		
						
				</tr>		
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password" class="form-control"></td>		
							
				</tr>	
				<tr>
					<td>비번확인</td>
					<td><input type="password" name="password" class="form-control" required
				title="영어,숫자,특수문자 조합(6~12)"
				pattern="(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}"> </td>					
				</tr>	
				<tr>
					<td>학과</td>
					<td><input type="password" name="password" class="form-control"></td>		
								
				</tr>	
				<tr>
					<td>부전공</td>
					<td><input type="password" name="password" class="form-control"></td>
										
				</tr>	
				<tr>
					<td>복수전공</td>
					<td><input type="password" name="password" class="form-control"></td>
										
				</tr>	
				<tr>
					<td>핸드폰번호</td>
					<td><input type="password" name="password" class="form-control"></td>	
									
				</tr>	
				<tr>
					<td>이메일</td>
					<td><input type="password" name="password" class="form-control"></td>	
								
				</tr>	
				<tr>
					<td>상태</td>
					<td><input type="password" name="password" class="form-control"></td>	
										
				</tr>	
			</table>	
		</form>
		<br><br><br>
	</div>
</div>

