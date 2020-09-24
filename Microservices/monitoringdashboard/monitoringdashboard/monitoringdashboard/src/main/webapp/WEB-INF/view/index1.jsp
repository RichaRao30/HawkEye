<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
background-color: powderblue;
}
table th {
   font-size: 15px;
 }
</style>
<meta charset="ISO-8859-1" http-equiv="refresh" content="30;URL=/monitoringdashboard/report">
<title>Smart Connect Hawk Eye</title>
<H1 style="color:darkblue; text-align: center; font-family:Times New Roman; font-size:40px;  text-shadow: 3px 2px yellow;">SMART CONNECT HAWK EYE<H1>
</head>
<body>
<marquee style="z-index:2; position:absolute; color:#848B79; font-family:Times New Roman; behavior:alternate; direction:left; text-shadow: 3px 2px yellow;" ><span style="background-color: darkblue">TODAY IS A MAJOR DEPLOYMENT!</span></marquee><BR>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>

<script type="text/javascript">
	$(document).ready(function() {

		  $.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
		    url : '${pageContext.request.contextPath}/report/ActivationData',
			success : function(result) {
				google.charts.load('current', {
					'packages' : [ 'corechart' ]
				});
				google.charts.setOnLoadCallback(function() {
					drawChartActivations(result);
				});
				
			}
		}); 
		
		$.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
		    url : '${pageContext.request.contextPath}/report/RechargeData',
			success : function(result) {
				google.charts.load('current', {
					'packages' : [ 'corechart' ]
				});
				google.charts.setOnLoadCallback(function() {
					drawChartRecharges(result);
				});
			}
		}); 
		
		
		$.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
		    url : '${pageContext.request.contextPath}/report/RechargeTrend',
			success : function(result) {
				google.charts.load('current', {packages: ['corechart','bar']});
				google.charts.setOnLoadCallback(function() {
					drawRechargeTrendlines(result);
				});
			}
		});
		
		
		
		$.ajax({
			type : 'GET',
			headers : {
				Accept : "application/json; charset=utf-8",
				"Content-Type" : "application/json; charset=utf-8"
			},
		    url : '${pageContext.request.contextPath}/report/ActivationTrend',
			success : function(result) {
				google.charts.load('current', {packages: ['corechart','bar']});
				google.charts.setOnLoadCallback(function() {
					drawActivationTrendlines(result);
				});
			}
		});
		
		
				
		
	function drawRechargeTrendlines(result) {
		        var dataArray = [];
				dataArray.push(['Time of Day', 'IDEA', { role: 'annotation' }, 'VODA', { role: 'annotation' }]);
				$.each(result, function(i, obj) {
					var time= i+8;
					var data= parseInt(obj.trxType);
					dataArray.push([{v: [i+8, 0, 0]}, obj.quantity, obj.quantity, data, data]);
				});

				var data= new google.visualization.arrayToDataTable(dataArray);
		      var options = {
		        title: 'RECHARGE LEVEL THROUGHOUT THE DAY',
				height : 250,
				colors: ['#ffff00','#ff0000'],
		        hAxis: {
		          title: 'TIME OF THE DAY',
		          format: 'h:mm a',
		          viewWindow: {
		            min: [8, 0, 0],
		            max: [21, 0, 0]
		          }
		        },
		        vAxis: {
		          title: 'RECHARGES'
		        },
		        chartArea: {
		            backgroundColor: {
		              fill: '#2B65EC',
		              fillOpacity: 0.1
		            },
		          }
		      }; 
		      
		      var chart = new google.visualization.ColumnChart(document.getElementById('rch_trend_div'));
		      chart.draw(data, options);    
		     
		    }
	
		
       function drawActivationTrendlines(result) { 
		        var dataArray = [];
				dataArray.push(['Time of Day', 'IDEA', { role: 'annotation' }, 'VODA', { role: 'annotation' }]);
				$.each(result, function(i, obj) {
					var time= i+8;
					var data= parseInt(obj.trxType);
					dataArray.push([{v: [i+8, 0, 0]}, obj.quantity, obj.quantity, data, data]);
				});

				var data= new google.visualization.arrayToDataTable(dataArray);
		      var options = {
		        title: 'ACTIVATION LEVEL THROUGHOUT THE DAY',
				height : 250,
				colors: ['#ffff00','#ff0000'],
		        hAxis: {
		          title: 'TIME OF THE DAY',
		          format: 'h:mm a',
		          viewWindow: {
		            min: [8, 0, 0],
		            max: [19, 0, 0]
		          }
		        },
		        vAxis: {
		          title: 'ACTIVATIONS'
		        },
		        chartArea: {
		            backgroundColor: {
		              fill: '#2B65EC',
		              fillOpacity: 0.1
		            },
		          }
		      };
 
			
		      var chart = new google.visualization.ColumnChart(document.getElementById('act_trend_div'));
		      chart.draw(data, options);
		 }
		   
		

        function drawChartRecharges(result) {
			
			var dataArray = [];
			dataArray.push(['Brand', 'Quantity', { role: 'style' },{ role: 'annotation' }]);
			$.each(result, function(i, obj) {
				if(obj.trxType=='IDEA'){
					dataArray.push([ obj.trxType, obj.quantity,'#ffff00', obj.quantity]);
				}else{
				dataArray.push([ obj.trxType, obj.quantity,'#ff0000', obj.quantity]);}
			});
			
			var data= new google.visualization.arrayToDataTable(dataArray);


			var piechart_options = {
				title : 'Recharge in Last 15 Minutes',
				colors: ['#ffff00','#ff0000'],
				width : 350,
				height : 250,
				is3D : true,
				titleTextStyle :{bold:true,
					fontSize: 16}
			};
			var piechart = new google.visualization.PieChart(document
					.getElementById('rch_piechart_div'));
			piechart.draw(data, piechart_options);

			var barchart_options = {
				title : 'Recharge in Last 15 Minutes',
				width : 350,
				height : 250,
				legend : 'none',
				is3D : true,
				titleTextStyle :{bold:true,
					fontSize: 16}
			};
			var barchart = new google.visualization.ColumnChart(document
					.getElementById('rch_barchart_div'));
			barchart.draw(data, barchart_options);
		}
     
        function drawChartActivations(result) {

			var dataArray = [];
			dataArray.push(['Brand', 'Quantity', { role: 'style' },{ role: 'annotation' }]);
			$.each(result, function(i, obj) {
				if(obj.trxType=='IDEA'){
					dataArray.push([ obj.trxType, obj.quantity,'#ffff00', obj.quantity]);
				}else{
				dataArray.push([ obj.trxType, obj.quantity,'#ff0000', obj.quantity]);}
			});
			
			var data= new google.visualization.arrayToDataTable(dataArray);

			var piechart_options = {
				title : 'Activation in Last 15 Minute',
				colors: ['#ffff00','#ff0000'],
				width : 350,
				height : 250,
				is3D : true,
				titleTextStyle :{bold:true,
					fontSize: 16}
			};
			var piechart = new google.visualization.PieChart(document
					.getElementById('act_piechart_div'));
			piechart.draw(data, piechart_options);

			var barchart_options = {
				title : 'Activation in Last 15 Minute',
				width : 350,
				height : 250,
				legend : 'none',
				is3D : true,
				titleTextStyle :{bold:true,
					fontSize: 16}
			};
			var barchart = new google.visualization.ColumnChart(document
					.getElementById('act_barchart_div'));
			barchart.draw(data, barchart_options);
		}  
        
	});
</script>

</head>
<body>

    
    <H3 align="center" style="color:#0000A0; font-family:Times New Roman; font-size:20px; text-shadow: 3px 2px yellow;"><u>ACTIVATION TREND</u><H3>
	<table cellpadding="10" align="center"  class="columns">
		<tr>
		     <div id="act_trend_div"></div>
		</tr> <br> 
		<tr>     
			 <td ><div id="act_piechart_div" style="border: 1px solid #ccc"></div></td>
			
			<td><div id="act_barchart_div" style="border: 1px solid #ccc"></div></td>		
		</tr>
	</table>
	<br><H3 align="center" style="color:#0000A0; font-family:Times New Roman; font-size:20px; text-shadow: 3px 2px yellow;"><u>RECHARGE TREND</u><H3> 
	<table cellpadding="10" align="center"  class="columns">
		<tr>
		     <div id="rch_trend_div"></div>
		</tr> <br>    	
		<tr>
			<td ><div id="rch_piechart_div" style="border: 1px solid #ccc"></div></td>
			
			<td><div id="rch_barchart_div" style="border: 1px solid #ccc"></div></td>					
		</tr> 
		
	</table>
	
			

</body>
</html>