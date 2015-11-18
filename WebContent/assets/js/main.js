var professorSearchByDepartment=function(data){
	var list=data.resData[0].professor;
	var str="<label class='col-sm-3 control-label'>교수</label>";
	str+="<div class='col-sm-8'>";
	str+="<select class='form-control' name='professor'>";
	str+="<option value='0'>교수를 선택하세요.</option>";
	
	$.each(list,function(key,value){
		str+="<option value='"+value.professorId+"'>"+value.professorName+"</option>";
	})
	
	str+="</select>";
	str+="</div>";
	$('#professorDiv').html(str);
}

var addOnlineCounsel=function(data){
	alert('신청되었습니다.');
	$("#onlineModal").modal('hide');
}

$(document).ready(function(){
	$('.onlineBtn').click(function(){
		if($(this).attr('auth').trim()==""){
			alert('로그인 후 이용하세요.');
			location.href="login.do";
		}else{
			$('#professorDiv').html('');
			
			$("#onlineModal .form-control").val('');
			$('select[name=department]').val('0');
		}
		
	})
	
	$('select[name=department]').change(function(){
		var departmentId=$(this).val();
		if(departmentId==0){
			$('#professorDiv').html('');
		}else{
			requestJsonData('professorSearchByDepartment.ajax',{departmentId:departmentId},professorSearchByDepartment);
		}
	})
	
	$('#onlineCounselForm').submit(function(){
		var professorId=$('select[name=professor]').val();
		var title=$('input[name=title]').val().trim();
		
		
		if(professorId==undefined || professorId==0){
			alert('교수를 선택해주세요.');
		}else if(title.length>20){
			alert('제목은 20자 이하로 입력하세요.');
		}else{
			var content=$('textarea[name=content]').val().trim();
			
			requestJsonData('addOnlineCounsel.ajax',{
				professorId:professorId,
				title:title,
				content:content
			},addOnlineCounsel)
		}
		return false;
	})
})