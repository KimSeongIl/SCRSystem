var thisPage;

var professorAdd=function(data){
	
	if(data.result=="success"){
		alert('추가되었습니다');
		requestJsonData("professorList.ajax",{page:thisPage},professorList);
		
		$("#professorModal").modal('hide');
		$("#professorModal .form-control").val('');
		
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}
var employeeAdd=function(data){
	if(data.result=="success"){
		alert('추가되었습니다');
		requestJsonData("employeeList.ajax",{page:thisPage},employeeList);
		
		$("#employeeModal").modal('hide');
		$("#employeeModal .form-control").val('');
		
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}

var studentDelete=function(data){
	
	if(data.result=="success"){
		alert('삭제되었습니다');
		requestJsonData("studentList.ajax",{page:thisPage},studentList);
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}

var professorDelete=function(data){
	
	if(data.result=="success"){
		alert('삭제되었습니다');
		requestJsonData("professorList.ajax",{page:thisPage},professorList);
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}

var employeeDelete=function(data){
	
	if(data.result=="success"){
		var deleted=data.resData[0].deleted;
		if(deleted){
			alert('삭제되었습니다');
		}else{
			alert('소속 학과가 있어서 지울수 없습니다');
		}
		requestJsonData("employeeList.ajax",{page:thisPage},employeeList);
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}
var studentList=function(data){
	
	if(data.result=="success"){
		var studentList=data.resData[0].studentList;
		
		
		var str="<table class='table'>";
		str+="<thead>";
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
		str+="</thead>";
		str+="<tbody>";
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
			str+="<td><input type='button' uid="+value.studentId+" class='btn btn-default studentDelete' value='삭제'></td>";
			str+="</tr>";
		})
		str+="</tbody>";
		str+="</table>";
		
		var pageCount=data.resData[0].pageCount;
		str+=pagination(pageCount,thisPage,"studentPage");
		$('#userManagementContainer').html(str);
		
		$('.studentPage').click(function(){
			thisPage=$(this).attr('page');
			
			requestJsonData("studentList.ajax",{page:thisPage},studentList);
		})
		$('.studentDelete').click(function(){
			if(confirm('삭제하시겠습니까')){
				var id=$(this).attr('uid');
				requestJsonData("userDelete.ajax",{uid:id},studentDelete);
			}
		})
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}



var professorList=function(data){
	
	if(data.result=="success"){
		
		var list=data.resData[0].professorList;
		
		var str="<div id='addBtnDiv'>";
		str+="<input type='button' class='btn btn-primary' href='#professorModal' data-toggle='modal' value='교수 추가'>";
		str+="</div>";
		str+="<table class='table'>";
		str+="<thead>";
		str+="<tr>";
		str+="<th>교수번호</th>";
		str+="<th>이름</th>";
		str+="<th>사무실번호</th>";
		str+="<th>사무실전화</th>";
		str+="<th>핸드폰</th>";
		str+="<th>이메일</th>";
		str+="<th>학과</th>";
		str+="<th></th>";
		str+="</tr>";
		str+="</thead>";
		str+="<tbody>";
		$.each(list,function(key,value){
			
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
			str+="<td>"+value.email+"</td>";
			str+="<td>"+value.departmentName+"</td>";
			str+="<td><input type='button' uid="+value.professorId+" class='btn btn-default professorDelete' value='삭제'></td>";
			str+="</tr>";
		})
		str+="</tbody>";
		str+="</table>";
		
		var pageCount=data.resData[0].pageCount;
		str+=pagination(pageCount,thisPage,"professorPage");
		$('#userManagementContainer').html(str);
		
		$('.professorPage').click(function(){
			thisPage=$(this).attr('page');
			
			requestJsonData("professorList.ajax",{page:thisPage},professorList);
		})
		
		$('.professorDelete').click(function(){
			if(confirm('삭제하시겠습니까')){
				var id=$(this).attr('uid');
				requestJsonData("userDelete.ajax",{uid:id},professorDelete);
			}
		})
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}
var employeeList=function(data){
	if(data.result=="success"){
		var employeeList=data.resData[0].employeeList;
		
		var str="<div id='addBtnDiv'>";
		str+="<input type='button' class='btn btn-primary' href='#employeeModal' data-toggle='modal' value='직원 추가'>";
		str+="</div>";
		str+="<table class='table'>";
		str+="<thead>"
		str+="<tr>";
		str+="<th>직원번호</th>";
		str+="<th>이름</th>";
		str+="<th>핸드폰</th>";
		str+="<th>이메일</th>";
		str+="<th></th>";
		str+="</tr>";
		str+="</thead>";
		str+="<tbody>";
		$.each(employeeList,function(key,value){
			
			str+="<tr>";
			str+="<td>"+value.employeeId+"</td>";
			str+="<td>"+value.employeeName+"</td>";
			str+="<td>"+value.phone+"</td>";
			str+="<td>"+value.email+"</td>";
			str+="<td><input type='button' uid="+value.employeeId+" class='btn btn-default employeeDelete' value='삭제'></td>";
			str+="</tr>";
		})
		str+="</tbody>";
		str+="</table>";
		
		var pageCount=data.resData[0].pageCount;
		str+=pagination(pageCount,thisPage,"employeePage");
		$('#userManagementContainer').html(str);
		
		$('.employeePage').click(function(){
			thisPage=$(this).attr('page');
			
			requestJsonData("employeeList.ajax",{page:thisPage},employeeList);
		})
		$('.employeeDelete').click(function(){
			if(confirm('삭제하시겠습니까')){
				var id=$(this).attr('uid');
				requestJsonData("userDelete.ajax",{uid:id},employeeDelete);
			}
		})
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}

$(document).ready(function(){
	thisPage=1;
	requestJsonData("studentList.ajax",{page:thisPage},studentList);
	$('#studentList').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			thisPage=1;
			requestJsonData("studentList.ajax",{page:thisPage},studentList);
			
		}
		
	})
	
	$('#professorList').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			thisPage=1;
			
			requestJsonData("professorList.ajax",{page:thisPage},professorList);
			
		}
	})
	
	$('#employeeList').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			thisPage=1;
			requestJsonData("employeeList.ajax",{page:thisPage},employeeList);
			
		}
	})
	$('.department_grp').change(function(){
		var exist=false;
		var department_id=$(this).val();
		if(department_id!=0){
			$('#departmentList li').each(function(){
				if($(this).attr('id')==department_id){
					exist=true;
				}
					
			})
			if(exist){
				alert('이미 추가했습니다.');
				return;
			}
			if($('#professorAddForm select[name=departmentId').val()==department_id){
				alert('학과와 중복됩니다');
				$('#professorAddForm select[name=departmentGroup] option:first-child').attr('selected','true');
				return;
			}
			
			$('#departmentList').html(function(index,html){
				return html+"<li id="+department_id+">"+$('.department_grp option:selected').text()+"<span class='departmentListDelete'>X</span></li>";
			})
		}
		
		
	})
	$(document).on('click','.departmentListDelete',function(){
		
		$(this).parent().remove();
	})
	
	
	
	
	
	$('#professorAddForm').submit(function(){
		var professorId=$('#professorAddForm input[name=professorId]').val();
		var professorName=$('#professorAddForm input[name=professorName]').val();
		var officeNo=$('#professorAddForm input[name=officeNo]').val();
		var officeTel=$('#professorAddForm input[name=officeTel]').val();
		var phone=$('#professorAddForm input[name=phone]').val();
		var email=$('#professorAddForm input[name=email]').val();
		var departmentId=$('#professorAddForm select[name=departmentId]').val();
		var departmentList="";
		$('#departmentList li').each(function(){
			departmentList+=$(this).attr('id')+",";
		})
		
		
		requestJsonData("professorAdd.ajax",{
			professorId:professorId,
			professorName:professorName,
			officeNo:officeNo,
			officeTel:officeTel,
			phone:phone,
			email:email,
			departmentId:departmentId,
			departmentList:departmentList
		},professorAdd);
		
		return false;
		
	})
	
	$('#employeeAddForm').submit(function(){
		var employeeId=$('#employeeAddForm input[name=employeeId]').val();
		var employeeName=$('#employeeAddForm input[name=employeeName]').val();
		var phone=$('#employeeAddForm input[name=phone]').val();
		var email=$('#employeeAddForm input[name=email]').val();
		
		requestJsonData("employeeAdd.ajax",{
			employeeId:employeeId,
			employeeName:employeeName,
			phone:phone,
			email:email
		},employeeAdd);
		
		return false;
	})
})
