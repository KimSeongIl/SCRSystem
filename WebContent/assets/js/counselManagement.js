

var ctx = document.getElementById("barChart").getContext("2d");
var data = {
	    labels: ["January", "February", "March", "April", "May", "June", "July"],
	    datasets: [
	        {
	            label: "My First dataset",
	            fillColor: "rgba(220,220,220,0.5)",
	            strokeColor: "rgba(220,220,220,0.8)",
	            highlightFill: "rgba(220,220,220,0.75)",
	            highlightStroke: "rgba(220,220,220,1)",
	            data: [65, 59, 80, 81, 56, 55, 40]
	        },
	        {
	            label: "My Second dataset",
	            fillColor: "rgba(151,187,205,0.5)",
	            strokeColor: "rgba(151,187,205,0.8)",
	            highlightFill: "rgba(151,187,205,0.75)",
	            highlightStroke: "rgba(151,187,205,1)",
	            data: [28, 48, 40, 19, 86, 27, 90]
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


// MEDIUM DOUGHNUT :)

var mediumDoughnutData = [
		{value:87,color:"#4bc584"},
		{value:100-87,color:"#dce0df"}
	];

$( "#doughnutChart" ).doughnutit({
	dnData: mediumDoughnutData,
    dnSize: 160,
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
				rctText: 'MÉDIA',
				rcSphereColor:'white',
				rctOffset: 2,
				rctImageOffsetRight: 5,
				rctImageOffsetBottom: 0,
				rctFontSize: '22px',
				// rctImage: 'calendar.png',
			},
			rctBelow: {
				rctText: '8.7',
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



