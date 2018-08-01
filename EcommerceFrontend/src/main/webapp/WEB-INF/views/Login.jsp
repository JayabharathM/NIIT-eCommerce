<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
   <head>
     <meta charset="utf-8">
     <meta name="viewport" content="width=device-width, initial-scale=1">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <head>
   <title>Login</title>
   
   <style>
   body{
	background:#001b33;
}
#login{
	position:absolute;
	top:50%;
	left:50%;
	transform:translate(-50%, -50%);
}
#login h2{
	text-align:center;
	color:white;
	font-family:sans-serif;
	font-size:35px;
}
#login input{
	display:block;
	width:320px;
	height:40px;
	font-size:14px;
	font-family:sans-serif;
	color:black;
	background:#cce6ff;
	outline:none;
	border:1px solid rgba(0,0,0,0.3);
	border-radius:5px;
	box-shadow:inset 0px -5px 45px rgba(100,100,100,0.2), 0px 1px, 1px rgba(100,100,100,0.2);
	margin-bottom:10px;
}
#login #login-btn{
	background: #006dcc;
	color:white;
	font-size:18px;
	text-align:center;
	vertical-align:middle;
	line-height:20px;
}
   </style>
   <body>
       <div id = "login" >
	       <form  action="loginProcess" method="post" >
		   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" class="form-control" />
		        <h2> Login </h2>
            <input type = "text" name = "j_username" placeholder = "Enter username" required />
            <input type = "password" name = "j_password" placeholder = "Enter password" required />
            <input type = "submit" id = "login-btn" value = "login" />
          </form>
       </div>
   </body>
</html>   