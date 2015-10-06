
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
			str+="</tr>";
		})
		str+="</table>";
		
		$('#userManagementContainer').html(str);
	}else{
		alert("오류가 발생했습니다.\n계속적으로 발생시 관리자께 해당 메시지를 캡쳐하여 보내주세요.\n오류 코드: " + data.resData[0].errorCd + "\n오류 메시지: " + data.resData[0].errorMsg);
	}
}

$(document).ready(function(){
	requestJsonData("studentList.ajax",{},studentList);
})
