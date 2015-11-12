var thisPage;
var professorList=function(data){
	
	
		var list=data.resData[0].professorList;
		
		
		var str="";
		str+="<table class='table table-bordered'>";
		str+="<tr>";
		str+="<th></th>";
		str+="<th>교수번호</th>";
		str+="<th>교수명</th>";
		str+="<th>학과</th>";
		str+="<th></th>";
		str+="</tr>";
		
			
		$.each(list,function(key,value){
			
			var subDept=value.departmentList;
			str+="<tr>";
			str+="<td rowspan='"+(subDept.length+1)+"'>";
			str+="<img width='140px' height='140pxs' class='img-rounded' src='assets/img/profile/"+value.img+"' onerror='this.src=\"assets/img/alt.png\"'>";
			str+="</td>";
			str+="<td rowspan='"+(subDept.length+1)+"'>"+value.professorId+"</td>";
			str+="<td rowspan='"+(subDept.length+1)+"'>"+value.professorName+"</td>";
			str+="<td>"+value.departmentName+"</td>";
			str+="<td rowspan='"+(subDept.length+1)+"'><input onclick='location.href=\"professorProfile.do?pid="+value.professorId+"\" ' type='button' class='btn btn-primary' value='상담신청'></td>";
			
			
			
			str+="</tr>";
			
			if(subDept!=""){
				$.each(subDept,function(key1,value1){
					str+="<tr>";
					str+="<td>"+value1.departmentName+"</td>";
					str+="</tr>";
				})
			}
			
/*
			
			if(value.departmentList!=""){
			
			
				var subDept=value.departmentList;
				str+="<th rowspan='"+(subDept.length+1)+"'>학과</th>";
				
			str+="<td>"+value.departmentName+"</td>";
			str+="</tr>";
				$.each(subDept,function(key1,value1){
					str+="<tr>";
					str+="<td>"+value1.departmentName+"</td>";
					str+="</tr>";
				})
			*/
		})
		str+="</table>";
		
		var pageCount=data.resData[0].pageCount;
		
		str+="<div style='clear:both;'></div>";
		str+=pagination(pageCount,thisPage,"professorPage");
		$('#professorListContainer').html(str);
		
		$('.professorPage').click(function(){
			thisPage=$(this).attr('page');
			var category=data.resData[0].category;
			if(category==undefined){
				requestJsonData("professorList.ajax",{page:thisPage,limit:9},professorList);
			}
			else{
				var content=data.resData[0].content;
				requestJsonDataGet("professorList.ajax",{page:thisPage,category:category,content:content,limit:9},professorList);
			}
			
		})
		
	
}


$(document).ready(function(){
	thisPage=1;
	
	requestJsonData("professorList.ajax",{page:thisPage,limit:9},professorList);
	
	$('#professorSearch').submit(function(){
		
		var category=$('#searchCategory').val();
		var content=$('#searchContent').val().trim();
		thisPage=1;
		requestJsonDataGet("professorList.ajax",{page:thisPage,category:category,content:content,limit:9},professorList);
		return false;
	})
	
	$('#searchBtn').click(function(){
		if($('#searchContent').val().trim()==""){
			thisPage=1;
			requestJsonData("professorList.ajax",{page:thisPage,limit:9},professorList);
			return false;
		}
	})
	
})