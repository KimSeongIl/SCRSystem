//회원가입  유효성검사
function signUp(check){

//	이름 입력여부 검사 
	if(check.uname.value=="")
	{
		alert("이름을 입력하지 않았습니다.")
		check.uname.focus()
		return false;
	}

	for (i=0;i<check.uname.value.length ;i++ )
	{
		var ch=check.uname.value.charAt(i)
		if ((ch>='0' && ch<='9') && (ch>='a' && ch<='z'))
		{
			alert ("이름는 소문자, 숫자만 입력불가능합니다.")
			check.uname.focus()
			
			return false;
		}
	}
	
	//학번 입력여부 검사 
	if(check.uid!=null){
	if(check.uid.value=="")
	{
		alert("학번을 입력하지 않았습니다.")
		check.uid.focus()
		return false;
	}

	//학번에 숫자만 입력가능하도록 검사 

	var uidCheck= /^[0-9+]{6,12}$/;


	if(!uidCheck.test(check.uid.value))
	{

		alert("학번은 숫자만 가능합니다")
		check.uid.focus();
		return false;

	}
	}
	
	

	//비밀번호 입력여부 검사
	if(check.password.vlaue="")
	{
		alert("비밀번호를 입력하지 않았습니다")
		check.password.focus();
		return false;

	}

	// 비밀번호에 숫자 특수문자 영어로 유효성 검사  비밀번호의 수는 6~12

	var pwCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{6,16}$/;



	if(!pwCheck.test(check.password.value))
	{


		alert("비밀번호는 영어,숫자,특수문자 조합으로 해주세요.(글자수는 6~12)")
		check.password.focus();
		return false;


	}

	
	// 비밀번호 일치여부 검사 
	if (check.password.value!=check.passwordConfirm.value)
	{
		alert("비밀번호가 일치하지 않습니다")
		check.password.value=""
			check.passwordConfirm.value=""
				check.password.focus()
				return false;
	}
	

	///여기까지  
	

	
	
	
	//학과
	//부전공
	//복수전공
	
	
	
	//휴대폰번호 입력여부 검사 
	if(check.phone.value=="")
	{
		alert("휴대폰 번호를 입력하지 않았습니다.")
		check.id.focus()
		return false;
	}

	//휴대폰 번호 유효성 검사 

	var phoneCheck = /^((01[1|6|7|8|9])[1-9]+[0-9]{6,7})|(010[1-9][0-9]{7})$/;

	if(!phoneCheck.test(check.phone.value))
	{
		alert("전화번호 형식에 맞지 않습니다 ");
		check.phone.focus()
		return false;
	}
	
//	이메일 입력 여부 검사
	if(check.email.value=="")
	{
		alert("이메일을 입력하지 않았습니다.")
		check.id.focus()
		return false;
	}

	//이메일 형식에 맞는지 검사 
	var emailCheck= /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;


	if(!emailCheck.test(check.email.value))
	{

		alert("이메일 형식에 맞지 않습니다 ")
		check.email.focus();
		return false;

	}
	
	//상태

	
	if(check.id=='signupForm'){
		alert("회원가입을 축하드립니다")
		return true;
		//location.href('insertMember.do')
		
	}
	
	
		
		
	}
	
	
	
	


