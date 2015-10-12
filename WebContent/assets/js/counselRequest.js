var professorList=function(data){
	
	if(data.result=="success"){
		var professorList=data.resData[0].professorList;
		
		
		var str="";
		$.each(professorList,function(key,value){
			
			str+="<tr>";
			str+="<td>"+value.professorId+"</td>";
			str+="<td>"+value.professorName+"</td>";
			str+="<td>"+value.departmentName+"</td>";
			str+="</tr>";
		})
		
		
		$('#professorListContainer tbody').html(str);
		
		
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
		location.href="main.do";
	}
}


$(document).ready(function(){
	requestJsonData("professorList.ajax",{},professorList);
})