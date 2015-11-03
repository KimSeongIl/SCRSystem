var thisPage;
var professorList=function(data){
	
	
		var list=data.resData[0].professorList;
		
		
		var str="";
		
		$.each(list,function(key,value){
			
			
			str+="<div class='col-xs-4 professorListDiv'>";
			str+="<img width='140px' height='140pxs' class='img-rounded' src='assets/img/profile/"+value.img+"' onerror='this.src=\"assets/img/alt.png\"'><br>";
			str+="<table>";
			str+="<tr>";
			str+="<th>교수번호</th>";
			str+="<td>"+value.professorId+"</td>";
			str+="</tr>";
			str+="<tr>";
			str+="<th>이름</th>";
			str+="<td>"+value.professorName+"</td>";
			str+="</tr>";
			
			str+="<tr>";
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
			}else{
				
				str+="<th>학과</th>";
				str+="<td>"+value.departmentName+"</td>";
			}
			str+="</tr>";
			str+="<tr>";
			str+="<td colspan='2'><input type='button' class='btn btn-primary' value='상담신청'></td>";
			str+="</tr>";
			str+="</table>";
			str+="</div>";
		})
		
		
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