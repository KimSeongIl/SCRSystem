
	

	<link rel="stylesheet" type="text/css" href="assets/css/signUp.css">

	<div id="article" style="padding-left:50px;">
	<br>
	<b>회원가입</b><br>
	<hr>
	<form action="" name="signupForm" id="signupForm" method="post" class="form-inline">
  <table id="signUp">  
	
   <tr>
           <td>이름</td>
	<td><input type="text" class="form-control" placeholder="이름" name="uname"></td>
    </tr>
    
    <tr>    
          <td>학번</td>
    <td><input type="text" class="form-control" placeholder="학번" name="uid"></td>      
	</tr>
	
	<tr>
	<td>비밀번호</td>
	<td><input type="password" class="form-control" placeholder="비밀번호" name="password"></td>
	</tr>
	
	<tr>
	<td>비번확인</td>
	<td><input type="password" class="form-control" placeholder="비밀번호 확인" name="passwordConfirm"></td>
	</tr>
	
	<tr>
	<td>학과</td>
	 <td><select class="form-control" name="department">
                <option>소프트웨어공학과</option>
                <option>컴퓨터공학과</option>
                <option>디지털컨텐츠공학과</option>
                <option>글로커IT학과</option>
            </select></td>
    </tr>
    
    <tr>
          <td>부전공</td>
	 <td><select class="form-control" name="minor">
                <option>소프트웨어공학과</option>
                <option>컴퓨터공학과</option>
                <option>디지털컨텐츠공학과</option>
                <option>글로커IT학과</option>
            </select></td>
            </tr>
            
            <tr>
            <td>복수전공</td>
	 <td><select class="form-control" name="doubleMajor">
                <option>소프트웨어공학과</option>
                <option>컴퓨터공학과</option>
                <option>디지털컨텐츠공학과</option>
                <option>글로커IT학과</option>
             </select></td>
            </tr>
            
            
	<tr>
           <td>휴대폰번호</td>
    <td><input type="number" class="form-control" placeholder="-포함하여 입력하시오" name="phone"></td>
    </tr>
    
    <tr>
           <td>이메일</td>
    <td><input type="text" class="form-control" placeholder="이메일" name="email"><td>
    </tr>
    
    <tr>
            <td>상태</td>
	 <td><select class="form-control" name="ustatus">
                <option>재학생</option>
                <option>휴학생</option>
               
            </select></td> 
     </tr>
     
     </table>
     
	
<hr>
	

<input type="submit" class="btn btn-primary" id="join" onclick="if(!signUp(this.form)){return false;}" value="가입하기"/>
	
	</form>
  
	</div>
	
	
	<script src="assets/js/signUp.js"></script>
	

