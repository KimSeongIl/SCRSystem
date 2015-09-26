
	<script src="assets/js/signUp.js"></script>

	

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
	
	
	학과
	 <select class="form-control" name="department">
                <option>소프트웨어공학과</option>
                <option>컴퓨터공학과</option>
                <option>디지털컨텐츠공학과</option>
                <option>글로커IT학과</option>
            </select>
            <br><br>
          부전공
	 <select class="form-control" name="minor">
                <option>소프트웨어공학과</option>
                <option>컴퓨터공학과</option>
                <option>디지털컨텐츠공학과</option>
                <option>글로커IT학과</option>
            </select>
            <br><br>
            복수전공
	 <select class="form-control" name="doubleMajor">
                <option>소프트웨어공학과</option>
                <option>컴퓨터공학과</option>
                <option>디지털컨텐츠공학과</option>
                <option>글로커IT학과</option>
            </select>
            <br><br>
	
	&nbsp;&nbsp;&nbsp;휴대폰번호
	<input type="number" class="form-control" placeholder="-없이 입력하시오" name="phone"><br><br>
	&nbsp;&nbsp;&nbsp;이메일
    <input type="text" class="form-control" placeholder="이메일" name="email"><br><br>
            상태
	 <select class="form-control" name="doubleMajor">
                <option>재학생</option>
                <option>휴학생</option>
            </select>
            <br><br>

	
	<hr>
	

<input type="submit" class="btn btn-primary" id="join" onclick="if(!signUp(this.form)){return false;}" value="가입하기"/>
	<br><br>
	</form>
	</div>
	
	

