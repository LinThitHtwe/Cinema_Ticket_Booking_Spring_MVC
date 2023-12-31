<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <jsp:include page="adminSideBar.jsp"></jsp:include>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
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
    .container{
        padding: 30px;
        width: 35%;
        text-align: center;
        margin: auto;
        border: 2px solid black;
        border-radius: 20px;
        position: absolute;
        bottom: 50%;
        right: 30%;
    }
    .pay{
        border: 2px solid black;
        border-radius: 20px;
        width: 50%;
        text-align: center;
        margin: auto;
    }
    </style>
</head>
<body>
    <div class="container">
        <h1>Your Total Income Amount is</h1>
            <h1 class="pay"> ${income} MMK</h1>
          </div>
</body>
</html>