//정보수정  유효성검사

function test(){
	alert("testss");
}


$(document).ready(function(){
	
	$('#updateBtn').click(function(){
		
		
		// 비밀번호 일치여부 검사 
		if ($('input[name=password]').val()!=$('input[name=passwordConfirm1]').val())
		{
			
			$('input[name=passwordConfirm1]').get(0).setCustomValidity('비밀번호가 일치하지 않습니다.');
			
		}else{	
			$('input[name=passwordConfirm1]').get(0).setCustomValidity('');
			
		}		
			
	})
	
	$('#updateForm').submit(function(){
				
		alert("수정을 완료하였습니다.")	
			
	})
	
})

	