<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="assets/css/counselManagement.css">
<div id="article">

	<div id="managementContainer">
		<div id="chartDiv">
			<div id="chart-title">
				
			</div>
			<div id="chart-first">
				<div id="chart-first-title">
				</div>
				<div id="doughnutChart"> </div>
				
			</div>
			<div id="chart-second">
				<div id="chart-second-title">
					<div id="selectDiv">
						
					</div>
					
				</div>
				<div id="char-second-bar">
				<canvas id="barChart" width="400"></canvas>
				</div>
			</div>
		</div>
		<div id="listDiv">
			<div id="list-title">
			</div>
			<div id="list-content">
				
			</div>
		</div>
		<div id="btnDiv">
			<div id="chargeBtnDiv" onclick="location.href='adviserStudentPro.do'">
				담당교수관리
			</div>
			<div id="studentBtnDiv" onclick="location.href='counselListPro.do'">
				학생상담목록
			</div>
		</div>
	</div>
</div>

<script src="assets/js/Chart.js"></script>
<script src="assets/js/doughnutit.js"></script>
<!-- Folha de estilos -->
<link rel="stylesheet" type="text/css" href="assets/css/doughnutit.css">
<script type="text/javascript" src="assets/js/counselManagementPro.js"></script>