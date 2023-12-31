<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ include file="adminSideBar.jsp" %>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Seat Table</title>
    <link rel="icon" type="image/x-icon" href="/CinemaTicketBooking/images/movie.jpg">
  <link rel="stylesheet" href="./style.css">
	<style>
	html,
body {
  height: 100%;
}

body {
  height: auto;
  margin: 0;
  background: linear-gradient(90deg,#212529,#15191d);
  font-family: sans-serif;
  font-weight: 100;
}

.container {
          margin: 0 auto; 
        width: 80%;
 /* max-width: 80% 80%; */

  overflow-x: auto;
}
.label{
  color: #fff;
    font-family: sans-serif;
  font-weight: 100;
  font-size: 40px;
  text-align: center;

}

.table {
  width: 100%;
  overflow: hidden;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  border: 2px solid #15191d;
}


.table th,.table td {
  padding: 1rem;
  background-color: #313b4b;
  color: #fff;
  text-align: left;
}

.table th {
  background-color: #074f75;
}



.table tbody td {
  position: relative;
}

.table tbody td:hover {
  background-color: #313743;
}

.table tbody tr:nth-child(even) {
  background-color: #212529;
  color: #fff;
}


.UpdateButton {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background-color: #3d5c71 ;
  /*background-image: linear-gradient(to bottom right,#228b22 ,#008000);*/
  width: 20%;
  border: 1px solid #3e607b;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}

.DeleteButton {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background-color: #e8000d ;
  /*background-image: linear-gradient(to bottom right,#228b22 ,#008000);*/
  width: 25%;
  border: 1px solid #ff0800 ;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}


.DetailsButton {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background-color: #3d5c71 ;
  /*background-image: linear-gradient(to bottom right,#228b22 ,#008000);*/
  width: 35%;
  border: 1px solid #3e607b;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}



.DeleteButton:hover {
  background-color: #ff0000 ;
}

.DetailsButton:hover {
  background-color: #40667d;
}

.UpdateButton:hover {
  background-color: #40667d;
}

.SearchButton {
  width: 20%;
  padding: 6px;
  margin-top: 8px;
  font-size: 17px
}

.SearchButton:hover {
  background-color: #4CAF50; /* Green */
  color: white;
}

@media only screen and (max-width: 768px) {
  table {
    font-size: 0.8rem;
  }
}

@media only screen and (max-width: 600px) {
  table {
    font-size: 0.7rem;
  }
}

@media only screen and (max-width: 480px) {
  table {
    font-size: 0.6rem;
  }

  .table thead {
    display: none;
  }

  .table, .table tbody, .table tr, .table td {
    display: block;
    width: 100%;
  }

  .table tr {
    margin-bottom: 15px;
  }

  .table td {
    text-align: right;
    padding-left: 50%;
    text-align: right;
    position: relative;
  }

  .table td::before {
    content: attr(data-label);
    position: absolute;
    left: 0;
    width: 50%;
    padding-left: 15px;
    font-size: 15px;
    font-weight: bold;
    text-align: left;
  }
}

.SearchButton {
  width: 10%;
  padding: 6px;
  margin-top: 8px;
  font-size: 17px
}

.SearchButton:hover {
  background-color: #40667d; /* Green */
  color: white;
}
.AddButton{
  width: 10%;
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
}
.AddButton:hover {
  background-color: #40667d; /* Green */
  color: white;
}

.ResetButton{
  width: 10%;
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
}
.ResetButton:hover {
  background-color: #40667d;
  color: white; /* Green */
}
input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;}
  
  input[type=email] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;}
  
 .top{
 padding:2px;
 margin-bottom:10px;
 }
 
 .labelContainer{
 margin-top: 10px;
 }
	
	</style>
</head>
<body>
<!-- partial:index.partial.html -->
<div class="container">
	<div class="labelContainer"><label class="label">Seat Table</label></div>

	<table class="table">
		<thead>
			<tr>
				<th>Row</th>
				<th>Price</th>
				<th style="text-align: center;">Action</th>
			</tr>
		</thead>
							<tr>
		<td>Row A</td>
				<td>${seatAPrice} MMK</td>
				<td style="text-align: center;"><button onclick="location.href='setupUpdateseat/1'" class="DetailsButton" >Change Price</button></td>
			</tr>

			
					<tr>
		<td>Row B</td>
				<td>${seatBPrice} MMK</td>
				<td style="text-align: center;"><button onclick="location.href='setupUpdateseat/11'" class="DetailsButton" >Change Price</button></td>
			</tr>
			
					<tr>
		<td>Row C</td>
				<td>${seatCPrice} MMK</td>
				<td style="text-align: center;"><button onclick="location.href='setupUpdateseat/21'" class="DetailsButton" >Change Price</button></td>
			</tr>
			
					<tr>
		<td>Row D</td>
				<td>${seatDPrice} MMK</td>
				<td style="text-align: center;"><button onclick="location.href='setupUpdateseat/31'" class="DetailsButton" >Change Price</button></td>
			</tr>
			
					<tr>
		<td>Row E</td>
				<td>${seatEPrice} MMK</td>
				<td style="text-align: center;"> <button onclick="location.href='setupUpdateseat/41'" class="DetailsButton" >Change Price</button></td>
			</tr>
			
					<tr>
		<td>Row F</td>
				<td>${seatFPrice} MMK</td>
				<td style="text-align: center;"><button onclick="location.href='setupUpdateseat/51'" class="DetailsButton" >Change Price</button></td>
			</tr>
		



		</tbody>
	</table>
</div>
<!-- partial -->
  
</body>
</html>
