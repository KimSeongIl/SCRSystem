var professorListByDepartment=function(data){
	
	var professorList=data.resData[0].professor;
	
	
	
	var str="";
	str+="<table class='table table-bordered'>";
	str+="<tr>";
	str+="<th></th>";
	str+="<th>교수번호</th>";
	str+="<th>교수명</th>";
	str+="<th>핸드폰</th>";
	str+="<th>이메일</th>";
	str+="<th></th>";
	str+="</tr>";
	
	$.each(professorList,function(key,value){
		
		str+="<tr>";
		str+="<td><img width='140px' height='140px' class='img-rounded' onerror='this.src=\"assets/img/alt.png\"' src='assets/img/profile/"+value.img+"'>";
		str+="<td>"+value.professorId+"</td>";
		str+="<td>"+value.professorName+"</td>";
		str+="<td>"+value.phone+"</td>";
		str+="<td>"+value.email+"</td>";
		str+="<td><input type='button' class='btn btn-primary' onclick=\"location.href='adviserStudent.do?pid="+value.professorId+"&did="+$('#departmentMenu').find('.active').attr('did')+"'\" value='담당학생관리'></td>";
		str+="</tr>";
	})
	str+="</table>";
	$('#professorContainer').html(str);
}

var departmentListByEmployee=function(data){
	var departmentList=data.resData[0].department;
	
	var str="<ul class='nav nav-tabs' id='departmentMenu'>";
	var departmentId;
	$.each(departmentList,function(key,value){
		if(key==0){
			var active='active';
			departmentId=value.departmentId;
		}else{
			var active="";
		}
		str+="<li role='presentation' class='"+active+"' did="+value.departmentId+" ><a href='#'>"+value.departmentName+"</a></li>";
	})
	str+="</ul>";
	$('#navContainer').html(str);
	
	requestJsonData("professorListByDepartment.ajax",{departmentId:departmentId},professorListByDepartment);
	
	$('#departmentMenu li').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			
			requestJsonData("professorListByDepartment.ajax",{departmentId:$(this).attr("did")},professorListByDepartment);
		}
			
	})
}

$(document).ready(function(){
	
	requestJsonData("departmentListByEmployee.ajax",{uid:$('h1').attr("uid")},departmentListByEmployee);
})


