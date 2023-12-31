
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
    <jsp:include page="adminSideBar.jsp" ></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Management</title>
  <link rel="icon" type="image/x-icon" href="/CinemaTicketBooking/images/movie.jpg">
<style>

.containerA{

	width:30%;
	margin:auto;
	height:auto;
    background-color: rgba(255,255,255,0.13);
    position: absolute;
    transform: translate(-50%,-50%);
    top: 90%;
    left: 50%;
    border-radius: 10px;
    backdrop-filter: blur(10px);
    border: 2px solid rgba(255,255,255,0.1);
    box-shadow: 0 0 40px rgba(8,7,16,0.6);
    padding: 50px 35px;

}

.infoDiv{
width:50%;
margin:auto;
margin-top :5%;
 
}

.picDiv{

width:50%;
margin:auto;
margin-top :10%;
}
.timage{
width:100%;
 
}

h3{
width: 100%;
margin-left:15%;
}

.rejectButton{
width:48%;
background: linear-gradient(#ff512f,#f09819);
height:40px;
border-radius:5px;

}
.confirmButton{
width:48%;
background: linear-gradient(#1845ad,#23a2f6);
height:40px;
border-radius:5px;
}
.backButton{
width:100%;
background: linear-gradient(to right, rgb(182, 244, 146), rgb(51, 139, 147));
height:40px;
border-radius:5px;
}
.table  td {
padding:5px;
}

i{
   position: relative;
right: -40px;
top:20px;
color:#fff;

}



i:hover{
transform: scale(1.2);

}
</style>
</head>
<body>
          <a type="submit" class="BackBtn" href="/CinemaTicketBooking/userPaymentTable">
<i class="fa fa-arrow-left fa-3x" aria-hidden="true"></i></a>
      <div class="containerA">
      <div><h3 class="label">Check User's Payment Information</h3></div>
      
      <div class="picDiv">
      <img src="/CinemaTicketBooking/images/${data.transctionImage}" alt="Transaction Image" class="timage" width=400px height=500px/>
      </div>
            <div class="infoDiv">
      <table class="table">
      <tr><td>User Name</td><td>${userName}</td></tr>
      <tr><td>User's Payment Method</td><td>${paymentMethod}</td></tr>
      <tr><td>User's Amount</td><td>${data.amount}</td></tr>
      <tr><td>User's Phone</td><td>${data.phone}</td></tr>
      <tr><td>Movie Name</td><td>${movieName}</td></tr>
      <tr><td>Purchase Time</td><td>${data.paymentTime}</td></tr>
      </table>
      <c:set var="pending" value="${fn:length(data.paymentStatus)}"/>
      <c:if test="${pending==7}">
      <button onclick="location.href='/CinemaTicketBooking/managePayment/rejected/${data.paymentID}' " class="rejectButton" >Reject</button>
      <button onclick="location.href='/CinemaTicketBooking/managePayment/confirmed/${data.paymentID}' " class="confirmButton" >Confirm</button>
      </c:if>
      <c:if test="${pending > 7 }">
      <button onclick="location.href='/CinemaTicketBooking/userPaymentTable' " class="backButton" >BACK</button>
      </c:if>
      </div>
      
      </div>
</body>
</html>