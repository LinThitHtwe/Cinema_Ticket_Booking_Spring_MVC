<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<jsp:include page="adminSideBar.jsp"></jsp:include>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js"></script>
<style>
.container{
   margin: 0 auto; 
    width: 80%;



  overflow-x: auto;
}
canvas{
margin-top:40px;
width:100%;
max-width:900px;
background-color:#333;
borderColor: 'red';

}
.title{
text-align:center;
  font-family: sans-serif;
  font-weight: 100;

}
</style>
<body>
<h1 class="title">Income Page</h1>
<div class="container"><canvas id="myChart"></canvas></div>


<script>
var xValues = ["15-03-2023","16-03-2023","17-03-2023","18-03-2023","19-03-2023","20-03-2023","21-03-2023","22-03-2023","23-03-2023","24-03-2023","25-03-2023"];
var yValues = [7,8,8,9,9,9,10,11,14,14,15];

new Chart("myChart", {
	  type: "line",
	  data: {
	    labels: xValues,
	    datasets: [{
	      fill: false,
	      lineTension: 0,
	      backgroundColor: "#0c637d",
	      borderColor: "#4682b4",
	      data: yValues
	    }]
	  },
	  options: {
	    legend: {display: false},
	    scales: {
	      yAxes: [{
	        ticks: {min: 6, max:16,fontColor: 'white'},
	        gridLines: { color: 'rgba(255, 255, 255, 0.1)',  },
	        scaleLabel: {
	          display: true,
	          labelString: 'Y-Axis Label',
	          fontColor: 'white'
	        }
	      }],
	      xAxes: [{
	        ticks: {fontColor: 'white'},
	        gridLines: { color: 'rgba(255, 255, 255, 0.1)',  },
	        scaleLabel: {
	          display: true,
	          labelString: 'X-Axis Label',
	          fontColor: 'white'
	        }
	      }]
	    }
	  }
	});

</script>

</body>
</html>
