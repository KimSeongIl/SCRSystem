var thisPage;
var search="student";
var searched=false;

var readImg=function(input){
	
	if( $('input[name=professorImg]').val() != "" ){
		var ext = $('input[name=professorImg]').val().split('.').pop().toLowerCase();
		      if($.inArray(ext, ['gif','png','jpg','jpeg']) == -1) {
		    	  alert('gif,png,jpg,jpeg 파일만 업로드 할수 있습니다.');
		    	  $('input[name=professorImg]').val('');
		      }else{
		    	  if(input.files && input.files[0]){
		    			var reader=new FileReader();
		    			reader.onload=function(e){
		    				$('#professorImg').attr('src',e.target.result);
		    			}
		    			
		    			reader.readAsDataURL(input.files[0]);
		    		}
		    	  
		      }
		}
	
}
var professorAdd=function(data){
	
	
		alert('추가되었습니다');
		searched=false;
		requestJsonData("professorList.ajax",{page:thisPage},professorList);
		
		$("#professorModal").modal('hide');
		$('#professorImg').attr('src','assets/img/sample.png');
		$("#professorModal .form-control").val('');
		$('#professorModal select[name=departmentId]').val('0');
		$('#professorModal select[name=departmentGroup]').val('0');
		
	
}
var employeeAdd=function(data){
	
		alert('추가되었습니다');
		searched=false;
		requestJsonData("employeeList.ajax",{page:thisPage},employeeList);
		
		$("#employeeModal").modal('hide');
		$("#employeeModal .form-control").val('');
		
	
}

var studentDelete=function(data){
	
	
		alert('삭제되었습니다');
		searched=false;
		requestJsonData("studentList.ajax",{page:thisPage},studentList);
	
}

var professorDelete=function(data){
	
	
		alert('삭제되었습니다');
		searched=false;
		requestJsonData("professorList.ajax",{page:thisPage},professorList);
	
}

var employeeDelete=function(data){
	
	
		var deleted=data.resData[0].deleted;
		if(deleted){
			alert('삭제되었습니다');
		}else{
			alert('소속 학과가 있어서 지울수 없습니다');
		}
		searched=false;
		requestJsonData("employeeList.ajax",{page:thisPage},employeeList);
	
}
var studentList=function(data){
	
		
		var list=data.resData[0].studentList;
		
		
		var str="<table class='table'>";
		str+="<thead>";
		str+="<tr>";
		str+="<th>학번</th>";
		str+="<th>이름</th>";
		str+="<th>전화번호</th>";
		str+="<th>이메일</th>";
		str+="<th>전공</th>";
		str+="<th>부전공</th>";
		str+="<th>복수전공</th>";
		str+="<th>상태</th>";
		str+="<th></th>";
		str+="</tr>";
		str+="</thead>";
		str+="<tbody>";
		$.each(list,function(key,value){
			
			str+="<tr>";
			str+="<td>"+value.studentId+"</td>";
			str+="<td>"+value.name+"</td>";
			str+="<td>"+value.phone+"</td>";
			str+="<td>"+value.email+"</td>";
			str+="<td>"+value.departmentName+"</td>";
			str+="<td>"+value.minorName+"</td>";
			str+="<td>"+value.doubleMajorName+"</td>";
			str+="<td>"+value.status+"</td>";
			str+="<td><input type='button' uid="+value.studentId+" class='btn btn-default studentDelete' value='삭제'></td>";
			str+="</tr>";
		})
		str+="</tbody>";
		str+="</table>";
		
		var pageCount=data.resData[0].pageCount;
		
		if(searched==true){
			str+=pagination(pageCount,thisPage,"studentSearchPage");
		}else{
			str+=pagination(pageCount,thisPage,"studentPage");
		}
		
		$('#userManagementContainer').html(str);
		
		$('.studentPage').click(function(){
			thisPage=$(this).attr('page');
			searched=false;
			requestJsonData("studentList.ajax",{page:thisPage},studentList);
		})
		
		$('.studentSearchPage').click(function(){
			thisPage=$(this).attr('page');
			
			searched=true;
			var content=data.resData[0].content;
			
			requestJsonDataGet("studentList.ajax",{page:thisPage,content:content,limit:10},studentList);
		})
		$('.studentDelete').click(function(){
			if(confirm('삭제하시겠습니까')){
				var id=$(this).attr('uid');
				requestJsonData("userDelete.ajax",{uid:id},studentDelete);
			}
		})
	
}



var professorList=function(data){
	
	
		
		var list=data.resData[0].professorList;
		
		var str="<div id='addBtnDiv'>";
		str+="<input type='button' class='btn btn-primary' id='professorAddBtn' href='#professorModal' data-toggle='modal' value='교수 추가'>";
		str+="</div>";
		str+="<table class='table'>";
		str+="<thead>";
		str+="<tr>";
		str+="<th>교수번호</th>";
		str+="<th>이름</th>";
		str+="<th>사무실번호</th>";
		str+="<th>사무실전화</th>";
		str+="<th>핸드폰</th>";
		str+="<th>이메일</th>";
		str+="<th>학과</th>";
		str+="<th></th>";
		str+="</tr>";
		str+="</thead>";
		str+="<tbody>";
		$.each(list,function(key,value){
			
			str+="<tr>";
			str+="<td>"+value.professorId+"</td>";
			str+="<td>"+value.professorName+"</td>";
			if(value.officeNo==0)
				str+="<td>없음</td>";
			else
				str+="<td>"+value.officeNo+"</td>";
			if(value.officeTel==undefined)
				str+="<td>없음</td>";
			else
				str+="<td>"+value.officeTel+"</td>";
			str+="<td>"+value.phone+"</td>";
			str+="<td>"+value.email+"</td>";
			str+="<td>"+value.departmentName+"</td>";
			str+="<td><input type='button' uid="+value.professorId+" class='btn btn-default professorDelete' value='삭제'></td>";
			str+="</tr>";
		})
		str+="</tbody>";
		str+="</table>";
		
		var pageCount=data.resData[0].pageCount;
		
		if(searched==true){
			str+=pagination(pageCount,thisPage,"professorSearchPage");
		}else{
			str+=pagination(pageCount,thisPage,"professorPage");
		}
		$('#userManagementContainer').html(str);
		
		$('.professorPage').click(function(){
			thisPage=$(this).attr('page');
			searched=false;
			requestJsonData("professorList.ajax",{page:thisPage},professorList);
		})
		
		$('.professorSearchPage').click(function(){
			thisPage=$(this).attr('page');
			searched=true;
			var content=data.resData[0].content;
			requestJsonDataGet("professorList.ajax",{page:thisPage,category:"professor",content:content,limit:10},professorList);
		})
		
		$('.professorDelete').click(function(){
			if(confirm('삭제하시겠습니까')){
				var id=$(this).attr('uid');
				requestJsonData("userDelete.ajax",{uid:id},professorDelete);
			}
		})
		$('#professorAddBtn').click(function(){
				$("#professorModal").modal('hide');
				$('#professorImg').attr('src','assets/img/sample.png');
				$("#professorModal .form-control").val('');
				$('#professorModal select[name=departmentId]').val('0');
				$('#professorModal select[name=departmentGroup]').val('0');
		})
	
}
var employeeList=function(data){
	
		var list=data.resData[0].employeeList;
		
		var str="<div id='addBtnDiv'>";
		str+="<input type='button' class='btn btn-primary' href='#employeeModal' data-toggle='modal' value='직원 추가'>";
		str+="</div>";
		str+="<table class='table'>";
		str+="<thead>"
		str+="<tr>";
		str+="<th>직원번호</th>";
		str+="<th>이름</th>";
		str+="<th>핸드폰</th>";
		str+="<th>이메일</th>";
		str+="<th></th>";
		str+="</tr>";
		str+="</thead>";
		str+="<tbody>";
		$.each(list,function(key,value){
			
			str+="<tr>";
			str+="<td>"+value.employeeId+"</td>";
			str+="<td>"+value.employeeName+"</td>";
			str+="<td>"+value.phone+"</td>";
			str+="<td>"+value.email+"</td>";
			str+="<td><input type='button' uid="+value.employeeId+" class='btn btn-default employeeDelete' value='삭제'></td>";
			str+="</tr>";
		})
		str+="</tbody>";
		str+="</table>";
		
		var pageCount=data.resData[0].pageCount;
		if(searched==true){
			str+=pagination(pageCount,thisPage,"employeeSearchPage");
		}else{
			str+=pagination(pageCount,thisPage,"employeePage");
		}
		$('#userManagementContainer').html(str);
		
		$('.employeePage').click(function(){
			thisPage=$(this).attr('page');
			searched=false;
			requestJsonData("employeeList.ajax",{page:thisPage},employeeList);
		})
		
		$('.employeeSearchPage').click(function(){
			thisPage=$(this).attr('page');
			searched=true;
			var content=data.resData[0].content;
			requestJsonDataGet("employeeList.ajax",{page:thisPage,content:content,limit:10},employeeList);
		})
		
		$('.employeeDelete').click(function(){
			if(confirm('삭제하시겠습니까')){
				var id=$(this).attr('uid');
				requestJsonData("userDelete.ajax",{uid:id},employeeDelete);
			}
		})
	
}

$(document).ready(function(){
	thisPage=1;
	requestJsonData("studentList.ajax",{page:thisPage},studentList);
	searched=false;
	
	$('#searchForm').submit(function(){
		
		var content=$('#searchInput').val();
		if(search=="professor"){
			
			requestJsonDataGet("professorList.ajax",{page:thisPage,category:"professor",content:content,limit:10},professorList);
			searched=true;
			
		}else if(search=="student"){
			requestJsonDataGet("studentList.ajax",{page:thisPage,content:content,limit:10},studentList);
			searched=true;
			
		}else if(search=="employee"){
			requestJsonDataGet("employeeList.ajax",{page:thisPage,content:content,limit:10},employeeList);
			searched=true;
		}
		
		return false;
	})
	$('#studentList').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			search="student";
			thisPage=1;
			searched=false;
			requestJsonData("studentList.ajax",{page:thisPage},studentList);
			
			
		}
		
	})
	
	$('#professorList').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			search="professor";
			thisPage=1;
			searched=false;
			requestJsonData("professorList.ajax",{page:thisPage},professorList);
			
		}
	})
	
	$('#employeeList').click(function(){
		if($(this).attr('class')!='active'){
			$(this).parent().find('.active').removeClass('active');
			$(this).addClass('active');
			search="employee";
			thisPage=1;
			searched=false;
			requestJsonData("employeeList.ajax",{page:thisPage},employeeList);
			
		}
	})
	$('.department_grp').change(function(){
		var exist=false;
		var department_id=$(this).val();
		if(department_id!=0){
			$('#departmentList li').each(function(){
				if($(this).attr('id')==department_id){
					exist=true;
				}
					
			})
			if(exist){
				alert('이미 추가했습니다.');
				return;
			}
			if($('#professorAddForm select[name=departmentId').val()==department_id){
				alert('학과와 중복됩니다');
				$('#professorAddForm select[name=departmentGroup] option:first-child').attr('selected','true');
				return;
			}
			
			$('#departmentList').html(function(index,html){
				return html+"<li id="+department_id+">"+$('.department_grp option:selected').text()+"<span class='departmentListDelete'>X</span></li>";
			})
		}
		
		
	})
	$(document).on('click','.departmentListDelete',function(){
		
		$(this).parent().remove();
	})
	
	
	
	
	
	$('#professorAddForm').submit(function(){
		var professorId=$('#professorAddForm input[name=professorId]').val();
		var professorName=$('#professorAddForm input[name=professorName]').val();
		var officeNo=$('#professorAddForm input[name=officeNo]').val();
		var officeTel=$('#professorAddForm input[name=officeTel]').val();
		var phone=$('#professorAddForm input[name=phone]').val();
		var email=$('#professorAddForm input[name=email]').val();
		var departmentId=$('#professorAddForm select[name=departmentId]').val();
		var departmentList="";
		$('#departmentList li').each(function(){
			departmentList+=$(this).attr('id')+",";
		})
		
		var data=new FormData();
		data.append("professorId",professorId);
		data.append("professorName",professorName);
		data.append("officeNo",officeNo);
		data.append("officeTel",officeTel);
		data.append("phone",phone);
		data.append("email",email);
		data.append("departmentId",departmentId);
		data.append("departmentList",departmentList);
		data.append("img",$('input[name=professorImg]')[0].files[0]);
		requestJsonDataFile("professorAdd.ajax",data,professorAdd);
		
		
		return false;
		
	})
	
	$('#employeeAddForm').submit(function(){
		var employeeId=$('#employeeAddForm input[name=employeeId]').val();
		var employeeName=$('#employeeAddForm input[name=employeeName]').val();
		var phone=$('#employeeAddForm input[name=phone]').val();
		var email=$('#employeeAddForm input[name=email]').val();
		
		requestJsonData("employeeAdd.ajax",{
			employeeId:employeeId,
			employeeName:employeeName,
			phone:phone,
			email:email
		},employeeAdd);
		
		return false;
	})
})
