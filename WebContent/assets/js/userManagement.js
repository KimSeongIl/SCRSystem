var professorAdd=function(data){
	
	if(data.result=="success"){
		alert('추가되었습니다');
		requestJsonData("professorList.ajax",{},professorList);
		
		$("#professorModal").modal('hide');
		$("#professorModal .form-control").val('');
		
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}

var studentDelete=function(data){
	
	if(data.result=="success"){
		alert('삭제되었습니다');
		requestJsonData("studentList.ajax",{},studentList);
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}

var professorDelete=function(data){
	
	if(data.result=="success"){
		alert('삭제되었습니다');
		requestJsonData("professorList.ajax",{},professorList);
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}
var studentList=function(data){
	
	if(data.result=="success"){
		var studentList=data.resData[0].studentList;
		
		
		var str="<table class='table'>";
		str+="<tr>";
		str+="<th>학번</th>";
		str+="<th>이름</th>";
		str+="<th>전화번호</th>";
		str+="<th>이메일</th>";
		str+="<th>전공</th>";
		str+="<th>부전공</th>";
		str+="<th>복수전공</th>";
		str+="<th>상태</th>";
		str+="<th></th>";
		str+="</tr>";
		$.each(studentList,function(key,value){
			
			str+="<tr>";
			str+="<td>"+value.studentId+"</td>";
			str+="<td>"+value.name+"</td>";
			str+="<td>"+value.phone+"</td>";
			str+="<td>"+value.email+"</td>";
			str+="<td>"+value.departmentName+"</td>";
			str+="<td>"+value.minorName+"</td>";
			str+="<td>"+value.doubleMajorName+"</td>";
			str+="<td>"+value.status+"</td>";
			str+="<td><input type='button' id="+value.studentId+" class='btn btn-default studentDelete' value='삭제'>";
			str+="</tr>";
		})
		str+="</table>";
		
		$('#userManagementContainer').html(str);
		
		$('.studentDelete').click(function(){
			if(confirm('삭제하시겠습니까')){
				var id=$(this).attr('id');
				requestJsonData("studentDelete.ajax",{uid:id},studentDelete);
			}
		})
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}



var professorList=function(data){
	
	if(data.result=="success"){
		var professorList=data.resData[0].professorList;
		
		var str="<div id='addBtnDiv'>";
		str+="<input type='button' class='btn btn-primary' href='#professorModal' data-toggle='modal' value='교수 추가'>";
		str+="</div>";
		str+="<table class='table'>";
		str+="<tr>";
		str+="<th>교수번호</th>";
		str+="<th>이름</th>";
		str+="<th>사무실번호</th>";
		str+="<th>사무실전화</th>";
		str+="<th>핸드폰</th>";
		str+="<th>학과</th>";
		str+="<th></th>";
		str+="</tr>";
		$.each(professorList,function(key,value){
			
			str+="<tr>";
			str+="<td>"+value.professorId+"</td>";
			str+="<td>"+value.professorName+"</td>";
			if(value.officeNo==0)
				str+="<td>없음</td>";
			else
				str+="<td>"+value.officeNo+"</td>";
			if(value.officeTel==undefined)
				str+="<td>없음</td>";
			else
				str+="<td>"+value.officeTel+"</td>";
			str+="<td>"+value.phone+"</td>";
			str+="<td>"+value.departmentName+"</td>";
			str+="<td><input type='button' id="+value.professorId+" class='btn btn-default professorDelete' value='삭제'>";
			str+="</tr>";
		})
		str+="</table>";
		
		$('#userManagementContainer').html(str);
		
		$('.professorDelete').click(function(){
			if(confirm('삭제하시겠습니까')){
				var id=$(this).attr('id');
				requestJsonData("professorDelete.ajax",{uid:id},professorDelete);
			}
		})
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}

$(document).ready(function(){
	
	requestJsonData("studentList.ajax",{},studentList);
	$('#studentList').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			requestJsonData("studentList.ajax",{},studentList);
		}
		
	})
	
	$('#professorList').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			requestJsonData("professorList.ajax",{},professorList);
			
		}
	})
	
	$('#employeeList').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			
		}
	})
	
	$('#professorAddForm').submit(function(){
		var professorId=$('#professorAddForm input[name=professorId]').val();
		var professorName=$('#professorAddForm input[name=professorName').val();
		var officeNo=$('#professorAddForm input[name=officeNo').val();
		var officeTel=$('#professorAddForm input[name=officeTel').val();
		var phone=$('#professorAddForm input[name=phone]').val();
		var departmentId=$('#professorAddForm select').val();
		
		requestJsonData("professorAdd.ajax",{
			professorId:professorId,
			professorName:professorName,
			officeNo:officeNo,
			officeTel:officeTel,
			phone:phone,
			departmentId:departmentId
		},professorAdd);
		
		return false;
		
	})
})
