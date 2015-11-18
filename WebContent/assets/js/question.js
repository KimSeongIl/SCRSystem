var questionAnswer=function(data){
	alert("answer comment success!")
}

function answerWrite(qId){

	alert(qId);
	
	var getqId,getaContent,getqName;
	
	getqId=qId;
	getaName=$('[name=answerName]').val();
	getaContent=$('[name=aContent]').val();
	
	requestJsonData('questionAnswer.ajax',{
		qid:getqId,
		aName:getaName,
		aContent:getaContent},questionAnswer)
	
	
	
	
	
	
	
	
}
