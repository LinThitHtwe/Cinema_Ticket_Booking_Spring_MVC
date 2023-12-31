<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
 
 <link rel="stylesheet" href="/CinemaTicketBooking/pages/navbar.css">
  
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" 
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" 
crossorigin="anonymous" referrerpolicy="no-referrer" /> 
<link rel="icon" type="image/x-icon" href="C:/Users/HP/eclipse-workspace1/CinemaTicketBooking/src/main/webapp/WEB-INF/pages/icon.png"/>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
        
  <style>
  <head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
 <link rel="stylesheet" href="/CinemaTicketBooking/pages/navbar.css">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" 
integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" 
crossorigin="anonymous" referrerpolicy="no-referrer" />
<style>

body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  color:white;
  background-color: #333;
}

.topnav {
  overflow: hidden;
  background-image:linear-gradient(to bottom right,#5B247A,#1BCEDF);

}

.topnav a {
  float: left;
  display: block;
  color: #f2f2f2;
  text-align: center;
  padding: 20px 16px;
  text-decoration: none;
  font-size: 17px;
    margin-left: 40px;
}

.topnav a:hover{
text-decoration:none;
color:#fff;
}
/*.topnav a:hover {
  background-color: #ddd;
  color: black;
}*/


.topnav .icon {
  display: none;
}

@media screen and (max-width: 600px) {
  .topnav a:not(:first-child) {display: none;}
  .topnav a.icon {
    float: right;
    display: block;
  }
}

@media screen and (max-width: 600px) {
  .topnav.responsive {position: relative;}
  .topnav.responsive .icon {
    position: absolute;
    right: 0;
    top: 0;
  }
  .topnav.responsive a {
    float: none;
    display: block;
    text-align: left;
  }
}

.w3rcontainer{
   border: 1px solid;
   border-radius: 2px;
} 
.hover-underline-animation {
  display: inline-block;
  position: relative;
 
}

.hover-underline-animation:after {
  content: '';
  position: absolute;
  width: 100%;
  transform: scaleX(0);
  height: 3px;
  bottom: 0;
  left: 0;
  background-color:white;
  transform-origin: bottom right;
  transition: transform 0.25s ease-out;
    text-decoration: none;
}

.hover-underline-animation:hover:after {
  transform: scaleX(1);
  transform-origin: bottom left;
    text-decoration: none;
}
/*----------------------------------------------------sidebar-----------------------------------------------*/
.sidebar {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color:#000d1a;
   
  overflow-x: hidden;
  transition: 0.3s;
  padding-top: 60px;
}

.sidebar a {
  padding: 8px 2px 8px 32px;
  text-decoration: none;
  font-size: 14px;
  color:white;
  display: block;
  transition: 0.3s;
}

.sidebar a:hover {
  color: #f1f1f1;
/*  color:#818181;*/
}

.sidebar .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

.openbtn {
  font-size: 20px;
  cursor: pointer;
  background-color:white;
  color: white;
  padding: 10px 15px;
  border: none;
  position:absolute;
}

.openbtn:hover {
  background-color: #444;
}

/* On smaller screens, where height is less than 450px, change the style of the sidenav (less padding and a smaller font size) */
@media screen and (max-height: 450px) {
  .sidebar {padding-top: 15px;}
  .sidebar a {font-size: 18px;}
}
/* my custom css*/
#user{
padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 16px;
  display: block;
  transition: 0.3s;
  
}
#useric{
position:absolute;
top:3%;
left:37%;
 
}
/*------------------------------------------------------------------*/
  
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content/Box */
.modal-content {
  background-color: #fefefe;
  margin: 15% auto; /* 15% from the top and centered */
  padding: 20px;
  border: 1px solid #888;
  width:300px; /* Could be more or less, depending on screen size */
}

/* The Close Button */
.close {
  color: #aaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.close:hover,
.close:focus {
  color: black;
  text-decoration: none;
  cursor: pointer;
}

.modalmsg{
display:block;
color:black;
font-size:20px;
}

.Registerbtn{
margin-right:10%;
color:white;
//float:right;

text-decoration:none;
border:solid 2px ;
padding:5px;
 background-image:linear-gradient(to bottom right,#5B247A,#1BCEDF);
}
.Loginbtn{
margin-right:10%;
color:white;
//float:right;

text-decoration:none;
border:solid 2px ;
padding:5px;
 background-image:linear-gradient(to bottom right,#5B247A,#1BCEDF);
}
a:hover{
text-decoration:none;
color:white;
}
 #user {
margin-top:25px;
}
.editA{
border-left:solid 2px lightblue;
}
.logoutA{
border-left:solid 2px pink;
}
 
  </style>

</head>
<body>
 
<div class="topnav" id="myTopnav">

  <a href="/CinemaTicketBooking/" id="active" class="hover-underline-animation">Home</a>
  <c:if test="${currentUser != null }">
  <a onclick="openNav()" class="hover-underline-animation" id="main">Profile</a>
  <a href="/CinemaTicketBooking/myticket" class="hover-underline-animation">My Tickets</a>
  <a href="/CinemaTicketBooking/contactUs" class="hover-underline-animation" >Contact Us</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
  </c:if>
  <c:if test="${currentUser == null }">
  <a  class="hover-underline-animation" id="myBtn">Profile</a>
  <a  class="hover-underline-animation" id="myBtn1">My Tickets</a>
  <a  class="hover-underline-animation" id="myBtn2">Contact Us</a>
    <a href="/CinemaTicketBooking/setupAccountLogin/" class="hover-underline-animation" >Login</a>
  <a href="javascript:void(0);" class="icon" onclick="myFunction()">
    <i class="fa fa-bars"></i>
  </a>
  </c:if>
</div>

<div id="mySidebar" class="sidebar">
 
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
  
  <i class="fa-solid fa-circle-user fa-3x" id="useric"></i>
   <p id="user">${currentUserName}</p>
      <p id="user">${currentUser}</p>
   
   <table>
     <tr> <td><a href="/CinemaTicketBooking/touserUpdate/${userId }" class="editA"><i class="fa-solid fa-user-pen"></i>&nbsp;&nbsp;&nbsp;&nbsp;Edit Profile</a></td> </tr>
     <tr> <td><a href="/CinemaTicketBooking/userLogout" class="logoutA"><i class="fa-solid fa-power-off"></i>&nbsp;&nbsp;&nbsp;&nbsp;LOGOUT</a></td> </tr>
   </table>
   
</div>
  

<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
     <p class="modalmsg">Let's purchase tickets and Enjoy!</p>
     <a href="/CinemaTicketBooking/setupAccountLogin" class="Loginbtn">Login</a>
     <a href="/CinemaTicketBooking/setupUserSignUp" class="Registerbtn">Register</a>
  </div>

</div>
  
<script>
function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }
}

function openNav() {
	  document.getElementById("mySidebar").style.width = "250px";
	  document.getElementById("main").style.marginLeft = "250px";
	  
	}

	function closeNav() {
	  document.getElementById("mySidebar").style.width = "0";
	  document.getElementById("main").style.marginLeft= "0";
	   
	}
	
	// Get the modal
	var modal = document.getElementById("myModal");
      
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");
	btn.onclick = function() {
	  modal.style.display = "block";
	}

	var btn1 = document.getElementById("myBtn1");
	btn1.onclick = function() {
	  modal.style.display = "block";
	}
	
	var btn2 = document.getElementById("myBtn2");
	btn2.onclick = function() {
	  modal.style.display = "block";
	}
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	  modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}
</script>

</body>
</html>

 