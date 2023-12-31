<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <jsp:include page="adminSideBar.jsp"></jsp:include>
  <meta charset="UTF-8">
  <title>Admin Table</title>
  <link rel="icon" type="image/x-icon" href="/CinemaTicketBooking/images/movie.jpg">

  <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.6/dist/sweetalert2.min.css">
	<style>
	html,
body {
  height: 100%;
}

body {
  height: auto;
  margin: 0;
  background: linear-gradient(to bottom right,#212529,#15191d);
  font-family: sans-serif;
  font-weight: 100;
}

.container {
   margin: 0 auto; 
    width: 80%;


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
.table tbody tr:hover {
  background-color: #fff;
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
  background-color: #1f75fe     ;
  /*background-image: linear-gradient(to bottom right,#228b22 ,#008000);*/
  width: 30%;
  border: 1px solid #1f75fe ;
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
  width: 20%;
  border: 1px solid #ff0800 ;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}

.DetailButton {
  font-family: "Roboto", sans-serif;
  text-transform: uppercase;
  outline: 0;
  background-color: #3d5c71     ;
  /*background-image: linear-gradient(to bottom right,#228b22 ,#008000);*/
  width: 30%;
  border: 1px solid #3e607b ;
  padding: 15px;
  color: #FFFFFF;
  font-size: 14px;
  -webkit-transition: all 0.3 ease;
  transition: all 0.3 ease;
  cursor: pointer;
}

.DetailButton:hover {
  background-color: #40667d ;
}

.UpdateButton:hover {
  background-color: #318ce7 ;
}

.DeleteButton:hover {
  background-color: #ff0000 ;
}


.SearchButton {
  width: 10%;
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
     background-image:linear-gradient(to bottom right,#5B247A,#1BCEDF);
   color: #fff;
    border: none;
}

.SearchButton:hover {
background-image:linear-gradient(to bottom right,#5B407A,#1BCFDF);
  color: white;
}
.AddButton{
  width: 10%;
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
   color:#fff;
 background-image:linear-gradient(to bottom right,#5B247A,#1BCEDF);
  border: none;
}
.AddButton:hover {
background-image:linear-gradient(to bottom right,#5B407A,#1BCFDF);
  color: white;
}

.ResetButton{
  width: 10%;
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
    color:#fff;
 background-image:linear-gradient(to bottom right,#5B247A,#1BCEDF);
  border: none;
}
.ResetButton:hover {
background-image:linear-gradient(to bottom right,#5B407A,#1BCFDF);
  color: white; /* Green */
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

input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;}
  
  input[type=number] {
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
	<div class="labelContainer"><label class="label">Admin Table</label></div>
	<div class="top"><input type="text" name="name" placeholder="Id" id="idInput" oninput="this.value = this.value.replace(/[^0-9]/g, '')" > 
	<input type="text" name="name" placeholder="Name" id="nameInput"> 
	<input type="text" name="email" placeholder="Email" id="emailInput">
		<button class="SearchButton" onclick="search()">Search</button>
		<button class="AddButton" onclick="location.href='toaddAdmin'">Add</button>
		<button class="ResetButton" onclick="location.href='/CinemaTicketBooking/adminTable'">Reset</button></div>

		<script>


function search() {
	  var id = document.getElementById("idInput").value.trim();
	  var name = document.getElementById("nameInput").value.trim();
	  var email = document.getElementById("emailInput").value.trim();

	  var searchUrl = "searchBy";
	  var searchParams = [];
	  if(id!=="" && name !== ""&& email !== ""){
		  searchParams.push("AdminAll/" + id+"/"+name+"/"+email);
		  
	  }
	  else if (id !== "") {
	    searchParams.push("AdminID/"+id);
	  }

	  else if (name !== "") {
	    searchParams.push("AdminName/" + name);
	  }

	  else if (email !== "") {
	    searchParams.push("AdminEmail/" + email);
	  }


	  searchUrl += searchParams.join("/");

	  if (searchParams.length > 0) {
	    // Redirect to the search results page
	    window.location.href = searchUrl;
	  }
	}


</script>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@10.16.6/dist/sweetalert2.min.js"></script>
<script>
    function confirmDelete(event) {
        event.preventDefault(); // Prevents the link from being followed immediately
        Swal.fire({
            title: 'Are you sure you want to delete?',
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes, delete it!'
        }).then((result) => {
            if (result.isConfirmed) {
                // Check if there's at least one row left
                if (document.querySelectorAll('table.table tbody tr').length > 1) {
                    Swal.fire('Deleted');
                    // Follow the link if the user confirms the deletion
                    window.location.href = event.target.href;
                } else {
                    Swal.fire('At least one row must be kept.');
                }
            } else {
                // User clicked Cancel button
                // Do nothing or show a message
                Swal.fire('Delete action cancelled.');
            }
        });
    }
</script>




	<table class="table" id="adminTable">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th style="text-align: center;">Action</th>
			</tr>
		</thead>
		<tbody>
<c:forEach items="${adminlist}" var="adminlist">
  <tr>
    <td id="admin-${adminlist.accountID}">${adminlist.accountID}</td>
    <td>${adminlist.accountName}</td>
    <td>${adminlist.accountEmail}</td>
    <td style="text-align: center;"> 
				<c:if test="${currentEmail == adminlist.accountEmail}">
				<button onclick="location.href='/CinemaTicketBooking/setupUpdateAdmin/${adminlist.accountID}'" class="UpdateButton" style="width:50%">Update</button> 
				</c:if>
				<c:if test="${currentEmail != adminlist.accountEmail}">
				<button onclick="location.href='/CinemaTicketBooking/setupUpdateAdmin/${adminlist.accountID}'" class="DetailButton" >Details</button>
				<a href="/CinemaTicketBooking/deleteAdmin/${adminlist.accountID}"  class="DeleteButton" onclick="return confirmDelete(event)" style="text-decoration:none;display: inline-block;">Delete</a> 
				</c:if>				

    </td>
  </tr>
</c:forEach>


		</tbody>
	</table>
</div>
<!-- partial -->
  
</body>
</html>
 