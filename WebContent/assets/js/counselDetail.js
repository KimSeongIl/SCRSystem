var counselSuccess=function(data){
	alert('완료되었습니다.');
	location.href="counselListPro.do";
}

var counselReturn=function(data){
	alert('반려되었습니다.');
	location.href="counselListPro.do";
	
}

var counselApproval=function(data){
	alert('승인되었습니다.');
	location.href="counselListPro.do";
}

$(document).ready(function(){
	document.getElementById('counselDate').valueAsDate = new Date();
	$('input[value=승인]').click(function(){
		if(confirm('승인하시겠습니까?')){
			var cid=$('h1').attr('cid');
			requestJsonData('counselApproval.ajax',{cid:cid},counselApproval)
		}
	})
	$('#returnForm').submit(function(){
		var returnReason=$('textarea[name=returnReason]').val().trim();
		var cid=$('h1').attr('cid');
		
		requestJsonData('counselReturn.ajax',{cid:cid,returnReason:returnReason},counselReturn);
		return false;
	})
	$('#successForm').submit(function(){
		var content=$('textarea[name=content]').val().trim();
		var cid=$('h1').attr('cid');
		var counselDate=$('#counselDate').val();
		requestJsonData('counselSuccess.ajax',{cid:cid,content:content,counselDate:counselDate},counselSuccess);
		return false;
	})
})