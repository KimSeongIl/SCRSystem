var questionAnswer=function(data){
	
var getaContent
	
	
	getaContent=$('[name=aContent]').val();
	
	$('#answer').append("<p>"+getaContent+"</p>")
	
}

function answerWrite(qId){

	alert(qId);
	
	var getqId,getaContent,getaId;
	
	getqId=qId;
	getaId=$('[name=aid]').val();
	getaContent=$('[name=aContent]').val();
	
	
	
	requestJsonData('questionAnswer.ajax',{
		qid:getqId,
		aid:getaId,
		aContent:getaContent},questionAnswer)
	
	
	
	
	
	
	
	
}
