function boardSearch(){
	var value=$('#searchValue').val().trim();
	var category=$('#searchCategory').val();
	alert(category);
	var select;
	
	
	
	if($('#searchSelect').val()=='작성자'){
		select=1;
	}else if($('#searchSelect').val()=='제목'){
		select=2;
		
	}else if($('#searchSelect').val()=='내용'){
		select=3;
		
	}
	
	
	if(value==''){
		alert("한글자이상부터 검색 가능합니다");
	}else{
		location.href="boardSearch.do?category="+category+"&select="+select+"&value="+value;
	}
	
	
}

function fileDownLoad(){
	
	$('#downloadForm').submit();
	
	
	
}
