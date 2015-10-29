var pagination=function(pageCount,thisPage,eventName){
	var str="";
	str+="<div class='paginationContainer'>";
	str+="<ul class='pagination'>";
	
	
	if(pageCount>=1){
		
		var currentPage=Math.floor((thisPage-1)/5);
		
		if(currentPage!=0){
			str+="<li class="+eventName+" page="+((currentPage-1)*5+1)+"><a aria-label='Previous' ><span aria-hidden='true'>&laquo;</span></a></li>";
		}
		
		
		var disabled=thisPage==1? 'disabled' : eventName;
		
		str+="<li class="+disabled+" page="+(Number(thisPage)-1)+"><a aria-label='Previous' ><span aria-hidden='true'>이전</span></a></li>";
		for(var i=(currentPage*5+1);i<=(currentPage*5+5);i++){
			
			if(i<=pageCount)
				str+="<li class='"+(thisPage==i? 'active' : eventName)+" ' page="+i+"><a>"+i+"</a></li>";
		}
		disabled=thisPage==pageCount? 'disabled' : eventName;
		str+="<li class="+disabled+" page="+(Number(thisPage)+1)+"> <a aria-label='Next'><span aria-hidden='true'>다음</span></a></li>";
		if(Math.floor(pageCount/5)!=currentPage){
			str+="<li class="+eventName+" page="+((currentPage+1)*5+1)+"><a aria-label='Previous' ><span aria-hidden='true'>&raquo;</span></a></li>";
		}
	}
		
	str+="</ul>";
	str+="</div>";
	return str;
}

var requestJsonData=function (requestUrl, requestParam, successFunction) {
	$.ajax({
		url : requestUrl,
		type : "POST",
		async: true,
		data : requestParam,
		dataType : "json",
		timeout: 10000,
		beforeSend:function(){
	        $('.wrap-loading').removeClass('display-none');
	    },
	    complete:function(){
	        $('.wrap-loading').addClass('display-none');
	    },
		success : successFunction,
		error : function(request,status,error){
			alert("오류가 발생했습니다.\n재시도 또는 다시 접속해주세요.\n\n[오류정보]\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
	        $('.wrap-loading').addClass('display-none');
		},
		fail : function() {
			alert("인터넷 연결 상태를 확인해주세요.");
	        $('.wrap-loading').addClass('display-none');
		}
	});
	
}

var requestJsonDataNoLoading=function (requestUrl, requestParam, successFunction) {
	$.ajax({
		url : serverUrl + requestUrl,
		type : "POST",
		async: true,
		data : requestParam,
		dataType : "json",
		timeout: 10000,
		success : successFunction,
		error : function(request,status,error){
			alert("오류가 발생했습니다.\n재시도 또는 다시 접속해주세요.\n\n[오류정보]\ncode:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
		},
		fail : function() {
			alert("인터넷 연결 상태를 확인해주세요.");
		}
	});
	
}