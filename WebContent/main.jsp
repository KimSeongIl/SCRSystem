<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,scr.dto.BoardDTO" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="assets/css/main.css">



<div id="category">
	<div id="notice">
		<div id="noticeTitle">
		</div>
		<%
	List boardList=(List)request.getAttribute("boardList");
	if(boardList !=null){
		out.println("<ul>");
		for(int i=0;i<4;i++){
			BoardDTO board=(BoardDTO)boardList.get(i);
			
			
		
			out.println("<li><a href='boardDetail.do?bid="+board.getBId()+"'>"+board.getBTitle()+"</a></li>");
	
			
		}
		out.println("</ul>");
	}
	
	%>
	</div>
	<c:choose>
		<c:when test="${empty sessionScope.auth || \"학생\" eq sessionScope.auth }">
			<div id="online">
				<div id="onlineTitle">
				</div>
				<div id="onlineContainer">
					<div id="onlineContent">
						<div id="onlineText">
						</div>
						<div id="onlineBtn">
							<input type="button" auth="${sessionScope.auth }" class="btn btn-default onlineBtn" value="온라인상담  >"  href='#onlineModal' data-toggle='modal' >
						</div>
					</div>
					<div id="onlineImgContainer">
						<div id="onlineImgMargin">
						</div>
						<div id="onlineImg">
						</div>
					</div>
			
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div id="download">
		
				<div id="downloadTitle">
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	
	<div id="link">
		<div id="linkTitle">
		</div>
		<div id="linkImgContainer">
  			<div class="linkImg">
  				<a href="http://www.skhu.ac.kr" target="_blank">
  					<img src="assets/img/skhuicon.jpg" width="100%" height="100%"  alt="skhu">
  				</a>
  				
  			</div>
  			<div class="linkImg">
  				<a href="http://ecareer.skhu.ac.kr" target="_blank">
  					<img src="assets/img/ecareericon.jpg" width="100%" height="100%" alt="ecareer">
  				</a>
  			</div>
  			<div class="linkImg">
  				<a href="http://forest.skhu.ac.kr" target="_blank">
  					<img src="assets/img/foresticon.jpg" width="100%" height="100%" alt="forest">
  				</a>
  			</div>
  			<div class="linkImg">
  				<a href="http://library.skhu.ac.kr" target="_blank">
  					<img src="assets/img/libraryicon.jpg" width="100%" height="100%" alt="library">
  				</a>
  			</div>
  			<div class="linkImg">
  				<a href="http://com.skhu.ac.kr" target="_blank">
  					<img src="assets/img/asicon.jpg" width="100%" height="100%" alt="as">
  				</a>
  			</div>
  		</div>
  			
		
	</div>
</div>
<div id="picture"></div>



<div id="onlineModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">x</button>
					<h2>온라인 상담</h2>
				</div>
				<div class="modal-body">
					<div class="col-sm-offset-5 col-sm-10">
						<label class="col-sm-8" id="generNum"> </label>
					</div>
					<form class="form-horizontal" id="onlineCounselForm" method="post">
					
						<div class="form-group">
							<label class="col-sm-3 control-label">학과</label>
							<div class="col-sm-8">
								<select class="form-control" name="department">
									<option value="0">학과를 선택하세요.</option>
									<c:forEach var="i" items="${ department }">
										<option value="${i.departmentId }">${ i.departmentName }</option>
									</c:forEach>

								</select>
							</div>
						</div>
						
						<div class="form-group" id="professorDiv">
							
						</div>
						
						
						<div class="form-group">
							<label class="col-sm-3 control-label">제목</label>
							<div class="col-sm-8">
								<input type="text" class="form-control" name="title"
									placeholder="Title.." required >
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">내용</label>
							<div class="col-sm-8">
								
								<textarea class="form-control" name="content" required></textarea>
							</div>
						</div>
						

						<div class="form-group">
							<div class="col-sm-offset-5 col-sm-10">
								<button type="submit" class="btn btn-primary" id="onlineSubmitButton"
						>상담 신청</button>
							</div>

						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<script src="assets/js/main.js"></script>