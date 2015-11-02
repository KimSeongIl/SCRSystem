var thisPage;
var professorList=function(data){
	
	
		var list=data.resData[0].professorList;
		
		
		var str="";
		str+="<table class='table table-hover'>";
		str+="<thead>";
		str+="<tr>";
		str+="<th>교수번호</th>";
		str+="<th>이름</th>";
		str+="<th>학과</th>";
		str+="</tr>";
		str+="</thead>";
		str+="<tbody>";
		$.each(list,function(key,value){
			
			str+="<tr onclick='location.href=\"professorProfile.do?id="+value.professorId+"\"'>";
			str+="<td>"+value.professorId+"</td>";
			str+="<td>"+value.professorName+"</td>";
			str+="<td>"+value.departmentName+"</td>";
			str+="</tr>";
		})
		str+="</tbody>";
		str+="</table>";
		
		var pageCount=data.resData[0].pageCount;
		
		
		str+=pagination(pageCount,thisPage,"professorPage");
		$('#professorListContainer').html(str);
		
		$('.professorPage').click(function(){
			thisPage=$(this).attr('page');
			var category=data.resData[0].category;
			if(category==undefined){
				requestJsonData("professorList.ajax",{page:thisPage},professorList);
			}
			else{
				var content=data.resData[0].content;
				requestJsonDataGet("professorList.ajax",{page:thisPage,category:category,content:content},professorList);
			}
			
		})
		
	
}


$(document).ready(function(){
	thisPage=1;
	
	requestJsonData("professorList.ajax",{page:thisPage},professorList);
	
	$('#professorSearch').submit(function(){
		
		var category=$('#searchCategory').val();
		var content=$('#searchContent').val().trim();
		thisPage=1;
		requestJsonDataGet("professorList.ajax",{page:thisPage,category:category,content:content},professorList);
		return false;
	})
	
	$('#searchBtn').click(function(){
		if($('#searchContent').val().trim()==""){
			thisPage=1;
			requestJsonData("professorList.ajax",{page:thisPage},professorList);
			return false;
		}
	})
	
})