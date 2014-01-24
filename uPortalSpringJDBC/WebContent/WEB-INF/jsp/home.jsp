<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<title>uPortal | Sign Up</title>
	<style>
	body {
	 font-size: 20px;
	 color: teal;
	 font-family: Calibri;
	}
	
	td {
	 font-size: 15px;
	 color: black;
	 width: 100px;
	 height: 22px;
	 text-align: left;
	}
	
	#love{
		color: green;
	}
	.heading {
	 font-size: 18px;
	 color: white;
	 font: bold;
	 background-color: orange;
	 border: thick;
	}
	</style>
	</head>
	<body>
	 <center>
	  
	 
	 
	 <b>uPortal | Home </b> 
	
	  <div>
	  	<c:if test="${msg_success == true}">Sign up success. You can now log in.</c:if>
	  </div>
	  
	  <div>
	  	<a href="http://localhost:8080/uPortalSpringJDBC/register">Register</a>
	  	<a href="#">Sign in</a>
	  </div>
	  
	 </center>
	</body>
</html>
