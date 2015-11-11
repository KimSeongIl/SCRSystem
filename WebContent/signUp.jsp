<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="scr.dto.DepartmentDTO"%>

<%@ page import="java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="assets/css/signUp.css">

<c:set var="department" value="${requestScope.department }" />

<style>
#signUpHead{background-color:#2080D0;height:15px;  }

#signUpHead td{border:1px solid #2080D0; }

tr#signUpHead{margin:100px;}

#signUpFooter{background-color:#2080D0;height:15px; }

#signUpFooter td{border:1px solid #2080D0; }





td{height:15px;}
#signUp tr td {
    padding: 7px;
}
.table>thead>tr>th {
    
    
    vertical-align: center;
   
}
table#signUp input{margin-left:30px;} 

table#signUp select{margin-left:30px;}



</style>


<div id="article">

	<center><h3>회원가입</h3></center><br>
	<form action="studentAdd.do" name="signupForm" id="signupForm"
		method="post" class="form-inline">
	
	<table id="signUp" class="table">
		<tr id="signUpHead" >
			<td colspan="3"><div></div></td>
			
		</tr>
		<tr>
		<td colspan="3"></td>
		</tr>
		<tr>
			<td>이름</td>
			<div></div><td><input type="text" class="form-control" placeholder="이름"
				name="uname" required></td></div>
				<td></td>
		</tr>
		
		<tr>
			<td>학번</td>
			<td><input type="number" class="form-control" placeholder="학번"
				name="uid" required></td>
				<td></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="password" class="form-control"
				placeholder="비밀번호" name="password" required
				title="영어,숫자,특수문자 조합(6~12)"
				pattern="(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}"> &nbsp;영어,숫자,특수문자 조합(6~12)자리입니다.</td>
				<td></td>
		</tr>
		<tr>
			<td>비번 확인</td>
			<td><input type="password" class="form-control"
				placeholder="비밀번호 확인" name="passwordConfirm" required></td>
			<td></td>
		</tr>
		<tr>
			<td>학과</td>
			<td><select class="form-control" name="department">
					<c:forEach var="i" items="${ department }">
						<option value="${i.departmentId }">${ i.departmentName }</option>
					</c:forEach>

			</select></td>
			<td></td>
		</tr>
		<tr>
			<td>부전공</td>
			<td><select class="form-control" name="minor">
					<option value="없음">해당없음</option>
					<c:forEach var="i" items="${ department }">
						<option value="${i.departmentId }">${ i.departmentName }</option>
					</c:forEach>

			</select></td>
			<td></td>
		</tr>
		<tr>
			<td>복수전공</td>
			<td><select class="form-control" name="doubleMajor">
					<option value="없음">해당없음</option>
					<c:forEach var="i" items="${ department }">
						<option value="${i.departmentId }">${ i.departmentName }</option>
					</c:forEach>
			</select></td>
			<td></td>
		</tr>
		<tr>
			<td>핸드폰 번호</td>
			<td><input type="text" class="form-control"
				placeholder="-포함하여 입력하시오" name="phone" title="xxx-xxxx-xxxx"
				required pattern="(010|011)-\d{3,4}-\d{4}"></td>
				<td></td>
		</tr>
		<tr>
			<td>이메일</td>
			<td><input type="email" class="form-control" placeholder="이메일"
				name="email" required></td>
				<td></td>
		</tr>

		<tr>
			<td>상태</td>
			<td><select class="form-control" name="status">
					<option>재학생</option>
					<option>휴학생</option>

			</select></td>
			<td></td>
		</tr>
		<tr>
		<td colspan="3"></td>
		</tr>
		<tr id="signUpFooter">
			<td colspan="3"></td>
			<td></td>
		</tr>

	</table>
	</form>
	
	

	<form action="studentAdd.do" name="signupForm" id="signupForm"
		method="post" class="form-inline">
		<div id="signUpTitle">
			<b>회원가입</b><br>
		</div>
		<hr>
		<table id="signUp">

			<tr>
				<td>이름</td>
				<td><input type="text" class="form-control" placeholder="이름"
					name="uname" required></td>
			</tr>

			<tr>
				<td>학번</td>
				<td><input type="number" class="form-control" placeholder="학번"
					name="uid" required></td>
			</tr>

			<tr>
				<td>비밀번호</td>
				<td><input type="password" class="form-control"
					placeholder="비밀번호" name="password" required
					title="영어,숫자,특수문자 조합(6~12)"
					pattern="(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,12}"></td>
			</tr>

			<tr>
				<td>비번확인</td>
				<td><input type="password" class="form-control"
					placeholder="비밀번호 확인" name="passwordConfirm" required></td>
			</tr>

			<tr>
				<td>학과</td>
				<td><select class="form-control" name="department">
						<c:forEach var="i" items="${ department }">
							<option value="${i.departmentId }">${ i.departmentName }</option>
						</c:forEach>

				</select></td>
			</tr>

			<tr>
				<td>부전공</td>
				<td><select class="form-control" name="minor">
						<option value="없음">해당없음</option>
						<c:forEach var="i" items="${ department }">
							<option value="${i.departmentId }">${ i.departmentName }</option>
						</c:forEach>

				</select></td>
			</tr>

			<tr>
				<td>복수전공</td>
				<td><select class="form-control" name="doubleMajor">
						<option value="없음">해당없음</option>
						<c:forEach var="i" items="${ department }">
							<option value="${i.departmentId }">${ i.departmentName }</option>
						</c:forEach>
				</select></td>
			</tr>


			<tr>
				<td>핸드폰번호</td>
				<td><input type="text" class="form-control"
					placeholder="-포함하여 입력하시오" name="phone" title="xxx-xxxx-xxxx"
					required pattern="(010|011)-\d{3,4}-\d{4}"></td>
			</tr>

			<tr>
				<td>이메일</td>
				<td><input type="email" class="form-control" placeholder="이메일"
					name="email" required>
				<td>
			</tr>

			<tr>
				<td>상태</td>
				<td><select class="form-control" name="status">
						<option>재학생</option>
						<option>휴학생</option>

				</select></td>
			</tr>

		</table>


		<hr>


		<div id="joinBtn">
			<input type="submit" class="btn btn-primary" id="join" value="가입하기" />
		</div>

	</form>

</div>


<script src="assets/js/signUp.js"></script>


