<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login page</title>
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

  <form:form name="submitForm" method="POST">
  <form class="form-horizontal" >
 <div class="row centered-form">
        <div class="col-xs-8 col-sm-8 col-md-5 col-sm-offset-2 col-md-offset-3">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title" style="text-align:center;">Login here</h3>
			 			</div>
			 			<div class="panel-body">
			    		<form role="form">



<!-- Text input-->
<div class="form-group">
  <label class="col-md-3 control-label" for="username">User Name</label>  
  <div class="col-md-7">
  <form:input id="username" name="username" type="text" placeholder="user name" class="form-control input-md" required="" path="username"/>
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-3 control-label" for="password">Password</label>  
  <div class="col-md-7">
  <form:input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="" path="password"/>
    
  </div>
</div>


<div class="form-group">
<div class="col-xs-8 col-sm-6 col-md-4 col-sm-offset-2 col-md-offset-4">
<div class="checkbox">
      <label><input type="checkbox"> Remember me</label>
    </div>
	</div>
	</div>
	
<div class="form-group">
<div class="col-xs-8 col-sm-6 col-md-4 col-sm-offset-2 col-md-offset-4">
<a href="REGISTER.jsp"> register here?</a>
<p></p>
<input type="submit" value="Login" class="btn btn-info btn-block">
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