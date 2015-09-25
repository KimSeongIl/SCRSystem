
	<script src=""></script>

	

	<div id="article" style="padding-left:50px;">
	<br>
	<b>회원가입</b><br>
	<hr>

	<form action="" name="signupForm" id="signupForm" method="post" class="form-inline">
         &nbsp;&nbsp;&nbsp;이름
    
	<input type="text" class="form-control" placeholder="이름" name="uname"><br><br>
          학번
    <input type="text" class="form-control" placeholder="학번" name="uid"><br><br>      

	비밀번호
	<input type="password" class="form-control" placeholder="비밀번호" name="password"><br><br>
	비번확인
	<input type="password" class="form-control" placeholder="비밀번호 확인" name="passwordConfirm"><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;학과
	<input type="text" class="form-control" placeholder="학과" name="department"><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;부전공
	<input type="text" class="form-control" placeholder="부전공" name="minor"><br><br>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;복수전공
	<input type="text" class="form-control" placeholder="복수전공" name="doubleMajor"><br><br>
	&nbsp;&nbsp;&nbsp;휴대폰번호

	<input type="number" class="form-control" placeholder="-없이 입력하시오" name="phone"><br><br>
	&nbsp;&nbsp;&nbsp;이메일
    <input type="text" class="form-control" placeholder="이메일" name="email"><br>
    &nbsp;&nbsp;&nbsp;상태
    <input type="text" class="form-control" placeholder="학생상태" name="ustatus"><br>

	
	<hr>
	

<input type="submit" class="btn btn-primary" id="join" onclick="if(!signUp(this.form)){return false;}" value="가입하기"/>
	<br><br>
	</form>
	</div>
	
	

