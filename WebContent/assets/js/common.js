function requestJsonData(requestUrl, requestParam, successFunction) {
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

function requestJsonDataNoLoading(requestUrl, requestParam, successFunction) {
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