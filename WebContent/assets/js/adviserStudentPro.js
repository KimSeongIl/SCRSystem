var updateAdviser=function(data){
	alert('저장되었습니다.');
	requestJsonData("studentListByDepartment.ajax",{departmentId:$('#departmentContainer select').val()},studentList);
}

var studentList=function(data){
	
		
		var list=data.resData[0].student;
		
		
		var str="<table class='table'>";
		str+="<thead>";
		str+="<tr>";
		str+="<th></th>";
		str+="<th>학번</th>";
		str+="<th>이름</th>";
		str+="<th>전화번호</th>";
		str+="<th>이메일</th>";
		str+="<th>상태</th>";
		str+="<th>담당교수</th>";
		str+="<th></th>";
		str+="</tr>";
		str+="</thead>";
		str+="<tbody>";
		$.each(list,function(key,value){
			
			str+="<tr>";
			if($('#studentContainer').attr('pid')==value.professorId)
				str+="<td><input type='checkbox' name='adviserCheck' checked value="+value.studentId+" style='width:15px;height:15px;'></td>";
			else
				str+="<td><input type='checkbox' name='adviserCheck' value="+value.studentId+" style='width:15px;height:15px;'></td>";
			str+="<td>"+value.studentId+"</td>";
			str+="<td>"+value.name+"</td>";
			str+="<td>"+value.phone+"</td>";
			str+="<td>"+value.email+"</td>";
			str+="<td>"+value.status+"</td>";
			str+="<td>"+value.professorName+"</td>";
			str+="</tr>";
		})
		str+="</tbody>";
		str+="</table>";
		
		
		
		
		
		$('#studentContainer').html(str);
		
		$('.studentPage').click(function(){
			thisPage=$(this).attr('page');
			searched=false;
			requestJsonData("studentListByDepartment.ajax",{departmentId:$('#studentContainer').attr('did')},studentList);
		})
		
		
		
	
}

var departmentListByProfessor=function(data){
	
	var list=data.resData[0].department;
	var str="";
	str+="<form class='form-inline'>";
	str+="<select class='form-control'>";
	$.each(list,function(key,value){
		str+="<option value="+value.departmentId+">"+value.departmentName+"</option>";
	})
	str+="</select>";
	str+="</form>";
	$('#departmentContainer').html(str);
	requestJsonData("studentListByDepartment.ajax",{departmentId:$('#departmentContainer select').val()},studentList);
	$('#departmentContainer select').change(function(){
		requestJsonData("studentListByDepartment.ajax",{departmentId:$(this).val()},studentList);
	})
}

$(document).ready(function(){
	requestJsonData("departmentListByProfessor.ajax",{},departmentListByProfessor);
	
	
	$('#updateAdviserBtn').click(function(){
		
		if(confirm('정말 저장하시겠습니까?')){
			var str="";
			$('input[name="adviserCheck"]:checked').each(function(key,value){
				if(key==$('input[name="adviserCheck"]:checked').length-1)
					str+=value.value;
				else
					str+=value.value+",";
			});
			var professorId=$('#studentContainer').attr('pid');
			requestJsonData("updateAdviser.ajax",{professorId:professorId,studentList:str},updateAdviser);
		}
	})
})