<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="assets/css/departmentManagement.css">

<c:if test="${\"관리자\" ne sessionScope.auth}">
	<script>
		alert('권한이 없습니다');
		location.href="login.do";
	</script>
</c:if>

<div id="article">

	<h1>
		학과관리
	</h1>
	<hr>
	
	<div id="departmentManagementContainer">
		
	</div>
</div>





<div id="departmentModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h2>학과 추가</h2>
				</div>
				<div class="modal-body">
					<div class="col-sm-offset-5 col-sm-10">
						<label class="col-sm-8" id="generNum"> </label>
					</div>
					<form class="form-horizontal" id="departmentAddForm" method="post">
					
						<div class="form-group">
							<label class="col-sm-3 control-label">학과 번호</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="departmentId"
									placeholder="Id.." required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">학과 이름</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="departmentName"
									placeholder="Name.." required>
							</div>
						</div>
						
						
						<div class="form-group">
							<label class="col-sm-3 control-label">사무실 번호</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="officeNo"
									placeholder="Office_No.." required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">사무실 전화</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="officeTel"
									placeholder="Office_Tel.." required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">담당직원</label>
							<div class="col-sm-8">
								<select class="form-control" name="employeeId">
										
									<c:forEach var="employee" items="${requestScope.employeeList }">
										<option value="${employee.employeeId }">${employee.employeeName }(${employee.employeeId })</option>
									</c:forEach> 
								</select>
								
								
							</div>
						</div>
						

						<div class="form-group">
							<div class="col-sm-offset-5 col-sm-10">
								<button type="submit" class="btn btn-primary" id="departmentAddButton"
						>학과 추가</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	

<div id="departmentModifyModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h2>학과 수정</h2>
				</div>
				<div class="modal-body">
					<div class="col-sm-offset-5 col-sm-10">
						<label class="col-sm-8" id="generNum"> </label>
					</div>
					<form class="form-horizontal" id="departmentModifyForm" method="post">
					
						<div class="form-group">
							<label class="col-sm-3 control-label">학과 번호</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="departmentId"
									placeholder="Id.." required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">학과 이름</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="departmentName"
									placeholder="Name.." required>
							</div>
						</div>
						
						
						<div class="form-group">
							<label class="col-sm-3 control-label">사무실 번호</label>
							<div class="col-sm-8">
								<input type="number" class="form-control" name="officeNo"
									placeholder="Office_No.." required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">사무실 전화</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="officeTel"
									placeholder="Office_Tel.." required>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">담당직원</label>
							<div class="col-sm-8">
								<select class="form-control" name="employeeId">
										
									<c:forEach var="employee" items="${requestScope.employeeList }">
										<option value="${employee.employeeId }">${employee.employeeName }(${employee.employeeId })</option>
									</c:forEach> 
								</select>
								
								
							</div>
						</div>
						

						<div class="form-group">
							<div class="col-sm-offset-5 col-sm-10">
								<button type="submit" class="btn btn-primary" id="departmentModifyButton"
						>학과 수정</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

<script src="assets/js/departmentManagement.js"></script>