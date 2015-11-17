<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"  prefix="fn"%>
<link rel="stylesheet" type="text/css" href="assets/css/profile.css">

<div id="article">
 <c:set var="professor" value="${requestScope.professor }"/>
 <c:set var="department" value="${professor.departmentList }" />
  
	<div id="profile" pid="${param.pid }">
	
		<table class="table table-bordered">
			<tr>
				<td rowspan="${fn:length(department)+2}"><img src="assets/img/profile/${professor.img }" onerror="this.src='assets/img/alt.png'" width="140px" height="140px"></td>
				<td>교수명</td>
				<td>${professor.professorName }</td>
			</tr>
			<tr>
				<td rowspan="${fn:length(department)+1}">학과</td>
				<td>${professor.departmentName }</td>
			</tr>
			
			<c:forEach var="i" items="${ department }">
			<tr>
				<td value="${i.departmentId }">${ i.departmentName }</td>
			</tr>
	        </c:forEach>
	        <tr>
	        	<td>핸드폰</td>
				<td colspan="2">${professor.phone }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td colspan="2">${professor.email }</td>
			</tr>
			<tr>
				<td>연구실번호</td>
				<td colspan="2">${professor.officeNo }</td>
			</tr>
			<tr>
				<td>연구실전화</td>
				<td colspan="2">${professor.officeTel }</td>
			</tr>
		</table>
	</div>
	
	<div id="counselContainer">
		<h2>상담신청</h2>
		<hr>
		<form id="counselSubmitForm" action="aa.do">
		<table class="table">
			<tr>
				<th>상담구분</th>
				<td><select name="division" class="form-control">
						<option>진로상담</option>
						<option>휴학상담</option>
						<option>학습상담</option>
						<option>취업상담</option>
						<option>생활상담</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>학기</th>
				<td><select name="term" class="form-control">
						<option value="1">1학기</option>
						<option value="2">2학기</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>상담요청시간</th>
				<td><input name="want_date" type="text" class="form-control" required></td>
			</tr>
			<tr>
				<th>상담사유</th>
				<td><div contenteditable="true" id="reasonDiv"></div></td>
			</tr>
			<tr>
				<th>첨부자료</th>
				<td><input type="file" class="form-control"></td>
			</tr>
			<tr>
				<th>상담종류</th>
				<td>
					<select class="form-control" id="counselCategory">
						<option>개인상담</option>
						<option>집단상담</option>
					</select>
				</td>
			</tr>
			
			<tr id="groupCounsel">
				<th>집단상담</th>
				<td><input type="text" placeholder="이름으로 검색" name="studentSearch" class="form-control"><div id="searchList"></div></td>
			</tr>
			
			
				<tr id="groupCounselListTh">
					<th rowspan="2">집단상담목록</th>
					
				</tr>
				<tr id="groupCounselListTd">
					<td>
						<div id="groupCounselList">
						
						</div>
					</td>
				</tr>
			
			<tr>
				<td colspan="2"><input type="submit" class="btn btn-primary" value="신청">
								<input type="button" class="btn btn-default" onclick="history.back()" value="돌아가기">
				</td>
				
			</tr>
		</table>
		</form>
	</div>

</div>

<script type="text/javascript" src="assets/js/profile.js"></script>