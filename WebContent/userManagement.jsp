<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="assets/css/userManagement.css">

<c:if test="${\"관리자\" ne sessionScope.auth}">
	<script>
		alert('권한이 없습니다');
		location.href="login.do";
	</script>
</c:if>

<div id="article">
	<div>
	<h1 style="display:inline-block;">
		회원관리
	</h1>
	<div style="display:inline-block;width:40%;float:right;margin-top:25px;margin-bottom:10px;text-align:right;">
			<form id="searchForm">
			<input type="search" class="form-control" id="searchInput" style="width:50%;display:inline-block;margin-right:10px;" placeholder="학생 이름으로 검색">
			<input width="50%" class="btn btn-default"  id="searchBtn" type="submit" value="검색" >
			</form>
	</div>
	<hr>
	</div>
	<ul class="nav nav-tabs" id="userManagementMenu">
  		<li role="presentation" class="active" id="studentList"><a href="#">학생</a></li>
  		<li role="presentation" id="professorList"><a href="#">교수</a></li>
  		<li role="presentation" id="employeeList"><a href="#">직원</a></li>
		
	</ul>
	
	<div id="userManagementContainer">
	
	</div>
</div>









<div id="employeeModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h2>직원 추가</h2>
				</div>
				<div class="modal-body">
					<div class="col-sm-offset-5 col-sm-10">
						<label class="col-sm-8" id="generNum"> </label>
					</div>
					<form class="form-horizontal" id="employeeAddForm" method="post">
					
						<div class="form-group">
							<label class="col-sm-3 control-label">직원 번호</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="employeeId"
									placeholder="Id.." required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">직원 이름</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="employeeName"
									placeholder="Name.." required>
							</div>
						</div>
						
						
						<div class="form-group">
							<label class="col-sm-3 control-label">핸드폰</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="phone"
									placeholder="Phone.." required title="xxx-xxxx-xxxx" required pattern="(010|011)-\d{3,4}-\d{4}">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">이메일</label>
							<div class="col-sm-8">
								<input type="email" class="form-control" name="email"
									placeholder="Email.." required>
							</div>
						</div>
						

						<div class="form-group">
							<div class="col-sm-offset-5 col-sm-10">
								<button type="submit" class="btn btn-primary" id="employeeAddButton"
						>직원 추가</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	
	
	
	
	
<div id="professorModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h2>교수 추가</h2>
				</div>
				<div class="modal-body">
					<div class="col-sm-offset-5 col-sm-10">
						<label class="col-sm-8" id="generNum"> </label>
					</div>
					<form class="form-horizontal" id="professorAddForm" method="post">
					
					
						<div class="form-group" id="imgContainer">
							
							<img src="assets/img/alt.png" id="professorImg" width="140px" height="140px" alt="img" class="img-rounded">
							
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">교수 이미지</label>
							<div class="col-sm-8">
								<input type="file" class="form-control" name="professorImg"
									placeholder="File.." onchange="readImg(this)">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">교수 번호</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="professorId"
									placeholder="Id.." required >
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">교수 이름</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="professorName"
									placeholder="Name.." required  >
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">사무실 번호</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="officeNo"
									placeholder="No.." >
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">사무실 전화</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="officeTel"
									placeholder="Tel.." >
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">핸드폰</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="phone"
									placeholder="Phone.." title="xxx-xxxx-xxxx" required pattern="(010|011)-\d{3,4}-\d{4}">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">이메일</label>
							<div class="col-sm-8">
								<input type="email" class="form-control" name="email"
									placeholder="Email.." required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">학과</label>
							<div class="col-sm-8">
								<select class="form-control" name="departmentId">
										<option value="0">없음</option>
									<c:forEach var="department" items="${requestScope.departmentList }">
										<option value="${department.departmentId }">${department.departmentName }</option>
									</c:forEach> 
								</select>
								
								
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">부학과</label>
							<div class="col-sm-8">
								<select class="form-control department_grp" name="departmentGroup">
										<option value="0">없음</option>
									<c:forEach var="department" items="${requestScope.departmentList }">
										<option value="${department.departmentId }">${department.departmentName }</option>
									</c:forEach> 
								</select>
								
								
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">등록 학과</label>
							<div class="col-sm-8" id="departmentList">
								
							</div>
						</div>
			
						
						
						


						<div class="form-group">
							<div class="col-sm-offset-5 col-sm-10">
								<button type="submit" class="btn btn-primary" id="professorAddButton"
						>교수 추가</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript" src="assets/js/userManagement.js"></script>
