<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
	<title>uPortal | Home</title>
	<style>
	body {
	 font-size: 20px;
	 color: teal;
	 font-family: Calibri;
	}
	
	a,a:visited{
		color: teal;
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
	  
	 
	 
	 <b><a href="home">uPortal</a> | Home </b> 
	
		<div>
			<c:if test="${username != null}"><a href="<c:url value="/j_spring_security_logout" />" > Logout</a></c:if>
		</div>
	  <div>
	  	<c:if test="${msg_success == true}">Sign up success. You can now log in.</c:if>
	  </div>
	  
	  <c:if test="${username == null}"><div>
	  	<a href="register">Sign up</a>
	  	<a href="login">Sign in</a>
	  </div>
	  
	  </c:if>
	  
	  <div>
	  	<a href="public">Public Feature</a>
	  	<a href="private">Private Feature</a>
	  </div>
	 </center>
	</body>
</html>
