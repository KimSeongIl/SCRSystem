var readImg=function(input){
	
	if( $('input[name=professorImg]').val() != "" ){
		var ext = $('input[name=professorImg]').val().split('.').pop().toLowerCase();
		      if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
		    	  alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
		    	  $('input[name=professorImg]').val('');
		      }else{
		    	  if(input.files && input.files[0]){
		    			var reader=new FileReader();
		    			reader.onload=function(e){
		    				$('#professorImg').attr('src',e.target.result);
		    			}
		    			
		    			reader.readAsDataURL(input.files[0]);
		    		}
		    	  
		      }
		}
	
}