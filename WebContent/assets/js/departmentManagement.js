var departmentAdd=function(data){
	
	
		alert('추가되었습니다');
		requestJsonData("departmentList.ajax",{},departmentList);
		
		$("#departmentModal").modal('hide');
		$("#departmentModal .form-control").val('');
		$('#departmentModal select[name=employeeId] option:first-child').attr('selected','true');
	
}

var departmentModify=function(data){
	
	
		var updated=data.resData[0].updated;
		if(updated){
			alert('수정되었습니다');
		}else{
			alert('오류가 발생했습니다');
		}
		requestJsonData("departmentList.ajax",{},departmentList);
		
		$("#departmentModifyModal").modal('hide');
		$("#departmentModifyModal .form-control").val('');
		$('#departmentModifyModal select[name=employeeId] option:first-child').attr('selected','true');
}

var departmentDelete=function(data){
	
	
		alert('삭제되었습니다');
		requestJsonData("departmentList.ajax",{},departmentList);
	
}

var departmentList=function(data){
	
		var departmentList=data.resData[0].departmentList;
		
		var str="";
		str+="<div id='addBtnDiv'>";
		str+="<input type='button' class='btn btn-primary' href='#departmentModal' data-toggle='modal' value='학과 추가'>";
	    str+="</div>";
	    str+="<table class='table'>"
		str+="<thead>";
	    str+="<tr>";
		str+="<th>학과번호</th>";
		str+="<th>학과이름</th>";
		str+="<th>사무실번호</th>";
		str+="<th>사무실전화</th>";
		str+="<th>담당직원</th>";
		str+="<th></th>"
		str+="</tr>";
		str+="</thead>";
		str+="<tbody>";
		
		$.each(departmentList,function(key,value){
			
			str+="<tr>";
			str+="<td>"+value.departmentId+"</td>";
			str+="<td>"+value.departmentName+"</td>";
			str+="<td>"+value.officeNo+"</td>";
			str+="<td>"+value.officeTel+"</td>";
			str+="<td>"+value.employeeName+" ("+value.employeeId+")</td>";
			str+="<td><input type='button' eid="+value.employeeId+" class='btn btn-primary departmentModify' href='#departmentModifyModal' data-toggle='modal' value='수정'> ";
			str+="<input type='button' did="+value.departmentId+" class='btn btn-default departmentDelete' value='삭제'></td>";
			str+="</tr>";
		})
		str+="</tbody>";
		str+="</table>";
		

		$('#departmentManagementContainer').html(str);
		
		$('.departmentModify').click(function(){
			
			$('#departmentModifyForm input[name=departmentId]').val($(this).parent().parent().find('td:nth-child(1)').text());
			$('#departmentModifyForm input[name=departmentName]').val($(this).parent().parent().find('td:nth-child(2)').text());
			$('#departmentModifyForm input[name=officeNo]').val($(this).parent().parent().find('td:nth-child(3)').text());
			$('#departmentModifyForm input[name=officeTel]').val($(this).parent().parent().find('td:nth-child(4)').text());
			$('#departmentModifyForm select[name=employeeId]').find('option[value='+$(this).attr('eid')+']').attr('selected','true');
			$('#departmentModifyButton').attr('did',$(this).parent().parent().find('td:nth-child(1)').text());
		})
		$('.departmentDelete').click(function(){
			if(confirm('삭제하시겠습니까')){
				var id=$(this).attr('did');
				requestJsonData("departmentDelete.ajax",{did:id},departmentDelete);
			}
		})
	
}


$(document).ready(function(){
	
	requestJsonData("departmentList.ajax",{},departmentList);
	
	$('#departmentAddForm').submit(function(){
		var departmentId=$('#departmentAddForm input[name=departmentId]').val();
		var departmentName=$('#departmentAddForm input[name=departmentName]').val();
		var officeNo=$('#departmentAddForm input[name=officeNo]').val();
		var officeTel=$('#departmentAddForm input[name=officeTel]').val();
		var employeeId=$('#departmentAddForm select[name=employeeId]').val();
		
		requestJsonData("departmentAdd.ajax",{
			departmentId:departmentId,
			departmentName:departmentName,
			officeNo:officeNo,
			officeTel:officeTel,
			employeeId:employeeId
			
		},departmentAdd);
		
		return false;
	})
	
	$('#departmentModifyForm').submit(function(){
		var originId=$('#departmentModifyButton').attr('did');
		var departmentId=$('#departmentModifyForm input[name=departmentId]').val();
		var departmentName=$('#departmentModifyForm input[name=departmentName]').val();
		var officeNo=$('#departmentModifyForm input[name=officeNo]').val();
		var officeTel=$('#departmentModifyForm input[name=officeTel]').val();
		var employeeId=$('#departmentModifyForm select[name=employeeId]').val();
		
		requestJsonData("departmentModify.ajax",{
			originId:originId,
			departmentId:departmentId,
			departmentName:departmentName,
			officeNo:officeNo,
			officeTel:officeTel,
			employeeId:employeeId
			
		},departmentModify);
		
		return false;
	})
})