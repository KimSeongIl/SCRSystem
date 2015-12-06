var thisPage;

var counselListByDatePro=function(data){
	var counselList=data.resData[0].counselList;
	var str="";
	str+="<table class='table' style='margin-top:50px;'>";
	str+="<tr>";
	str+="<th>학번</th>";
	str+="<th>학생명</th>";
	str+="<th>상담구분</th>";
	str+="<th>상담종류</th>";
	str+="<th>신청일</th>";
	str+="<th>상태</th>";
	str+="<th></th>";
	str+="</tr>";
	$.each(counselList,function(key,value){
		str+="<tr>";
		str+="<td>"+value.studentId+"</td>";
		str+="<td>"+value.studentName+"</td>";
		str+="<td>"+value.counselDivision+"</td>";
		str+="<td>"+value.counselCategory+"</td>";
		
		
		
		str+="<td>"+value.counselDate+"</td>";
		if(value.status=="신청")
			str+="<td><span style='margin-top:5px;display:inline-block;' class='label label-default'>"+value.status+"</span></td>";
		else if(value.status=="반려")
			str+="<td><span style='margin-top:5px;display:inline-block;' class='label label-warning'>"+value.status+"</span></td>";
		else if(value.status=="승인")
			str+="<td><span style='margin-top:5px;display:inline-block;' class='label label-primary'>"+value.status+"</span></td>";
		else if(value.status=="완료")
			str+="<td><span style='margin-top:5px;display:inline-block;' class='label label-success'>"+value.status+"</span></td>";
		str+="<td><input type='button' value='상세보기' class='btn btn-default' onclick='location.href=\"counselDetail.do?cid="+value.counselId+"\"'></td>";
		str+="</tr>";
	})
	str+="</table>";
	var pageCount=data.resData[0].pageCount;
	str+=pagination(pageCount,thisPage,"counselListPage");
	$('.counselListPage').click(function(){
		thisPage=$(this).attr('page');
		requestJsonData("counselListByDatePro.ajax",{page:thisPage,year:$('select[name=year]').val(),term:$('select[name=term]').val()},employeeList);
	})
	
	$('#counselContainer').html(str);
}

var getYearList=function(data){
	var yearList=data.resData[0].yearList;
	var str="";
	str+="<form class='form-inline'>";
	str+="<select class='form-control' name='year'>";
	var year;
	var term;
	$.each(yearList,function(key,value){
		if(key!=yearList.length-1){
			str+="<option value="+value.year+">"+value.year+"년</option>";
		}else{
			year=value.year;
			str+="<option value="+value.year+" selected>"+value.year+"년</option>";
		}
		
	})
	str+="</select>";
	var date=new Date();
	str+="<select class='form-control' name='term'>";
	if((date.getMonth()+1)<=6){
		term=1;
		str+="<option selected value='1'>1학기</option>";
		str+="<option value='2'>2학기</option>";
	}else{
		term=2;
		str+="<option value='1'>1학기</option>";
		str+="<option selected value='2'>2학기</option>";
	}
	str+="</select>";
	str+="<select class='form-control' name='type'>";
	str+="<option>전체</option>";
	str+="<option>신청</option>";
	str+="<option>승인</option>";
	str+="<option>반려</option>";
	str+="<option>완료</option>";
	str+="</select>";
	str+="</form>";
	
	$('#dateContainer').html(str);
	requestJsonData("counselListByDatePro.ajax",{page:thisPage,year:year,term:term,type:$('select[name=type]').val()},counselListByDatePro);
	$('select[name=year]').change(function(){
		requestJsonData("counselListByDatePro.ajax",{page:thisPage,year:$(this).val(),term:$('select[name=term]').val(),type:$('select[name=type]').val()},counselListByDatePro);
	})
	$('select[name=term]').change(function(){
		requestJsonData("counselListByDatePro.ajax",{page:thisPage,year:$('select[name=year]').val(),term:$(this).val(),type:$('select[name=type]').val()},counselListByDatePro);
	})
	$('select[name=type]').change(function(){
		requestJsonData("counselListByDatePro.ajax",{page:thisPage,year:$('select[name=year]').val(),term:$('select[name=term]').val(),type:$(this).val()},counselListByDatePro);
	})
	
}

$(document).ready(function(){
	thisPage=1;
	requestJsonData("getYearList.ajax",{},getYearList);
})