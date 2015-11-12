var groupIndex=-1;

var studentSearchByName=function(data){
	var list=data.resData[0].list;
	
	var str="";
	$.each(list,function(key,value){
		
		str+="<span><span class='col-xs-4'>"+value.studentId+"</span>";
		str+="<span class='col-xs-4'>"+value.name+"</span>";
		str+="<span class='col-xs-4'>"+value.departmentName+"</span></span>";
		
		
	})
	
	$('#searchList').html(str);
}


$(document).ready(function(){
	
	$(document).on('click','#searchList>span',function(){
		var studentId=$(this).find('span:first-child').text();
		var studentName=$(this).find('span:nth-child(2)').text();
		var departmentName=$(this).find('span:last-child').text();
		
		$('#searchList').html('');
		$('input[name=studentSearch]').val('');
		var added=false;
		$('#groupCounselList li').each(function(){
			if(studentId==$(this).attr('sid')){
				alert('이미 추가했습니다');
				added=true;
			}
		})
		if(!added){
			var str="<li sid='"+studentId+"'><span class='col-xs-3'>"+studentId+"</span> <span class='col-xs-2'>"+studentName+"</span><span class='col-xs-3'> "+departmentName+"</span><span class='col-xs-1 groupListDelete' style='float:right'>x</span></li> ";
			$('#groupCounselList').html(function(index,html){
				return html+str;
			})
			
			
			$('.groupListDelete').click(function(){
				$(this).parent().remove();
			})
		}
		
	})
	
	$('#groupCounsel,#groupCounselListTh,#groupCounselListTd').css('display','none');
	
	$('#counselCategory').change(function(){
	
		if($(this).val()=='집단상담'){
			$('#groupCounsel,#groupCounselListTh,#groupCounselListTd').css('display','table-row');
		}else{
			$('#groupCounsel,#groupCounselListTh,#groupCounselListTd').css('display','none');
			$('#groupCounselList').html('');
			$('input[name=studentSearch]').val('');
		}
	})
	$('input[name=studentSearch]').keypress(function(){
		
		if(event.keyCode==13){
			
			
			var studentId=$('.studentSelected').find('span:first-child').text();
			var studentName=$('.studentSelected').find('span:nth-child(2)').text();
			var departmentName=$('.studentSelected').find('span:last-child').text();
			
			$('#searchList').html('');
			$('input[name=studentSearch]').val('');
			var added=false;
			
			$('#groupCounselList li').each(function(){
				if(studentId==$(this).attr('sid')){
					alert('이미 추가했습니다');
					added=true;
				}
			})
			if(!added){
				
				var str="<li sid='"+studentId+"'><span class='col-xs-3'>"+studentId+"</span> <span class='col-xs-2'>"+studentName+"</span><span class='col-xs-3'> "+departmentName+"</span><span class='col-xs-1 groupListDelete' style='float:right'>x</span></li> ";
				
				$('#groupCounselList').html(function(index,html){
					return html+str;
				})
				
				
				$('.groupListDelete').click(function(){
					$(this).parent().remove();
				})
			}
			return false;
		}
	})
	
	$('input[name=studentSearch]').keyup(function(){
		var studentName=$(this).val().trim();
		
		if(event.keyCode==38){
			if(groupIndex>0){
				groupIndex--;
				$('#searchList').find('.studentSelected').removeClass('studentSelected');
				$('#searchList>span').eq(groupIndex).addClass('studentSelected');
				
			}
			return false;
		}else if(event.keyCode==40){
			
			if(groupIndex<($('#searchList>span').length-1)){
				
				groupIndex++;
				
				$('#searchList').find('.studentSelected').removeClass('studentSelected');
				$('#searchList>span').eq(groupIndex).addClass('studentSelected');
			}
			$('#searchList>span').eq(groupIndex).addClass('studentSelected');
			return false;
		}
		else if(studentName==""){
			$('#searchList').html('');
		}else{
			groupIndex=-1;
			requestJsonDataNoLoading("studentSearchByName.ajax",{studentName:studentName},studentSearchByName);
		}
	})
	
})