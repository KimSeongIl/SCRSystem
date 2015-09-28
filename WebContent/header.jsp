<div id="header">
<%
String name=(String)session.getAttribute("name");
String auth=(String)session.getAttribute("auth");
if(name==null){
%>
	<li id="login" data-toggle="modal" data-target="#myModal">로그인</li>
	<li id="signUp" onclick="location.href='signUp.do'">회원가입</li>
<%}else{ %>
	<li id="sessionContent"><%=name%>(<%=auth%>)</li>
	<li id="myPage">마이페이지</li>
	<li id="logout" onclick="location.href='logout.do'">로그아웃</li>
<%} %>
</div>

<div class="modal fade" id="myModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Log in</h4>
      </div>
      <div class="modal-body col-xs-12">
        <form method="post" action="login.do" class="form-horizontal">
					
						<div class="form-group">
							<label class="col-sm-3 control-label">I D</label>
							<div class="col-xs-8">
								<input type="text" class="form-control" name="uid"
									placeholder="ID..">
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-xs-3 control-label">Password</label>
							<div class="col-sm-8">
								<input type="password" class="form-control" name="password"
									placeholder="Password..">
							</div>
						</div>
			
						
						
						


						
					
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Save changes</button>
      </div>
      </form>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->