//회원가입  유효성검사



$(document).ready(function(){
	$('#join').click(function(){
		
		
		
		// 비밀번호 일치여부 검사 
		if ($('input[name=password]').val()!=$('input[name=passwordConfirm]').val())
		{
			
			$('input[name=passwordConfirm]').get(0).setCustomValidity('비밀번호가 일치하지 않습니다');
		
		}else{
			$('input[name=passwordConfirm]').get(0).setCustomValidity('');
		}

		
	
			
	})
	
	$('#signupForm').submit(function(){
		

	
	
		alert("회원가입을 축하드립니다")
	
			
	})
})

	
	
	