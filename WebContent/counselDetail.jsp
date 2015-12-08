<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/profile.css">
 <c:set var="student" value="${requestScope.student }"/>
  <c:set var="counsel" value="${requestScope.counsel }"/>
  <c:set var="counselRecord" value="${requestScope.counselRecord }"/>
<div id="article">

<h1 cid="${param.cid }">
	상담상세정보
</h1>
<hr>

<div id="profile">
	<h2>학생정보</h2>
		<hr>
		<table class="table table-bordered">
			<tr>
				
				<td>학번</td>
				<td>${student.studentId }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${student.name }</td>
			</tr>
			<tr>
				<td>학과</td>
				<td>${student.departmentName }</td>
			</tr>
			<tr>
				<td>부전공</td>
				<td>${student.minorName }</td>
			</tr>
			<tr>
				<td>복수전공</td>
				<td>${student.doubleMajorName }</td>
			</tr>
			
	        <tr>
	        	<td>핸드폰</td>
				<td colspan="2">${student.phone }</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td colspan="2">${student.email }</td>
			</tr>
			<tr>
				<td>상태</td>
				<td colspan="2">${student.status }</td>
			</tr>
			
		</table>
	</div>
	
	<div id="counselContainer">
		<h2>상담정보</h2>
		<hr>
		
		<table class="table">
			<tr>
				<th>상담구분</th>
				<td>${counsel.counselDivision }</td>
			</tr>
			
			<tr>
				<th>상담요청시간</th>
				<td>${counsel.wantDate }</td>
			</tr>
			
			<tr>
				<th>첨부자료</th>
				<td>
					<form method="POST" id="downloadForm" action="counselFileDownload.ajax">
					<span id="fileDownload"><a href="#">${counsel.file }</a></span>
					<input type="hidden" name="fileName" value="${counsel.file }">
					</form>
				</td>
			</tr>
			
			<tr>
				<th>상담사유</th>
				<td>${counsel.reason }</td>
			</tr>
			<tr>
				<th>상담종류</th>
				<td>${counsel.counselCategory }</td>
			</tr>
			
			
			<c:if test="${\"집단상담\" eq counsel.counselCategory}">
				<tr id="groupCounselListTh">
					<th rowspan="2">집단상담목록</th>
					
				</tr>
				<tr id="groupCounselListTd">
					<td>
						<div id="groupCounselList">
							<c:forEach var="i" items="${ requestScope.groupList }">
								<li>${i.studentId}&nbsp;${ i.name }</li>
							</c:forEach>
						</div>
					</td>
				</tr>
			</c:if>
			<c:if test="${\"완료\" eq counsel.status }">
				<tr>
					<td>상담기록</td>
					<td><input type="button" class="btn btn-default" value="상세보기" href='#recordModal' data-toggle='modal'></td>
				</tr>
			</c:if>
			<tr>
				<td colspan="2">
				<c:choose>
					<c:when test="${\"신청\" eq counsel.status }">
						<input type="button" class="btn btn-primary" value="승인">
						<input type="button" class="btn btn-danger" value="반려" href='#returnModal' data-toggle='modal'>
					</c:when>
					<c:when test="${\"승인\" eq counsel.status }">
						<input type="button" class="btn btn-success" value="완료" href='#successModal' data-toggle='modal'>
					</c:when>
				</c:choose>
				
								<input type="button" class="btn btn-default" onclick="history.back()" value="돌아가기">
				</td>
				
			</tr>
		</table>
		
	</div>
</div>

<div id="recordModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h2>상담기록</h2>
				</div>
				<div class="modal-body">
					<div class="col-sm-offset-5 col-sm-10">
						<label class="col-sm-8" id="generNum"> </label>
					</div>
					<form class="form-horizontal" id="recordForm" method="post">
					
						<div class="form-group">
							<label class="col-sm-3 control-label">상담완료시간</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${counselRecord.counselDate }" readonly>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">상담기록</label>
							<div class="col-sm-8">
								<textarea type="text" class="form-control" readonly>${counselRecord.content }</textarea>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">작성일</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" value="${counselRecord.recordDate }" readonly>
							</div>
						</div>
	

						
					</form>
				</div>
			</div>
		</div>
	</div>
	


<div id="returnModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h2>반려사유</h2>
				</div>
				<div class="modal-body">
					<div class="col-sm-offset-5 col-sm-10">
						<label class="col-sm-8" id="generNum"> </label>
					</div>
					<form class="form-horizontal" id="returnForm" method="post">
					
						<div class="form-group">
							<label class="col-sm-3 control-label"></label>
							<div class="col-sm-8">
								<textarea class='form-control' name="returnReason" required></textarea>
							</div>
						</div>
						
	

						<div class="form-group">
							<div class="col-sm-offset-5 col-sm-10">
								<button type="submit" class="btn btn-primary" id="returnButton"
						>반려</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
<div id="successModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h2>상담기록</h2>
				</div>
				<div class="modal-body">
					<div class="col-sm-offset-5 col-sm-10">
						<label class="col-sm-8" id="generNum"> </label>
					</div>
					<form class="form-horizontal" id="successForm" method="post">
					
						<div class="form-group">
							<label class="col-sm-3 control-label">상담날짜</label>
							<div class="col-sm-8">
								<input type="date" id="counselDate" class="form-control">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">상담내용</label>
							<div class="col-sm-8">
								<textarea class="form-control" name="content" required></textarea>
							</div>
						</div>
						
	

						<div class="form-group">
							<div class="col-sm-offset-5 col-sm-10">
								<button type="submit" class="btn btn-primary" id="successButton"
						>완료</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<script src="assets/js/counselDetail.js"></script>