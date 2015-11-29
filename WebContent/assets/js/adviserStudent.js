
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
				str+="<td><input type='checkbox' checked style='width:15px;height:15px;'></td>";
			else
				str+="<td><input type='checkbox' style='width:15px;height:15px;'></td>";
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

$(document).ready(function(){

	requestJsonData("studentListByDepartment.ajax",{departmentId:$('#studentContainer').attr('did')},studentList);
})