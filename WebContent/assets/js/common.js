$(document).ready(function(){
	$('#navBtn').click(function(){
		if($('#hideMenu').css('display')=='block'){
			
			$('#hideMenu').slideUp();
			
		}
		else{
			
			$('#hideMenu').slideDown();
			
		}
	})
})