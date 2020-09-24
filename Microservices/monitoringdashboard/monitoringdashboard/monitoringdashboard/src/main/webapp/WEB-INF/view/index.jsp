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
<meta charset="ISO-8859-1" http-equiv="refresh" content="30;URL=/monitoringdashboard/report/chart">
<title>Smart Connect Hawk Eye</title>
<H1 style="color:darkblue; text-align: center; font-family:Times New Roman; font-size:40px; text-shadow: 3px 2px red;">SMART CONNECT HAWK EYE<H1>

</head>
<body>
<marquee style="z-index:2; position:absolute; color:#EBF4FA; font-family:Times New Roman; behavior:alternate; direction:left; text-shadow: 3px 2px red;" ><span style="background-color: darkblue">TODAY IS A MAJOR DEPLOYMENT!</span></marquee><BR>
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
		    url : '${pageContext.request.contextPath}/report/ActivationTrendTable',
			success : function(result) {
				google.charts.load('current', {'packages':['table']});
				google.charts.setOnLoadCallback(function() {
					drawActivationTrendTable(result);
				});
			}
		});
 
 $.ajax({
		type : 'GET',
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
	    url : '${pageContext.request.contextPath}/report/RechargeTrendTable',
		success : function(result) {
			google.charts.load('current', {'packages':['table']});
			google.charts.setOnLoadCallback(function() {
				drawRechargeTrendTable(result);
			});
		}
	});
 
 $.ajax({
		type : 'GET',
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
	    url : '${pageContext.request.contextPath}/report/SimexTrendTable',
		success : function(result) {
			google.charts.load('current', {'packages':['table']});
			google.charts.setOnLoadCallback(function() {
				drawSimexTrendTable(result);
			});
		}
	});
 
	$.ajax({
		type : 'GET',
		headers : {
			Accept : "application/json; charset=utf-8",
			"Content-Type" : "application/json; charset=utf-8"
		},
	    url : '${pageContext.request.contextPath}/report/ActivationCircleTrendTable',
		success : function(result) {
			google.charts.load('current', {'packages':['table']});
			google.charts.setOnLoadCallback(function() {
				drawActivationCircleTrendTable(result);
			});
		}
	});

$.ajax({
	type : 'GET',
	headers : {
		Accept : "application/json; charset=utf-8",
		"Content-Type" : "application/json; charset=utf-8"
	},
    url : '${pageContext.request.contextPath}/report/RechargeCircleTrendTable',
	success : function(result) {
		google.charts.load('current', {'packages':['table']});
		google.charts.setOnLoadCallback(function() {
			drawRechargeCircleTrendTable(result);
		});
	}
});

$.ajax({
	type : 'GET',
	headers : {
		Accept : "application/json; charset=utf-8",
		"Content-Type" : "application/json; charset=utf-8"
	},
    url : '${pageContext.request.contextPath}/report/SimexCircleTrendTable',
	success : function(result) {
		google.charts.load('current', {'packages':['table']});
		google.charts.setOnLoadCallback(function() {
			drawSimexCircleTrendTable(result);
		});
	}
});

$.ajax({
	type : 'GET',
	headers : {
		Accept : "application/json; charset=utf-8",
		"Content-Type" : "application/json; charset=utf-8"
	},
    url : '${pageContext.request.contextPath}/report/MFPIHSTrendTable',
	success : function(result) {
		google.charts.load('current', {'packages':['table']});
		google.charts.setOnLoadCallback(function() {
			mfpIHSTrendTable(result);
		});
	}
});
        
        
        function drawActivationTrendTable(result){
        	
        	var dataArray = [];
			dataArray.push(['DATE TIME', 'TODAY', 'LAST WEEK', 'DIFF', 'DIFF %']);
			$.each(result, function(i, obj) {	
				var diff1= parseFloat(obj.diff_prct);
					dataArray.push([ obj.time, obj.today, obj.lastweek, obj.diff, diff1]);
			});
			
			var data= new google.visualization.arrayToDataTable(dataArray);
			
			var table = new google.visualization.Table(document.getElementById('act_table_div'));
			
			var formatter = new google.visualization.ColorFormat();
			formatter.addRange(-5000, -30, 'White', 'Red');
			formatter.addRange(-30, -20, 'Black', 'Orange');
			formatter.addRange(-20, -10, 'Black', 'Yellow');
			formatter.addRange(0, 5000, 'White', 'Green');
			formatter.format(data, 4);

	        table.draw(data, {allowHtml: true, showRowNumber: true, width: '100%', height: '100%'});
        	
        }
        
function drawRechargeTrendTable(result){
        	
        	var dataArray = [];
			dataArray.push(['DATE TIME', 'TODAY', 'LAST WEEK', 'DIFF', 'DIFF %']);
			$.each(result, function(i, obj) {	
				var diff1= parseFloat(obj.diff_prct);
					dataArray.push([ obj.time, obj.today, obj.lastweek, obj.diff, diff1]);
			});
			
			var data= new google.visualization.arrayToDataTable(dataArray);
			
			var table = new google.visualization.Table(document.getElementById('rch_table_div'));
			
			var formatter = new google.visualization.ColorFormat();
			formatter.addRange(-5000, -30, 'White', 'Red');
			formatter.addRange(-30, -20, 'Black', 'Orange');
			formatter.addRange(-20, -10, 'Black', 'Yellow');
			formatter.addRange(0, 5000, 'White', 'Green');
			formatter.format(data, 4);

	        table.draw(data, {allowHtml: true, showRowNumber: true, width: '100%', height: '100%'});
        	
        }
        
function drawSimexTrendTable(result){
	
	var dataArray = [];
	dataArray.push(['DATE TIME', 'TODAY', 'LAST WEEK', 'DIFF', 'DIFF %']);
	$.each(result, function(i, obj) {	
		var diff1= parseFloat(obj.diff_prct);
			dataArray.push([ obj.time, obj.today, obj.lastweek, obj.diff, diff1]);
	});
	
	var data= new google.visualization.arrayToDataTable(dataArray);
	
	var table = new google.visualization.Table(document.getElementById('simex_table_div'));
	
	var formatter = new google.visualization.ColorFormat();
	formatter.addRange(-5000, -30, 'White', 'Red');
	formatter.addRange(-30, -20, 'Black', 'Orange');
	formatter.addRange(-20, -10, 'Black', 'Yellow');
	formatter.addRange(0, 5000, 'White', 'Green');
	formatter.format(data, 4);

    table.draw(data, {allowHtml: true, showRowNumber: true, width: '100%', height: '100%'});
	
}
	

function drawActivationCircleTrendTable(result){
	
	var dataArray = [];
	dataArray.push(['CIRCLE', 'TODAY', 'LAST WEEK', 'DIFF', 'DIFF %']);
	$.each(result, function(i, obj) {	
		var diff1= parseFloat(obj.diff_prct);
			dataArray.push([ obj.time, obj.today, obj.lastweek, obj.diff, diff1]);
	});
	
	var data= new google.visualization.arrayToDataTable(dataArray);
	
	var table = new google.visualization.Table(document.getElementById('act_circle_table_div'));
	
	var formatter = new google.visualization.ColorFormat();
	formatter.addRange(-5000, -30, 'White', 'Red');
	formatter.addRange(-30, -20, 'Black', 'Orange');
	formatter.addRange(-20, -10, 'Black', 'Yellow');
	formatter.addRange(0, 5000, 'White', 'Green');
	formatter.format(data, 4);

    table.draw(data, {allowHtml: true, showRowNumber: true, width: '100%', height: '100%'});
	
}

function drawRechargeCircleTrendTable(result){
	
	var dataArray = [];
	dataArray.push(['CIRCLE', 'TODAY', 'LAST WEEK', 'DIFF', 'DIFF %']);
	$.each(result, function(i, obj) {	
		var diff1= parseFloat(obj.diff_prct);
			dataArray.push([ obj.time, obj.today, obj.lastweek, obj.diff, diff1]);
	});
	
	var data= new google.visualization.arrayToDataTable(dataArray);
	
	var table = new google.visualization.Table(document.getElementById('rch_circle_table_div'));
	
	var formatter = new google.visualization.ColorFormat();
	formatter.addRange(-5000, -30, 'White', 'Red');
	formatter.addRange(-30, -20, 'Black', 'Orange');
	formatter.addRange(-20, -10, 'Black', 'Yellow');
	formatter.addRange(0, 5000, 'White', 'Green');
	formatter.format(data, 4);

    table.draw(data, {allowHtml: true, showRowNumber: true, width: '100%', height: '100%'});
	
}

function drawSimexCircleTrendTable(result){

var dataArray = [];
dataArray.push(['CIRCLE', 'TODAY', 'LAST WEEK', 'DIFF', 'DIFF %']);
$.each(result, function(i, obj) {	
var diff1= parseFloat(obj.diff_prct);
	dataArray.push([ obj.time, obj.today, obj.lastweek, obj.diff, diff1]);
});

var data= new google.visualization.arrayToDataTable(dataArray);

var table = new google.visualization.Table(document.getElementById('simex_circle_table_div'));

var formatter = new google.visualization.ColorFormat();
formatter.addRange(-5000, -30, 'White', 'Red');
formatter.addRange(-30, -20, 'Black', 'Orange');
formatter.addRange(-20, -10, 'Black', 'Yellow');
formatter.addRange(0, 5000, 'White', 'Green');
formatter.format(data, 4);

table.draw(data, {allowHtml: true, showRowNumber: true, width: '100%', height: '100%'});

}

function mfpIHSTrendTable(result){

	var dataArray = [];
	dataArray.push(['DATE TIME', 'IP', 'HOST NAME', 'MAX CLIENT', 'REMARK']);
	$.each(result, function(i, obj) {	
	var diff1= parseFloat(obj.diff_prct);
		dataArray.push([ obj.time, obj.today, obj.lastweek, obj.diff, diff1]);
	});

	var data= new google.visualization.arrayToDataTable(dataArray);

	var table = new google.visualization.Table(document.getElementById('mfp_ihs_trend_div'));

	var formatter = new google.visualization.ColorFormat();
	formatter.addRange(1000, 3000, 'White', 'Red');
	formatter.addRange(700, 1000, 'Black', 'Orange');
	formatter.addRange(500, 700, 'Black', 'Yellow');
	formatter.addRange(0, 500, 'White', 'Green');
	formatter.format(data, 3);

	table.draw(data, {allowHtml: true, showRowNumber: true, width: '100%', height: '100%'});

	}


	});
</script>

</head>
<body>
	
	<table cellpadding="10" style="width:100%">
		<tr>
	       <th style="color:#0000A0; font-family:Times New Roman; font-size:17px;"><u>MFP IHS MAX CLIENT</u></th>
	    </tr>
		
		<tr>	
			<td><div id="mfp_ihs_trend_div" style="border: 1px solid #ccc"></div></td>			
		</tr>  		
	</table>
	
	
	<table cellpadding="10" style="width:100%">
	    <tr>
	        <th style="color:#0000A0; font-family:Times New Roman; font-size:17px;"><u>RECHARGES PER MINUTE</u></th>
	        <th style="color:#0000A0; font-family:Times New Roman; font-size:17px;"><u>ACTIVATIONS PER MINUTE</u></th>
	        <th style="color:#0000A0; font-family:Times New Roman; font-size:17px;"><u>SIMEX PER MINUTE</u></th>
	    </tr>
		<tr>
			<td><div id="rch_table_div" style="border: 1px solid #ccc"></div></td>
			
			<td ><div id="act_table_div" style="border: 1px solid #ccc"></div></td>
			
			<td ><div id="simex_table_div" style="border: 1px solid #ccc"></div></td>
								
		</tr> 
	</table>
	<table cellpadding="10" style="width:100%">
		<tr>
	       <th style="color:#0000A0; font-family:Times New Roman; font-size:17px;"><u>RECHARGES CIRCLE WISE</u></th>
	       <th style="color:#0000A0; font-family:Times New Roman; font-size:17px;"><u>ACTIVATIONS CIRCLE WISE</u></th>
	       <th style="color:#0000A0; font-family:Times New Roman; font-size:17px;"><u>SIMEX CIRCLE WISE</u></th>
	    </tr>
		<tr>
		    <td><div id="rch_circle_table_div" style="border: 1px solid #ccc"></div></td>
			
			<td><div id="act_circle_table_div" style="border: 1px solid #ccc"></div></td>	
			
			<td><div id="simex_circle_table_div" style="border: 1px solid #ccc"></div></td>	
			
		</tr>  	 
		
	</table>
	
	
			

</body>
</html>