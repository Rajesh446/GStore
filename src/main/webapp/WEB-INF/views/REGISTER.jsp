<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register page</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<style>
footer {
    
    margin-top: 50px;
    
} 
body {
width:100%;
}
  
  </style>
</head>
<body>
 <%@include file="Header.jsp"%>
  <form:form name="submitForm" method="POST" commandName="user"> 
<form class="form-horizontal">
 <div class="row centered-form">
        <div class="col-xs-8 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title" style="text-align:center;">Registration Form</h3>
			 			</div>
			 			<div class="panel-body">
<form role="form">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Id">Id</label>  
  <div class="col-md-6">
  <form:input id="Id" name="Id" type="text" placeholder="user id" class="form-control input-md" path="userId"/>
    
  </div>
</div>



<div class="form-group">
  <label class="col-md-4 control-label" for="username">User name</label>  
  <div class="col-md-6">
  <form:input id="username" name="username" type="text" placeholder="user name" class="form-control input-md" path="username"/>
    
  </div>
</div>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>  
  <div class="col-md-6">
  <form:input id="email" name="email" type="text" placeholder="email address" class="form-control input-md" path="email"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>  
  <div class="col-md-6">
  <form:input id="password" name="password" type="text" placeholder="Password" class="form-control input-md" path="password"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="confirmpassword">Confirm Password</label>  
  <div class="col-md-6">
  <form:input id="confirmpassword" name="confirmpassword" type="password" placeholder="Confirm Password" class="form-control input-md" path="confirmpassword"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="phone">Phone Number</label>  
  <div class="col-md-6">
  <form:input id="phone" name="phone" type="text" placeholder="Phone Number" class="form-control input-md" path="phone"/>
    
  </div>
</div>

<div class="form-group">
<div class="col-xs-8 col-sm-6 col-md-4 col-sm-offset-2 col-md-offset-4">
<input type="submit" value="Register" class="btn btn-info btn-block">
</div>
</div>
</form>
</div>
</div>
</div>
</div>
</form>
</form:form>


 <%@include file="Footer.jsp"%> 

</body>
</html>