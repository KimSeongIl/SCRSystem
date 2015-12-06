var notSuccessStudentListByProfessor=function(data){
	var professorList=data.resData[0].professorList;
	
	var str="";
	$.each(professorList,function(key,value){
		str+="<li sid="+value.studentId+">";
		str+="학번:"+value.studentId+"<br>";
		str+="이름:"+value.name+"<br>";
		str+="핸드폰:"+value.phone+"<br>";
		str+="이메일:"+value.email;
		str+="<br><br>";
		str+="</li>";
	})
	$('#list-content').html(str);
}

var groupByDepartmentListAndCount=function(data){
	var departmentList=data.resData[0].departmentList;
	if(departmentList.length!=0){
		$('#char-second-bar').html('<canvas id="barChart" width="400"></canvas>');
	var ctx = document.getElementById("barChart").getContext("2d");
	var data = {
		    labels: [],
		    datasets: [
		        {
		            label: "",
		            
		            fillColor: "rgba(220,220,220,0.5)",
		            strokeColor: "rgba(220,220,220,0.8)",
		            highlightFill: "rgba(220,220,220,0.75)",
		            highlightStroke: "rgba(220,220,220,1)",
		            data: []
		            
		        },
		        {
		            label: "",
		            
		            fillColor: "rgba(151,187,205,0.5)",
		            strokeColor: "rgba(151,187,205,0.8)",
		            highlightFill: "rgba(151,187,205,0.75)",
		            highlightStroke: "rgba(151,187,205,1)",
		            data: []
		        }
		    ]
		};
	var option={
		    //Boolean - Whether the scale should start at zero, or an order of magnitude down from the lowest value
		    scaleBeginAtZero : true,

		    //Boolean - Whether grid lines are shown across the chart
		    scaleShowGridLines : true,

		    //String - Colour of the grid lines
		    scaleGridLineColor : "rgba(0,0,0,.05)",

		    //Number - Width of the grid lines
		    scaleGridLineWidth : 1,
		    scaleFontColor:"white",
		    //Boolean - Whether to show horizontal lines (except X axis)
		    scaleShowHorizontalLines: true,

		    //Boolean - Whether to show vertical lines (except Y axis)
		    scaleShowVerticalLines: true,

		    //Boolean - If there is a stroke on each bar
		    barShowStroke : true,

		    //Number - Pixel width of the bar stroke
		    barStrokeWidth : 2,

		    //Number - Spacing between each of the X value sets
		    barValueSpacing : 5,

		    //Number - Spacing between data sets within X values
		    barDatasetSpacing : 1,

		    

		}
	var myBarChart = new Chart(ctx).Bar(data,option);
	$.each(departmentList,function(key,value){
		myBarChart.addData([value.count, value.success], value.departmentName,value.departmentId);
	})
	
	$("#barChart").click(function(e) {
		   var activeBars = myBarChart.getBarsAtEvent(e); 
		   
		   requestJsonData("notSuccessStudentListByProfessor.ajax",{departmentId:activeBars[0].userId},notSuccessStudentListByProfessor);
		});
	$("#barChart").mouseover(function(){
		$(this).css('cursor','pointer');
	})
	}else{
		$('#char-second-bar').html('상담기록이 없습니다.');
	}

	
}

var counselCount=function(data){
	var count=data.resData[0].count;
	var successCount=data.resData[0].successCount;
	
	if(count!=0){
		var mediumDoughnutData = [
			                  		{value:successCount,color:"#4bc584",label:"완료",highlight:"#78D4A3"},
			                  		{value:count-successCount,color:"#dce0df",label:"미완료",highlight:"#E5E8E7"}
			                  	];
			
			// MEDIUM DOUGHNUT :)



			$( "#doughnutChart" ).doughnutit({
				dnData: mediumDoughnutData,
			    dnSize: 150,
			    dnInnerCutout: 60,
			    dnAnimation: true,
				dnAnimationSteps: 60,
				dnAnimationEasing: 'linear',
				dnStroke: false,
				dnShowText: true,
				dnFontSize: '50px',
				dnFontOffset: 30,
				dnFontColor: "white",
				dnText: 'G1',
				dnStartAngle: 0,
				dnCounterClockwise: false,
				dnRightCanvas: {
					rcRadius: 5,
					rcPreMargin: 20,
					rcMargin: 20,
					rcHeight: 40,
					rcOffset: 5,
					rcLineWidth: 100,
					rcSphereColor: '#819596', //점
					rcSphereStroke: '#819596',	//점 테두리			
					rcTop:{
						rcTopLineColor: '#819596', //맨 위 선
						rcTopDashLine: 0,
						rcTopFontSize: '13px',
						rcStrokeWidth: 1,
						
						rcTopPreMargin: 30,
			        	rcTopMargin: 20,
			        	rcTopHeight: 30,

						rctAbove: {						
							rctText: '상담완료비율',
							rcSphereColor:'white',
							rctOffset: 2,
							rctImageOffsetRight: 5,
							rctImageOffsetBottom: 0,
							rctFontSize: '22px',
							rctFontStyle: 'bold'
							// rctImage: 'calendar.png',
						},
						rctBelow: {
							rctText: ((successCount/count)*100).toFixed()+"%",
							rctFontSize: '55px',
							rctFontStyle: 'bold',
							rctOffset: 2,
							rctImageOffsetRight: 5,
							rctImageOffsetBottom: 0,
							// rctImage: 'calendar.png'
						}		        	
					},
					rcBottom:{					
						rcBottomDashLine: 0,
						rcBottomFontSize: '15px',
						rcBottomLineColor: '#819596',
						rcStrokeWidth: 1,

						rcBottomPreMargin: 30,
			        	rcBottomMargin: 20,
			        	rcBottomHeight: 60,

						rcbAbove: {
							// rcbImage: 'calendar.png',
							rcbImageOffsetBottom: 0,
							rcbImageOffsetRight: 5,
							rcbText: 'DATA DE G3',
							rcbFontSize: '14px',
							rcbOffset: 2
						}
						/*,
						rcbBelow: {
							rcbImage: 'assets/img/calendar.png',
							rcbImageOffsetRight: 5,
							rcbImageOffsetBottom: 0,
							rcbText: '20/10/2013',
							rcbFontSize: '16px',
							rcbOffset: 5
						}		    */    	
					}
				}
			});// End Doughnut
	}else{
		$( "#doughnutChart" ).html('상담기록이 없습니다.');
	}
		
	
}

$(document).ready(function(){

	

	requestJsonData("counselCountPro.ajax",{},counselCount);
	requestJsonData("groupByDepartmentListAndCount.ajax",{},groupByDepartmentListAndCount);
	
})